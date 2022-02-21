package com.bitwin.bangbang;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitwin.domain.paqVO;
import com.bitwin.domain.Criteria;
import com.bitwin.domain.PageDTO;
import com.bitwin.service.paqService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/paq/*")
@AllArgsConstructor
public class paqController {
	
	private paqService service;
	

	
	@GetMapping("/member-list")
	public void memberList(Criteria cri, Model model) {
		
		log.info("list: " + cri);
		
		
		model.addAttribute("list", service.memberGetList(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, 200));
		
		int total = service.memberGetTotal(cri);
		
		log.info("total: " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		
	}
	
	@GetMapping("/admin-list")
	public void adminList(Criteria cri, Model model) {
		
		log.info("list: " + cri);
		
		
		model.addAttribute("list", service.adminGetList(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, 200));
		
		int total = service.adminGetTotal(cri);
		
		log.info("total: " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		
	}
	
	
	
	@PostMapping("/member-register")
	public String register(paqVO paq, RedirectAttributes rttr) {
		
		log.info("register: " + paq);
		
		service.register(paq);
		
		rttr.addFlashAttribute("result", paq.getPqidx());
		
		return "redirect:/paq/member-list";
	}
	
	@GetMapping({"/member-get"})
	public void memberGet(@RequestParam("pqidx") int pqidx, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("/adminGet or modify");
		model.addAttribute("paq", service.get(pqidx));
		
	}
	
	@GetMapping({"/admin-get"})
	public void adminGet(@RequestParam("pqidx") int pqidx, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("/adminGet or modify");
		model.addAttribute("paq", service.get(pqidx));
		
	}
	
	
	  @GetMapping({"/get", "/reply-register"})
		public void get(@RequestParam("pqidx") int pqidx, @ModelAttribute("cri") Criteria cri, Model model) {
			
			log.info("/get or replyRegister");
			model.addAttribute("paq", service.get(pqidx));
			
		}
	  
	  
	
	  @PostMapping("/reply-register") 
	  public String replyRegister(paqVO paq, @ModelAttribute("cri") Criteria cri, @RequestParam("pqidx") int pqidx, RedirectAttributes rttr) {
	  
	  log.info("modify: " + paq);
	  
	  if(service.modify(paq)) { rttr.addFlashAttribute("result", "answer");
	  
	  
	  
	  
	  
		 rttr.addAttribute("pqidx", pqidx); 
		 rttr.addAttribute("pageNum", cri.getPageNum()); 
		 rttr.addAttribute("amount", cri.getAmount()); 
		 rttr.addAttribute("start", cri.getStart());
		 
		 
	  
	  return "redirect:/paq/reply-register";
	  
	  }
	  
	  
	  
	  
	  
	  
	  rttr.addAttribute("pageNum", cri.getPageNum()); rttr.addAttribute("amount",
	  cri.getAmount()); rttr.addAttribute("start", cri.getStart());
	  
	  return "redirect:/paq/admin-list"; }
	  
	  
	  
	  
	 

		
	
	
	
	  @PostMapping("/remove") public String remove(@RequestParam("pqidx") int
	  pqidx, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	  
	  log.info("remove..." + pqidx);
	  
	  if(service.remove(pqidx)) {
	  
	  rttr.addFlashAttribute("result", "success");
	  
	  }
	  
	  rttr.addAttribute("pageNum", cri.getPageNum()); rttr.addAttribute("amount",
	  cri.getAmount()); rttr.addAttribute("start", cri.getStart());
	  
	 return "redirect:/paq/admin-list"; }
	 
	
	@GetMapping("/member-register")
	public void memberRegister() {
		
	}
	
	
	 // 이미지 업로드
    @RequestMapping(value="/imageUpload", method = RequestMethod.POST)
    public void imageUpload(HttpServletRequest request,
    		HttpServletResponse response, MultipartHttpServletRequest multiFile
    		, @RequestParam MultipartFile upload) throws Exception{
    	// 랜덤 문자 생성
    	UUID uid = UUID.randomUUID();
    	
    	OutputStream out = null;
    	PrintWriter printWriter = null;
    	
    	//인코딩
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	try{
    		//파일 이름 가져오기
    		String fileName = upload.getOriginalFilename();
    		byte[] bytes = upload.getBytes();
    		
    		//이미지 경로 생성
    		String path = "C:\\Users\\samsung\\Pictures\\Saved Pictures" + "ckImage/";	// 이미지 경로 설정(폴더 자동 생성)
    		String ckUploadPath = path + uid + "_" + fileName;
    		File folder = new File(path);
    		System.out.println("path:"+path);	// 이미지 저장경로 console에 확인
    		//해당 디렉토리 확인
    		if(!folder.exists()){
    			try{
    				folder.mkdirs(); // 폴더 생성
    		}catch(Exception e){
    			e.getStackTrace();
    		}
    	}
    	
    	out = new FileOutputStream(new File(ckUploadPath));
    	out.write(bytes);
    	out.flush(); // outputStram에 저장된 데이터를 전송하고 초기화
    	
    	String callback = request.getParameter("CKEditorFuncNum");
    	printWriter = response.getWriter();
    	String fileUrl = "/bangbang/paq/ckImgSubmit?uid=" + uid + "&fileName=" + fileName; // 작성화면
    	
    	// 업로드시 메시지 출력
    	printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
    	printWriter.flush();
    	
    	}catch(IOException e){
    		e.printStackTrace();
    	} finally {
    		try {
    		if(out != null) { out.close(); }
    		if(printWriter != null) { printWriter.close(); }
    	} catch(IOException e) { e.printStackTrace(); }
    	}
    	return;
    }
	
	
	
    // 서버로 전송된 이미지 뿌려주기
    @RequestMapping(value="/ckImgSubmit")
    public void ckSubmit(@RequestParam(value="uid") String uid
    		, @RequestParam(value="fileName") String fileName
    		, HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    	
    	//서버에 저장된 이미지 경로
    	String path = "C:\\Users\\samsung\\Pictures\\Saved Pictures" + "ckImage/";	// 저장된 이미지 경로
    	System.out.println("path:"+path);
    	String sDirPath = path + uid + "_" + fileName;
    	
    	File imgFile = new File(sDirPath);
    	
    	//사진 이미지 찾지 못하는 경우 예외처리로 빈 이미지 파일을 설정한다.
    	if(imgFile.isFile()){
    		byte[] buf = new byte[1024];
    		int readByte = 0;
    		int length = 0;
    		byte[] imgBuf = null;
    		
    		FileInputStream fileInputStream = null;
    		ByteArrayOutputStream outputStream = null;
    		ServletOutputStream out = null;
    		
    		try{
    			fileInputStream = new FileInputStream(imgFile);
    			outputStream = new ByteArrayOutputStream();
    			out = response.getOutputStream();
    			
    			while((readByte = fileInputStream.read(buf)) != -1){
    				outputStream.write(buf, 0, readByte); 
    			}
    			
    			imgBuf = outputStream.toByteArray();
    			length = imgBuf.length;
    			out.write(imgBuf, 0, length);
    			out.flush();
    			
    		}catch(IOException e){
    			e.printStackTrace();
    		}finally {
    			outputStream.close();
    			fileInputStream.close();
    			out.close();
    			}
    		}
    }
    
    
    
	@Autowired
	private JavaMailSender mailSender;
    
	//mailSend 코드
	@RequestMapping(value = "/mailSend", method = RequestMethod.POST)
	public String mailSend(HttpServletRequest request,@RequestParam("pqidx") int pqidx, @ModelAttribute("cri") Criteria cri, @RequestParam("uidx") int uidx, RedirectAttributes rttr) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
		    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		    String emailReceiver = service.getEmail(uidx);
		    messageHelper.setFrom("wnrak0116@gmail.com"); // 보내는사람 이메일 여기선 google 메일서버 사용하는 아이디를 작성하면됨
		    messageHelper.setTo(emailReceiver); // 받는사람 이메일
		    messageHelper.setSubject("안녕하세요. 방방술래 고객센터입니다."); // 메일제목
		    messageHelper.setText("고객님께서 문의해주신 1:1 문의 답변이 등록되었으니, "
		    					+ "홈페이지에 접속하셔서 확인해주시기 바랍니다."
		    					+ "감사합니다."); // 메일 내용
		    
		    mailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		 rttr.addFlashAttribute("result", "success");
		 rttr.addAttribute("pqidx", pqidx); 
		 rttr.addAttribute("pageNum", cri.getPageNum()); 
		 rttr.addAttribute("amount", cri.getAmount()); 
		 rttr.addAttribute("start", cri.getStart());
		 
		
		return "redirect:/paq/reply-register";
	}
	
	
	
}

package com.bitcamp.op.member.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.dao.mybatisMemberDao;
import com.bitcamp.op.member.domain.ListPageView;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchParams;

@Service
public class MemberListService {

	// @Autowired
	// private MemberDao dao;

	// @Autowired
	// private JdbcTemplateMemberDao dao;

	// @Autowired
	// private mybatisMemberDao dao;

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 페이지 당 표현할 회원의 수
	private final int COUNT_PER_PAGE = 3;

	public ListPageView getPageView(SearchParams params) throws SQLException {

		ListPageView view = null;

		dao = template.getMapper(MemberDao.class);

				// 검색 타입과 검색어를 확인 -> 모든 데이터가 null 이 아니어야 한다
		// 데이터 중 하나라도 null 이거나 공백이면 searchType->null
		if (params.getKeyword() == null || params.getKeyword().trim().isEmpty()) {
			params.setSearchType(null);
		}

		// 전체 회원의 수
		// int totalCount = dao.selectTotalCount(conn);
		Map<String, String>  searchMap = new HashMap();
		searchMap.put("searchType", params.getSearchType());
		searchMap.put("keyword", params.getKeyword());
		
		int totalCount = dao.selectTotalCount(searchMap);

		// 현재 페이지 번호
		int currentPage = params.getP() == 0 ? 1 : params.getP();

		int index = (currentPage - 1) * COUNT_PER_PAGE;
		// List<Member> list = dao.selectList(conn, index, COUNT_PER_PAGE);

		params.setIndex(index);
		params.setCount(COUNT_PER_PAGE);
		
		List<Member> list = dao.selectList(params);
		// List<Member> list = dao.selectList(COUNT_PER_PAGE, index);

		view = new ListPageView(totalCount, currentPage, COUNT_PER_PAGE, list);


		return view;
	}

}

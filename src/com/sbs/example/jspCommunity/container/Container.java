package com.sbs.example.jspCommunity.container;

import com.sbs.example.jspCommunity.dao.ArticleDao;
import com.sbs.example.jspCommunity.dao.MemberDao;
import com.sbs.example.jspCommunity.service.ArticleService;
import com.sbs.example.jspCommunity.service.MemberService;
import com.sbs.example.jspCommunity.servlet.controller.usr.MemberController;

public class Container {
	public static ArticleService articleService;
	public static ArticleDao articleDao;
	
	public static MemberService memberService;
	public static MemberDao memberDao;
	public static MemberController memberController;
	
	static {
		memberDao = new MemberDao();
		articleDao = new ArticleDao();
		
		memberService = new MemberService();
		articleService = new ArticleService();
		
		memberController = new MemberController();
	}
}

package com.sbs.example.jspCommunity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.example.jspCommunity.container.Container;
import com.sbs.example.jspCommunity.servlet.controller.usr.MemberController;
import com.sbs.example.mysqlutil.MysqlUtil;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String requestUri = req.getRequestURI(); // 웹 경로 나타남
		String[] requestUriBits = requestUri.split("/"); // 하나하나를 슬래시로 나눔
		
		if(requestUriBits.length < 5) {
			resp.getWriter().append("올바른 요청이 아니니다.");
			return;
		}
		
		String controllerName = requestUriBits[3];
		String actionMethodName = requestUriBits[4];
		// member냐 article이냐, showlist냐 showdetail이냐
		
		String jspPath = null;
		
		MysqlUtil.setDBInfo("127.0.0.1", "sbsst", "sbs1234124", "jspCommunity");
		
		if(controllerName.equals("member")) {
			MemberController memberController = Container.memberController;
			
			if(actionMethodName.equals("list")) {
				jspPath = memberController.showList(req, resp);
			}
		}
		
		MysqlUtil.closeConnection();
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/" + jspPath + ".jsp");
		rd.forward(req, resp);
		
		
	}
	
}
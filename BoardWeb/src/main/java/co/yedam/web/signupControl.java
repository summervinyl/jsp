package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class signupControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 회원이 입력한 정보 가져오기
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String res = req.getParameter("res").length() == 0 ? "User" : "Admin";
		
		
		
		// 세팅해주기
		BoardVO bvo = new BoardVO();
		bvo.setId(id);
		bvo.setName(name);
		bvo.setPw(pw);
		bvo.setRes(res);
		
		BoardService svc = new BoardServiceImpl();
		
		
		if(svc.addMember(bvo)) {
			resp.sendRedirect("loginForm.do");
		}else {
			resp.sendRedirect("signupForm.do");
		}

	}

}
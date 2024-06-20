package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberModAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 멤버 수정
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");		
		String name = req.getParameter("name");
		
		MemberVO mvo = new MemberVO();
		mvo.setUserName(name);
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		
		System.out.println(mvo);
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.updateMember(mvo)) { //{"return" : "OK"} 
			resp.getWriter().print("{\"return\" : \"ok\"}");
		}else {
			resp.getWriter().print("{\"return\" : \"fail\"}");			
		}

	}

}

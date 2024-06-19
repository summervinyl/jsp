package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class MemberDelAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 멤버 정보 삭제
		String id = req.getParameter("id");
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.removeMember(id)) { //{"retCode": "success"}
			resp.getWriter().print("{\"retCode\": \"success\"}");
		}else {
			resp.getWriter().print("{\"retCode\": \"fail\"}");			
		}
	}
}

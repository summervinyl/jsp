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
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		
		
		
		BoardService svc = new BoardServiceImpl();
		MemberVO mvo = svc.updateMember(id);

	}

}

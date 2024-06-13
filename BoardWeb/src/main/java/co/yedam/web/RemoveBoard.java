package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 삭제 기능 구현
		
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		
		
		if(svc.removeBoard(Integer.parseInt(bno))) {
			resp.sendRedirect("boardList.do");
		} else {
			req.getRequestDispatcher("WEB-INF/view/removeBoardFrom.jsp").forward(req, resp);
		}
		

	}

}
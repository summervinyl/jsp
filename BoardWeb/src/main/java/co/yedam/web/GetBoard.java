package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class GetBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터정보를 읽어서 게시글 번호 조회
		// board.jsp 페이지에 출력
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		
		BoardService svc = new BoardServiceImpl();
		BoardVO brd = svc.getBoard(Integer.parseInt(bno)); //문자열을 정수 타입으로 변경
		
		req.setAttribute("board", brd);
		req.setAttribute("page", page);
		
		
		//포워딩
		req.getRequestDispatcher("WEB-INF/view/board.jsp").forward(req, resp);
		
	}

}

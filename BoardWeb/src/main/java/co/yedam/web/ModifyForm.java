package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 수정 화면으로 이동 메소드
		
		String bno = req.getParameter("bno");
		//게시글 번호 bno 정보 조회
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		
		
		//요청정보의 attribute(=board)
		req.setAttribute("board", board);
		//리퀘스트에 담아서 넘겨준다.
		
		req.getRequestDispatcher("WEB-INF/view/modifyBoardForm.jsp").forward(req, resp);		
	}

}
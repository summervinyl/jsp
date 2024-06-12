package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 게시글 등록 버튼 클릭시 목록으로 이동하는 기능 구현
		// 사용자의 입력 값 받아오기	
		
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		//받아온 입력 값을 세팅해주기
		BoardVO bv = new BoardVO();		
		
		bv.setTitle(title);
		bv.setContent(content);
		bv.setWriter(writer);
		
		//입력 값으로 쿼리 메소드 실행
		BoardService svc = new BoardServiceImpl();
		
		//등록이 true면 목록 보여주기.		
		//아니면 다시 등록화면 보여주기.
		if(svc.addBoard(bv)) {
			resp.sendRedirect("boardList.do");
		} else {
			resp.sendRedirect("addBoard.do");
		}

	}

}

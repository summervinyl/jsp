package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class AddForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//게시판 글 등록 화면으로 이동하는 기능
		// 사용자가 /addForm.do를 요청하면 new AddForm()가 실행된다.
		req.getRequestDispatcher("board/boardForm.tiles").forward(req, resp);
		//getRequestDispatcher(가려고하는 서블릿 네임)
		//forward 방식은 클라이언트가 요청한 방식에 따라 이동한다.
		
		
	}

}

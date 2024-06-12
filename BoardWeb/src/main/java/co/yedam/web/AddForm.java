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
		
		req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);		
		
	}

}

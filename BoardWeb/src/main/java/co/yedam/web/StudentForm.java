package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class StudentForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/view/studentForm.jsp").forward(req, resp);
		//getRequestDispatcher():()안에 있는 기능 요구 -- forward():요청재지정

	}

}

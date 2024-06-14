package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class LoginForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 로그인 화면으로 이동
		//member/loginForm.tiles : 경로명. 타일즈가 적용된 jsp페이지 열기.
		req.getRequestDispatcher("member/loginForm.tiles").forward(req, resp);		
	}

}
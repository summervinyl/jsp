package co.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 제어의 역전(Inversion of Control)
// url 호출 tomcat이 처리 url에 해당되는 클래스에 객체 생성하고 init메소드 호출 service - destory.
// 서블릿의 생명주기
public class SecondServlet extends HttpServlet {
	
	// 생성자
	public SecondServlet() {
		System.out.println("SecondServlet 생성자 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}
	
} // end class

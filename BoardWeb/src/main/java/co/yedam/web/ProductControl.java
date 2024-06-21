package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class ProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HttpServletRequest : 클라이언트가 서버에 보내는 요청정보를 처리하는 객체,
		//HttpServletResponse : 서버가 클라이언트로 보내는 응답정보를 처리하는 객체
		//System.out.println("요청정보: "+ req + ", 응답정보: " + resp);
		String sno = req.getParameter("stdNo"); //http://localhost/BoardWeb/product.do?stdNo=S0000 중에 <?stdNo=S0000>
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = mapper.getStudent(sno);
		req.setAttribute("student", student);
		
		req.getRequestDispatcher("WEB-INF/view/member/product.jsp").forward(req, resp);
		//getRequestDispatcher():()안에 있는 기능 요구 -- forward():요청재지정
	}
}

package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class MainControl implements Control{
	//우리가 만들어 놓은 Control 인터페이스 클래스를 구현한 클래스
	//인터페이스 기능 재정의 = 직접 입력 || 클래스명 add~ 클릭

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//객체 선언 : 중요한 부분 !
		Student student = new Student();
		student.setStdNo("S0012");
		student.setStdName("다니엘");
		student.setPhone("000-0000-0000");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		//StudentMapper.xml이 클래스 역할
		//getMapper : 매칭작업
		//StudentMapper : 인터페이스
		List<Student> list = mapper.selectBlog();
		
		
		//생성된 student 객체 정보를 jsp로 전달하고 싶을 
		//req~ 에다가 정보를 담아서 전달
		req.setAttribute("student", student); //student속성지정, 실제값
		req.setAttribute("studentList", list); //main.jsp가 list를 읽어들이면
		
		
		
		System.out.println("요청정보: "+ req + ", 응답정보: " + resp);
		//WEB-INF/public/main.jsp -- 사람들이 main.do를 치면 이 클래스를 보여준다?
		//mian.do 호출->main.jsp로 페이지 재 지정 :서블릿에서는 html을 쓰면 코드가 길어진다. main.jsp로 페이지 재 지정.
		req.getRequestDispatcher("WEB-INF/public/main.jsp").forward(req, resp); //매개값으로 이동할 페이지 지정 후
		//인터페이스에 없는 기능 구현시 오류, 그래서 인터페이스에 똑같이 써준다.
		//하단에 servers 리스타트 - http://localhost/BoardWeb/main.do 실행시 main.jsp페이지 실행
	}

}

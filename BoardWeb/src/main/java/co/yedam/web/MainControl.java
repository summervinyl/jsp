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
//		student.setStdName("-ˋˏ ♡ ˎˊ-");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		//StudentMapper.xml이 클래스 역할
		//getMapper : 매칭작업
		//StudentMapper : 인터페이스
		
		List<Student> list = mapper.selectBlog();		
		
		req.setAttribute("student", student);  //student 속성(이름) 지정, 실제 값
		req.setAttribute("studentList", list);		
		
		//System.out.println("요청정보: "+ req + ", 응답정보: " + resp);
		//WEB-INF/public/main.jsp -- 사용자가 main.do를 주소에 입력하면(요청) 필요한 정보를 담아서 main.jsp로 전달
		//~.do 호출 → FrontController.java에서 호출한 페이지가 유요한지 검사 후 해당 컨트롤러 exec()실행 → 해당 컨트롤러에서 필요한 데이터를 들고 ~.jsp로 페이지 재지정
		//페이지 재지정하는 이유 : 서블릿에서는 html을 쓰면 코드가 길어진다. 고로 jsp로 재지정. 톰캣이 jsp를 실행하면 java파일로 변환된다.
		req.getRequestDispatcher("member/main.tiles").forward(req, resp); //매개값으로 이동할 페이지 지정 후
		//인터페이스에 없는 기능 구현시 오류, 그래서 인터페이스에 똑같이 써준다.
		//하단에 servers 리스타트 - http://localhost/BoardWeb/main.do 실행시 main.jsp페이지 실행
	}

}

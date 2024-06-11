package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddStudent;
import co.yedam.web.MainControl;
import co.yedam.web.ProductControl;
import co.yedam.web.StudentForm;

//front -> 요청 url(*.do) -> 실행컨트롤 매칭 :: ex) main.do로 시작하면 이 서블릿을 거친다.
// main.do 요청이 들어오면 -> FrontController -> WEB-INF/public/main.jsp
// 객체생성 -> init -> service -> destroy
//240611 이 클래스를 거쳐서(통해서) 모든 페이지를 여는 게 목적
// 모든 요청을 FrontController 이 클래스를 통해서 열기
//FrontController 얘를 안 거치면 작업을 못하게 하는 게 목적
//FrontController는 HttpServlet을 상속 받은 서블릿
public class FrontController extends HttpServlet {
	//필드 선언
	private Map<String, Control> map; //map = key:url, value:control
	
	//생성자
	public FrontController() {
		map = new HashMap<>(); //밸류형식으로 값을 ㄷ담을 수 있는
	}
	
	
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/product.do", new ProductControl());
//		map.put("/main.do", "Main페이지입니다"); //key와 value
//		map.put("/product.do", "상품 페이지입니다"); //페이지 실행시 해당되는 출력문 console에 출력
		
		//학생 등록 화면 studentForm.do
		map.put("/studentForm.do", new StudentForm()); //사용자가 http://localhost/BoardWeb/studentForm.do를 요청하면 new StudentForm() 실행
		map.put("/addStudent.do", new AddStudent()); //사용자가 등록화면에서 등록하는 기능
		
		//게시판 목록
		map.put("/boardList.do", new BoardLsit());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req :
		String uri = req.getRequestURI(); //BoardWeb/main.do = URI ---- http://localhost/BoardWeb/main.do = URL
//		System.out.println("uri : " + uri);
		String context = req.getContextPath(); //BoardWeb : context (프로젝트이름)
//		System.out.println("context : " + context);
		//계산해오는 방식
		String page = uri.substring(context.length()); // main.do : 요청 페이지
//		System.out.println("page : " + page);
		
		//키에 해당되는 값 = 키를 알면 해당되는 밸류 가져올 수 잇음. (Map의 특징)
//		String result = map.get(page);
//		System.out.println("result " + result);
		Control result = map.get(page);
		result.exec(req, resp); //자바에서 만든 규칙
	}

}

package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddBoard;
import co.yedam.web.AddForm;
import co.yedam.web.AddStudent;
import co.yedam.web.GetBoard;
import co.yedam.web.LoginControl;
import co.yedam.web.LoginForm;
import co.yedam.web.LogoutControl;
import co.yedam.web.MainControl;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductControl;
import co.yedam.web.RemoveBoard;
import co.yedam.web.RemoveForm;
import co.yedam.web.SignupForm;
import co.yedam.web.StudentForm;
import co.yedam.web.deleteAccoutForm;
import co.yedam.web.signupControl;
import co.yedam.web.ModifyBoard;
import co.yedam.web.BoardLsit;

// 2024-06-10 월요일 JSP 첫 날
// front → 서버 요청 url(*.do) → FrontController → 실행 컨트롤 매칭 / [ex] main.do 요청 → FrontController → exec() → WEB-INF/public/main.jsp
// 객체 생성 -> init() 서블릿 로딩 -> service() -> destroy() 제거
// FrontController는 HttpServlet을 상속 받은 servlet
public class FrontController extends HttpServlet {
	//필드 선언
	private Map<String, Control> map; //map = key:url, value:control
	
	//생성자
	public FrontController() {
		map = new HashMap<>(); //HashMap : 컬렉션의 하나로 데이터를 키(Key)와 밸류(Value)의 짝으로 저장
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new MainControl());
		
		map.put("/product.do", new ProductControl());
		
		//학생 등록 화면 studentForm.do
		map.put("/studentForm.do", new StudentForm()); //사용자가 http://localhost/BoardWeb/studentForm.do를 요청하면 new StudentForm() 실행
		
		map.put("/addStudent.do", new AddStudent()); //사용자가 등록화면에서 등록하는 기능
		
		//게시판 목록
		map.put("/boardList.do", new BoardLsit());
		
		//게시글 상세 보기
		map.put("/getBoard.do", new GetBoard());
		
		//게시판 글 등록 화면으로 이동
		map.put("/addForm.do", new AddForm());
		
		//게시글 등록
		map.put("/addBoard.do", new AddBoard());
		
		//게시글 삭제 화면으로 이동 -- 사용자가 삭제 이동으로 버튼을 클릭시 게시글 상세 화면 표출, 삭제버튼 구현ㄴ
		map.put("/removeForm.do", new RemoveForm());
		
		//게시글 삭제하기! -> 이동했을 시 사용자가 입력한 값을 세팅하고, 삭제 성공시 이동할 페이지와, 실패시 이동할 페이지 설정
		map.put("/removeBoard.do", new RemoveBoard());
		
		//게시글 수정 화면
		map.put("/modifyForm.do", new ModifyForm());
		
		//게시글 수정 처리
		map.put("/modifyBoard.do", new ModifyBoard());
		
		//로그인 화면
		map.put("/loginForm.do", new LoginForm());
		
		//로그인 기능
		map.put("/login.do", new LoginControl());
		
		//로그아웃 기능
		map.put("/logout.do", new LogoutControl());
		
		//회원가입 페이지로 이동
		map.put("/signupForm.do", new SignupForm());
		
		//회원가입 등록을 누르면 기능 작동
		map.put("/signup.do", new signupControl());
		
		//회원탈퇴 페이지로 이동
		map.put("/deleteAccout.do", new deleteAccoutForm());
		
	}
	
	
	//사용자가 정보를 요청하면 service() 자동으로 실행
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI(); //BoardWeb/main.do = URI ---- http://localhost/BoardWeb/main.do = URL
//		System.out.println("uri : " + uri);
		String context = req.getContextPath(); //BoardWeb : context (프로젝트이름)
//		System.out.println("context : " + context);
		String page = uri.substring(context.length()); // /main.do : 요청 페이지
//		System.out.println("page : " + page);
		
		//키에 해당되는 값 = 키를 알면 해당되는 밸류 가져올 수 잇음. (Map의 특징)
//		String result = map.get(page);
//		System.out.println("result " + result);
		Control result = map.get(page);
		result.exec(req, resp); //자바에서 만든 규칙
	}

}

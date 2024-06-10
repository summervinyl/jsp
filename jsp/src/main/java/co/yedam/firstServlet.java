package co.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fisrtServlet
 */
@WebServlet("/fisrtServlet") //url에 ()안에 것 검색하면 밑에 클래스 실행 : 정의 구문
public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//생성자
    public firstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8"); //출력스트림 한글 처리
		PrintWriter out = response.getWriter(); //출력스트림(사용자의 웹 브라우저)
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id"); //input name="id" 사용자가 입력한 값을 id라는 파라미터로 전달
		String pw = request.getParameter("pw");
		out.print("<p>입력한 아이디 "+ id + "</p>");
		out.print("<p>입력한 비번 "+ pw + "</p>");
		
		out.print("ㅠㅠ");
		out.print("<a href='index.html'>인덱스 페이지로 이동</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		//사용자 입력값.
		String no = request.getParameter("stdNo"); //파라미터값에 네임속성 넣어주기
		String name = request.getParameter("stdName");
		String phone = request.getParameter("phone");
		String type = request.getParameter("bloodType");
		
		Student std = new Student();
		std.setStdNo(no);
		std.setStdName(name);
		std.setPhone(phone);
		std.setBldType(type);
		
		PrintWriter out = response.getWriter();
		
		StudentDAO sdao = new StudentDAO();
		if(sdao.insertStudent(std)) out.print("<b>OK</b>");
		else out.print("<b>FAIL</b>");
	}

}

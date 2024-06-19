package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberAddAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 파라미터 4개를 받아오기 (이름, 비번, 권한, 아이디) -> DB 입력 -> 성공하면 OK 반환
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String nm = req.getParameter("nm");
		String auth = req.getParameter("auth");	
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserName(nm);
		mvo.setResponsibility(auth);
		mvo.setUserPw(pw);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.addMember(mvo)) { // 리턴 코드 json 문자열로 반환 {"retCode": "OK", "retMsg": "Success"}
			resp.getWriter().print("{\"retCode\": \"OK\", \"retMsg\": \"Success\"}");
		} else { //{"retCode": "NG", "retMsg": "Fail"}
			resp.getWriter().print("{\"retCode\": \"NG\", \"retMsg\": \"Fail\"}");
		}
	}
}

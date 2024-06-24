package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class SignupControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원이 입력한 정보 가져오기
		// 파일첨부일 경우에는 멀티파트 요청을 처리
		// Multipart 요청 (1.요청 정보 2.저장위치 3.최대크기 4.인코딩방식지정 5.리네임정책:파일을서버에올릴때파일명이중복될때,변경규칙지정)
		String savePath = req.getServletContext().getRealPath("images"); //프로젝트를 기준으로 경로 지정
		int maxSize = 1024 * 1024 * 5; //5메가
		String encoding = "utf-8";
		
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy()); //DefaultFileRenamePolicy : cos 라이브러리가 갖고 있는		
		
		String name = mr.getParameter("name");
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String img = mr.getParameter("myImage");
		
		String res = mr.getParameter("res").length() == 0 ? "User" : "Admin";
		
		// 세팅해주기
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserName(name);
		mvo.setUserPw(pw);
		mvo.setResponsibility(res);
		mvo.setImage(img);
		
		BoardService svc = new BoardServiceImpl();
		
		try {
			if(svc.addMemberImage(mvo)) {
				resp.sendRedirect("memberList.do");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}

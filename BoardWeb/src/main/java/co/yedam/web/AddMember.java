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

public class AddMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 파일첨부일 경우에는 multipart 요청을 처리.
		// Multipart요청 (1.요청정보 2.저장위치 3.최대크기 4.인코딩 5.리네임정책:파일을서버에올릴때파일명이중복될때,변경규칙지정)
		String savePath = req.getServletContext().getRealPath("images"); //프로젝트를 기준으로 경로 지정
		int maxSize = 1024 * 1024 * 5;
		String encoding = "utf-8";
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy()); //DefaultFileRenamePolicy : cos 라이브러리가 갖고 있는
		
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String nm = mr.getParameter("name");		
		String img = mr.getFilesystemName("myImage"); //getFilesystemName 파일을 넘겨받을 때,

		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(nm);
		mvo.setImage(img);

		BoardService svc = new BoardServiceImpl();

		try {
			if(svc.addMemberImage(mvo)) {
				if(req.getMethod().equals("POST")) { //요청방식이 form이면
					resp.sendRedirect("memberList.do");					
				} else if(req.getMethod().equals("PUT")){
					//{"retCode":"OK"}
					resp.getWriter().print("{\"retCode\":\"OK\"}");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(req.getMethod().equals("PUT")){
				//{"retCode":"OK"}
				resp.getWriter().print("{\"retCode\":\"NG\"}");
			}
		}

	}

}

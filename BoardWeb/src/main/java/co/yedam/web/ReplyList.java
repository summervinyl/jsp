package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class ReplyList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 파라미터로 원본 글 받아오기
		resp.setContentType("text/json;charset=utf-8"); // 인코딩 방식
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		//게시글을 클릭했을 때, 초기페이지를 1로 지정
		page = page == null ? "1" : page;

		// 댓글 목록 가져오기
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno), Integer.parseInt(page));

		// Gson gson = new GsonBuilder().create(); //gson 객체를 생성하는 방식 / Gson 문자열을 만들어서
		// 반환,
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // gson 객체를 생성하는 방식 / Gson 문자열을 만들어서 반환,
																	// setPrettyPrinting 추가시 깔끔하게 정렬해서 출력
		String json = gson.toJson(list); // gson 객체를 json 문자열로 반환

		resp.getWriter().print(json); // 사용자 출력 스트립- 사용자 웹브라우저에 출력

		// http://localhost/BoardWeb/replyListJson.do?bno=201 - 게시글 번호 201번에 대한 댓글 정보 출력
	}

}

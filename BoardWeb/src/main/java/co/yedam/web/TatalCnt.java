package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class TatalCnt implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO boardNo에 대한 댓글 전체 건수 필요, 가져온 값을 반환
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt =  svc.getTotalCnt(Integer.parseInt(bno));
		
		resp.getWriter().print(totalCnt);
		//http://localhost/BoardWeb/replyTotalCnt.do?bno=1 - 게시글 1번에 대한 댓글 건수 출력해준다.
	}

}

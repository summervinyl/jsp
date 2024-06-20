package co.yedam.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class AddReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//post방식일 땐
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8"); //인코딩 방식 지정
		
		String bno = req.getParameter("bno");
		String replyer = req.getParameter("replyer");
		String reply = req.getParameter("reply");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReplyer(replyer);
		rvo.setReply(reply);
		System.out.println(rvo);
		
		Map<String, Object> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		
		ReplyService svc = new ReplyServiceImpl();
		//insert는 에러가 쿼리에서 발생하기 때문에 else말고 예외처리를 해준다
		try {
			if(svc.registerReply(rvo)) {
				rvo.setReplyDate(new Date());
				System.out.println(rvo);
				map.put("retCode", "OK");
				map.put("retVal", rvo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("retCode", "NG");
			map.put("retVal", "처리 중 오류가 발생했습니다."); //현업에서는 담당자 연락처 기입
		}
		//웹 브라우저에 제이슨 형태로 출력.
		resp.getWriter().print(gson.toJson(map));
	}
	
}

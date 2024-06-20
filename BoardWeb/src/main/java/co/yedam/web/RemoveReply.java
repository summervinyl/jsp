package co.yedam.web;

import java.io.IOException;
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

public class RemoveReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 삭제해야 될 댓글 번호 넘겨주어야 한다.
		// 댓글 번호를 활용해서 댓글 삭제.
		
		/* reply연습.js
		 * String replyNo = req.getParameter("replyNo");
		 * 
		 * ReplyService svc = new ReplyServiceImpl();
		 * 
		 * if(svc.removeReply(Integer.parseInt(replyNo))) { //{"return" : "success"}
		 * resp.getWriter().print("{\"return\" : \"success\"}"); } else {
		 * resp.getWriter().print("{\"return\" : \"fail\"}"); }
		 */
		 resp.setContentType("text/json;charset=utf-8");
		 
		 String rno = req.getParameter("rno");
		 
		 ReplyService svc = new ReplyServiceImpl();
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		 Gson gson = new GsonBuilder().create();
		 
		 if(svc.removeReply(Integer.parseInt(rno))) {
			 map.put("retCode", "OK");
			 map.put("retMsg", "삭제 성공");
		 } else {
			 map.put("retCode", "NG");
			 map.put("retMsg", "삭제 실패");
		 }
		 String json = gson.toJson(map);
		 resp.getWriter().print(json);
	}

}

package co.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class CenterChart implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		
		ReplyService svc = new ReplyServiceImpl();
		List<Map<String, Object>> result = svc.centerList();
		
		//Map<String, Object> centerMap = new HashMap<>(); //chart.jsp에서 for in으로 배열 반복할 경우 사용.
		
		 for(Map<String, Object> map : result) {
			 System.out.println(map.get("sido") + ", " + map.get("count"));
			 System.out.println("-------------------------------------------"); //데이터 한 건당 구분선
			 //centerMap.put((String)map.get("sido"), map.get("count")); //chart.jsp에서 for in으로 배열 반복할 경우 사용.
		 }
		 Gson gson = new GsonBuilder().create();
		 String json = gson.toJson(result);      //chart.jsp에서 forEach로 배열 반복시 사용
		 //String json = gson.toJson(centerMap); //chart.jsp에서 for in으로 배열 반복할 경우 사용.
		 resp.getWriter().print(json);
	}

}

package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// json 형태의 문자열을 반환해주는 기능 작성.
		// {"name":"홍길동", "age":20, "phone":"010-0000-0000"} = json 문자열 형태
		resp.setContentType("text/json;charset=utf-8"); // 깨진 제이슨 문자열 제대로 출력
		BoardService svc = new BoardServiceImpl();
		List<MemberVO> list = svc.memberLsit();
		String json = "[";
		// \"
		for(int i=0; i<list.size(); i++) {
			json += "{\"userId\":\"" + list.get(i).getUserId() + "\",\"userName\":\"" + list.get(i).getUserName() + "\",\"userPw\":\"" + list.get(i).getUserPw() + "\",\"responsibility\":\"" + list.get(i).getResponsibility() + "\"}";
			//마지막 데이터 : list.size()-1
			//마지막 데이터와 i의 값이 다를 경우 ,를 입력
			if(i != list.size()-1) {
				json += ",";
			}
		}
		json += "]";
		resp.getWriter().print(json);
		// resp.getWriter().print("{\"name\":\"홍길동\", \"age\":20, \"phone\":\"010-0000-0000\"}");
	}

}

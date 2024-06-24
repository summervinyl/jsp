package co.yedam.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.CenterVO;
import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class CenterInfo implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO json 형태의 문자열이 넘어오면 자바 객체로 변환 후 DB에 insert
		ServletInputStream sis = req.getInputStream(); //stream : 자바에서 데이터를 주고 받는 흐름 통로
		String json = StreamUtils.copyToString(sis, StandardCharsets.UTF_8); //2번째 값이 인코딩 방식
		System.out.println(json);
		
		//문자열 -> 객체, VO타입으로 정의하기
		ObjectMapper objectMapper = new ObjectMapper();
		CenterVO[] centers = objectMapper.readValue(json, CenterVO[].class); //json을 CenterVO의 배열 타입으로 반환
		
		//mapper에 한 번에 배열을 여러건 넣는 쿼리
		
		
		ReplyService svc = new ReplyServiceImpl();
		int r = svc.createCenterInfo(centers);
		
		//{"txtCnt" : 2} = 트랜젝션 카운트
		resp.getWriter().print("{\"txtCnt\": " + r + "}");
		

	}

}

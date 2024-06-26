package co.yedam.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class BoardLsit implements Control {
	//oracle db에 글 목록 조회 -> boardLsit.jsp 출력.
	//최소 기능의 매퍼
//	@Override
//	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		BoardService svc = new BoardServiceImpl();
//		List<BoardVO> list = svc.boardList();
//		
//		req.setAttribute("boardList", list);
//		
//		req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);	
//	}
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//http://localhost/BoardWeb/boardList.do?page=3
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		page = page == null ? "1" : page; //page의 값이 널이면 1, 즉 파라미터 값이 없으면 에러를 방지하기 위해 한 페이지라도 보여주기 위한 설정
		//검색하기 위한 조건을 담는 SearchVO 생성 - 3개의 파라미터
		SearchVO search = new SearchVO(Integer.parseInt(page), sc, kw);
		
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);
		
		req.setAttribute("boardList", list);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page); //쓰진 않지만 확인용
		
		
		// paging 계산.
		int totalCnt = svc.boardTotal(search); //boardService에서 가져온 값, 검색한 결과값만큼 페이지 출력 예)제목이 자바인 결과페이지가 5페이지면 5페이지만 출력
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", dto);
		
//		req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
		
		
//		// paging 계산.
//		int totalCnt = svc.boardTotal(); //boardService에서 가져온 값
//		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
//		req.setAttribute("paging", dto);
//		
//		req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);
	}

}

package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.mapper.BoardMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 수정 기능
		
		//modifyBoard,do?bno=1&title=1-자바&content=감자바
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		//editBoard 매개값 전달하기 위해 BoardVO 객체 생성
		BoardVO bv = new BoardVO();
		bv.setBoardNo(Integer.parseInt(bno));
		bv.setTitle(title);
		bv.setContent(content);
				
		BoardService svc = new BoardServiceImpl();		
		 
		
		if(svc.editBoard(bv)) {
			resp.sendRedirect("boardList.do?searchCondition="+sc+"&keyword="+kw+"&page="+page);
		} else {
			req.getRequestDispatcher("WEB-INF/view/modifyBoardForm.jsp").forward(req, resp);
		}
		
		
		
	}

}

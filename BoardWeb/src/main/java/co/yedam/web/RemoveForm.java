package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class RemoveForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용자가 삭제 이동으로 버튼을 클릭시 현재 게시글(게시글 번호)를 갖고 이동해야 되니까 게시글 번호 저장하고 req에 담아주기.
		String bno = req.getParameter("bno");
		//게시글 번호 bno 정보 조회
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		
		BoardService svc = new BoardServiceImpl();
		//현재 게시글 번호를 세팅해주고, getBoard의 서비스를 이용해서 현재 게시글 정보를 담아준다.
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		//리퀘스트에 담아서 넘겨준다.
		
		//페이지 이동시 현재 페이지 전달
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
				
				
		req.getRequestDispatcher("WEB-INF/view/removeBoardForm.jsp").forward(req, resp);
		

	}

}

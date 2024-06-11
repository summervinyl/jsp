package co.yedam.service;

import java.util.List;

import co.yedam.vo.BoardVO;

public interface BoardService {
	//목룍, 단건조회, 등록, 수정, 삭제 등의 기능 선언
	//기능 실행은 mapper의 기능을 가져와서 실행
	
	List<BoardVO> boardList();
	BoardVO getBoard(int bno);
	boolean addBoard(BoardVO bvo);
	boolean editBoard(BoardVO bvo);
	boolean removeBoard(int bno);

}

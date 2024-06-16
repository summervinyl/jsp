package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;

public interface BoardService {
	//목룍, 단건조회, 등록, 수정, 삭제 등의 기능 선언
	//기능 실행은 mapper의 기능을 가져와서 실행
	
//	List<BoardVO> boardList();
//	List<BoardVO> boardList(int page);
	List<BoardVO> boardList(SearchVO search);
	//구현부분으로 가서 변경
	int boardTotal(SearchVO search);
	BoardVO getBoard(int bno); //단건조회
	boolean addBoard(BoardVO bvo); //등록
	boolean editBoard(BoardVO bvo);
	boolean removeBoard(int bno);
	
	//체크멤버(id, pw)
	boolean checkMember(String id, String pw);
	
	//회원가입
	boolean addMember(BoardVO bvo);
}

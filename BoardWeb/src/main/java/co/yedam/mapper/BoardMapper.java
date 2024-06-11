package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BoardVO;

public interface BoardMapper {
	//목록 보기, 등록, 수정, 삭제, 단건조회 등의 기능들 생성~!
	List<BoardVO> boardList();
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bvo);
	BoardVO selectBoard(int bno);

}

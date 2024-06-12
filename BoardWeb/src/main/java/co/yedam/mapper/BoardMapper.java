package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BoardVO;

public interface BoardMapper {
	//BoardMapper이 구현 클래스 역할을 함.
	//목록 보기, 등록, 수정, 삭제, 단건조회 등의 기능들 생성~!
	List<BoardVO> boardList();      //전체 목록
	List<BoardVO> boardListPaging(int page); //페이지별로 5건씩.
	int getTotalCnt(); //페이징 계산 용도
	int insertBoard(BoardVO bvo); //등록
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bvo);
	BoardVO selectBoard(int bno); // 단건조회, 반환타입 BoardVO 
	
}

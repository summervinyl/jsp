package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyMapper {
	// 목록, 단건 조회, 등록, 삭제
	//목록 -반환 유형 컬렉션
	List<ReplyVO> selectList(int boardNo);
	ReplyVO selectReply(int replyNo);
	int insertReply(ReplyVO rvo);
	int deleteReply(int replyNo);
	

}

package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.ReplyVO;

public interface ReplyMapper {
	// 목록, 단건 조회, 등록, 삭제
	//목록 -반환 유형 컬렉션
	List<ReplyVO> selectList(int boardNo);
	List<ReplyVO> selectListPaging(@Param("boardNo") int boardNo, @Param("page") int page);	//param은 mybatis에서 제공하는 기능
	ReplyVO selectReply(int replyNo);
	int insertReply(ReplyVO rvo);
	int deleteReply(int replyNo);
	
	//댓글 건수를 가져오는 
	int selectReplyCnt (int bno);
	

}

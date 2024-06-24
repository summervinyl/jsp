package co.yedam.service;

import java.util.List;
import java.util.Map;

import co.yedam.common.CenterVO;
import co.yedam.vo.ReplyVO;

public interface ReplyService {
	//목록
	List<ReplyVO> replyList(int boardNo, int page);
	//단건조회
	ReplyVO getReply(int replyNo);
	//입력
	boolean registerReply(ReplyVO rvo);
	//삭제
	boolean removeReply(int replyNo);
	
	//댓글 건수
	int getTotalCnt (int bno);
	
	//센터 정보 생성
	int createCenterInfo(CenterVO[] array);
	
	//센터 개수 정보 차트
	List<Map<String, Object>> centerList();
	
}

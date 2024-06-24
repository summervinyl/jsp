package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.CenterVO;
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
	
	
	//센터 정보 생성
	//insert니까 반환이 int 건수로 반환해야 됨
	int insertCenter(CenterVO[] array);
	
//	//센터 정보 가져오기 -- 개인적으로 해보는 것.
//	int selectCenter(CenterVO cvo);
	
	//시도별 센터의 개수 정보 차트
	List<Map<String, Object>> centerBysido(); //데이터가 여러건이라 맵타입이 여러건이어야 한다.

}

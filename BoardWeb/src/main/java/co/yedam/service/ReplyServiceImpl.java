package co.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.CenterVO;
import co.yedam.common.DataSource;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession() true 넣으면 자동 커밋
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);	

	@Override
	public List<ReplyVO> replyList(int boardNo, int page) {
		return mapper.selectListPaging(boardNo, page);
	}
	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}
	@Override
	public boolean registerReply(ReplyVO rvo) {
		return mapper.insertReply(rvo) == 1;
	}
	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo) == 1;
	}
	
	@Override
	public int getTotalCnt(int bno) {
		return mapper.selectReplyCnt(bno);
	}
	
	@Override
	public int createCenterInfo(CenterVO[] array) {
		return mapper.insertCenter(array);
	}
	
	@Override
	public List<Map<String, Object>> centerList() {
		return mapper.centerBysido();
	}
}

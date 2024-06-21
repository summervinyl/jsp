package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession() true 넣으면 자동 커밋
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	/*
	 * @Override public List<ReplyVO> replyList(int boardNo) { // TODO
	 * Auto-generated method stub return mapper.selectList(boardNo); }
	 */
	
	@Override
	public List<ReplyVO> replyList(int boardNo, int page) {
		// TODO Auto-generated method stub
		return mapper.selectListPaging(boardNo, page);
	}
	@Override
	public ReplyVO getReply(int replyNo) {
		// TODO Auto-generated method stub
		return mapper.selectReply(replyNo);
	}
	@Override
	public boolean registerReply(ReplyVO rvo) {
		// TODO Auto-generated method stub
		return mapper.insertReply(rvo) == 1;
	}
	@Override
	public boolean removeReply(int replyNo) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(replyNo) == 1;
	}
	
	@Override
	public int getTotalCnt(int bno) {
		// TODO Auto-generated method stub
		return mapper.selectReplyCnt(bno);
	}
}

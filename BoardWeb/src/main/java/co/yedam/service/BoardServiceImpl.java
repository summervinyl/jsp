package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

public class BoardServiceImpl implements BoardService {
	//업무 프로세스를 따라 실행하기 위한 서비스.
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession() 투르 넣으면 자동 커밋
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

//	@Override
//	public List<BoardVO> boardList() {
//		//mapper에 등록된 기능 활용
//		return mapper.boardList(); //boardList 컨트롤 -- 서비는 
//	}
	
//	@Override
//	public List<BoardVO> boardList(int page) {
//		//mapper에 등록된 기능 활용
//		return mapper.boardListPaging(page); //boardList 컨트롤 -- 서비는 
//	}
	@Override
	public List<BoardVO> boardList(SearchVO search) {
		//mapper에 등록된 기능 활용
		return mapper.boardListPaging(search); //boardList 컨트롤 -- 서비는 
	}
	
	//보드리스트에서 
	@Override
	public int boardTotal(SearchVO search) {
		return mapper.getTotalCnt(search);
	}
		
	@Override
	public BoardVO getBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		return mapper.insertBoard(bvo) == 1;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		return mapper.updateBoard(bvo) == 1;
	}

	@Override
	public boolean removeBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}
	
	
	@Override
	public MemberVO checkMember(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> memberLsit() {
		return mapper.memberList();
	}


	@Override public boolean addMember(MemberVO mvo) {
		return mapper.insertMember(mvo) == 1; }
	 

	@Override
	public boolean checkMemberId(String id) {
		return mapper.selectMemberAjax(id) == 1;
	}
	
	@Override
	public boolean removeMember(String id) {
		return mapper.deleteMember(id) == 1;
	}
	
	@Override
	public boolean updateMember(MemberVO mvo) {
		return mapper.updateMember(mvo) == 1;
	}

	@Override
	public boolean addMemberImage(MemberVO mvo) {
		return mapper.insertMember(mvo) == 1;
	}
}

package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	//업무 프로세스를 따라 실행하기 위한 서비스.
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession() 투르 넣으면 자동 커밋
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList() {
		//mapper에 등록된 기능 활용
		return mapper.boardList(); //boardList 컨트롤 -- 서비는 
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}

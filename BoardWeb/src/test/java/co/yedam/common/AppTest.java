package co.yedam.common;

import java.util.function.Consumer;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest {

	public static void main(String[] args) {
		
		
		//----------------------------------------------------------------------
		//댓글 페이지 조회ㅐ
		 SqlSession sqlSession = DataSource.getInstance().openSession(true);
		 ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		 
		 mapper.selectListPaging(11, 1).forEach(reply -> System.out.println(reply));
		

		// ----------------------------------------------------------------------

		// 매퍼가 잘 코딩되었는지 테스트하는 용도
		/*
		 * SqlSession sqlSession = DataSource.getInstance().openSession(true);
		 * ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		 * 
		 * //인터페잇ㅡ에 구현해 메소드가 하나만 있는 인터페이스 : 함수형 인터페이스
		 * 
		 * mapper.selectList(201).forEach(new Consumer<ReplyVO>() { public void
		 * accept(ReplyVO t) { System.out.println(t); }; });
		 * 
		 * //게시글 201번에 대한 댓글정보를 출력 //람다 표현식! mapper.selectList(201).forEach(reply ->
		 * System.out.println(reply));
		 * 
		 * //단건조회
		 * 
		 * ReplyVO rvo = mapper.selectReply(1); System.out.println(rvo);
		 * 
		 * 
		 * //댓글 입력 ReplyVO rvo = new ReplyVO(); rvo.setReply("배고프다");
		 * rvo.setReplyer("사람"); rvo.setBoardNo(11);
		 * 
		 * try { if(mapper.insertReply(rvo) == 1) { System.out.println("입력 성공"); } }
		 * catch (Exception e) { System.out.println("예외 발생"); }
		 * 
		 * 
		 * //댓글 삭제 if(mapper.deleteReply(6) == 1) { System.out.println("삭제 성공"); } else
		 * { System.out.println("삭제 실패"); } mapper.selectList(201).forEach(reply ->
		 * System.out.println(reply));
		 */

		// ----------------------------------------------------------------------

		/*
		 * SqlSessionFactory sqlSessionFactory = DataSource.getInstance(); SqlSession
		 * sqlSession = sqlSessionFactory.openSession();
		 * 
		 * 
		 * 
		 * //interface 구현 BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		 * 
		 * 
		 * SearchVO search = new SearchVO(1, "T", "자바");
		 * 
		 * mapper.boardListPaging(search).forEach(bvo -> System.out.println(bvo));
		 */

		// 목록 조회
//	List<BoardVO> list = mapper.boardList();
//	for(BoardVO bvo : list) {
//		System.out.println(bvo.toString());
//	}

		// 페이지 조회
//	List<BoardVO> list1 = mapper.boardListPaging(1);
//	for(BoardVO bvo : list1) {
//		System.out.println(bvo.toString());
//	}

		// 단건 조회
//	BoardService svc = new BoardServiceImpl();
//	System.out.println(svc.getBoard(100));
//	
//	System.out.println(mapper.selectBoard(100));

		// 등록
//	BoardVO board = new BoardVO();
//	board.setBoardNo(list.size()+1);
//	board.setTitle("제목없음");
//	board.setContent("내용없음");
//	board.setWriter("이름없음");
//	board.setClickCnt(0);	
//	System.out.println(mapper.insertBoard(board));
//	sqlSession.commit();

		// 수정
//	board.setContent("안녕");
//	board.setBoardNo(5);
//	System.out.println(mapper.updateBoard(board));
//	sqlSession.commit();

		// 삭제
//	if(mapper.deleteBoard(5) == 1) System.out.println("삭제");
//	else System.out.println("실패!");
//	sqlSession.commit();
	}

//	public static void main(String[] args) {
	// 00. DB 접근
//		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//sqlSession : DB 접속 쿼리 가져옴

	// interface 와 구현객체의 관계 설정, 연결지어주기
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	// StudentMapper.java를 객체처럼 사용 접근하기 위해서 --필수 아님

	// 01. 객체 생성
//		Student std = new Student();
//		std.setStdNo("S0010");
//		std.setStdName("서현진");
//		std.setPhone("010-1231-1231");
//		std.setBldType("A");

	// 02. 객체를 DB에 넣기
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
//		sqlSession.commit();

	// 03. DB에 저장된 객체를 수정하기
//		std.setPhone("010-0000-0000");
//		std.setStdNo("S0010");
	// sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
//		mapper.updateStudent(std);
//		sqlSession.commit();

	// 04. DB에 저장된 객체 삭제
//		sqlSession.delete("co.yedam.mapper.StudentMapper.deleteStudent", std);
//		mapper.deleteStudent(std);
//		sqlSession.commit();

	// 05. list console에 출력
//		List<Student> list //
////				= sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
//				= mapper.selectBlog();
//		for (Student std1 : list) {
//			System.out.println(std1.toString());
//		}
//		
//		
//	}	
//	

//	public static void main(String[] args) {
//		
//		insert2();
//
//	}
//	
//	static void insert() {
//		//00. DB 접근
//		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//sqlSession : DB 접속, 후에 지정한 쿼리 가져옴
//				
//		//01. 객체 생성
//		Student std = new Student();
//		std.setStdNo("S0010");
//		std.setStdName("서현진");
//		std.setPhone("010-1231-1231");
//		std.setBldType("A");
//		
//		//
//		// int insert(String statement, Object parameter); -- statement:문구
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
//		sqlSession.commit();
//		
//		//05. list console에 출력
//		List<Student> list //
//				= sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
//		for (Student std1 : list) {
//			System.out.println(std1.toString());
//		}
//	}
//	
//	
//	//insert 사용 2
//	static void insert2() {
//		//00. DB 접근
//		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//sqlSession : DB 접속, 후에 지정한 쿼리 가져옴
//				
//		//01. 객체 생성
//		Student std = new Student();
//		std.setStdNo("S0011");
//		std.setStdName("서현진");
//		std.setPhone("010-1231-1231");
//		std.setBldType("A");
//		
//		
//		//interface 와 구현객체의 관계 설정, 연결지어주기
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//		
//		mapper.insertStudent(std); //교수님께 여쭤보기!
//		//이렇게 접근하는 건 왜 안 되는지
//	
//		//05. list console에 출력
//		List<Student> list = mapper.selectBlog();
//		for (Student std1 : list) {
//			System.out.println(std1.toString());
//		}
//	}
//	
//	
//	static void update() {
//		//00. DB 접근
//		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//sqlSession : DB 접속 쿼리 가져옴
//		
//		//interface 와 구현객체의 관계 설정, 연결지어주기
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//		
//		//01. 객체 생성
//		Student std = new Student();
//		std.setStdNo("S0010");
//		std.setStdName("서현진");
//		std.setPhone("010-1231-1231");
//		std.setBldType("A");
//		
//		//03. DB에 저장된 객체를 수정하기
//		std.setPhone("010-0000-0000");
//		std.setStdNo("S0010");
//		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std); //교수님께 여쭤보기2 update = xml로 접근
//		mapper.updateStudent(std); //mapper.updateStudent = 인터페이스로 접근 <- 이게 맞는지 여쭤보기 / 위랑 아래랑 같은 기능인지
//		sqlSession.commit();
//
//		//05. list console에 출력
//		List<Student> list //
////				= sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
//				= mapper.selectBlog();
//		for (Student std1 : list) {
//			System.out.println(std1.toString());
//		}
//	}
//	
//	static void delete() {
//		//00. DB 접근
//		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//sqlSession : DB 접속 쿼리 가져옴
//		
//		//interface 와 구현객체의 관계 설정, 연결지어주기
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//		
//		//01. 객체 생성
//		Student std = new Student();
//		std.setStdNo("S0010");
//		std.setStdName("서현진");
//		std.setPhone("010-1231-1231");
//		std.setBldType("A");		
//		
//		//04. DB에 저장된 객체 삭제
//		sqlSession.delete("co.yedam.mapper.StudentMapper.deleteStudent", std);
////		mapper.deleteStudent(std);
//		sqlSession.commit();
//		
//		//05. list console에 출력
//		List<Student> list //
////				= sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
//				= mapper.selectBlog();
//		for (Student std1 : list) {
//			System.out.println(std1.toString());
//		}
//	}

} // end class

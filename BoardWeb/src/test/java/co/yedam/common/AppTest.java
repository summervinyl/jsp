package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.BoardMapper;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.Student;

public class AppTest {
	
public static void main(String[] args) {
	
	SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	
	//interface 구현
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	List<BoardVO> list = mapper.boardList();
	for(BoardVO bvo : list) {
		System.out.println(bvo.toString());
	}
}
	
//	public static void main(String[] args) {
		//00. DB 접근
//		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//sqlSession : DB 접속 쿼리 가져옴
		
		//interface 와 구현객체의 관계 설정, 연결지어주기
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		//StudentMapper.java를 객체처럼 사용 접근하기 위해서 --필수 아님
		
		//01. 객체 생성
//		Student std = new Student();
//		std.setStdNo("S0010");
//		std.setStdName("서현진");
//		std.setPhone("010-1231-1231");
//		std.setBldType("A");
		
		//02. 객체를 DB에 넣기
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
//		sqlSession.commit();
		
		//03. DB에 저장된 객체를 수정하기
//		std.setPhone("010-0000-0000");
//		std.setStdNo("S0010");
		//sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
//		mapper.updateStudent(std);
//		sqlSession.commit();
		
		//04. DB에 저장된 객체 삭제
//		sqlSession.delete("co.yedam.mapper.StudentMapper.deleteStudent", std);
//		mapper.deleteStudent(std);
//		sqlSession.commit();
		
		//05. list console에 출력
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

package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession : DB 접속 쿼리 가져옴
		
		//interface 와 구현객체의 관계 설정, 연결지어주기
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		
		Student std = new Student();
		std.setStdNo("S0010");
		std.setStdName("서현진");
		std.setPhone("010-1231-1231");
		std.setBldType("A");
		
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
//		sqlSession.commit();		
		
		std.setPhone("010-0000-0000");
		std.setStdNo("S0010");
		//sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
		mapper.updateStudent(std);
		sqlSession.commit();
		
//		sqlSession.delete("co.yedam.mapper.StudentMapper")
		
		List<Student> list //
//				= sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
				= mapper.selectBlog();
		for (Student std1 : list) {
			System.out.println(std1.toString());
		}
	}
}

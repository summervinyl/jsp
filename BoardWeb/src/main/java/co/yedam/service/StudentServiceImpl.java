package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.MemberVO;
import co.yedam.vo.Student;

public class StudentServiceImpl implements StudentService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession() 투르 넣으면 자동 커밋
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

	@Override
	public List<Student> studentList() {
		return mapper.selectBlog();
	}

	@Override
	public boolean addStudent(Student std) {
		return mapper.insertStudent(std) == 1;
		//boolean 리턴타입 true면 1
	}

	@Override
	public boolean modifyStudent(Student std) {
		return mapper.updateStudent(std) == 1;
	}
	
	
}

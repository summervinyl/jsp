package co.yedam;

import java.awt.dnd.DropTargetContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO{
	//등록, 삭제, 수정, 목록 기능 구현
	
	
	//
//	boolean updateNuber(Student std) {
//		getConnection();
//		
//		String sql = "update tbl_student set "
//	}
	//04. 정보 변경 (연락처)
	boolean updateStudent(Student std) {
		getConnection();
		
		String sql = "update tbl_student" + " set phone = ?" + " where std_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getPhone());
			psmt.setString(2, std.getStdNo());
			
			if(psmt.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); //자원해제
		}
		return false;
	}
	
	
	//03.정보 삭제
	boolean deleteStudent(String stdNo) {
		getConnection();
		
		String sql = "delete from tbl_student" + " where std_no = ?"; //띄어쓰기 주의!!
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			
			if(psmt.executeUpdate() == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); //자원해제
		}
		
		return false;
	}
	
	
	
	//02.정보 등록 기능 생성
	boolean insertStudent(Student std) {
		getConnection();
		
		String sql = "insert into tbl_student(std_no, std_name, phone, bld_type) values(?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getPhone());
			psmt.setString(4, std.getBldType());
			if(psmt.executeUpdate() == 1) {					//쿼리에 의해 처리된 건수 == 1
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); //자원해제
		}
		
		return false;
	} // end of insertStudent()
	
	//01.목록을 가져오는 기능 생성
	List<Student> StudentList(){
		getConnection(); //중요!! Connection 객체 (세션)
		
		String sql = "select * from tbl_student order by std_no";
		
		List<Student> students = new ArrayList<Student>();	//쿼리의 결과값을 students에 담기.
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();			//sql을 rs(ResultSet)에 담아줌
			
			//조회(처리)된 결과 목록을 List<Student>에 담아서 반환.
			while(rs.next()) {
				Student std = new Student();
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				std.setPhone(rs.getString("phone"));
				std.setBldType(rs.getString("bld_type"));
				std.setCreateDate(rs.getDate("create_date"));
				
				students.add(std); //디비에 조회값 하나를 List에 담아줌.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); //자원해제
		}
		return students;
	} // end of studentList()
	
	
} // end class

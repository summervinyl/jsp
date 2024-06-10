package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	//데이터 베이스(oracle sql developer) 연결해주자.
	
	//필드 : 타 클래스에서 편리하게 사용하기 위해 미리 선언해두자.
	//자바에서 DB와 연결하기 위해 사용하는 객체입니다.
	Connection conn;
	
	//파라미터가 포함된 SQL문을 DB에 전달하기 위한 preparedStatement 객체를 생성한다.
	PreparedStatement psmt;
	
	ResultSet rs;
	
	
	//메소드
	public void getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="jsp";
		String passwd = "jsp";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace(); //예외 발생했을 경우 로그 보는 것
		}
	}	
	
	//메모리 회복?
	//close() 순서도 중요!--역순으로 자원해제
	//마지막에 적어주기.
	public void disconn() {
		try {
			if(rs != null) rs.close();			
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

	
} //end class

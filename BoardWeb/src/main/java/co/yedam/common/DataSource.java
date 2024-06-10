package co.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	// SqlSessionFactory 반환 getInstance()
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml"; //경로는 무조건 String 타입
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			//resource 대신 url 쓰는 게 더 가독성 있음.
			//getResourceAsStream():얻다,자원을,경로로부터,리소스라는
			//Resources.getResourceAsStream() : 제공하는 Resources의 getResourceAsStream() = DB 접근 열쇠
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory //
				= new SqlSessionFactoryBuilder().build(inputStream);
		//sqlSessionFactory은 결국엔 내가 사용하고자 하는 DB!
		return sqlSessionFactory;
	}
	
}

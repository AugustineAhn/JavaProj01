package ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//객체생성의 목적이 아닌 상속의 목적으로 정의된 추상클래스
public abstract class ConnectDB {

	/*
	 멤버변수:상속받은 하위클래스
	 */
	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;
	protected PreparedStatement psmt;
	
	public ConnectDB() {

		try {

			Class.forName("oracle.jdbc.OracleDriver");

			con=DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl", 
					"kosmo", "1234");
			System.out.println("오라클 DB 연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("알수없는 아이디");
		}
	}
	//자원반납을 위한 메소드
	public void close() {

		try {
			if (stmt!=null) stmt.close();
			if(con!=null)con.close();
			if(rs!=null)rs.close();
			System.out.println("DB자원반납완료");
		}
		catch(SQLException e){
			System.out.println("자원반납시 오류발생");
		}
	}//end of close
	
	/*
	 오버라이딩을 목적으로 정의한 추상메소드
	 */
	abstract void dataInput();
	
	abstract void dataSearch();
	
	abstract void dataDelete();
	
	
}

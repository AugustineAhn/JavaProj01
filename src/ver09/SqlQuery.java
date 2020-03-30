package ver09;

import java.sql.SQLException;
import java.util.Scanner;

public class SqlQuery extends ConnectDB{
	
	public SqlQuery() {
		super();
	}
	void dataInput() {
		try {
			//1.쿼리문준비: 값의 세팅이 필요한 부분을 ?로 대체한다.
			String query = "INSERT INTO member VALUES (?, ?, ?)";
			
			//2. prepared객체 생성: 생성시 준비한 쿼리문을 인자로 전달한다.
			psmt=con.prepareStatement(query);
			
			//3. DB에 입력할 값을 사용자로부터 입력받음.
			Scanner scan = new Scanner(System.in);
			System.out.print("이름");
			String name = scan.nextLine();
			System.out.print("전화번호");
			String phonenumber = scan.nextLine();
			System.out.print("생일");
			String birthday = scan.nextLine();
			
				
			
			//5. 쿼리실행을 위해 prepared 객체를 실행한다.
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력되었습니다.");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	void dataDelete() {

		try {
			
			stmt = con.createStatement();
			
			String query = "DELETE FROM member WHERE name=' '";
			int affected = stmt.executeUpdate(query);
						
			System.out.println(affected+"행이 삭제되었습니다.");
					
		}
		catch(SQLException e) {
			System.out.println("쿼리실행 오류.");
			e.printStackTrace();
		}
		finally {
			//6.자원반납
			close();
		}
		}
	}//end of execute

	public void close() {
		try {
			if(stmt!=null) stmt.close();//Statement객체 자원반납
			if(con!=null) con.close();//Connection 객체 자원반납
			System.out.println("자원반납완료");
			
		}
		catch(SQLException e) {
			System.out.println("자원반납시 오류가 발생");
		}
	}//end of close
	
	void dataSearch() {
		
		try {
			stmt=con.createStatement();
			
			String query="SELECT name, phonenumber, birthday from member";
			
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("name");
				String phonenumber = rs.getString("phonenumber");
				String name = rs.getString("birthday");
				
			}
					
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	
}

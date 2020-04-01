package ver09;

import java.sql.SQLException;

public class SearchSQL extends IConnectImpl {


	@Override
	public void execute() {
		try {
			String query = "SELECT * FROM phonebook_tb"
					+ "	WHERE \"이름\" LIKE '"+ scanValue("찾는이름")+"' ";
					
			
			
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString("이름");
				String phoneNumber = rs.getString("전화번호");
				String birthday = rs.getString("생일");
				
				System.out.printf("이름: %-10s 전화번호: %-15s 생일: %-10s \n",
						name, phoneNumber, birthday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	
	
	
}

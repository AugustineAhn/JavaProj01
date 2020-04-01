package ver09;

import java.sql.SQLException;

public class ShowAllSQL extends IConnectImpl {


	@Override
	public void execute() {
		try {
			String query = "SELECT * FROM phonebook_tb ";
			
			
			psmt = con.prepareStatement(query);
            rs = psmt.executeQuery();

            
			while(rs.next()) {
				String name = rs.getString("이름");
				String phoneNumber = rs.getString("전화번호");
				String birthday = rs.getString("생일");
				/*
				오라클의 date타입을 getDate()로 추출하면 2020-03-15
				포맷으로 출력된다. 이경우 date형 자료가 되기때문에
				java.sql.Date클래스의 참조변수로 저장해야한다.
				 */

				System.out.printf("이름: %-10s 전화번호: %-15s 생일: %-10s \n",
						name, phoneNumber, birthday);
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	
}

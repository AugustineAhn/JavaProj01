import java.util.Scanner;


import ver09.PhoneBookManager;
import ver09.SqlQuery;
import ver09.connect.IConnectimpl;
import ver09.statement.ConnectDB;

public class PhoneBookVer9 extends IConnectimpl {

	public static void main(String[] args) {



	
		new SqlQuery().dataInput();
		new SqlQuery().dataSearch();
		new SqlQuery().dataDelete();
	
	
	}
}

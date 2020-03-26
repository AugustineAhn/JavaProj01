import ver01.PhoneInfo01;

public class PhoneBookVer01 {

	public static void main(String[] args) {


		PhoneInfo01 p1 = new PhoneInfo01("토니스타크", "010-1111-1111", 
				"70-01-01");
		PhoneInfo01 p2 = new PhoneInfo01("브루스배너", "010-2222-2222", 
				"70-01-01");

		p1.showPhoneInfo();
		p2.showPhoneInfo();
	}

}

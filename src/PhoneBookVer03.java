import java.util.Scanner;


import ver03.PhoneBookManager;

public class PhoneBookVer03 {

	public static void main(String[] args) {

		//프로그램 전반에 대한 비즈니스로직을 가진 핸들러 객체 생성
		PhoneBookManager manager =new PhoneBookManager(100);
		manager.printMenu();
	}
}

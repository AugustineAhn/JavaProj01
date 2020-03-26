import java.util.Scanner;

import ver03.PhoneBookManager;

public class PhoneBookVer03 {

	public static void menuShow() {

		System.out.println("***메뉴를 선택하세요***");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴선택>>>");
	}
	public static void main(String[] args) {

		//프로그램 전반에 대한 비즈니스로직을 가진 핸들러 객체 생성
		PhoneBookManager manager =new PhoneBookManager(100);
		while(true) {
			//메뉴출력을 위한 메소드호출
			menuShow();

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch(choice) {
			case 1: //데이터입력
				manager.dataInput(choice);
				break;
			case 2:
				//데이터검색
				manager.dataSearch();
				break;
			case 3:
				//데이터삭제
				manager.dataDelete();
				break;
			case 4:
				//주소록출력
				manager.dataAllShow();
				break;

			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;

			}
		}
	}
}

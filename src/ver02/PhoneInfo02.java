package ver02;

import java.util.Scanner;

public class PhoneInfo02 {

	//멤버변수
	String name;
	String phoneNumber;
	String birthday;

	public void insert() {

		int choice;
		Scanner scan =new Scanner(System.in);

		

		while (true) {
			System.out.println("선택하세요....");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 프로그램 종료");
			System.out.print("선택: ");
			choice = scan.nextInt();
			scan.nextLine();
			
			if(choice==1) {


				System.out.print("이름을 입력하세요 : ");
				name = scan.nextLine();

				System.out.print("전화번호를 입력하세요 : ");
				phoneNumber=scan.nextLine();

				System.out.print("생년월일을 입력하세요 : ");
				birthday=scan.nextLine();

				showPhoneInfo();
			}
			else if(choice!=1) {

				System.out.println("프로그램 종료");
				break;
			}

		}
	}

	//정보출력용 메소드
	public void  showPhoneInfo() {

		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);
		if(birthday==null) {
			System.out.println("생년월일 입력되지 않음");
		}
		else {
			System.out.println("생년월일: "+ birthday);
		}

	}
}

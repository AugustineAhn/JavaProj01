package ver07;

import java.util.Scanner;

public class PhoneInfo {

	//멤버변수
	public String name;
	String phoneNumber;



	public PhoneInfo(String name, String phoneNumber) {


		this.name = name;
		this.phoneNumber = phoneNumber;

	}

	@Override
	public String toString() {

		return "\n이름: " + name + "전화번호: " + phoneNumber;
	}

	@Override
	public int hashCode() {

		int hc1 = name.hashCode();
		int hc2 = name.hashCode();
		int result = hc1+hc2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		PhoneInfo pi = (PhoneInfo)obj;
		if(pi.name.equals(this.name)) {
					return true;
		}
		
		else {
					
			return false;
		}

	}

	public void dataInput() {

		int choice;
		Scanner scan =new Scanner(System.in);



		while (true) {
			System.out.println("선택하세요....");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 주소록 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택: ");
			choice = scan.nextInt();
			scan.nextLine();

			if(choice==1) {

				System.out.println("데이터 입력을 시작합니다.");
				System.out.print("이름을 입력하세요 : ");
				name = scan.nextLine();

				System.out.print("전화번호를 입력하세요 : ");
				phoneNumber=scan.nextLine();



				System.out.println("데이터 입력이 완료되었습니다.");

				showPhoneInfo();
			}
			else if(choice!=1) {

				System.out.println("프로그램 종료");
				break;
			}

		}
	}

	//정보출력용 메소드
	public void showPhoneInfo() {

		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);

	}
}

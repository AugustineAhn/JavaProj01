package ver07;

import java.io.Serializable;
import java.util.Scanner;

public class PhoneInfo implements Serializable{

	//멤버변수
	public String name;
	String phoneNumber;



	public PhoneInfo(String name, String phoneNumber) {


		this.name = name;
		this.phoneNumber = phoneNumber;

	}

	@Override
	public String toString() {

		return "이름: \n" + name + "전화번호: \n" + phoneNumber;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return true;
		}
		
		
		PhoneInfo other = (PhoneInfo) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	//정보출력용 메소드
	public void showPhoneInfo() {

		System.out.println("이름: \n"+ name);
		System.out.println("전화번호: \n"+ phoneNumber);

	}
}

package ver06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookManager {
	String name;
	String phone;
	PhoneInfo[] myFriends;
	int numOfFriends=0;

	public PhoneBookManager(int size) {
		myFriends = new PhoneInfo[size];
		numOfFriends=0;
	}

	public void printMenu() {

		try {
		System.out.println("***메뉴를 선택하세요***");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴선택>>>");

		
			Scanner scan = new Scanner(System.in);

			int group = scan.nextInt();

			if(group<1||group>5) {
				MenuSelectException mse =
						new MenuSelectException();
				throw mse;
			}

			switch(group) {
			case MenuItem.INPUT1 : //데이터입력	
				System.out.println("데이터입력을 시작합니다.");
				System.out.println("1.일반, 2.동창, 3.회사.");
				int num = scan.nextInt();

				dataInput(num);
				break;			
			case MenuItem.INPUT2://데이터검색

				dataSearch();
				break;
			case MenuItem.INPUT3://데이터삭제

				dataDelete();
				break;
			case MenuItem.INPUT4://주소록출력
				dataAllShow();
				break;

			case MenuItem.INPUT5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}	
		}
		catch (InputMismatchException e) {
			System.out.println("숫자만 입력 해주세요");
			printMenu();
		}
		catch (MenuSelectException e) {
			System.out.println("1에서 5까지만 입력하세요.");
			
		}
		printMenu();
	}




	public void dataAllShow() {
		System.out.println("주소록 전체를 출력합니다.");
		for(int i=0;i<numOfFriends;i++) {
			myFriends[i].showPhoneInfo();
		}
		System.out.println("주소록이 출력되었습니다.");
		
		printMenu();
	}
	public void dataInput(int choice4) {

		String iName, iPhone;
		String company;
		int year;
		String major;
		Scanner scan = new Scanner(System.in);

		switch (choice4) {
		case SubMenuItem.Input1:
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			myFriends[numOfFriends++] = new PhoneInfo(iName, iPhone);
			break;
			
		case SubMenuItem.Input2:
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			System.out.print("전공:"); major = scan.nextLine();
			System.out.print("학년:"); year = scan.nextInt();

			myFriends[numOfFriends++] = new PhoneSchoolInfo(iName, iPhone, major, year );

			break;
			
		case SubMenuItem.Input3:
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			System.out.print("회사:"); company = scan.nextLine();
			myFriends[numOfFriends++] = new PhonCompanyInfo(iName, iPhone, company);

			break;

		default:
			break;
		}
		printMenu();
	}


	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName4 = scan.nextLine();
		
		
		System.out.println(numOfFriends+"numOfFriends");
		
		
		
		for (int i = 0; i < numOfFriends; i++) {
			if (searchName4.compareTo(myFriends[i].name)==0) {
				myFriends[i].showPhoneInfo();

				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");

			}
			
		}
		printMenu();
	}
	public void dataDelete() {

		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요:");
		String deleteName4 = scan.nextLine();


		

		for (int i = 0; i < numOfFriends; i++) {
			if (deleteName4.compareTo(myFriends[i].name)==0) {
				myFriends[i] = null;
				numOfFriends--;
				
				
				int deleteIndex = -1;
				for (int j = deleteIndex; j < numOfFriends; j++) {
					myFriends[j] = myFriends[j+1];
				}
				System.out.println("==데이터("+deleteIndex+ "번)가 삭제되었습니다==");
				//삭제할 이름으로  배열의 이름을 찾을경우
			}
			else{ //삭제할 이름으로  배열의 이름을 못 찾을경우
				System.out.println("==삭제된 데이터가 없습니다.");
			}
		}
		printMenu();
	}
}

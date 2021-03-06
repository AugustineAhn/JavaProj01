package ver03;

import java.util.Scanner;

public class PhoneBookManager {
	String name;
	String phone;
	String birthday;
	PhoneInfo[] myFriends;
	public int numOfFriends;
	
	public PhoneBookManager(int size) {
		myFriends = new PhoneInfo[size];
		numOfFriends=0;
	}
	
	public void printMenu() {
		
		System.out.println("***메뉴를 선택하세요***");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴선택>>>");

		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		switch(choice) {
		case 1: //데이터입력
			dataInput(choice);
			break;
		case 2:
			//데이터검색
			dataSearch();
			break;
		case 3:
			//데이터삭제
			dataDelete();
			break;
		case 4:
			//주소록출력
			dataAllShow();
			break;

		case 5:
			System.out.println("프로그램을 종료합니다.");
			return;
		}
	}
	
	public void dataAllShow() {
		System.out.println("주소록 전체를 출력합니다.");
		for(int i=0;i<numOfFriends;i++) {
			myFriends[i].showPhoneInfo();
		}
		System.out.println("주소록이 출력되었습니다.");
		printMenu();
	}

	public void dataInput(int choice) {

		Scanner scan = new Scanner(System.in);

		String iName, iPhone, iBirthday;

		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("생일:");iBirthday = scan.nextLine();


		if (choice==1) {

			PhoneInfo common = new PhoneInfo(iName, iPhone, iBirthday);
			myFriends[numOfFriends++] = common;
		}
		printMenu();
	}

	
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();

		for (int i = 0; i < numOfFriends; i++) {
			if (searchName.compareTo(myFriends[i].name)==0) {
				myFriends[i].showPhoneInfo();

				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");

			}
		}
		printMenu();
	}
	public void dataDelete() {

		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();


		int deleteIndex = -1;

		for (int i = 0; i < numOfFriends; i++) {
			if (deleteName.compareTo(myFriends[i].name)==0) {
				myFriends[i] = null;
				deleteIndex = i;
				numOfFriends--;
			}
		}
		if (deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다.");
		} else {

			for (int i = deleteIndex; i < numOfFriends; i++) {
				myFriends[i] = myFriends[i+1];

			}
			System.out.println("==데이터("+deleteIndex 
					+ "번)가 삭제되었습니다==");
		}
		printMenu();
	}


}

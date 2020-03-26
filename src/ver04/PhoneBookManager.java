package ver04;

import java.util.Scanner;

public class PhoneBookManager {
	String name;
	String phone;
	
	PhoneInfo[] myFriends;
	public int numOfFriends=0;
	
	public PhoneBookManager(int size) {
		myFriends = new PhoneInfo[size];
		numOfFriends=0;
	}

	public PhoneBookManager(String name, String phone) {
		this.name = name;
		this.phone = phone;
		
	}

	
	public void dataAllShow() {
		System.out.println("주소록 전체를 출력합니다.");
		for(int i=0;i<numOfFriends;i++) {
			myFriends[i].showPhoneInfo();
		}
		System.out.println("주소록이 출력되었습니다.");
	}
	public void dataInput(int choice) {

		Scanner scan = new Scanner(System.in);

		String iName, iPhone;

//		System.out.print("이름:");iName = scan.nextLine();
//		System.out.print("전화번호:");iPhone = scan.nextLine();
//		PhoneInfo high = new PhoneInfo(iName, iPhone);
//		myFriends[numOfFriends++] = high;
		
		String company;
		int year;
		String major;
		
		
		switch (choice) {
		case 1:
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			myFriends[numOfFriends++] = new PhoneInfo(iName, iPhone);
			break;
		case 2:
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			System.out.print("전공:"); major = scan.nextLine();
			System.out.print("학년:"); year = scan.nextInt();
					
			myFriends[numOfFriends++] = new PhoneSchoolInfo(iName, iPhone, major, year );
			
			break;
		case 3:
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			System.out.print("회사:"); company = scan.nextLine();
			myFriends[numOfFriends++] = new PhonCompanyInfo(iName, iPhone, company);
			
			break;

		default:
			break;
		}
		
		
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
	}


}

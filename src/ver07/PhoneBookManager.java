package ver07;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;



public class PhoneBookManager {

	String name;
	String phone;
	HashSet<PhoneInfo> myFriends;



	public PhoneBookManager(int size) {
		myFriends = new HashSet<>(size);

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
			printMenu();
		}

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


			PhoneInfo commFreind = new PhoneInfo(iName, iPhone);
			myFriends.add(commFreind);

			break;

		case SubMenuItem.Input2:
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			System.out.print("전공:"); major = scan.nextLine();
			System.out.print("학년:"); year = scan.nextInt();

			PhoneSchoolInfo schoolFreind = new PhoneSchoolInfo(iName, iPhone, major, year);
			myFriends.add(schoolFreind);

			break;

		case SubMenuItem.Input3:
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			System.out.print("회사:"); company = scan.nextLine();

			PhoneInfo companyFriend = new PhonCompanyInfo(iName, iPhone, company);
			myFriends.add(companyFriend);

			break;

		default:
			break;
		}
	}


	public void dataAllShow() {
		System.out.println("주소록 전체를 출력합니다.");
		for(PhoneInfo pi : myFriends) {

			System.out.println(pi.toString());
		}

		printMenu();

	}


	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName4 = scan.nextLine();

		boolean searchFlag = false;

		Iterator<PhoneInfo> itr = myFriends.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(searchName4.equals(pi.name)) {

				searchFlag = true;

				System.out.println(pi);
			}
		}

		if(searchFlag==true) {
			System.out.println("요청하신 정보를 찾았습니다.");
		}
		else {
			System.out.println("찾는 사람이 없어요.");
		}

		System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");


		printMenu();

	}


	public void dataDelete() {

		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요:");
		String deleteName4 = scan.nextLine();
		boolean searchFlag = false;

		Iterator<PhoneInfo> itr = myFriends.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(deleteName4.equals(pi.name)) {

				searchFlag = true;
				System.out.println(myFriends.remove(deleteName4));
				
			}

		}
		printMenu();
	}
}

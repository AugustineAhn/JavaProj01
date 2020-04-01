package ver07;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;



public class PhoneBookManager {
	Scanner scan = new Scanner(System.in);
	String name;
	String phone;
	HashSet<PhoneInfo> myFriends = new HashSet<PhoneInfo>();



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


	public void nameCheck(PhoneInfo compFreind) {
		
		
		if(myFriends.add(compFreind))
			System.out.println("입력이 완료되었습니다.");
		else {
			System.out.print("이름이 같습니다 덮어쓰기하실래요? 1.예  2.나가기");
			int nameCheck = scan.nextInt();
			
			
			if(nameCheck==1) {
				myFriends.remove(compFreind);
				myFriends.add(compFreind);
			}
			else {
				System.out.println("취소되엇습니다.");
				return;
			}
			
		}
		
	}
		
	
	public void dataInput(int choice7) {

		String iName, iPhone;
		String company;
		int year;
		String major;
		Scanner scan = new Scanner(System.in);

		switch (choice7) {
		case SubMenuItem.Input1:
			
			System.out.print("이름:\n");	iName = scan.nextLine();
			System.out.print("전화번호:\n");	iPhone = scan.nextLine();
			
			
			PhoneInfo compFreind = new PhoneInfo(iName, iPhone);
			
			nameCheck(compFreind);
			
				

			
			

			break;

		case SubMenuItem.Input2:
			System.out.print("이름:\n");iName = scan.nextLine();
			System.out.print("전화번호:\n");iPhone = scan.nextLine();
			System.out.print("전공:\n"); major = scan.nextLine();
			System.out.print("학년:\n"); year = scan.nextInt();

			PhoneInfo schoolFreind = new PhoneSchoolInfo(iName, iPhone, major, year);
			nameCheck(schoolFreind);

			break;

		case SubMenuItem.Input3:
			System.out.print("이름:\n");iName = scan.nextLine();
			System.out.print("전화번호:\n");iPhone = scan.nextLine();
			System.out.print("회사:\n"); company = scan.nextLine();

			PhoneInfo companyFriend = new PhonCompanyInfo(iName, iPhone, company);
			nameCheck(companyFriend);

			break;

		default:
			break;
		}
		printMenu();
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
		System.out.print("검색할 이름을 입력하세요: \n");
		String searchName4 = scan.nextLine();

		boolean searchFlag = false;

		Iterator<PhoneInfo> itr = myFriends.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(searchName4.equals(pi.name)) {///////////////////////////

				searchFlag = true;

				System.out.println(pi.toString());
			}
		}

		if(searchFlag==true) {
			System.out.println("요청하신 정보를 찾았습니다.");
			System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
		}
		else {
			System.out.println("찾는 사람이 없어요.");
		}



		printMenu();

	}

	public void dataDelete() {

		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요: \n");
		String deleteName4 = scan.nextLine();
		boolean searchFlag = false;

		Iterator<PhoneInfo> itr = myFriends.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(deleteName4.equals(pi.name)) {

				searchFlag = true;
				itr.remove();

			}

		}
		printMenu();
	}
}

package ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ver08.PhoneInfo;;

public class PhoneBookManager implements MenuItem {

	String name;
	String phone;
	HashSet<PhoneInfo> myFriends ;



	public PhoneBookManager() {
		myFriends = new HashSet<PhoneInfo>();
		try {
			//역직렬화(복원)을 위한 스트림 생성
			ObjectInputStream in = 
				new ObjectInputStream(
					new FileInputStream("src/ver08/PhoneBook.obj")
				);
			
			while(true) {
				//저장된 파일에서 정보 1개 읽어오기
				PhoneInfo friend = (PhoneInfo)in.readObject();
				//만약 읽어올 정보(객체)가 더이상 없다면 루프 탈출
				if(friend==null) break;
				//읽어온 객체를 통해 정보출력
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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
				saveFriendInfo();
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


	public void nameCheck(String iName) {

		Iterator<PhoneInfo> itr = myFriends.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			Scanner scan = new Scanner(System.in);

			System.out.print("1.이름이 같습니다 덮어쓰기하실래요? 2.나가기");
			int nameCheck = scan.nextInt();

			if(nameCheck==1) {
				if(iName.equals(pi.name)) {
					itr.remove();
				}
			}else if(nameCheck==2) {
				printMenu();
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
			System.out.print("이름: \n");iName = scan.nextLine();
			nameCheck(iName);
			System.out.print("전화번호: \n");iPhone = scan.nextLine();

			PhoneInfo compFreind = new PhoneInfo(iName, iPhone);
			myFriends.add(compFreind);


			break;

		case SubMenuItem.Input2:
			System.out.print("이름: \n");iName = scan.nextLine();
			nameCheck(iName);
			System.out.print("전화번호: \n");iPhone = scan.nextLine();
			System.out.print("전공: \n"); major = scan.nextLine();
			System.out.print("학년: \n"); year = scan.nextInt();

			PhoneSchoolInfo schoolFreind = new PhoneSchoolInfo(iName, iPhone, major, year);
			myFriends.add(schoolFreind);

			break;

		case SubMenuItem.Input3:
			System.out.print("이름: \n");iName = scan.nextLine();
			nameCheck(iName);
			System.out.print("전화번호: \n");iPhone = scan.nextLine();
			System.out.print("회사: \n"); company = scan.nextLine();

			PhoneInfo companyFriend = new PhonCompanyInfo(iName, iPhone, company);
			myFriends.add(companyFriend);

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


	public void saveFriendInfo() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/ver08/PhoneBook.obj")
					);

			//myFriends 객체배열에 저장된 친구의 정보만큼 반복
			for(PhoneInfo p : myFriends) {
				//객체배열의 i번째 요소를 파일로 저장
				out.writeObject(p);
			}
			
			out.writeObject(null);
			out.close();
		}
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}		
	}
	
	
	
	

}

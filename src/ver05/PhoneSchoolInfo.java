package ver05;


public class PhoneSchoolInfo extends PhoneInfo {

	String major;
	int year;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int year) {
		super(name, phoneNumber);
		
		this.major=major;
		this.year=year;
	}
	public void showPhoneInfo() {

		super.showPhoneInfo();
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ year);
		
	}

}

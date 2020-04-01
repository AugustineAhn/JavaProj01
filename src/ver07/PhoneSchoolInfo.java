package ver07;


public class PhoneSchoolInfo extends PhoneInfo {

	String major;
	int year;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int year) {
		super(name, phoneNumber);
		
		this.major=major;
		this.year=year;
	}
	
	@Override
	public String toString() {

		return "이름: \n" + name + "전화번호: \n" + phoneNumber + 
				"전공: \n" + major +"학년: \n"+ year;
	}


	
	
	
}

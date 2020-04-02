package ver08;


@SuppressWarnings("serial")
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

		return "이름: " + name + "\n전화번호: " + phoneNumber + 
				"\n전공: " + major +"\n학년: "+ year;
	}


}

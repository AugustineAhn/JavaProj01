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

		return "\n이름: " + name + "전화번호: " + phoneNumber + 
				"전공: " + major +"학년: "+ year;
	}

	@Override
	public int hashCode() {

		int hc1 = name.hashCode();
		int hc2 = name.hashCode();
		int hc3 = name.hashCode();
		int hc4 = name.hashCode();
		
		int result = hc1+hc2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		PhoneInfo pi = (PhoneInfo)obj;
		if(pi.name.equals(this.name))  {
					return true;
		}
		
		else {
					
			return false;
		}

	}

}

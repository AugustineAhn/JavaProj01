package ver08;


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

		return "이름: \n " + name + "전화번호: \n" + phoneNumber + 
				"전공: \n" + major +"학년: \n"+ year;
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

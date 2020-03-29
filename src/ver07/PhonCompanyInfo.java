package ver07;

public class PhonCompanyInfo extends PhoneInfo {

	String company;
	
	
	public PhonCompanyInfo(String name, String phoneNumber,String company) {
		super(name, phoneNumber);
		
		this.company=company;

	}
	
	@Override
	public String toString() {

		return "\n이름: " + name + "전화번호: " + phoneNumber + "회사: " + company;
	}

	
	@Override
	public int hashCode() {

		int hc1 = name.hashCode();
		int hc2 = name.hashCode();
		int hc3 = name.hashCode();
		int result = hc1+hc2+hc3;
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

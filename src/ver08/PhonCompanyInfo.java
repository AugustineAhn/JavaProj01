package ver08;

@SuppressWarnings("serial")
public class PhonCompanyInfo extends PhoneInfo {

	String company;
	
	
	public PhonCompanyInfo(String name, String phoneNumber,String company) {
		super(name, phoneNumber);
		
		this.company=company;

	}
	
	@Override
	public String toString() {

		return "이름: " + name + "\n전화번호: " + phoneNumber + "\n회사: " + company;
	}



	

}

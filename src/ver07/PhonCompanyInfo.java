package ver07;

public class PhonCompanyInfo extends PhoneInfo {

	String company;
	
	
	public PhonCompanyInfo(String name, String phoneNumber,String company) {
		super(name, phoneNumber);
		
		this.company=company;

	}
	
	@Override
	public String toString() {

		return "이름: \n" + name + "전화번호: \n" + phoneNumber + "회사: \n" + company;
	}


	

}

package ver06;

public class PhonCompanyInfo extends PhoneInfo {

	String company;
	
	
	public PhonCompanyInfo(String name, String phoneNumber,String company) {
		super(name, phoneNumber);
		
		this.company=company;

	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사: "+ company);
	}

}

public class CreditDebit implements Payment {

	
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	CreditDebit(String name, String ccNum, String cvv, String expiryDate){
		this.name=name;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}

	@Override
	public String pay(double amount) {
		
		 return amount +" paid with credit/debit card";
		
	}
}


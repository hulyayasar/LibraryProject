public class Cash implements Payment {
	
	private double amount;

	Cash(double amount){
		this.amount = amount;
	}
	
	Cash(){
		
	}

	@Override
	public String pay(double amount) {
		String result = "$"+amount +" paid in cash.";
		return result;
		
	}

}
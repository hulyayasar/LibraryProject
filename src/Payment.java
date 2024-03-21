
public abstract class Payment {

	
	 String name;
	
	double balance;
	// maybe add a strategy for non cash payments
	double withdraw(double amount) {return 0.0;}
	void deposit(double amount) {}
}

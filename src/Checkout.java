
public class Checkout {

	User user;
	Payment paymentType;
	Item[] items;
	double totalCost;
	String couponCode;
	
	String isCouponAvailable(Item item) {return null;}
double applyCoupon(String coupon) {return 0.0;}
String makePayment(Payment payment) {



		return payment.pay(totalCost);
	}
String useOnlineWallet(User user, Payment pt) {
		return null;
	}


}


public class Rent {

	User user;
	Item itemType;
	boolean canRent;
	double OverdueCost;
	int numOfItemsRented;
	
	boolean subscribe(Item item, User user) {return false;}
	double calculateOverdue(User user) {
		return this.OverdueCost * this.numOfItemsRented;
	}
	String requestNewBook(User user, Item item ) {return null;}
	String payOrRentItem() {return null;}
	String cancelSubscription(Item item, User user) {return null;}
}


public class MagazineNewspaper extends OnlineItem {

	int subscriptiontime;
	
	public MagazineNewspaper(String name, int subscriptionTime2) {
		super.setName(name);
		setSubscriptiontime(subscriptionTime2);
	}

	public MagazineNewspaper(String name, int itemID, String author, double price, boolean isDisabled,
			boolean buyable) {
		super.setName(name);
		super.setItemID(itemID);
		super.setAuthor(author);
		super.setPrice(price);
		super.setDisabled(isDisabled);
		super.setBuyable(buyable);
	}

	String renewSubscription(User user,Item item) {return null;}

	public int getSubscriptiontime() {
		return subscriptiontime;
	}

	public void setSubscriptiontime(int subscriptiontime) {
		this.subscriptiontime = subscriptiontime;
	}
	
	public String getType() {
		this.type = "MagazineNewspaper";
		return this.type;
		
		
	}
}

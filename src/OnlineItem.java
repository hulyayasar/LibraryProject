
public abstract class OnlineItem extends Item {

	boolean isSubscription;
	
	String readItem() {return null;}

	public boolean isSubscription() {
		return isSubscription;
	}

	public void setSubscription(boolean isSubscription) {
		this.isSubscription = isSubscription;
	}
	
}

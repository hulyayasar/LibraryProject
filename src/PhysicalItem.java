
public class PhysicalItem extends Item {

	String itemLocation;
	int itemAmountLeft;
	public PhysicalItem(String name, String itemLocation2) {
		super.setName(name);
		setItemLocation(itemLocation2);
		
		
	}
	public PhysicalItem(String name, int itemID, String author, double price, boolean isDisabled, boolean buyable) {
		super.setName(name);
		super.setItemID(itemID);
		super.setAuthor(author);
		super.setPrice(price);
		super.setDisabled(isDisabled);
		super.setBuyable(buyable);
	}
	public String getItemLocation() {
		return itemLocation;
	}
	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}
	public int getItemAmountLeft() {
		return itemAmountLeft;
	}
	public void setItemAmountLeft(int itemAmountLeft) {
		this.itemAmountLeft = itemAmountLeft;
	}
}

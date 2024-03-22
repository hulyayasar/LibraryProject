
public class OnlineTextbook extends OnlineItem {

	int textbooksLeft;
	
	public OnlineTextbook(String name, int textbooksLeft2) {
		super.setName(name);
		setTextbooksLeft(textbooksLeft2);
	}

	public OnlineTextbook(String name, int itemID, String author, double price, boolean isDisabled, boolean buyable) {
		super.setName(name);
		super.setItemID(itemID);
		super.setAuthor(author);
		super.setPrice(price);
		super.setDisabled(isDisabled);
		super.setBuyable(buyable);
	}

	Item getTextbook(User user) {return null;}

	public int getTextbooksLeft() {
		return textbooksLeft;
	}

	public void setTextbooksLeft(int textbooksLeft) {
		this.textbooksLeft = textbooksLeft;
	}
}

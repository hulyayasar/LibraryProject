
public  class Item {

	 private String name;
     private int itemID;
     private String author;
     private double price;
     private String type;
     private boolean isDisabled;
     private boolean buyable;
     private int rentalDuration; 
     

     public Item() {
    	 
     }
       
        public Item(String name, int itemID, String author, double price, String type, boolean isDisabled, boolean buyable) {
            this.name = name;
            this.itemID = itemID;
            this.author = author;
            this.price = price;
            this.type = type;
            this.isDisabled = isDisabled;
            this.buyable = buyable;
            this.rentalDuration =0; 
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getItemID() {
            return itemID;
        }

        public void setItemID(int itemID) {
            this.itemID = itemID;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isDisabled() {
            return isDisabled;
        }

        public void setDisabled(boolean disabled) {
            isDisabled = disabled;
        }

        public boolean isBuyable() {
            return buyable;
        }

        public void setBuyable(boolean buyable) {
            this.buyable = buyable;
        }

        public int getRentalDuration() {
            return rentalDuration;
        }

        public void setRentalDuration(int rentalDuration) {
            this.rentalDuration = rentalDuration;
        }
    

	
}

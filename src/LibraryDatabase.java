import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryDatabase {

	Item item;
	User management;
	User user;
	// Maybe add Iterator design for arrays
	Item[] itemsBlocked;
	Item[] itemsList;
	String[] itemsRented;
	String[] bookPriorityQueue;
	
	int itemAmountLeft(Item item) {
		 int count = 0;
	        for (Item i : itemsList) {
	            if (i != null && i.equals(item)) {
	                count++;
	            }
	        }
	        return count;
	}
	
	boolean itemAvailabilty(Item item) {

		for (Item i : itemsList) {
            if (i != null && i.equals(item)) {
                for (String rentedItem : itemsRented) {
                    if (rentedItem != null && rentedItem.equals(item.getName())) {
                        return false; 
                    }
                }
                return true; 
            }
        }
        return false; 
     }
	
	String isItemLost(Item item){
		 for (Item i : itemsList) {
	            if (i != null && i.equals(item)) {
	                for (String rentedItem : itemsRented) {
	                    if (rentedItem != null && rentedItem.equals(item.getName())) {
	                       
	                        if (i.getRentalDuration() > 15) {
	                            
	                            return "Item is lost";
	                        } else {
	                            
	                            return "Item is not lost";
	                        }
	                    }
	                }
	                return "Item is not rented"; 
	            }
	        }
	        return "Item not found"; 
	}
	
	String verifyUser(User mt, User user) {
		if (user.getRegistration() instanceof NotRegistered) {
            
            return "User is not registered";
        } else {
           
            return user.getRegistration().register(user);
        }
    }
	
	public String orderTextbook(Item book, User user, ManagementTeam managementTeam) {
        if (user.equals(managementTeam)) {
            String orderMessage = "Book ordered successfully for user " + user.getName();

            managementTeam.notifyUsersAboutItems();

            return orderMessage;
        } else {
            return "Only members of the management team can order books.";
        }
    }
	
	Item[] blockItem(Item item) {
		List<Item> blockedItemsList = new ArrayList<>();
        blockedItemsList.addAll(Arrays.asList(itemsBlocked));
        blockedItemsList.add(item);
        itemsBlocked = blockedItemsList.toArray(new Item[blockedItemsList.size()]);
        return itemsBlocked;
	}
	Item[] addItem(Item item) {
		List<Item> itemList = new ArrayList<>();
        itemList.addAll(Arrays.asList(itemsList));
        itemList.add(item);
        itemsList = itemList.toArray(new Item[itemList.size()]);
        return itemsList;
	}
	String[] rentedItems(){
		List<String> rentedItemList = new ArrayList<>();
        rentedItemList.addAll(Arrays.asList(itemsRented));
        return rentedItemList.toArray(new String[rentedItemList.size()]);
		
	}
	String[] queue(Item item) {
		List<String> queueList = new ArrayList<>();
        for (String queueItem : bookPriorityQueue) {
            if (queueItem != null && queueItem.equals(item.getName())) {
                queueList.add(queueItem);
            }
        }
        return queueList.toArray(new String[queueList.size()]);
	}
	
	
	
}

import java.util.*;

public class SystemInterface {

	Rent Store;
	User user;
    List<String> itemsRented;
    List<String> itemsDueDate;
    List<String> itemsOverdue;
    List<String> recommendedItems;
    
    String register(User user, String password ) {return null;}
	List<String> viewDueItems() {return null;}
	List<String> overdueItems() {return null;}
	String readOnlineItem() {return null;}
	List<String> viewRecommendation() {return null;}
	
}

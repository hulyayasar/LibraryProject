
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDatabase {
    private static final String CSV_FILE = "items.csv";
    private static final String CSV_FILE2 = "my.csv";
    public static void saveItem(Item item) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            if (new File(CSV_FILE).length() == 0) {
                writer.println("name,itemID,author,price,type,isDisabled,buyable");
            }

            if (item instanceof OnlineTextbook) {
                writer.println(item.getName() + "," + ((OnlineTextbook) item).getItemID() + ","
                        + ((OnlineTextbook) item).getAuthor() + "," + ((OnlineTextbook) item).getPrice() + ","
                        + "OnlineTextbook," + ((OnlineTextbook) item).isDisabled() + ","
                        + ((OnlineTextbook) item).isBuyable());
            } else if (item instanceof MagazineNewspaper) {
                writer.println(item.getName() + "," + ((MagazineNewspaper) item).getItemID() + ","
                        + ((MagazineNewspaper) item).getAuthor() + "," + ((MagazineNewspaper) item).getPrice() + ","
                        + "MagazineNewspaper," + ((MagazineNewspaper) item).isDisabled() + ","
                        + ((MagazineNewspaper) item).isBuyable());
            } else if (item instanceof PhysicalItem) {
                writer.println(item.getName() + "," + ((PhysicalItem) item).getItemID() + ","
                        + ((PhysicalItem) item).getAuthor() + "," + ((PhysicalItem) item).getPrice() + ","
                        + "PhysicalItem," + ((PhysicalItem) item).isDisabled() + ","
                        + ((PhysicalItem) item).isBuyable());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Item> loadMyItems(int id) {
        List<Item> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE2))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                //"name,itemID,author,price,type,UID"
                if (parts.length >= 6) {
                    String name = parts[0];
                    int itemID = Integer.parseInt(parts[1]);
                    String author = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    String type = parts[4];
                    int uid = Integer.parseInt(parts[5]);
                    boolean isDisabled = false;
                    boolean buyable;
                    if(price>0.0) {
                    buyable = true;}
                    else{ buyable = false;}
                    if(uid == id) {
                    if (type.equals("OnlineTextbook")) {
                        items.add(new OnlineTextbook(name, itemID, author, price, isDisabled, buyable));
                    } else if (type.equals("MagazineNewspaper")) {
                        items.add(new MagazineNewspaper(name, itemID, author, price, isDisabled, buyable));
                    } else if (type.equals("PhysicalItem")) {
                        items.add(new PhysicalItem(name, itemID, author, price, isDisabled, buyable));
                    }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static List<Item> loadItems() {
        List<Item> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    String name = parts[0];
                    int itemID = Integer.parseInt(parts[1]);
                    String author = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    String type = parts[4];
                    boolean isDisabled = Boolean.parseBoolean(parts[5]);
                    boolean buyable = Boolean.parseBoolean(parts[6]);
                    if (type.equals("OnlineTextbook")) {
                        items.add(new OnlineTextbook(name, itemID, author, price, isDisabled, buyable));
                    } else if (type.equals("MagazineNewspaper")) {
                        items.add(new MagazineNewspaper(name, itemID, author, price, isDisabled, buyable));
                    } else if (type.equals("PhysicalItem")) {
                        items.add(new PhysicalItem(name, itemID, author, price, isDisabled, buyable));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
    
    public static void addItem(Item item, User user) {
   
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE2, true))) {
            if (new File(CSV_FILE2).length() == 0) {
                writer.println("name,itemID,author,price,type,UID");
            }

            if (item instanceof OnlineTextbook) {
                writer.println(item.getName() + "," + ((OnlineTextbook) item).getItemID() + ","
                        + ((OnlineTextbook) item).getAuthor() + "," + ((OnlineTextbook) item).getPrice() + ","
                        + "OnlineTextbook" +"," +user.getID());
            } else if (item instanceof MagazineNewspaper) {
                writer.println(item.getName() + "," + ((MagazineNewspaper) item).getItemID() + ","
                        + ((MagazineNewspaper) item).getAuthor() + "," + ((MagazineNewspaper) item).getPrice() + ","
                        + "MagazineNewspaper" +"," +  user.getID());
            } else if (item instanceof PhysicalItem) {
                writer.println(item.getName() + "," + ((PhysicalItem) item).getItemID() + ","
                        + ((PhysicalItem) item).getAuthor() + "," + ((PhysicalItem) item).getPrice() + ","
                        + "PhysicalItem" +"," +  user.getID());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void remove(Item item, User user) {
		// TODO Auto-generated method stub
		String currLine;
		String filep = CSV_FILE2;
		String tempName = "temp.csv";
		
		
		
		File tempfile = new File(filep);
		File newFile = new File(tempName);
		String entry = item.getName()+","+item.getItemID()+","
				+item.getAuthor()+","+item.getPrice()+","+item.getType()
				+","+user.ID;

		//"name,itemID,author,price,type,UID"
		
		try {
			FileWriter fw = new FileWriter(tempName,true);
			BufferedWriter buffer = new BufferedWriter(fw);
			PrintWriter prt = new PrintWriter(buffer);
			
			FileReader fr = new FileReader(filep);
			BufferedReader br = new BufferedReader(fr);
			
			while((currLine = br.readLine())!=null) {
				
				if(!entry.equals(currLine)) {
					
					prt.println(currLine);
				}
			}
			prt.flush();
			prt.close();
			fr.close();
			br.close();
			buffer.close();
			fw.close();
			
			tempfile.delete();
			File dump = new File(filep);
			newFile.renameTo(dump);
			
		}
		catch(Exception e) {}
		
	}


}



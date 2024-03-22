// import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ItemDatabase {
//    private static final String CSV_FILE = "items.csv";
//
//    public static void saveItem(Item item) {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
//           
//            if (new File(CSV_FILE).length() == 0) {
//                writer.println("name,type,...");
//            }
//
//           
//            if (item instanceof OnlineTextbook) {
//                writer.println(item.getName() + ",OnlineTextbook," + ((OnlineTextbook) item).getTextbooksLeft() + ",...");
//            } else if (item instanceof MagazineNewspaper) {
//                writer.println(item.getName() + ",MagazineNewspaper," + ((MagazineNewspaper) item).getSubscriptiontime() + ",...");
//            } else if (item instanceof PhysicalItem) {
//                writer.println(item.getName() + ",PhysicalItem," + ((PhysicalItem) item).getItemLocation() + ",...");
//            }
//           
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<Item> loadItems() {
//        List<Item> items = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
//            String line;
//            
//            reader.readLine();
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length >= 2) {
//                    String name = parts[0];
//                    String type = parts[1];
//                    if (type.equals("OnlineTextbook")) {
//                        int textbooksLeft = Integer.parseInt(parts[2]);
//                       
//                        items.add(new OnlineTextbook(name, textbooksLeft));
//                    } else if (type.equals("MagazineNewspaper")) {
//                        int subscriptionTime = Integer.parseInt(parts[2]);
//                       
//                        items.add(new MagazineNewspaper(name, subscriptionTime));
//                    } else if (type.equals("PhysicalItem")) {
//                        String itemLocation = parts[2];
//                        
//                        items.add(new PhysicalItem(name, itemLocation));
//                    }
//                    
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return items;
//    }
//}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDatabase {
    private static final String CSV_FILE = "items.csv";

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
}



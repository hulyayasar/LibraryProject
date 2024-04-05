import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {
    private Student student;
    private Staff staff;
    private Faculty faculty;
    private LibraryDatabase libraryDatabase;
    private Item book;

    private LibrarySingleton librarySingleton;

    private Visitor visitor;

    private SystemInterface systemInterface;
    private Item testItem;

    @Test
    public void testUser() {


        User.IDCounter = 0; // Resetting ID counter for consistent test results
        student = new Student("Enes Yesil", "enes.student@example.com", "york1234");
        staff = new Staff("Enes Yesil", "enes.staff@example.com", "york1234");
        faculty = new Faculty("Enes Yesil", "enes.faculty@example.com", "york1234");

        assertEquals("Enes Yesil", student.getName());
        assertEquals("enes.student@example.com", student.getEmail());
        assertEquals("york1234", student.getPassword());
        assertEquals(0, student.getID());


        assertEquals("Enes Yesil", staff.getName());
        assertEquals("enes.staff@example.com", staff.getEmail());
        assertEquals("york1234", staff.getPassword());
        assertEquals(1, staff.getID());


        assertEquals("Enes Yesil", faculty.getName());
        assertEquals("enes.faculty@example.com", faculty.getEmail());
        assertEquals("york1234", faculty.getPassword());
        assertEquals(2, faculty.getID());


        student.setName("New Enes");
        assertEquals("New Enes", student.getName());
        student.setEmail("new.enes.yesil@example.com"); // Updated email address
        assertEquals("new.enes.yesil@example.com", student.getEmail());
        student.setPassword("newYork1234");
        assertEquals("newYork1234", student.getPassword());
    }

    @Test
    public void testItem() {
        Item book = new OnlineTextbook("Java Basics", 1, "Author Name", 19.99, false, true);
        assertEquals("Java Basics", book.getName());
        assertEquals(19.99, book.getPrice());
        assertEquals("OnlineTextbook", book.getType());

        Item magazine = new MagazineNewspaper("Tech Today", 1, "Editor Name", 5.99, false, true);
        assertEquals("Tech Today", magazine.getName());
        assertEquals(5.99, magazine.getPrice());
        assertEquals("MagazineNewspaper", magazine.getType());

        Item chair = new PhysicalItem("Office Chair", 1, "Manufacturer", 120.00, false, true);
        assertEquals("Office Chair", chair.getName());
        assertEquals(120.00, chair.getPrice());
        assertEquals("PhysicalItem", chair.getType());

        OnlineTextbook textbook = new OnlineTextbook("Advanced Java", 10);
        assertEquals(10, textbook.getTextbooksLeft());

        textbook.setTextbooksLeft(5);
        assertEquals(5, textbook.getTextbooksLeft());

    }

    @Test
    public void testPhysicalItem() {
        PhysicalItem laptop = new PhysicalItem("Gaming Laptop", "Aisle 3");
        laptop.setItemAmountLeft(20);

        assertEquals("Aisle 3", laptop.getItemLocation());
        assertEquals(20, laptop.getItemAmountLeft());

        laptop.setItemLocation("Aisle 5");
        laptop.setItemAmountLeft(15);

        assertEquals("Aisle 5", laptop.getItemLocation());
        assertEquals(15, laptop.getItemAmountLeft());
    }

    @Test
    public void testDatabase() {
        libraryDatabase = new LibraryDatabase();
        book = new Item("Effective Java", 123, "Joshua Bloch", 50.00, "Book", false, true);


        libraryDatabase.itemsList = new Item[1];
        libraryDatabase.itemsList[0] = book;


        libraryDatabase.itemsRented = new String[0];

        assertEquals(libraryDatabase.itemAvailabilty(book), "The book available for rent.");
    }

    @Test
    public void testSingletonInstance() {

        LibrarySingleton firstInstance = LibrarySingleton.getInstance();
        LibrarySingleton secondInstance = LibrarySingleton.getInstance();


        assertSame(firstInstance.toString(), secondInstance.toString(), "Both calls to getInstance should return the same instance.");


        assertNotNull(firstInstance.getLibrary().toString(), "The library should be properly initialized and not null.");
    }


    @Test
    public void testRegister() {

        Register register = new Register();


        User user = new User();

        user.setName("Zed Diado");
        user.setEmail("zdiado@example.com");
        user.setPassword("lassonde123");


        String result = register.register(user);


        assertEquals("User registered successfully", result, user.toString());
    }

    @Test
    public void testPay() {
        Payment cardPayment = new CreditDebit("Enes Yesil", "12345467690123456", "123", "12/34");
        String paymentResult1 = cardPayment.pay(100.0);

        assertEquals("100.0 paid with credit/debit card", paymentResult1, "Card payment message should match expected output.");

        Payment cashPayment = new Cash();
        String paymentResult2 = cashPayment.pay(100.0);

        assertEquals("$100.0 paid in cash.", paymentResult2, "Cash payment message should match expected output.");
    }

    @Test
    public void testCheckout() {
        // Setup
        Checkout checkout1 = new Checkout();
        Payment cashPayment = new Cash(100.0);
        double totalCost1 = 100.0;
        checkout1.totalCost = totalCost1;


        String result = checkout1.makePayment(cashPayment);


        assertEquals("$100.0 paid in cash.", result, "Payment with cash done successfully.");

        Checkout checkout2 = new Checkout();
        Payment cardPayment = new CreditDebit("Jane Doe", "9876543210987654", "321", "01/25");
        double totalCost2 = 200.0;
        checkout2.totalCost = totalCost2;


        String result2 = checkout2.makePayment(cardPayment);


        assertEquals("200.0 paid with credit/debit card", result2, "Payment with card done successfully.");
    }

    @Test
    public void testRent() {
        // Setup
        Rent rent = new Rent();
        User user = new User();
        rent.OverdueCost = 5.0;
        rent.numOfItemsRented = 3;


        int overdueDays = 2;
        double expectedOverdueCost = overdueDays * rent.OverdueCost * rent.numOfItemsRented;


        double actualOverdueCost = rent.calculateOverdue(user);


        assertEquals("The calculated overdue match the expected value.", expectedOverdueCost, actualOverdueCost);
    }

    @Test
    public void testItemDataBase() {

        testItem = new PhysicalItem("Test Book", 999, "Test Author", 9.99, false, true);
        ItemDatabase.saveItem(testItem);


        List<Item> items = ItemDatabase.loadItems();


        boolean found = items.stream().anyMatch(item ->
                item.getName().equals("Test Book") &&
                        item.getItemID() == 999 &&
                        item.getAuthor().equals("Test Author") &&
                        item.getPrice() == 9.99 &&
                        item.getType().equals("PhysicalItem") &&
                        !item.isDisabled() &&
                        item.isBuyable()
        );

        assertTrue( "The saved item should be present in the loaded items.",found);
    }

}



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
        Item book = new OnlineTextbook("Java Basics", 1, "John Atmar", 19.99, false, true);
        double delta = 0.0001;
        assertEquals(book.getName(),"Java Basics");
        assertEquals( book.getPrice(),19.99,delta);
        assertEquals(book.getType(),"OnlineTextbook");

        Item magazine = new MagazineNewspaper("Tech Today", 1, "Mirlan Aliovic", 5.99, false, true);
        assertEquals( magazine.getName(),"Tech Today");
        assertEquals(magazine.getPrice(),5.99 ,delta);
        assertEquals( magazine.getType(),"MagazineNewspaper");

        Item chair = new PhysicalItem("Office Chair", 1, "Manufacturer", 120.00, false, true);
        assertEquals( chair.getName(),"Office Chair");
        assertEquals( chair.getPrice(),120.00,delta);
        assertEquals( chair.getType(),"PhysicalItem");

        OnlineTextbook textbook = new OnlineTextbook("Advanced Java", 10);
        assertEquals( textbook.getTextbooksLeft(),10,delta);

        textbook.setTextbooksLeft(5);
        assertEquals( textbook.getTextbooksLeft(),5,delta);

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

        assertEquals(libraryDatabase.itemAvailabilty(book), true);
    }

    @Test
    public void testSingletonInstance() {

        LibrarySingleton firstInstance = LibrarySingleton.getInstance();
        LibrarySingleton secondInstance = LibrarySingleton.getInstance();


        assertSame(firstInstance, secondInstance);


        assertNotNull(firstInstance.getLibrary());
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
        Payment cardPayment = new CreditDebit("Enes Yesil", "1234534934690123456", "123", "12/34");
        String paymentResult1 = cardPayment.pay(100.0);

        assertEquals("100.0 paid with credit/debit card", paymentResult1);

        Payment cashPayment = new Cash();
        String paymentResult2 = cashPayment.pay(100.0);

        assertEquals("$100.0 paid in cash.", paymentResult2);
    }

    @Test
    public void testCheckout() {
        // Setup
        Checkout checkout1 = new Checkout();
        Payment cashPayment = new Cash(100.0);
        double totalCost1 = 100.0;
        checkout1.totalCost = totalCost1;


        String result = checkout1.makePayment(cashPayment);


        assertEquals( result,"$100.0 paid in cash." );

        Checkout checkout2 = new Checkout();
        Payment cardPayment = new CreditDebit("Enes Yesil", "9876543210987654", "321", "01/25");
        double totalCost2 = 200.0;
        checkout2.totalCost = totalCost2;


        String result2 = checkout2.makePayment(cardPayment);


        assertEquals( result2, "200.0 paid with credit/debit card");
    }

    @Test
    public void testRent() {
        
        Rent rent = new Rent();
        User user = new User();
        rent.OverdueCost = 5.0;
        rent.numOfItemsRented = 3;



        double expectedOverdueCost = rent.OverdueCost * rent.numOfItemsRented;


        double actualOverdueCost = rent.calculateOverdue(user);
        double delta = 0.0001;

        assertEquals(expectedOverdueCost, actualOverdueCost,delta);
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



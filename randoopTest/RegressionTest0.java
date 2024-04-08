
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        java.util.List<Item> itemList0 = ItemDatabase.loadItems();
        org.junit.Assert.assertNotNull(itemList0);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (short) -1, "", (double) 1, false, false);
        User user7 = null;
        // The following exception was thrown during execution in test generation
        try {
            ItemDatabase.addItem((Item) physicalItem6, user7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"User.getID()\" because \"<parameter2>\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (short) -1, "", (double) 1, false, false);
        User user7 = null;
        // The following exception was thrown during execution in test generation
        try {
            ItemDatabase.remove((Item) physicalItem6, user7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"ID\" because \"<parameter2>\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        User user0 = new User();
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        Item item0 = new Item();
        java.lang.String str1 = item0.type;
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        PhysicalItem physicalItem2 = new PhysicalItem("", "hi!");
        int int3 = physicalItem2.getItemAmountLeft();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        Faculty faculty3 = new Faculty("", "", "hi!");
        faculty3.setPassword("hi!");
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        Item item7 = new Item("", (-1), "", (double) (-1L), "hi!", false, false);
        double double8 = item7.getPrice();
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-1.0d) + "'", double8 == (-1.0d));
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (short) -1, "", (double) 1, false, false);
        ItemDatabase.saveItem((Item) physicalItem6);
        physicalItem6.setType("");
        java.lang.String str10 = physicalItem6.getName();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (short) -1, "", (double) 1, false, false);
        ItemDatabase.saveItem((Item) physicalItem6);
        physicalItem6.setRentalDuration((int) (short) 100);
        physicalItem6.setName("PhysicalItem");
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        SystemInterface systemInterface0 = new SystemInterface();
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (short) -1, "", (double) 1, false, false);
        ItemDatabase.saveItem((Item) physicalItem6);
        double double8 = physicalItem6.getPrice();
        java.lang.String str9 = physicalItem6.getAuthor();
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1.0d + "'", double8 == 1.0d);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (short) -1, "", (double) 1, false, false);
        ItemDatabase.saveItem((Item) physicalItem6);
        physicalItem6.setType("");
        java.lang.String str10 = physicalItem6.getItemLocation();
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        PhysicalItem physicalItem2 = new PhysicalItem("PhysicalItem", "PhysicalItem");
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (short) -1, "", (double) 1, false, false);
        int int7 = physicalItem6.getItemID();
        Faculty faculty11 = new Faculty("", "", "hi!");
        ItemDatabase.remove((Item) physicalItem6, (User) faculty11);
        java.lang.String str13 = faculty11.getName();
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "" + "'", str13, "");
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        Checkout checkout0 = new Checkout();
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        UserDatabase userDatabase0 = new UserDatabase();
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        Faculty faculty3 = new Faculty("", "", "hi!");
        boolean boolean4 = faculty3.isStaff();
        java.lang.String str5 = faculty3.getName();
        Faculty faculty9 = new Faculty("", "", "hi!");
        boolean boolean10 = faculty9.isStaff();
        java.lang.String str11 = faculty9.getName();
        faculty3.tryRegister((User) faculty9);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (byte) 0, "", (double) ' ', false, false);
        double double7 = physicalItem6.getPrice();
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 32.0d + "'", double7 == 32.0d);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        MagazineNewspaper magazineNewspaper2 = new MagazineNewspaper("hi!", (int) (short) 0);
        int int3 = magazineNewspaper2.getRentalDuration();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        Faculty faculty3 = new Faculty("", "", "hi!");
        ManagementTeam managementTeam4 = null;
        faculty3.setMt(managementTeam4);
        int int6 = faculty3.getID();
// flaky:         org.junit.Assert.assertTrue("'" + int6 + "' != '" + 9 + "'", int6 == 9);
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        PhysicalItem physicalItem6 = new PhysicalItem("hi!", (int) (short) -1, "", (double) 1, false, false);
        java.lang.String str7 = physicalItem6.getType();
        double double8 = physicalItem6.getPrice();
        int int9 = physicalItem6.getItemID();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "PhysicalItem" + "'", str7, "PhysicalItem");
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1.0d + "'", double8 == 1.0d);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }
}

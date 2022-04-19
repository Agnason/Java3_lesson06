package lesson07;

public class MyTest {

    @Test(priority = 1)
    public static void test1() {
        System.out.println("@test priority = 1");
    }

    @Test(priority = 5)
    public static void test5() {
        System.out.println("@test priority = 5");
    }

    @BeforeSuite
    public static void testBefore() {
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public static void testAfter() {
        System.out.println("@AfterSuite");
    }

}

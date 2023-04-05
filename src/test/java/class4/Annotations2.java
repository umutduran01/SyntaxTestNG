package class4;

import org.testng.annotations.*;

public class Annotations2 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("I am before class.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I am after class.");
    }

    @BeforeMethod
    public void before() {
        System.out.println("I am before method.");
    }

    @AfterMethod
    public void after() {
        System.out.println("I am after method.");
    }

    @Test
    public void testA() {
        System.out.println("I am test A.");
    }

    @Test
    public void testB() {
        System.out.println("I am test B.");
    }

    @Test
    public void testC() {
        System.out.println("I am test C.");
    }
}

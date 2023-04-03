package class1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {

    //In TestNG, the test cases are being executed by their alphabetical order.

    @BeforeMethod //This annotation runs before every single @Test annotation.
    public void beforeMethod() {
        System.out.println("I am before method.");
    }

    @AfterMethod
    public void afterMethod() { //This runs after every @Test.
        System.out.println("I am after method.");
    }

    @Test
    public void FirstTestCase() {
        System.out.println("I am the first test case.");
    }

    @Test
    public void SecondTestCase() {
        System.out.println("I am the second test case.");
    }

    @Test
    public void ThirdTestCase() {
        System.out.println("I am the third test case.");
    }
}

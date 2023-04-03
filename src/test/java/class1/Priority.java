package class1;

import org.testng.annotations.Test;

public class Priority {

    //We can assign priorities to test cases. We do not pass any priority, it is 0 by default.

    @Test(priority = 3)
    public void Atest() {
        System.out.println("I am Test A.");
    }

    @Test(priority = 1)
    public void Btest() {
        System.out.println("I am Test B.");
    }

    @Test(priority = 2)
    public void Ctest() {
        System.out.println("I am Test C.");
    }

}

package class1;

import org.testng.annotations.Test;

public class EnableDisable {

    //We can enable or disable a case if we do not want to execute it.

    @Test(enabled = false)
    public void ATest(){
        System.out.println("I am the first test case.");
    }

    @Test
    public void BTest(){
        System.out.println("I am the second test case.");
    }
}

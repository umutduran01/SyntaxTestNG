package class1;

import org.testng.annotations.Test;

public class DependsOn {

    //By this method, DashBoardVerification test will not execute if Login fails.

    @Test
    public void Login() {
        System.out.println(6/0);
    }

    @Test(dependsOnMethods = {"Login"})
    public void DashBoardVerification() {
        System.out.println("After login I am verifying dashboard.");
    }
}

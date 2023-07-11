package class4;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case has passed." + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case has failed.");
        //take screenshot
    }
}

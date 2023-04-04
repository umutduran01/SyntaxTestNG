package class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertion {

    //Go to syntax hrms and send no keys, clik on login and get the text if it is username cannot be empty.
    //Then check if the login button is displayed.

    public static WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testCase() {
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement actualError = driver.findElement(By.id("spanMessage"));
        String actualErrorText = actualError.getText();

        String expectedErrorText = "Username cannot be empty";

        //compare strings

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualErrorText, expectedErrorText);

        //login button is displayed

        soft.assertTrue(loginButton.isDisplayed());

        soft.assertAll(); //After making all assertions, we do assertAll. It marks our case as pass or fail.
    }

}

package class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assertions {

    public static WebDriver driver;

    @BeforeMethod
    public void SetupBrowser() {
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

    /*
    enter username and password
    click on login button
    verify that the message invalid credentials is displayed
    verify if the password box is displayed
    */

    @Test
    public void invalidCredentials() {
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("helloEveryone");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();

        //verify the error message

        WebElement error = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String errorText = error.getText();
        String expectedText = "Invalid credentials";

        //While doing verification, we cannot use if-else because it executes everytime and passes the test case. So we need to use assertion.

        Assert.assertEquals(errorText, expectedText); //Assert.assertEquals(Actual Output,Expected Output);

        //Verifying is the password box is displayed.

        //First we need to declare the element again otherwise will get a StaleElementReferenceException.

        password = driver.findElement(By.xpath("//input[@id='txtPassword']"));

        boolean passwordBoxDisplayed = password.isDisplayed();

        Assert.assertTrue(passwordBoxDisplayed); //This method passes if boolean value is true and fails if not.

        //If one assertion fails, the rest of the code will not be executed. That is called Hard Assertion.

    }

}

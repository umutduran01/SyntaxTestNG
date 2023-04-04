package class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviding {

    //Test Scenario:
    //todo navigate to syntax HRMS
    //todo login into the webiste using the following credentials and check for correct errors
    //  username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
    //  username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
    //  username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
    //  username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"
    //todo Data provider

    public static WebDriver driver;

    @DataProvider(name = "credentials")
    public Object[][] data() {
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return loginData;
    }

    @Test(dataProvider = "credentials") //Here we connect our test with data provider.
    public void invalidCredentials(String username, String password, String errorMsg) {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();

        String actualError = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();

        Assert.assertEquals(actualError, errorMsg);
    }


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
}
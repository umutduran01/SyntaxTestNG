package Practice;

import Utils.Constants;
import Utils.ExcelUtility;
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

public class DataProviderExcel {

    public static WebDriver driver;

    @DataProvider(name = "excelData")
    public Object[][] data() {
        return ExcelUtility.convertExlToArray(Constants.XL_DATA_FILEPATH,
                "Sheet1");
    }

    @Test(dataProvider = "excelData")
    public void invalidCredentials(String username, String password) {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();
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

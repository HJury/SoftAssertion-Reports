package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class Tests {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        String path = System.getProperty("user.dir") + "/src/test/resources/webdrivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @org.testng.annotations.Test
    public void searchingForFlights() {
        driver.get("https://www.google.com/");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.googlo.com/");
    }
}

package loginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.time.Duration;

public class AdminLoginTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://128.185.138.116:8080/VibePayAdmin/login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }
    @Test
    public void adminLoginTest() {

        System.out.println(driver.getPageSource());

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']")));

        usernameField.sendKeys("7742582254");
        passwordField.sendKeys("GLpgwar@789");
        loginButton.click();

        wait.until(ExpectedConditions.urlContains("dashboard"));


        assert driver.getCurrentUrl().contains("dashboard"): "Login failed or dashboard not loaded";
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

package HomeworkDay06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeworkDay06 {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Dùng WebDriverWait toàn cục
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void openForm() {
        driver.get("https://saucelabs.com/request-demo");
    }

    @Test
    public void testSuccessfulRegistration() {
        driver.findElement(By.name("FirstName")).sendKeys("Nguyen Thi");
        driver.findElement(By.name("LastName")).sendKeys("Hanh");
        driver.findElement(By.name("Email")).sendKeys("Hanhnt@gmail.com");
        driver.findElement(By.name("Phone")).sendKeys("1234567890");
        driver.findElement(By.name("Company")).sendKeys("FFT Company");

        WebElement countryDropdown = driver.findElement(By.name("Country"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByValue("Vietnam");

        WebElement interestDropdown = driver.findElement(By.name("Solution_Interest__c"));
        Select selectInterest = new Select(interestDropdown);
        selectInterest.selectByValue("Real Device Cloud");

        WebElement checkbox = driver.findElement(By.cssSelector("input[name='mktoOptIn']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitBtn.click();

        wait.until(ExpectedConditions.urlContains("thank-you"));
        Assert.assertTrue(driver.getCurrentUrl().contains("thank-you"), "Form not submitted successfully");
    }

    @Test
    public void testMissingInterestField() {
        driver.findElement(By.name("FirstName")).sendKeys("Alice");
        driver.findElement(By.name("LastName")).sendKeys("Smith");
        driver.findElement(By.name("Email")).sendKeys("alice@example.com");
        driver.findElement(By.name("Phone")).sendKeys("0987654321");
        driver.findElement(By.name("Company")).sendKeys("Test Company");

        WebElement countryDropdown = driver.findElement(By.name("Country"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByValue("Vietnam");

        // Bỏ qua Interest

        WebElement checkbox = driver.findElement(By.cssSelector("input[name='mktoOptIn']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitBtn.click();

        boolean isErrorDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".mktoErrorMsg"))).isDisplayed();

        Assert.assertTrue(isErrorDisplayed, "Validation error message not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

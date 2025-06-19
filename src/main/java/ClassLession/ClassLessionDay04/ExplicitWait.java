package ClassLession.ClassLessionDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            // Mở trang web
            driver.get("https://saucelabs.com/request-demo");
            // Tạo WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            // Chờ và tìm phần tử email
            WebElement BussinessEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))
            );
            BussinessEmail.sendKeys("hanhhn@gmail.com");
            WebElement submitButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contais(@type,'submit1')]"))
            );
            submitButton.click();
        } catch (TimeoutException e) {
            System.out.println("Không tìm thấy phần tử trong thời gian cho phép: " + e.getMessage());
        } finally {
            // Luôn đóng trình duyệt
            driver.quit();
        }
    }
}



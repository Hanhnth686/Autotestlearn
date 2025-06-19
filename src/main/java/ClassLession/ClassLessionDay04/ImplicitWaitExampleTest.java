package ClassLession.ClassLessionDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ImplicitWaitExampleTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Tạo WebDriverWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Selenium sẽ đợi tối đa thời gian được chỉ định nếu chưa thấy phần tử ngay
        // Nếu thấy sớm selenium sẽ tiếp tục chạy mà không đợi đủ thời gian
        try {
            driver.get("https://saucelabs.com/request-demo");
            // Tìm phần tử "Email" và nhập dữ liệu
            WebElement BussinessEmail = driver.findElement(By.xpath("//input[@id='Email']"));
            BussinessEmail.sendKeys("hanhhn@gmail.com");
            WebElement Company = driver.findElement(By.xpath("//input[@name='Company']"));
            Company.sendKeys("Công ty FFT");
            WebElement Comments = driver.findElement(By.xpath("//textarea[contains(@class,'mktoField')]"));
            Comments.sendKeys("Dịch vụ tốt");
            WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
            firstName.sendKeys("Nguyễn Thị");
            WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
            lastName.sendKeys("Hạnh");
            WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='Phone']"));
            phoneNumber.sendKeys("888-999-8888");
            WebElement Country = driver.findElement(By.xpath("//select[@id='Country']"));
            Select selectCountry = new Select(Country);
            selectCountry.selectByVisibleText("United States");
            WebElement State = driver.findElement(By.xpath("//select[@id='State']"));
            Select selectState = new Select(State);
            selectState.selectByVisibleText("KY");
            WebElement Interest = driver.findElement(By.xpath("//select[@id='Solution_Interest__c']"));
            Select selectInterest = new Select(Interest);
            selectInterest.selectByVisibleText("Scalable Test Automation1");
            // Tìm và nấn nút "Submit"
            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        } catch (Exception e) {
            System.out.println("Lỗi khi tìm phần tử hoặc thao tác: " + e.getMessage());
        } finally {
            // Đảm bảo luôn đóng trình duyệt
            driver.quit();
        }
    }
}

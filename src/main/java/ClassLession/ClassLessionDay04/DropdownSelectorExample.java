package ClassLession.ClassLessionDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelectorExample {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Mở trang web
        driver.get("https://saucelabs.com/request-demo");
        // Tìm phần tử dropDown (Interest)
        WebElement interestDropdown = driver.findElement(By.xpath("//select[@id='Solution_Interest__c']"));
        // Sử dụng Select để tương tác với dropdown
        Select selectInterest = new Select(interestDropdown);
        // Chọn một tuỳ chọn bằng giá trị (value)
        // selectInterest.selectByIndex(1);
        // Chọn một tuỳ chọn bằng giá trị (value)
        selectInterest.selectByValue("Scalable Test Automation");
        System.out.println("Interest selected successfully");
        Thread.sleep(3000);
        // Đóng trình duyệt
        driver.quit();
    }
}

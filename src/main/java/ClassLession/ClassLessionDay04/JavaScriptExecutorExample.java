package ClassLession.ClassLessionDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
 public class JavaScriptExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Mở trang web
        driver.get("https://saucelabs.com/request-demo");
        // Lấy phần tử droplist (interest) bằng cách dùng Xpath
        WebElement interest = driver.findElement(By.xpath("//select[@id='Solution_Interest__c']"));
        // Tạo đối tượng JavascriptExcutor chuyển đổi driver thanhf JavaScriptExecutor thực thi
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /* Thực thi đoạn mã  JavaScript v thay đô giá trị của dropdown
           Thực hiện thay đổi giá trị(giả sử chúng ta chọn một option có giá trị là "Visual Testing") */
        js.executeScript("arguments[0].value='Visual Testing'", interest);
        Thread.sleep(3000);
        // Kiểmm tra giá trị đã được chọn
        String selectedValue = interest.getAttribute("value");
        System.out.println("Selected value from dropdowmList: "+ selectedValue);
        // Đóng trình duyệt
        driver.quit();
    }
}


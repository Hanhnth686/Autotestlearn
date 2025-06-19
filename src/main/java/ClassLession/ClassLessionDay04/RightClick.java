package ClassLession.ClassLessionDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Mở trang web
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        // Tìm button cần thực hiện righ-click
        WebElement rightClick = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        // Tạo đối tợng actions để thực hiện right-click
        Actions actions = new Actions(driver);
        // Thực hiện hành động right-click vào button
        actions.contextClick(rightClick).perform();
        //Lấy danh sách các tuỳ chọn trong menu chuột phải
        WebElement option = driver.findElement(By.xpath("//li/span[text()='Cut']"));
        // Nhấn vào tuỳ chọn "Edit"
        option.click();
    }
}

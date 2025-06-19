package ClassLession.ClassLessionDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MultiCheckboxSelection {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Mở trang web
        driver.get("https://demo.guru99.com/test/radio.html");
        // Tìm danh sách các checkbox
        List<WebElement> checkboxes = new ArrayList<>();
        checkboxes.add(driver.findElement(By.id("vfb-6-0")));
        checkboxes.add(driver.findElement(By.id("vfb-6-1")));
        Thread.sleep(3000);
        // Click vào từng checkbox và in ra giá trị đã chọn
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
            System.out.println("Checkbox value selected: " + checkbox.getAttribute("value"));
            System.out.println("Is selected? " + checkbox.isSelected());
        }
        // Đóng trình duyệt
        driver.quit();
    }
}

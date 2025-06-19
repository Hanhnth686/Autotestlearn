package ClassLession.ClassLessionDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DoubleClick {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Mở trang web
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        // Tìm phần tử nút cần double click
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
        // Tạo đối tượng Actions để thực hiện Double click
        Actions actions = new Actions(driver);
        // Thực hiện double click vào button
        actions.doubleClick(doubleClickButton).perform();
        Thread.sleep(5000);
        // Xử lý cảnh báo (alert) xuất hiện sau double click
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text after double click: " + alertText);
        // Đóng alert
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        // Đóng trình duyệt
        driver.quit();
    }
}

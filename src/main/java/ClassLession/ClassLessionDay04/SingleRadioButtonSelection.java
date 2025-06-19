package ClassLession.ClassLessionDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class SingleRadioButtonSelection {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Mở trang web
        driver.get("https://demo.guru99.com/test/radio.html");
        // Tìm một radio button
        WebElement radioButton = driver.findElement(By.id("vfb-7-1"));
        // Click vào radio button đã chọn
        radioButton.click();

        Thread.sleep(3000);
        // Lấy giá trị và trạng thái của radio button
        String value = radioButton.getAttribute("");
        boolean isSelected = radioButton.isSelected();
        // In ra giá trị và trạng thái đã chọn
        System.out.println("Radio Button value selceted: " + value);
        System.out.println("Radio Button is selceted: " + isSelected);
        driver.quit();
    }
}

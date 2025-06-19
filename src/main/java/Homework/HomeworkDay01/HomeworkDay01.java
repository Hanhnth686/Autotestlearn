package Homework.HomeworkDay01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkDay01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://serenity-bdd.github.io");
        System.out.printf("Tieu de trang: " + driver.getTitle());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

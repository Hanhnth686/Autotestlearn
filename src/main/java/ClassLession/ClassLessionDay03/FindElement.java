package ClassLession.ClassLessionDay03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        WebElement Email = driver.findElement(By.xpath("//input[@id='Email']"));
        Email.sendKeys("thaontp70@gmail.com");
        WebElement Company = driver.findElement(By.xpath("//input[@name='Company']"));
        Company.sendKeys("Công ty FFT");
        WebElement Comments = driver.findElement(By.xpath("//textarea[contains(@class,'mktoField')]"));
        Comments.sendKeys("Công ty FFT");
        WebElement Checkbox = driver.findElement(By.cssSelector("input#mktoCheckbox_46340_0"));
        Checkbox.click();
        WebElement Tryitfree = driver.findElement(By.partialLinkText("Try"));
        Tryitfree.click();
    }
}

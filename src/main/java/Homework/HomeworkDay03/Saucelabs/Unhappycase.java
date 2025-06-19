package Homework.HomeworkDay03.Saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Unhappycase {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        WebElement BussinessEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        BussinessEmail.sendKeys("hoant@gmail.com");
        WebElement Company = driver.findElement(By.xpath("//input[@name='Company']"));
        Company.sendKeys("Công ty FFT");
        WebElement Comments = driver.findElement(By.xpath("//textarea[contains(@class,'mktoField')]"));
        Comments.sendKeys("Dịch vụ tốt");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Nguyễn Thị");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Hoa");
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='Phone']"));
        phoneNumber.sendKeys("889-899-8899");
        WebElement Country = driver.findElement(By.xpath("//select[@id='Country']"));
        Select selectCountry = new Select(Country);
        selectCountry.selectByVisibleText("United States");
        WebElement State = driver.findElement(By.xpath("//select[@id='State']"));
        Select selectState = new Select(State);
        selectState.selectByVisibleText("KY");
        WebElement Checkbox = driver.findElement(By.cssSelector("input#mktoCheckbox_46340_0"));
        Checkbox.click();
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Talk')]"));
        submitButton.click();
        driver.quit();
    }
}

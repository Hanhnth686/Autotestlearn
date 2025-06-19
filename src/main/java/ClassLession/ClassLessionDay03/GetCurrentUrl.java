package ClassLession.ClassLessionDay03;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCurrentUrl {
    static WebDriver driver = null;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com");
        driver.navigate().to("https://saucelabs.com/request-demo");
        driver.navigate().back();
        driver.navigate().forward();
        String url = driver.getCurrentUrl();
        System.out.println("String irl la: " + url);
    }
}
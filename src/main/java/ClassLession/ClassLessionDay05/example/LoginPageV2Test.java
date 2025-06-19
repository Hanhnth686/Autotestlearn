package ClassLession.ClassLessionDay05.example;

import ClassLession.ClassLessionDay05.Utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class LoginPageV2Test {
    public static void main(String[] args) {
        // Đường dẫn file Excel
        String excelFilePath = "dataLogin.xlsx"; // Hoặc thay bằng tên sheet bất kỳ trong file
        String sheetName = "Sheet1";
        // Đọc dữ liệu từ file excel
        List<Map<String, String>> excelData = ExcelUtils.readExelData(excelFilePath, sheetName);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        for (Map<String, String> rowData : excelData) {
            System.out.println("Dữ liệu hàng: " + rowData);
            String user = (String) rowData.get("Username");
            String pass = (String) rowData.get("Password");
            driver.get("https://www.saucedemo.com/");
            WebElement userNameInput = driver.findElement(By.id("user-name"));
            userNameInput.sendKeys(new CharSequence[]{user});
            WebElement passInput = driver.findElement(By.id("password"));
            passInput.sendKeys(new CharSequence[]{pass});
        }

    }
}


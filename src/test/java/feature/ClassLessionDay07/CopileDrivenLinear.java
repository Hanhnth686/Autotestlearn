package feature.ClassLessionDay07;

import ClassLession.ClassLessionDay05.Utils.ExcelUtils;
import action.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import untils.Hook;

import java.util.List;
import java.util.Map;

public class CopileDrivenLinear extends Hook {
    LoginPage loginPage;
    String excelFilePath = "dataLogin.xlsx";

    @BeforeMethod
    public void setupPage() {
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        List<Map<String, String>> excelData = ExcelUtils.readExelData(excelFilePath, "Sheet1");
        Object[][] data = new Object[excelData.size()][1]; // Mỗi row là 1 Map<String, String>
        for (int i = 0; i < excelData.size(); i++) {
            data[i][0] = excelData.get(i);
        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(Map<String, String> rowData) {
        String username = rowData.get("Username");
        String password = rowData.get("Password");
        String expectedResult = rowData.get("ExpectedResult");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

    }
}

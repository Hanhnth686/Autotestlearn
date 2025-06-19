package feature.ClassLessionDay07;

import action.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import untils.Hook;

public class ModuleDrivenTest extends Hook {
    LoginPage loginPage = new LoginPage(driver);

    @BeforeMethod
    public void setupPage() {
        loginPage = new LoginPage(driver);
    }
    public void inputData(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Test
    public void inputValidUserNameAndPassword() {
        inputData("standard_user", "secret_sauce");
        clickLogin();
    }

    @Test
    public void inputValidUserNameAndInvalidPassword() {
        inputData("standard_user", "secret_sauce1");
        clickLogin();
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(error.isDisplayed());
    }

}



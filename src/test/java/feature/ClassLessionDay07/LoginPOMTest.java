package feature.ClassLessionDay07;

import action.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import untils.Hook;

public class LoginPOMTest extends Hook {
    LoginPage loginPage;

    @BeforeMethod
    public void setupPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithValidCredentials() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo not displayed!");
        Assert.assertTrue(loginPage.getInventoryItemCount() > 0, "No product displayed!");
    }
}





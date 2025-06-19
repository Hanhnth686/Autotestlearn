package Homework.HomeworkDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.function.ToIntFunction;

public class HomeworkDay04 {
    public static void main(String[] args) {
        // Step 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement Username = driver.findElement(By.xpath("//input[@id='user-name']"));
        Username.sendKeys("standard_user");
        WebElement Password = driver.findElement(By.xpath("//input[@id='user-name']"));
        Password.sendKeys("secret_sauce");
        WebElement Login = driver.findElement(By.xpath("//input[@id='login-button']"));
        Login.click();
        // Step 2
        WebElement DropdownList = driver.findElement(By.xpath("//select[contains(@class,'sort')]"));
        Select selectInterest = new Select(DropdownList);
        selectInterest.selectByIndex(2);
        // Step 3
        WebElement AddProduct1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
        AddProduct1.click();
        WebElement AddProduct2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        AddProduct2.click();
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement resultCart = driver.findElement(By.xpath("//span[contains(text(),'2')]"));
        System.out.println("Số lượng trong giỏ hàng: " + resultCart.getText());
        // Step 4
        //Expected 1
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        boolean boltTshirtFound = false;
        boolean bikeLightFound = false;
        for (WebElement item : cartItems) {
            String name = item.findElement(By.className("inventory_item_name")).getText();
            String price = item.findElement(By.className("inventory_item_price")).getText();

            if (name.equals("Sauce Labs Bolt T-Shirt") && price.equals("$15.99")) {
                boltTshirtFound = true;
            }

            if (name.equals("Sauce Labs Bike Light") && price.equals("$9.99")) {
                bikeLightFound = true;
            }
        }
        if (boltTshirtFound && bikeLightFound) {
            System.out.println("Đúng sản phẩm và giá tiền trong giỏ hàng.");
        } else {
            System.out.println("Sai thông tin sản phẩm hoặc giá tiền.");
        }
        // Expected 2
        List<WebElement> removeButtons = driver.findElements(By.xpath("//button[text()='remove']"));
        int buttons = 0;
        for (WebElement removeButton : removeButtons) {
            if (removeButton.isDisplayed()) {
                buttons++;
            }
        }
        System.out.println("Số lượng button 'Remove' hiển thị: " + buttons);
        // Step 5
        WebElement continueButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        continueButton.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys("Nguyễn Thị");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys("Hồng Hạnh");
        WebElement zip = driver.findElement(By.xpath("//input[@id='postal-code']"));
        zip.sendKeys("100000");
        // Step 6
        WebElement continueCart = driver.findElement(By.xpath("//input[@id='continue']"));
        continueCart.click();
        // Expected 1
        WebElement name = driver.findElement(By.className("inventory_item_name"));
        WebElement description = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']"));
        WebElement price = driver.findElement(By.className("inventory_item_price"));
        WebElement quantity = driver.findElement(By.className("cart_quantity"));
        boolean nameOK = name.getText().equals("Sauce Labs Bolt T-Shirt");
        boolean descriptionOK = description.getText().equals(description);
        boolean priceOK = price.getText().equals("$15.99");
        boolean quantityOK = quantity.getText().equals("1");
        if (nameOK && descriptionOK && priceOK && quantityOK && descriptionOK) {
            System.out.println("Tên, mô tả, số lượng và giá tiền đều đúng trong giỏ hàng.");
        } else {
            System.out.println("Dữ liệu giỏ hàng KHÔNG đúng:");
            System.out.println("- Tên: " + name.getText());
            System.out.println("- Mô tả: " + description.getText());
            System.out.println("- Giá: " + price.getText());
            System.out.println("- Số lượng: " + quantity.getText());
        }
        // Expected 2
        WebElement shippingInfor = driver.findElement(By.xpath("//div[contains(text(),'Express')]"));
        shippingInfor.getText().equals("Free Pony Express Delivery!");
        // Expected 3
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));
        double total = 0.0;
        for (WebElement totalPricerice : itemPrices) {
            String text = totalPricerice.getText();
            text = text.replace("$", "").trim();
            total += Double.parseDouble(text);
        }
        WebElement totalElement = driver.findElement(By.className("summary_subtotal_label"));
        String totalText = totalElement.getText().replace("Item total: $", "").trim();
        double displayedTotal = Double.parseDouble(totalText);
        if (Math.abs(displayedTotal - total) < 0.01) {
            System.out.println("Tổng tiền chính xác: " + displayedTotal);
        } else {
            System.out.println("Tổng tiền KHÔNG đúng!");
            System.out.println("Cộng theo từng sản phẩm: " + total);
            System.out.println("Hiển thị trên giao diện: " + displayedTotal);
        }
        // Expect 4
//        List<WebElement> total = driver.findElements(By.className("inventory_item_price"));
        double totalProducts = 0.0;
        for (WebElement priceElement : itemPrices) {
            totalProducts += Double.parseDouble(priceElement.getText().replace("$", ""));
        }

        double itemTotal = Double.parseDouble(driver.findElement(By.className("summary_subtotal_label")).getText().replace("Item total: $", ""));
        double tax = Double.parseDouble(driver.findElement(By.className("summary_tax_label")).getText().replace("Tax: $", ""));
        double totalDisplayed = Double.parseDouble(driver.findElement(By.className("summary_total_label")).getText().replace("Total: $", ""));

        double expectedTotal = itemTotal + tax;

        System.out.println("Tổng từng sản phẩm: $" + totalProducts);
        System.out.println("Subtotal (hiển thị): $" + itemTotal);
        System.out.println("Thuế: $" + tax);
        System.out.println("Total (hiển thị): $" + totalDisplayed);

        if (Math.abs(expectedTotal - totalDisplayed) < 0.01) {
            System.out.println("Total đúng.");
        } else {
            System.out.println("Total KHÔNG đúng!");
        }
        // Expect 5
        WebElement finishButton = driver.findElement(By.id("finish"));
        if (finishButton.isDisplayed()) {
            System.out.println("Button 'Finish' hiển thị.");
        } else {
            System.out.println("Button 'Finish' KHÔNG hiển thị.");
        }
        WebElement finishComplete = driver.findElement(By.id("finish"));
        if (finishComplete.isDisplayed()) {
            System.out.println("Button 'Finish' hiển thị.");
            finishComplete.click();
        } else {
            System.out.println("Button 'Finish' KHÔNG hiển thị.");
        }
        // Step 7
        // Expect 1: Check title
        WebElement title = driver.findElement(By.className("complete-header"));
        if (title.getText().equals("Thank you for your order!")) {
            System.out.println("Tiêu đề 'Thank you for your order!' hiển thị.");
        }

        // Expect 2: Check thank you message
        WebElement thankYou = driver.findElement(By.className("complete-text"));
        if (thankYou.getText().contains("Your order has been dispatched")) {
            System.out.println("Thông điệp giao hàng hiển thị đúng.");
        }

        // Expect 3: Check Back Home button
        WebElement backHomeBtn = driver.findElement(By.id("back-to-products"));
        if (backHomeBtn.isDisplayed()) {
            System.out.println("Button 'Back Home' hiển thị.");
        }
        driver.quit();
    }
}


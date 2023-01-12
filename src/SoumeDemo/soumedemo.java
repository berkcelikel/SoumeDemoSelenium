package SoumeDemo;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.List;

public class soumedemo extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//*[@data-test='username']"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//*[@placeholder='Password']"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.xpath("//*[@name='login-button']"));
        login.click();

        WebElement backpack = driver.findElement(By.xpath("//*[@name='add-to-cart-sauce-labs-backpack']"));
        backpack.click();

        WebElement tshirt = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        tshirt.click();

        WebElement cart = driver.findElement(By.xpath("//*[@class='shopping_cart_link']"));
        cart.click();

        WebElement checkout = driver.findElement(By.xpath("//*[@class='btn btn_action btn_medium checkout_button']"));
        checkout.click();

        WebElement name = driver.findElement(By.xpath("//*[@id='first-name']"));
        name.sendKeys("Berk");

        WebElement lastname = driver.findElement(By.xpath("//*[@data-test='lastName']"));
        lastname.sendKeys("Çelikel");

        WebElement code = driver.findElement(By.xpath("//*[@data-test='postalCode']"));
        code.sendKeys("34315");

        WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
        submit.click();


        //(//*[@class='inventory_item_price'])[1]
        List<WebElement> ucretler= driver.findElements(By.xpath("//*[@class='inventory_item_price']"));

        double toplam=0;
        for (WebElement e : ucretler)
        {
            System.out.println("e.getText() = " + e.getText());;
            toplam=toplam + Double.parseDouble(e.getText().substring(1));
        }
        System.out.println("toplam = " + toplam);

        WebElement webtoplam=driver.findElement(By.xpath("//*[@class='summary_subtotal_label']"));
        System.out.println("webtoplam = " + webtoplam.getText());
        double altoplam=Double.parseDouble(webtoplam.getText().substring(13));
        System.out.println("altoplam = " + altoplam);

        if (toplam == altoplam)
            System.out.println("Test Başarılı");
        else
            System.out.println("Test başarısız");

        Assert.assertTrue(toplam==altoplam);
         //  Assert.assertEquals("merhaba","merhaba1");


        BekleKapat();

    }
}

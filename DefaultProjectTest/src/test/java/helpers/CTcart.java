package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;


public class CTcart {
    static String selectFirst = "/html/body/main/section/form/div/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div[2]/h4";
    static String addItem = "product-addtocart-button";
    static String cont ="nastavi";
    static String cross = "removeItem";
    static String cartIcon = "sharkskin-header-cart";
    public static String model;

    public static void addCart(WebDriver driver, WebDriverWait wdWait){
        model = BaseHelper.getModel(driver.findElement(By.xpath(selectFirst)));

        driver.findElement(By.xpath(selectFirst)).click();
        driver.findElement(By.id(addItem)).click();
        driver.findElement(By.className(cont)).click();
    }
    public static void removeCart(WebDriver driver, WebDriverWait wdWait){
        driver.findElement(By.id(cartIcon)).click();
        driver.findElement(By.id(cross)).click();
        wdWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("shoppingCart"), "Vaša korpa"));
    }
}
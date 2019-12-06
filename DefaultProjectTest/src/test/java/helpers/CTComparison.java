package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CTComparison {
    static String compareBtn = "link-compare";
    public static String compareBoxText;
    public static String model;

    public static void compare(WebDriver driver, WebDriverWait wdWait) {
        model = BaseHelper.getModel(driver.findElement(By.xpath(CTcart.selectFirst)));

        driver.findElement(By.xpath(CTcart.selectFirst)).click();
        driver.findElement(By.className(compareBtn)).click();
        CTSort.goToList(driver, wdWait);
        Actions scrollTo = new Actions(driver);
        scrollTo.moveToElement(driver.findElement(By.id("productCompareSidebar"))).perform();
        wdWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("productCompareSidebar"))));
        compareBoxText = driver.findElement(By.id("productCompareSidebar")).getText();
    }
}


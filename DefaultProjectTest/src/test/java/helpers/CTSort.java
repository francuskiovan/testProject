package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class CTSort {
    static String selHover = ".am-container";
    static String select1 = "li.level0:nth-child(1) > a:nth-child(1)";
    static String select2 = "ul.pos-1 > li:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)";
    public static boolean control = true;

    public static void goToList(WebDriver driver, WebDriverWait wdWait){
        driver.get(CTLogInPoz.url);
        Actions sortAct = new Actions (driver);
        sortAct.moveToElement(driver.findElement(By.cssSelector(selHover))).moveToElement(driver.findElement(By.cssSelector(select1))).moveToElement(driver.findElement(By.cssSelector(select2))).click().build().perform();
    }

    static int priceToNum(String price){
        if(price.contains("RSD")) return Integer.parseInt(price.substring(0, price.indexOf(" ")).replace(".",""));
        else return Integer.parseInt(price.replace(".",""));
    }

    public static void sort(WebDriver driver, WebDriverWait wdWait){
        driver.findElement(By.className("fa-angle-down")).click();
        driver.findElement(By.xpath("/html/body/main/section/form/div/div/div[1]/div[2]/div[1]/div[1]/div/div[1]/ul/li[3]")).click();
        wdWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/main/section/form/div/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div[2]/h4/a"),"A315-33-C4FZ"));
        WebElement cont = driver.findElement(By.id("products-list"));
        List<WebElement> allItems =  cont.findElements(By.className("price"));
        for (int i = 0; i < allItems.size() -1 ; i++){
            if(priceToNum(allItems.get(i).getText()) > priceToNum(allItems.get(i+1).getText())){
                control = false;
                break;
            }
        }
    }
}

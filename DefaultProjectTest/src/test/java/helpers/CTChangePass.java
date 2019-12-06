package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CTChangePass {
    static String changeBtn = "/html/body/main/section/div/main/div/div/div[3]/div[1]/a";
    static String passChangeBox = "/html/body/main/section/div/main/main/div/form/div[1]/ul/li[6]/div/label";
    static String currPass = "current_password";
    static String pass = "password";
    static String confPass = "confirmation";
    static String saveBtn = "btn-continue";
    static String signOut = "/html/body/header/div/section/div/div/div[4]/div[1]/div[1]/ul/li[1]/a";

    public static void changePass(WebDriver driver, WebDriverWait wdWait){
        driver.findElement(By.xpath(changeBtn)).click();
        driver.findElement(By.xpath(passChangeBox)).click();
        driver.findElement(By.id(currPass)).sendKeys("srboslava");
        driver.findElement(By.id(pass)).sendKeys("danas");
        driver.findElement(By.id(confPass)).sendKeys("danas");
        driver.findElement(By.className(saveBtn)).click();
        driver.findElement(By.xpath(signOut)).click();
    }
}

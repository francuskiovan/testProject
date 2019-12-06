package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CTLogInPoz {
    public static String url = "https://www.comtradeshop.com/";
    public static String logInPic = "fa-user";
    public static String email = "email";
    public static String pass = "pass";
    public static String checkBox = "persistent_remember_me";
    public static String prijava = "send2";

    public static void logIn (WebDriver driver, WebDriverWait wdWait, String emailInp, String passImp){
        driver.get(url);
        driver.findElement(By.className(logInPic)).click();
        driver.findElement(By.id(email)).sendKeys(emailInp);
        driver.findElement(By.id(pass)).sendKeys(passImp);
        driver.findElement(By.name(checkBox)).click();
        driver.findElement(By.id(prijava)).click();
    }

}

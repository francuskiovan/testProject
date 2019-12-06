package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CTSearch {
    private static String srcInpField = "pretrazi";
    private static String srcBtn = "search-submit-header";
    public static String modelName = "Samsung UE43RU7172UXXH";

    public static void search(WebDriver driver, WebDriverWait wdWait){
        driver.get(CTLogInPoz.url);
        driver.findElement(By.name(srcInpField)).sendKeys(modelName);
        driver.findElement(By.id(srcBtn)).click();
    }
}

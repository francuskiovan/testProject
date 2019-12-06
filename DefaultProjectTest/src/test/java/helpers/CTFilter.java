package helpers;

import com.sun.javafx.runtime.async.AbstractRemoteResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CTFilter {
    public static boolean check = true;

    public static void brandFilter(WebDriver driver, WebDriverWait wdWait){
        WebElement brand = driver.findElement(By.id("mCSB_1_container"));
        List<WebElement> brandList = brand.findElements(By.tagName("label"));
        String brandName = brandList.get(0).getText();
        brandList.get(0).click();
        List<WebElement> hpList = driver.findElements(By.className("product-name"));
        for(WebElement el : hpList) {
            if(!el.getText().contains(brandName)) {
                check = false;
                break;
            }
        }
    }
}

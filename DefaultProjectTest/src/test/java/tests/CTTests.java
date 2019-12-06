package tests;

import helpers.*;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import javax.swing.border.SoftBevelBorder;

public class CTTests extends BaseTest {
    @Test
    public void logInPoz() {
        CTLogInPoz.logIn (driver, wdWait, "francuskiovan@gmail.com", "srboslava");
        Assert.assertTrue(driver.findElement(By.className("hello")).getText().contains("Nikola Popović"));
    }
    @Test
    public void logInNeg(){
        CTLogInPoz.logIn(driver, wdWait, "francuskiovan@gmail.com", "11111");
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).getText().contains("Uneta email adresa i lozinka se ne poklapaju."));
}
    @Test
    public void logInDoubleNeg(){
        CTLogInPoz.logIn(driver, wdWait, "neki@neko.com", "11111");
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).getText().contains("Uneta email adresa i lozinka se ne poklapaju."));
    }
    @Test
    public void findItem(){
        CTSearch.search(driver, wdWait);
        Assert.assertTrue(driver.findElement(By.id("products-list")).getText().contains(CTSearch.modelName));
    }
    @Test
    public void sort(){
        CTSort.goToList(driver,wdWait);
        CTSort.sort(driver, wdWait);
        Assert.assertTrue(CTSort.control);
    }
    @Test
    public void filter(){
        CTSort.goToList(driver,wdWait);
        CTFilter.brandFilter(driver, wdWait);
        Assert.assertTrue(CTFilter.check);
    }
    @Test
    public void cart(){
        SoftAssert sa = new SoftAssert();
        CTSort.goToList(driver, wdWait);
        CTcart.addCart(driver, wdWait);
        sa.assertTrue(driver.findElement(By.className("product-name")).getText().contains(CTcart.model));
        CTcart.removeCart(driver, wdWait);
        sa.assertTrue(driver.findElement(By.id("shoppingCart")).getText().contains("Vaša korpa je trenutno prazna."));
        sa.assertAll();
    }
    @Test
    public void myFirstBugCaught(){
        //CTLogInPoz.logIn(driver, wdWait, "francuskiovan@gmail.com", "srboslava");
        CTSort.goToList(driver, wdWait);
        CTComparison.compare(driver, wdWait);
        Assert.assertFalse(CTComparison.compareBoxText.contains(CTComparison.model));
    }
    @Test
    public void mySecondBugCaught(){
        CTLogInPoz.logIn(driver, wdWait, "francuskiovan@gmail.com", "srboslava");
        CTChangePass.changePass(driver, wdWait);
        CTLogInPoz.logIn (driver, wdWait, "francuskiovan@gmail.com", "srboslava");
        Assert.assertTrue(driver.findElement(By.className("hello")).getText().contains("Dobrodošli, Nikola Popović!"));
    }
}

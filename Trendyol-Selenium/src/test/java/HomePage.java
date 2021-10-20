import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {
    public  String productPagePrice;
    public  String basketPagePrice;


    @Test
    public void productSearch() throws InterruptedException {
        setElementByCssSelector("[class='search-box']", "kazak");
        TimeUnit.SECONDS.sleep(2);
        clickElementByCssSelector("[class='search-icon']");
        TimeUnit.SECONDS.sleep(2);
        clickElementByCssSelector("[class='overlay']");
        TimeUnit.SECONDS.sleep(2);
        //scroll();
    }

    @Test
    public void productChoose() throws InterruptedException {
        productSearch();
        clickElementByXpath("//div[@class='p-card-wrppr'][10]");
        /* RANDOM URUN
        List<WebElement> links = driver.findElements(By.cssSelector("[class='p-card-wrppr']"));
        System.out.println(" Size : " + links.size());
        Random productSize = new Random();
        int rndmno = productSize.nextInt(links.size());
        System.out.println("Random Choose Number:" + rndmno);
        clickElementByXpath("//div[@class='p-card-wrppr'][" + rndmno + "]");
         */
    }

    @Test
    public void basket() throws InterruptedException {
        productChoose();
        newTab();
        /*
        WebElement productNum = driver.findElement(By.xpath("//div[@class='product-price-container']//div//div//span[@class='prc-dsc']"));
        productPagePrice = productNum.getText();
        System.out.println("Sayfadaki ürün fiyatı: "+productPagePrice);
         */
        TimeUnit.SECONDS.sleep(2);
        clickElementByXpath("//div[@class='product-button-container']//div//div//div//button//i[@class='i-heart']");
        TimeUnit.SECONDS.sleep(2);
        clickElementByCssSelector("[class='add-to-basket-button-text']");
       // clickElementByCssSelector("[class='i-heart']");
        TimeUnit.SECONDS.sleep(2);
        clickElementByCssSelector("[class='goBasket']");
        TimeUnit.SECONDS.sleep(2);
        clickElementByCssSelector("[class='i-trash']");
        clickElementByXpath("//div//div//button[@class='ty-font-w-semi-bold ty-button ty-bordered ty-transition ty-input-medium ty-notr'][2]");
    }
}

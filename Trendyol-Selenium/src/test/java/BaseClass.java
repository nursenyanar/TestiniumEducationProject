import org.junit.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    String baseUrl = "https://trendyol.com/";
    public WebDriver driver;
    WebDriverWait wait;
    protected String userName = "rejini1638@settags.com";
    protected String password = "gzv-89ZC7M?6NuB";

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(05));
        driver.get(baseUrl);
        clickElementByXpath("//div[@class='homepage-popup-content'][1]//span[@class='homepage-popup-gender']");
        TimeUnit.SECONDS.sleep(2);
        mouseHover("[class='link account-user']", "[class='login-button']");
        TimeUnit.SECONDS.sleep(2);
        setElementById("login-email", userName);
        setElementById("login-password-input", password);
        TimeUnit.SECONDS.sleep(2);
        clickElementByCssSelector("[class='q-primary q-fluid q-button-medium q-button submit']");
        TimeUnit.SECONDS.sleep(2);
        //clickElementByCssSelector("[class='modal-close']");
    }

    @After
    public void finish() {
        driver.quit();
    }

    public void newTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    public void setElementByCssSelector(String cssSelector, String value) {
        WebElement search = driver.findElement(By.cssSelector(cssSelector));
        search.sendKeys(value);
    }

    public void setElementById(String id, String value) {
        WebElement search = driver.findElement(By.id(id));
        search.sendKeys(value);
    }

    public void clickElementByCssSelector(String cssSelector) {
        WebElement click = driver.findElement(By.cssSelector(cssSelector));
        click.click();
    }

    public void clickElementById(String id) {
        WebElement click = driver.findElement(By.id(id));
        click.click();
    }

    public void clickElementByXpath(String xpath) {
        WebElement click = driver.findElement(By.xpath(xpath));
        click.click();
    }

    public void mouseHover(String attribute, String secondAttribute) throws InterruptedException {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector(attribute));
        builder.moveToElement(element).build().perform();
        //wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        TimeUnit.SECONDS.sleep(5);
        clickElementByCssSelector(secondAttribute);
    }

    public String scroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        return null;
    }

}

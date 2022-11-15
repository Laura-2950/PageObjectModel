package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return driver;
    }

    public static WebDriver driver() {
        return driver;
    }

    public void link(String url) {
        driver.get(url);
    }


    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void writeInput(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void enter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void down(By locator) {
        driver.findElement(locator).sendKeys(Keys.ARROW_DOWN);
    }

}

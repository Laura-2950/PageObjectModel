package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage extends BasePage {

    By searchBox = By.name("search");
    By btnSearch = By.xpath("//button[@class='btn btn-default btn-lg']");
    By result = By.xpath("//body//div[@id='product-search']//div[@class='row']//div[@class='row']//p[1]");
    //*[@id="content"]/div[3]/div/div
    //div[@class='product-thumb']

    By btnAddToCart= By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
    By mainTitle= By.xpath("//*[@id=\"content\"]/h1");
    By cart = By.id("cart");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
    }


    public void search(String product) throws InterruptedException {
        writeInput("Iphone", searchBox);
        Thread.sleep(2000);
        enter(searchBox);
        click(btnSearch);
    }

    public String result() throws InterruptedException {
        Thread.sleep(2000);
        String res = findElement(result).getText();
        System.out.println("Resultado card value: " + res);
        return res;
    }

    public String mainTitle() throws InterruptedException {
        Thread.sleep(2000);
        String res = findElement(mainTitle).getText();
        System.out.println("Resultado H1 value: " + res);
        return res;
    }

    public String addToCartResult() throws InterruptedException {
        Thread.sleep(2000);
        String res = findElement(cart).getText();
        System.out.println("Resultado Cart value: " + res);
        return res;
    }

    public void addToCart() {
        click(btnAddToCart);
    }
}

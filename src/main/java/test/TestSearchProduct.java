package test;

import base.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSearchProduct extends BasePage {

    private SearchPage searchPage;
    private WebDriver driver;


    @BeforeEach
    public void setUp() throws Exception {
        driver = super.chromeDriverConnection();
        searchPage = new SearchPage(driver, null);
        searchPage.link("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    public void successfulSearch () throws InterruptedException {
        searchPage.search("Iphone");
        assertTrue(searchPage.result().contains("iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a name o.."));
        assertTrue(searchPage.mainTitle()
                .equals("Search - Iphone"));

        searchPage.addToCart();
        assertTrue(searchPage.addToCartResult().equals("1 item(s) - $123.20"));

    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

}

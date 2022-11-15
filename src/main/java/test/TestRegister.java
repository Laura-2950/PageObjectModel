package test;

import base.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegister extends BasePage {

    private RegisterPage registerPage;
    private WebDriverWait wait;

    public TestRegister(WebDriver driver) {
        super(driver);
    }

    @BeforeEach
    public void setUp() throws Exception {
        driver = super.chromeDriverConnection();
        registerPage = new RegisterPage(driver);
        registerPage.link("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    public void successfulRegistration() throws InterruptedException {
        registerPage.clickLoginBtn();
        registerPage.completeForm("prueba5d", "prueba5d", "prueba5d@gmail.com", "1234", "1234","1234");
        registerPage.clickEnterBtn();
        assertTrue(registerPage.result().contains("Account If you already have an account with us, please login at the login page. Your Personal Details"));
        registerPage.clickContinueBtn();
    }

    @Test
    public void unsuccessfulRegistration() throws InterruptedException {
        registerPage.clickLoginBtn();
        registerPage.completeForm("prueba1", "prueba1", "prueba1@gmail.com", "1234", "1234","1234");
        registerPage.clickEnterBtn();
        //TODO no funciona.
        assertTrue(registerPage.result().contains("Congratulations! Your new account has been successfully created!"));
        System.out.println("Mensaje: " + registerPage.result());

    }


    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

}

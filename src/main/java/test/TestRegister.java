package test;

import base.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegister extends BasePage {

    private RegisterPage registerPage;
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        driver = super.chromeDriverConnection();
        registerPage = new RegisterPage(driver, null);
        registerPage.link("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    public void successfulRegistration() throws InterruptedException {
        registerPage.clickLoginBtn();
        registerPage.completeForm("prueba4e", "prueba4e", "prueba4e@gmail.com", "1234", "1234","1234");
        registerPage.clickEnterBtn();
        assertTrue(registerPage.result().contains("Congratulations! Your new account has been successfully created!"));
        registerPage.clickContinueBtn();
    }

    @Test
    public void unsuccessfulRegistration() throws InterruptedException {
        registerPage.clickLoginBtn();
        registerPage.completeForm("prueba1", "prueba1", "prueba1@gmail.com", "1234", "1234","1234");
        registerPage.clickEnterBtn();
        assertTrue(registerPage.container().contains("Warning: E-Mail Address is already registered!"));
        System.out.println("Mensaje: " + registerPage.result());

    }


    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

}

package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterPage extends BasePage {

    By inputFirstName = By.id("input-firstname");
    By inputLastName = By.id("input-lastname");
    By inputEmail = By.id("input-email");
    By inputTelephone = By.id("input-telephone");
    By inputPassword = By.id("input-password");
    By inputPasswordConfirm = By.id("input-confirm");
    By inputPrivacyPolicy = By.name("agree");
    By bottomMyAccount = By.xpath("//ul[@class='list-inline']//li[@class='dropdown']");
    By bottomRegistration = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    By bottomFinish = By.xpath("//input[@value='Continue']");
    By message = By.id("content");
    By warning= By.xpath("//div[@id='account-register'])[1]");
    By bottomContinue = By.xpath("//*[@id=\"content\"]/div/div/a");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public String result() throws InterruptedException {
        WebElement res = findElement(message);
        return res.getText();
    }

    public void clickLoginBtn() throws InterruptedException {
        click(bottomMyAccount);
        click(bottomRegistration);
    }

    public void completeForm(String name, String lastName, String mail, String tel, String password, String confirmPassword) throws InterruptedException {
        writeInput(name, inputFirstName);
        writeInput(lastName, inputLastName);
        writeInput(mail, inputEmail);
        writeInput(tel, inputTelephone);
        writeInput(password, inputPassword);
        writeInput(confirmPassword, inputPasswordConfirm);
        click(inputPrivacyPolicy);
    }


    public void clickEnterBtn() throws InterruptedException {
        click(bottomFinish);
    }

    public void clickContinueBtn() throws InterruptedException {
        click(bottomContinue);
    }

    public String warning() throws InterruptedException {
        return findElement(warning).getText();
    }

}

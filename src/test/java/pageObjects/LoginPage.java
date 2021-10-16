package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

import java.util.Random;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {
        //inicia os elementos da página --> PageFactory
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Preencheu o e-mail")
    public void fillEmail() {
        email.sendKeys("emailqualquerinventado@gmail.com");
    }

    @Step("Preencheu a senha")
    public void fillPasswd() {
        passwd.sendKeys("teste123456");
    }

    @Step("Clicou em Sign in")
    public void clickBtnSubmitLogin() {
        SubmitLogin.click();
    }

    @Step("Preencheu endereço de e-mail concatenado aleatoriamente")
    public void fillEmailCreate() {
        Random randomNumber = new Random();
        String emailAdress = "lgcc" + randomNumber.nextInt(51) + "@gmail.com";
        System.out.println("E-mail random criado: " + emailAdress);
        email_create.sendKeys(emailAdress);
    }

    @Step("Clicou em Create an account")
    public void clickBtnSubmitCreate() {
        SubmitCreate.click();
    }
}

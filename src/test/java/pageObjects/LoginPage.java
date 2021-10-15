package pageObjects;

import elementMapper.LoginPageElementMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

import java.util.Random;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {
        //inicia os elementos da página --> PageFactory
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void fillEmail() {
        email.sendKeys("emailqualquerinventado@gmail.com");
    }

    public void fillPasswd() {
        passwd.sendKeys("teste123456");
    }

    public void clickBtnSubmitLogin() {
        SubmitLogin.click();
    }

    public void fillEmailCreate() {
        Random randomNumber = new Random();
        String emailAdress = "lgcc" + randomNumber.nextInt(51) + "@gmail.com";
        System.out.println("E-mail random criado: " + emailAdress);
        email_create.sendKeys(emailAdress);
    }

    public void clickBtnSubmitCreate() {
        SubmitCreate.click();
    }
}

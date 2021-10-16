package pageObjects;

import elementMapper.CreateAnAccountElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

public class CreateAnAccountPage extends CreateAnAccountElementMapper {

    public CreateAnAccountPage() {
        //inicia os elementos da página --> PageFactory
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String createAnAccountPageValidation() {
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(createAnAccountPageValidationWord, "CREATE AN ACCOUNT"));
        return createAnAccountPageValidationWord.getText();
    }

    @Step("Preencheu o campo First name: lg")
    public void fillFirstName() {
        customer_firstname.sendKeys("lg");
    }

    @Step("Preencheu o campo Last name: cc")
    public void fillLastName() {
        customer_lastname.sendKeys("cc");
    }

    @Step("Preencheu o campo Password: teste123456")
    public void fillAccountPasswd() {
        accountPasswd.sendKeys("teste123456");
    }

    @Step("Preencheu o campo Date of Birth: 03/março/1993")
    public void clickDateOfBirth() {
        dayOfBirth3.click();
        monthOfBirth3.click();
        yearOfBirth93.click();
    }

    @Step("Preencheu o campo Adress: Street address, P.O. Box, Company name, etc.")
    public void fillAddress1() {
        address1.sendKeys("Street address, P.O. Box, Company name, etc.");
    }

    @Step("Preencheu o campo City: Itajuba")
    public void fillCity() {
        city.sendKeys("Itajuba");
    }

    @Step("Preencheu o campo State: Alabama")
    public void clickState() {
        state.click();
    }

    @Step("Preencheu o campo Zip/Postal Code: 12345")
    public void fillPostCode() {
        postCode.sendKeys("12345");
    }

    @Step("Preencheu o campo Mobile phone: 123456")
    public void fillPhoneMobile() {
        phone_mobile.sendKeys("123456");
    }

    @Step("Clicou no botão Register")
    public void clickSubmitAccount() {
        submitAccount.click();
    }
}

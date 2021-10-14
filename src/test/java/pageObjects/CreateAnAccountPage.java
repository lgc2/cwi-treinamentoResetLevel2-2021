package pageObjects;

import elementMapper.CreateAnAccountElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CreateAnAccountPage extends CreateAnAccountElementMapper {

    public CreateAnAccountPage() {
        //inicia os elementos da página --> PageFactory
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String createAnAccountPageValidation() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return createAnAccountPageValidationWord.getText();
    }

    public void fillFirstName() {
        customer_firstname.sendKeys("lg");
    }

    public void fillLastName() {
        customer_lastname.sendKeys("cc");
    }

    public void fillAccountPasswd() {
        accountPasswd.sendKeys("teste123456");
    }

    public void clickDateOfBirth() {
        dayOfBirth3.click();
        monthOfBirth3.click();
        yearOfBirth93.click();
    }

    public void fillAddress1() {
        address1.sendKeys("Street address, P.O. Box, Company name, etc.");
    }

    public void fillCity() {
        city.sendKeys("Itajuba");
    }

    public void clickState() {
        state.click();
    }

    public void fillPostCode() {
        postCode.sendKeys("12345");
    }

    public void fillPhoneMobile() {
        phone_mobile.sendKeys("123456");
    }

    public void clickSubmitAccount() {
        submitAccount.click();
    }
}

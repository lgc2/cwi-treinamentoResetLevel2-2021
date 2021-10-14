package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountElementMapper {

    @FindBy(css = "#center_column #noSlide .page-heading")
    public WebElement createAnAccountPageValidationWord;

    @FindBy(css = "#customer_firstname")
    public WebElement customer_firstname;

    @FindBy(css = "#customer_lastname")
    public WebElement customer_lastname;

    @FindBy(css = "#passwd")
    public WebElement accountPasswd;

    @FindBy(css = "#days > option:nth-child(4)")
    public WebElement dayOfBirth3;

    @FindBy(css = "#months > option:nth-child(4)")
    public WebElement monthOfBirth3;

    @FindBy(css = "#years > option:nth-child(30)")
    public WebElement yearOfBirth93;

    @FindBy(css = "#address1")
    public WebElement address1;

    @FindBy(css = "#city")
    public WebElement city;

    @FindBy(css = "#id_state > option:nth-child(2)")
    public WebElement state;

    @FindBy(css = "#postcode")
    public WebElement postCode;

    @FindBy(css = "#phone_mobile")
    public WebElement phone_mobile;

    @FindBy(css = "#submitAccount")
    public WebElement submitAccount;

}

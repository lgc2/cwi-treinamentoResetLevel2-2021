package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartAddressPageElementMapper {

    @FindBy(css = "#center_column > h1")
    public WebElement shoppingCartAddressPageValidationWord;

    @FindBy(css = "#address_invoice > li.address_firstname.address_lastname")
    public WebElement billingAddressName;

    @FindBy(css = "#address_invoice > li.address_address1.address_address2")
    public WebElement billingAddressStreet;

    @FindBy(css = "#address_invoice > li.address_city.address_state_name.address_postcode")
    public WebElement billingAddressCityStateZipcode;

    @FindBy(css = "#address_invoice > li.address_phone_mobile")
    public WebElement billingAddressPhone;

    @FindBy(css = "#center_column > form > p > button > span")
    public WebElement btnProceedToCheckOutAddressesPage;


}

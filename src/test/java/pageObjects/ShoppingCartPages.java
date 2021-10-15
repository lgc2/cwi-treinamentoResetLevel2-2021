package pageObjects;

import elementMapper.ShoppingCartPagesElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ShoppingCartPages extends ShoppingCartPagesElementMapper {

    public ShoppingCartPages() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getShoppingCartValidationText() {
        return shoppingCartValidationText.getText();
    }

    public String getProductNameValidation() {
        return productNameValidation.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getAddress() {
        return address.getText();
    }

    public String getCityStateZipcode() {
        return cityStateZipcode.getText();
    }

    public String getPhoneMobile() {
        return phoneMobile.getText();
    }

}

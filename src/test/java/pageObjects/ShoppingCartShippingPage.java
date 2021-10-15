package pageObjects;

import elementMapper.ShoppingCartShippingPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ShoppingCartShippingPage extends ShoppingCartShippingPageElementMapper {

    public ShoppingCartShippingPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String shoppingCartShippingPageValidation() {
        return shoppingCartShippingPageValidationWord.getText();
    }

    public void clickAgree() {
        checkbox.click();
    }

    public void clickBtnProceedToCheckOutShippingPage() {
        btnProceedToCheckOutShippingPage.click();
    }



}

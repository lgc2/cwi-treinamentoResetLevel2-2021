package pageObjects;

import elementMapper.ShoppingCartPaymentPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ShoppingCartPaymentPage extends ShoppingCartPaymentPageElementMapper {

    public ShoppingCartPaymentPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String shoppingCartPaymentPageValidation() {
        return shoppingCartPaymentPageValidationWord.getText();
    }

    public String totalPriceValidation() {
        return totalPricePaymentPage.getText();
    }

    public void clickBtnPayByBankWire() {
        btnPayByBankWire.click();
    }

    public void clickBtnIConfirmMyOrder() {
        btnIConfirmMyOrder.click();
    }

    public String orderConfirmationValidation() {
        return orderConfirmationValidationWord.getText();
    }

    public String amountInOrderConfirmationPageValidation() {
        return amountInOrderConfirmationPage.getText();
    }

}

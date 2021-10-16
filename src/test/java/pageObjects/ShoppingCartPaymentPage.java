package pageObjects;

import elementMapper.ShoppingCartPaymentPageElementMapper;
import io.qameta.allure.Step;
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

    @Step("Clicou no botão Pay by bank wire da página 05 do carrinho de compras")
    public void clickBtnPayByBankWire() {
        btnPayByBankWire.click();
    }

    @Step("Clicou no botão I confirm my order")
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

package pageObjects;

import elementMapper.ShoppingCartShippingPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ShoppingCartShippingPage extends ShoppingCartShippingPageElementMapper {

    public ShoppingCartShippingPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String shoppingCartShippingPageValidation() {
        return shoppingCartShippingPageValidationWord.getText();
    }

    @Step("Marcou a caixa Terms of service para concordar com os termos de serviço")
    public void clickAgree() {
        checkbox.click();
    }

    @Step("Clicou no botão Proceed to check out da página 04 do carrinho de compras")
    public void clickBtnProceedToCheckOutShippingPage() {
        btnProceedToCheckOutShippingPage.click();
    }



}

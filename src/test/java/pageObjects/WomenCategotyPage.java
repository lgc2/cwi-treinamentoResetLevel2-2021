package pageObjects;

import elementMapper.WomenCategoryPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class WomenCategotyPage extends WomenCategoryPageElementMapper {

    public WomenCategotyPage() {
        //inicia os elementos da página --> PageFactory
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String womenCategoryPageValidation() {
        return womenCategoryPageValidationWord.getText();
    }

    @Step("Passou o mouse sobre o produto Blouse e clicou no botão Add to cart")
    public void clickBtnAddToCart() {
        BasePage.mouseOver(productBlouse);
        addToCartBtn.click();
    }

    @Step("Clicou no botão Proceed to checkout da Modal e direcionou para a página 01 do carrinho de compras")
    public void clickButtonModalProceedToCheckout() {
        buttonModalProceedToCheckout.click();
    }
}

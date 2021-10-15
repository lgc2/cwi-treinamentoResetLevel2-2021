package pageObjects;

import elementMapper.WomenCategoryPageElementMapper;
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

    public void clickBtnAddToCart() {
        BasePage.mouseOver(productBlouse);
        addToCartBtn.click();
    }

    public void clickButtonModalProceedToCheckout() {
        buttonModalProceedToCheckout.click();
    }
}

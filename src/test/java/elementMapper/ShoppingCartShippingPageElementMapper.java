package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartShippingPageElementMapper {

    @FindBy(css = "#carrier_area > h1")
    public WebElement shoppingCartShippingPageValidationWord;

    @FindBy(css = "#cgv")
    public WebElement checkbox;

    @FindBy(css = "#form > p > button > span")
    public WebElement btnProceedToCheckOutShippingPage;
}

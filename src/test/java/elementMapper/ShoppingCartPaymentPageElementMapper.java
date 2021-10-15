package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPaymentPageElementMapper {

    @FindBy(css = "#center_column > h1")
    public WebElement shoppingCartPaymentPageValidationWord;

    @FindBy(css = "#total_price")
    public WebElement totalPricePaymentPage;

    @FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    public WebElement btnPayByBankWire;

    @FindBy(css = "#cart_navigation > button > span")
    public WebElement btnIConfirmMyOrder;

    @FindBy(css = "#center_column > h1")
    public WebElement orderConfirmationValidationWord;

    @FindBy(css = "#center_column > div > span > strong")
    public WebElement amountInOrderConfirmationPage;
}

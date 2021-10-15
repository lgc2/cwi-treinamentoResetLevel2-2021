package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPagesElementMapper {

    @FindBy(css = "h1#cart_title.page-heading")
    public WebElement shoppingCartValidationText;

    @FindBy(css = "#product_2_7_0_584330 > td.cart_description > p > a")
    public WebElement productNameValidation;

    @FindBy(css = "#total_price")
    public WebElement totalPrice;

    @FindBy(css = "#center_column > div.order_delivery.clearfix.row > div:nth-child(1) > ul > li:nth-child(3) > span")
    public WebElement address;

    @FindBy(css = "#center_column > div.order_delivery.clearfix.row > div:nth-child(1) > ul > li:nth-child(4) > span")
    public WebElement cityStateZipcode;

    @FindBy(css = "#center_column > div.order_delivery.clearfix.row > div:nth-child(1) > ul > li:nth-child(6) > span")
    public WebElement phoneMobile;
}

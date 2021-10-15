package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenCategoryPageElementMapper {

    @FindBy(css = "#columns .navigation_page")
    public WebElement womenCategoryPageValidationWord;

    @FindBy(css = "#center_column > ul > li:nth-child(2) > div")
    public WebElement productBlouse;

    @FindBy(css = "#center_column > ul > li:nth-child(2) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    public WebElement addToCartBtn;

    @FindBy(css = ".button-container > a[title='Proceed to checkout']")
    public WebElement buttonModalProceedToCheckout;

}

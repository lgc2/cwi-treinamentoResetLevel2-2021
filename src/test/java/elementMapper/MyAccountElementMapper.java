package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountElementMapper {

    @FindBy(css = "#center_column .page-heading")
    public WebElement myAccountPageValidationWord;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    public WebElement womenCategoryBtn;
}

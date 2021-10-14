package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountElementMapper {

    @FindBy(css = "#center_column .page-heading")
    public WebElement myAccountPageValidationWord;
}

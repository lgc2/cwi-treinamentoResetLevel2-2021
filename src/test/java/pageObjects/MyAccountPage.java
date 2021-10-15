package pageObjects;

import elementMapper.MyAccountElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class MyAccountPage extends MyAccountElementMapper {

    public MyAccountPage() {
        //inicia os elementos da página --> PageFactory
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getMyAccountPageValidation() {
        return myAccountPageValidationWord.getText();
    }

    public void clickBtnWomenCategory() {
        womenCategoryBtn.click();
    }

}

package pageObjects;

import elementMapper.MyAccountElementMapper;
import io.qameta.allure.Step;
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

    @Step("Clicou no botão da categoria WOMAN")
    public void clickBtnWomenCategory() {
        womenCategoryBtn.click();
    }

}

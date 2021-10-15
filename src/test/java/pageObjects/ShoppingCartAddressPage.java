package pageObjects;

import elementMapper.ShoppingCartAddressPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ShoppingCartAddressPage extends ShoppingCartAddressPageElementMapper {

    public ShoppingCartAddressPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String shoppingCartAddressPageValidation() {
        return shoppingCartAddressPageValidationWord.getText();
    }

    public String[] shoppingCartAddressPageBillingInformations() {
        String[] billingInformations = new String[4];
        billingInformations[0] = billingAddressName.getText();
        billingInformations[1] = billingAddressStreet.getText();
        billingInformations[2] = billingAddressCityStateZipcode.getText();
        billingInformations[3] = billingAddressPhone.getText();

        return billingInformations;
    }

    public void clickBtnProceedToCheckOutAddressesPage() {
        btnProceedToCheckOutAddressesPage.click();
    }




}

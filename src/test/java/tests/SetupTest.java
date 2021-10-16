package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import java.util.Arrays;

import static org.junit.Assert.*;

@Feature("Testes site de ecommerce")
public class SetupTest extends BaseTests{

    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    @Story("Realizar o login")
    public void testLogin() {
        //Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickBtnLogin();
        System.out.println("Clicou Sign in e direcionou para a página de login");
        //certificando de que está entrando na página de login
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        login.fillEmail();
        System.out.println("Preencheu o e-mail");
        login.fillPasswd();
        System.out.println("Preencheu a senha");
        login.clickBtnSubmitLogin();
        System.out.println("Clicou em Sign in");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou a URL de MY ACCOUNT");
        //Cerificando de que está na página correta?
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading"))
                .getText().contains("MY ACCOUNT"));
        System.out.println("Validou Minha Conta no site");
    }

    @Test
    public void testSearch() {
        String quest = "DRESS";
        String questResultQtd = "7";

        //iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //fazer a pesquisa
        home.doSearch(quest);

        //validar a pesquisa
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"", ""), quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
    }

    @Test
    @Story("Acessar categoria")
    public void testAcessCategoryTShirts() {
        //iniciar as páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //clicar na categoria T-SHIRTS
        //Browser.getCurrentDriver().findElement(By.LinkText("T-SHIRTS")).click();
        home.clickCategoryTShirts();

        //validar se ao clicar na categoria T-Shirts ocorre o direcionamento correto
        assertTrue(category.isPageTshirts());
    }

    @Test
    @Story("Acessar página de produto")
    public void testAddProductToProductPage() {
        //acessar categoria T-Shirts
        testAcessCategoryTShirts();

        //iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //salva nome do produto na página da categoria
        String nameProductCategory = category.getProductNameCategory();

        //clicar em More e direcionar para a página do produto
        category.clickProductAddToProductPage();

        //verificar se o produto está na página de detalhes do produto
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));
    }

    @Test
    @Story("Adicionar produto ao carrinho")
    public void testAddProductToCartPage() {
        //acessa a página de produto
        testAddProductToProductPage();

        //iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //salvar o nome do produto na página de PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //clicar no botão de adicionar ao carrinho
        pdp.clickButtonAddToCart();

        //clicar no botão Proceed to Checkout da modal
        pdp.clickButtonModalProceedToCheckout();

        //validação do nome do produto na página do carrinho
        assertTrue(cart.getNameProductCart().equals(nameProductPDP));

    }

    //Desafio2 - Parte1 - Criar uma conta para novo usuário no site automationpractice
    @Test
    @Story("Cadastrar uma nova conta de usuário")
    public void creatNewUserAccount() {
        //Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        CreateAnAccountPage creatAccount = new CreateAnAccountPage();
        MyAccountPage myAccountPage = new MyAccountPage();

        //Clicou no botão "Sign in"
        home.clickBtnLogin();

        //certificando de que está entrando na página de login
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        //Preencheu o campo de e-mail a ser cadastrado
        login.fillEmailCreate();

        //Clicou em "Creat an account"
        login.clickBtnSubmitCreate();

        //Validação da página "CREATE AN ACCOUNT"
        System.out.println(creatAccount.createAnAccountPageValidation());
        assertTrue(creatAccount.createAnAccountPageValidation().equals("CREATE AN ACCOUNT"));

        //Preencheu os campos "First name" e "Last name"
        creatAccount.fillFirstName();
        creatAccount.fillLastName();

        //Preencheu o campo "Password"
        creatAccount.fillAccountPasswd();

        //Preencheu "Date of Birth"
        creatAccount.clickDateOfBirth();

        //Preencheu "Adress"
        creatAccount.fillAddress1();

        //Preencheu "City"
        creatAccount.fillCity();

        //Preencheu "State"
        creatAccount.clickState();

        //Preencheu "Postal Code"
        creatAccount.fillPostCode();

        //Preencheu "Mobile phone"
        creatAccount.fillPhoneMobile();

        //Clicou em "Register"
        creatAccount.clickSubmitAccount();

        //Validação de que estou realmente na página "MY ACCOUNT" após cadastro realizado com sucesso
        System.out.println(myAccountPage.getMyAccountPageValidation());
        assertTrue(myAccountPage.getMyAccountPageValidation().equals("MY ACCOUNT"));
    }

    //Desafio2 - Parte2 - Comprar um produto desde a página HomePage, passando pelo login, até conclusão com sucesso
    @Test
    @Story("Comprar um produto - processo completo")
    public void buyAProduct() {
        //Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        WomenCategotyPage womenPage = new WomenCategotyPage();
        ShoppingCartPages cartPages = new ShoppingCartPages();
        ShoppingCartAddressPage addressValidationPage = new ShoppingCartAddressPage();
        ShoppingCartShippingPage shippingPage = new ShoppingCartShippingPage();
        ShoppingCartPaymentPage paymentPage = new ShoppingCartPaymentPage();

        //Clicou no botão "Sign in"
        home.clickBtnLogin();

        //certificando de que está entrando na página de login
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        //Preencheu e-mail e senha, e clicou em "Sign in"
        login.fillEmail();
        login.fillPasswd();
        login.clickBtnSubmitLogin();

        //Validação de que estou realmente na página "MY ACCOUNT"
        System.out.println("Validação da página MYACCOUNT: " + myAccountPage.getMyAccountPageValidation());
        assertTrue(myAccountPage.getMyAccountPageValidation().equals("MY ACCOUNT"));

        //Clicou no botão da categoria "WOMEN"
        myAccountPage.clickBtnWomenCategory();

        //Validação de que estou realmente na página "Women"
        System.out.println("Validação da página Women: " + womenPage.womenCategoryPageValidation());
        assertTrue(womenPage.womenCategoryPageValidation().equals("Women"));

        //Clicou no botão "Add to cart" do produto "Blouse"
        womenPage.clickBtnAddToCart();

        //Clicou no botão "Proceed to checkout"
        womenPage.clickButtonModalProceedToCheckout();

        //Validações na página "SHOPPING-CART SUMMARY"
        System.out.println("Validação da página 1 do carrinho: " + cartPages.getShoppingCartValidationText());
        assertTrue(cartPages.getShoppingCartValidationText().contains("SHOPPING-CART SUMMARY"));
            //Validação do nome do produto "Blouse"
        System.out.println("Nome do produto: " + cartPages.getProductNameValidation());
        assertEquals(cartPages.getProductNameValidation(), "Blouse");
            //Validação do preço total: $27.00 + $2.00 + $1.16 = $30.16
        System.out.println("Preço total: " + cartPages.getTotalPrice());
        assertEquals(cartPages.getTotalPrice(), "$30.16");
            //Validação do endereço
        System.out.println("Endereço: " + cartPages.getAddress());
        assertEquals(cartPages.getAddress(), "Street address, P.O. Box, Company name, etc.");
            //Validação da cidade, estado e código postal
        System.out.println("Cidade, estado e código postal: " + cartPages.getCityStateZipcode());
        assertEquals(cartPages.getCityStateZipcode(), "Itajuba, Alabama 12345");
            //Validação do número de telefone
        System.out.println("Número de telefone: " + cartPages.getPhoneMobile());
        assertEquals(cartPages.getPhoneMobile(), "123456");

        //Clicou no botão "Proceed to checkout" na página "SHOPPING-CART SUMMARY"
        cartPages.clickBtnProceedToCheckout();

        //Validação de que estou realmente na página "Address" (etapa 03) do carrinho de compras
        System.out.println("Validação da página Address: " + addressValidationPage.shoppingCartAddressPageValidation());
        assertEquals(addressValidationPage.shoppingCartAddressPageValidation(), "ADDRESSES");

        //Validações do Billing Address
        System.out.println(Arrays.toString(addressValidationPage.shoppingCartAddressPageBillingInformations()));
        assertEquals(addressValidationPage.shoppingCartAddressPageBillingInformations()[0], "lg cc");
        assertEquals(addressValidationPage.
                shoppingCartAddressPageBillingInformations()[1], "Street address, P.O. Box, Company name, etc.");
        assertEquals(addressValidationPage.
                shoppingCartAddressPageBillingInformations()[2], "Itajuba, Alabama 12345");
        assertEquals(addressValidationPage.shoppingCartAddressPageBillingInformations()[3], "123456");

        //Clicou no botão "Proceed to checkout" na página "ADDRESSES" do carrinho de compras
        addressValidationPage.clickBtnProceedToCheckOutAddressesPage();

        //Validação de que estou realmente na página "Shipping" (etapa 04) do carrinho de compras
        System.out.println("Validação da página Shipping: " + shippingPage.shoppingCartShippingPageValidation());
        assertEquals(shippingPage.shoppingCartShippingPageValidation(), "SHIPPING");

        //Clicou no aceite do "Terms of service"
        shippingPage.clickAgree();

        //Clicou no botão "Proceed to checkout" na página "SHIPPING" do carrinho de compras
        shippingPage.clickBtnProceedToCheckOutShippingPage();

        //Validação de que estou realmente na página "Payment" (etapa 05) do carrinho de compras
        System.out.println("Validação da página Payment: " + paymentPage.shoppingCartPaymentPageValidation());
        assertEquals(paymentPage.shoppingCartPaymentPageValidation(), "PLEASE CHOOSE YOUR PAYMENT METHOD");

        //Validação de que o preço total está correto: $30.16
        System.out.println("Preço total na Payment Page: " + paymentPage.totalPriceValidation());
        assertEquals(paymentPage.totalPriceValidation(), "$30.16");

        //Clicou no botão "Pay by bank wire" na pégina "Payment"
        paymentPage.clickBtnPayByBankWire();

        //Clicou no botão "I confirm my order" na página "Payment"
        paymentPage.clickBtnIConfirmMyOrder();

        //Validação de que fui redirecionado para a página de confirmação da compra: "ORDER CONFIRMATION"
        System.out.println("Validação da página Order Confirmation: " + paymentPage.orderConfirmationValidation());
        assertEquals(paymentPage.orderConfirmationValidation(), "ORDER CONFIRMATION");

        //validação do valor total ("Amount") na página "ORDER CONFIRMATION"
        System.out.println("Montante total na página Order Confirmation: "
                + paymentPage.amountInOrderConfirmationPageValidation());
        assertEquals(paymentPage.amountInOrderConfirmationPageValidation(), "$30.16");

    }

}

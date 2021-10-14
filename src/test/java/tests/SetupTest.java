package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

public class SetupTest extends BaseTests{

    @Test
    public void testOpeningBrowserAndLoadingPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
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

}

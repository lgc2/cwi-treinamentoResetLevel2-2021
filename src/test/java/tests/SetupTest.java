package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.CategoryPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
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

}

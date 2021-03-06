package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElementMapper {

    //botão de Sign in
    @FindBy(className = "login")
    public WebElement login;

    //campo de pesquisa
    //@FindBy(id = "search_query_top")
    public WebElement search_query_top;

    //botão de buscar
    //@FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    @FindBy(css = "button.btn.btn-default.button-search")
    public WebElement submit_search;

    //botão da categoria T-Shirts
    @FindBy(css = "#block_top_menu .sf-menu li:nth-child(3) a[title=T-shirts]")
    public WebElement menuTshirts;

}

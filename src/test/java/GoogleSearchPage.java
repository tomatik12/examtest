import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends GoogleBasePage {

    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']")
    private  WebElement searchButton;

    public GoogleSearchPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver,this);
        assertElementIsVisable(searchButton,10,"Google search page is not loaded");
    }

    public GoogleResultPage googleSearch(String statement) {
        searchField.sendKeys(statement);
        searchButton.click();

        return new GoogleResultPage(driver);
    }

}
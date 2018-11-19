import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultPage extends GoogleBasePage {

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultStats;

    @FindBy(xpath = "//div[@class='srg']//div[@class='g']")
    private List<WebElement> foundResults;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondPage;

    public GoogleResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        assertElementIsVisable(resultStats,10,"Result page is not loaded");
    }

    public int getSearchResultsAmount() {
        return foundResults.size();
    }

    public List<String> getResultsTextList(){
        List<String > resultsTextList = new ArrayList<String>();
        for(WebElement foundResult: foundResults){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",foundResult);
            resultsTextList.add(foundResult.getText());
        }
        return resultsTextList;
    }

    public GoogleResultPage goNextPage(){
        secondPage.click();
        return new GoogleResultPage(driver);
    }
}
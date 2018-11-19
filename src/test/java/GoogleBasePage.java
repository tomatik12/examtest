import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Google Base Page object class.
 */
public class GoogleBasePage {

    protected WebDriver webDriver;

    /**
     * Explicit wait till WebElement visibility becomes true
     *
     * @param element - WebElement expected on the Page
     * @param timeOutInSec - int time for waiting in seconds
     * @return WebElement
     */
    protected WebElement waitUntilElementVisable(WebElement element, int timeOutInSec){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void assertElementIsVisable(WebElement webElement, int timeOutInSec, String message){
        try {
            waitUntilElementVisable(webElement, timeOutInSec);
        }catch (TimeoutException e){
            throw new AssertionError(message);
        }
    }
}
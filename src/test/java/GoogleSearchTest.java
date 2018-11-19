import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {



    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"Selenium",10}
        };
    }
    @Test(dataProvider = "validDataProvider")
    public void googleSearchTest(String statement, int resultsAmount){
        googleResultPage = googleSearchPage.googleSearch(statement);
        Assert.assertEquals(googleResultPage.getSearchResultsAmount(),resultsAmount, "Wrong total amount of results");

        List<String> resultsTextList = googleResultPage.getResultsTextList();
        for(String resultsText: resultsTextList){
            try {
                Assert.assertTrue(resultsText.toLowerCase().contains(statement.toLowerCase()),"Search statement:" + " " + statement + " is not found: \n" + resultsText);
            }catch (AssertionError e){
                e.printStackTrace();
            }

        }

        googleResultPage = googleResultPage.goNextPage();

        Assert.assertEquals(googleResultPage.getSearchResultsAmount(),resultsAmount, "Wrong total amount of results");
        resultsTextList = googleResultPage.getResultsTextList();
        for(String resultsText: resultsTextList){
            try {
                Assert.assertTrue(resultsText.toLowerCase().contains(statement.toLowerCase()),"Search statement:" + " " + statement + " is not found: \n" + resultsText);
            }catch (AssertionError e){
                e.printStackTrace();
            }

        }
    }
}

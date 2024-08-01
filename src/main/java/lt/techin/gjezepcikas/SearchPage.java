package lt.techin.gjezepcikas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(css = "input[name='s']")
    private WebElement searchField;

    @FindBy(css = "h2 > a")
    private WebElement getItemName;


    public SearchPage(WebDriver driver) {
        super(driver);
    }


    void SearchField(String itemName) {
        searchField.click();
        searchField.sendKeys(itemName);
        searchField.sendKeys(Keys.ENTER);
    }


    String getItemName() {

        return getItemName.getText();
    }


}

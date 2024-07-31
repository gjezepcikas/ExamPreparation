package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement clickSignInButton;

    @FindBy(xpath = "//div[@id='content']//a[@href='http://192.168.68.112/registration']")
    private WebElement clickCreateAccountButton;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn() {
        clickSignInButton.click();
    }

    public void clickCreateAccount() {
        clickCreateAccountButton.click();
    }

}

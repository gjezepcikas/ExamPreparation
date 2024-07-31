package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "/html//input[@id='field-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "/html//input[@id='field-password']")
    private WebElement inputPassword;

    @FindBy(css = "button#submit-login")
    private WebElement submitLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void emailInput(String email) {
        inputEmail.click();
        inputEmail.sendKeys(email);
    }

    public void passwordInput(String password) {
        inputPassword.click();
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        submitLogin.click();
    }

}

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

    @FindBy(linkText = "Sign out")
    private WebElement loggedIn;

    @FindBy(linkText = "Sign in")
    private WebElement loggedOut;

    @FindBy(xpath = "//div[@id='_desktop_user_info']//a[@href='http://192.168.68.112/?mylogout=']")
    private WebElement logOutButton;

    @FindBy(css = "[title] .hidden-sm-down")
    private WebElement myUserName;

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
    String loggedIn() {
        return loggedIn.getText();
    }
    String loggedout() {
        return loggedOut.getText();
    }

    void logOut() {
        logOutButton.click();
    }

    String myUserName() {
        return myUserName.getText();
    }



}

package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement clickSignInButton;

    @FindBy(xpath = "//div[@id='content']//a[@href='http://192.168.68.112/registration']")
    private WebElement clickCreateAccountButton;

    @FindBy(css = "label:nth-of-type(1)  input[name='id_gender']")
    private WebElement clickSocialTitle;

    @FindBy(xpath = "/html//input[@id='field-firstname']")
    private WebElement inputFirstName;

    @FindBy(css = "[name='lastname']")
    private WebElement inputLastName;

    @FindBy(css = "input#field-email")
    private WebElement inputEmail;

    @FindBy(css = "input#field-password")
    private WebElement inputPassword;

    @FindBy(css = "input#field-birthday")
    private WebElement inputBirthDate;
    @FindBy(css = "input[name='psgdpr']")
    private WebElement clickCheckBoxAgreeTerms;

    @FindBy(css = "input[name='customer_privacy']")
    private WebElement clickCheckBoxPrivacy;

    @FindBy(xpath = "//form[@id='customer-form']//button[@type='submit']")
    private WebElement clickSaveButton;



    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn() {
        clickSignInButton.click();
    }

    void clickCreateAccount() {
        clickCreateAccountButton.click();
    }

    void socialTitle() {
        clickSocialTitle.click();
    }

    void inputFirstName(String FirstName) {
        inputFirstName.sendKeys(FirstName);
    }

    void inputLastName(String LastName) {
        inputLastName.sendKeys(LastName);
    }

    void inputEmail(String Email) {
        inputEmail.sendKeys(Email);
    }

    void inputPassword(String Password) {
        inputPassword.sendKeys(Password);
    }

    void inputBirthDate(String BirthDate) {
        inputBirthDate.sendKeys(BirthDate);
    }

    void clickCheckBoxAgreeTerms() {
        clickCheckBoxAgreeTerms.click();
    }

    void clickCheckBoxPrivacy() {
        clickCheckBoxPrivacy.click();
    }

    void clickSaveButton() {
        clickSaveButton.click();
    }


}

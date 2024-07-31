package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest{

    @Test
    void clickOnSignInAndClickCreateAccountTest() {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();

        assertEquals("Login", registrationPage.getTitle());

        registrationPage.clickCreateAccount();
        assertEquals("Registration",registrationPage.getTitle());

    }

    @Test
    void createAccountTest() {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        registrationPage.clickCreateAccount();

        registrationPage.socialTitle();






    }


}

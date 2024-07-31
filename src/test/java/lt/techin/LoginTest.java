package lt.techin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithStoredCredentialsAndLogoutTest() {
        String email = ConfigUtility.getProperty("email");
        String password = ConfigUtility.getProperty("password");
        String firstName = ConfigUtility.getProperty("firstName");
        String lastName = ConfigUtility.getProperty("lastName");

        // Ensure values are not null
        assertNotNull(email, "Email is null");
        assertNotNull(password, "Password is null");
        assertNotNull(firstName, "First name is null");
        assertNotNull(lastName, "Last name is null");


        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        assertEquals("Sign out", loginPage.loggedIn());
        assertEquals("PrestaShop", registrationPage.getTitle());

        String expectedName = firstName + " " + lastName;
        assertEquals(expectedName, loginPage.myUserName(), "Name does not match");




        loginPage.logOut();


        assertEquals("Sign in", loginPage.loggedout());

    }
}
package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentialsTest() {
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
        assertEquals("PrestaShop", registrationPage.getTitle(), "Login page title mismatch");
        assertEquals(firstName + " " + lastName, loginPage.myUserName(), "Name does not match");

        loginPage.logOut();

        assertEquals("Sign in", loginPage.loggedout());

    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_email_values.csv", numLinesToSkip = 1)
    void loginWithInvalidEmail(String email) {

        String password = ConfigUtility.getProperty("password");

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        // Verify user is not logged in
        assertEquals("Login", loginPage.getTitle(), "Login page title mismatch");
        assertEquals("http://192.168.68.112/login?back=http%3A%2F%2F192.168.68.112%2F", driver.getCurrentUrl(), "Current URL does not match expected URL");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid password.csv", numLinesToSkip = 1)
    void loginWithInvalidPassword(String password) {

        String email = ConfigUtility.getProperty("email");

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        // Verify user is not logged in
        assertEquals("Login", loginPage.getTitle(), "Login page title mismatch");
        assertEquals("http://192.168.68.112/login?back=http%3A%2F%2F192.168.68.112%2F", driver.getCurrentUrl(), "Current URL does not match expected URL");
    }

}
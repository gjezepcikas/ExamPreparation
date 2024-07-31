import lt.techin.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithStoredEmailAndPasswordTest() {
        String email = ConfigUtility.getProperty("email");
        String password = ConfigUtility.getProperty("password");


        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        assertEquals("PrestaShop", registrationPage.getTitle());

    }
}
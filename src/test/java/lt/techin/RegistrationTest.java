package lt.techin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class RegistrationTest extends BaseTest {




    @Test
    void clickOnSignInAndClickCreateAccountTest() {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();

        assertEquals("Login", registrationPage.getTitle());

        registrationPage.clickCreateAccount();
        assertEquals("Registration", registrationPage.getTitle());
    }

    @Test
    void createAccountTest() {

        String firstName = RandomDataGenerator.getRandomFirstName();
        String lastName = RandomDataGenerator.getRandomLastName();
        String email = RandomDataGenerator.getRandomEmail(firstName, lastName);
        String password = RandomDataGenerator.getRandomPassword();
        String birthDate = RandomDataGenerator.getRandomBirthDate();

        // Store the email and password in the properties file
        ConfigUtility.setProperty("firstName", firstName);
        ConfigUtility.setProperty("lastName", lastName);
        ConfigUtility.setProperty("email", email);
        ConfigUtility.setProperty("password", password);

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSignIn();
        registrationPage.clickCreateAccount();
        registrationPage.socialTitle();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputBirthDate(birthDate);
        registrationPage.clickCheckBoxPrivacy();
        registrationPage.clickCheckBoxAgreeTerms();
        registrationPage.clickSaveButton();

        // Assertions
        String expectedUrl = "http://192.168.68.112/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        assertEquals("PrestaShop", registrationPage.getTitle());


    }
}

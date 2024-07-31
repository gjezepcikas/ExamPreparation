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
        String generatedEmail = RandomDataGenerator.getRandomEmail(firstName, lastName);
        String generatedPassword = RandomDataGenerator.getRandomPassword();
        String birthDate = RandomDataGenerator.getRandomBirthDate();

        // Store the email and password in the properties file
        ConfigUtility.setProperty("email", generatedEmail);
        ConfigUtility.setProperty("password", generatedPassword);

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSignIn();
        registrationPage.clickCreateAccount();

        registrationPage.socialTitle();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(generatedEmail);
        registrationPage.inputPassword(generatedPassword);
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

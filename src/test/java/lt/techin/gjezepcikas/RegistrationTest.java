package lt.techin.gjezepcikas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RegistrationTest extends BaseTest {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;

    @BeforeEach
    void startUp() {

        firstName = RandomDataGenerator.getRandomFirstName();
        lastName = RandomDataGenerator.getRandomLastName();
        email = RandomDataGenerator.getRandomEmail(firstName, lastName);
        password = RandomDataGenerator.getRandomPassword();
        birthDate = RandomDataGenerator.getRandomBirthDate();

        // Store the email and password in the properties file
        ConfigUtility.setProperty("firstName", firstName);
        ConfigUtility.setProperty("lastName", lastName);
        ConfigUtility.setProperty("email", email);
        ConfigUtility.setProperty("password", password);
    }


    @Test
    void clickOnSignInAndAccountTest() {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();

        assertEquals("Login", registrationPage.getTitle(), "Sign-in page title mismatch");

        registrationPage.clickCreateAccount();
        assertEquals("Registration", registrationPage.getTitle(), "Registration page title mismatch");
    }

    @Test
    void createAccountTest() {

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
        assertEquals(expectedUrl, actualUrl, "Current URL does not match expected URL");
        assertEquals("PrestaShop", registrationPage.getTitle(), "Page title does not match 'PrestaShop'");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_first_name_values.csv", numLinesToSkip = 1)
    void registerWithInvalidFirstName(String firstName) {

        LoginPage loginPage = new LoginPage(driver);

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

        // Verify user is not logged in
        assertNotEquals(firstName + " " + RandomDataGenerator.getRandomLastName(), loginPage.myUserName(), "Name matches when it shouldn't");
        assertEquals("http://192.168.68.112/registration", driver.getCurrentUrl(), "Current URL does not match expected URL");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_last_name_values.csv", numLinesToSkip = 1)
    void registerWithInvalidLastName(String lastName) {
        LoginPage loginPage = new LoginPage(driver);

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

        // Verify user is not logged in
        assertNotEquals(RandomDataGenerator.getRandomFirstName() + " " + lastName, loginPage.myUserName(), "Name matches when it shouldn't");
        assertEquals("http://192.168.68.112/registration", driver.getCurrentUrl(), "Current URL does not match expected URL");
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid password.csv", numLinesToSkip = 1)
    void registerUsingBadPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);

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

        // Verify user is not logged in
        assertNotEquals(RandomDataGenerator.getRandomFirstName() + " " + RandomDataGenerator.getRandomLastName(), loginPage.myUserName(), "Name matches when it shouldn't");
        assertEquals("http://192.168.68.112/registration", driver.getCurrentUrl(), "Current URL does not match expected URL");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_email_values.csv", numLinesToSkip = 1)
    void registerWithInvalidEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);

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

        // Verify user is not logged in
        assertNotEquals(RandomDataGenerator.getRandomFirstName() + " " + RandomDataGenerator.getRandomLastName(), loginPage.myUserName(), "Name matches when it shouldn't");
        assertEquals("http://192.168.68.112/registration", driver.getCurrentUrl(), "Current URL does not match expected URL");
    }


}

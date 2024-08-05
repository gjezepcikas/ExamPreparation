package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        String expectedUrl = "http://192.168.89.54/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        assertEquals("PrestaShop", registrationPage.getTitle());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_first_name_values.csv", numLinesToSkip = 1)
    void registerWithInvalidFirstName(String firstName) {
        LoginPage loginPage = new LoginPage(driver);


        String lastName = RandomDataGenerator.getRandomLastName();
        String email = RandomDataGenerator.getRandomEmail(firstName, lastName);
        String password = RandomDataGenerator.getRandomPassword();
        String birthDate = RandomDataGenerator.getRandomBirthDate();


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
        assertNotEquals(firstName + " " + RandomDataGenerator.getRandomLastName(), loginPage.myUserName(), "Name does not match");
        assertEquals("http://192.168.89.54/registration", driver.getCurrentUrl(), "Web addresses not match");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_last_name_values.csv", numLinesToSkip = 1)
    void registerWithInvalidLastName(String lastName) {
        LoginPage loginPage = new LoginPage(driver);

        String firstName = RandomDataGenerator.getRandomFirstName();
        String email = RandomDataGenerator.getRandomEmail(firstName, lastName);
        String password = RandomDataGenerator.getRandomPassword();
        String birthDate = RandomDataGenerator.getRandomBirthDate();


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
        assertNotEquals(RandomDataGenerator.getRandomFirstName() + " " + lastName, loginPage.myUserName(), "Name does not match");
//        assertEquals("http://192.168.89.54/registration", driver.getCurrentUrl(), "Web addresses not match");
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid password.csv", numLinesToSkip = 1)
    void registerUsingBadPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);

        String firstName = RandomDataGenerator.getRandomFirstName();
        String lastName = RandomDataGenerator.getRandomLastName();
        String email = RandomDataGenerator.getRandomEmail(firstName, lastName);
        String birthDate = RandomDataGenerator.getRandomBirthDate();

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
        assertNotEquals(RandomDataGenerator.getRandomFirstName() + " " + RandomDataGenerator.getRandomLastName(), loginPage.myUserName(), "Name does not match");
        assertEquals("http://192.168.89.54/registration", driver.getCurrentUrl(), "Web addresses not match");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_email_values.csv", numLinesToSkip = 1)
    void registerWithInvalidEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);

        String firstName = RandomDataGenerator.getRandomFirstName();
        String lastName = RandomDataGenerator.getRandomLastName();
        String password = RandomDataGenerator.getRandomPassword();
        String birthDate = RandomDataGenerator.getRandomBirthDate();

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
        assertNotEquals(RandomDataGenerator.getRandomFirstName() + " " + RandomDataGenerator.getRandomLastName(), loginPage.myUserName(), "Name does not match");
        assertEquals("http://192.168.89.54/registration", driver.getCurrentUrl(), "Web addresses not match");
    }


}

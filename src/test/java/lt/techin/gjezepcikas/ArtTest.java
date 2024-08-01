package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArtTest extends BaseTest {

    @Test
    public void artPageAndAvailabilityTest() {

        //Login
        String email = ConfigUtility.getProperty("email");
        String password = ConfigUtility.getProperty("password");
        String firstName = ConfigUtility.getProperty("firstName");
        String lastName = ConfigUtility.getProperty("lastName");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        assertEquals("Sign out", loginPage.loggedIn());
        assertEquals("PrestaShop", registrationPage.getTitle());
        assertEquals(firstName + " " + lastName, loginPage.myUserName(), "Name does not match");

        //Art Page Availability
        ArtPage artPage = new ArtPage(driver);
        artPage.clickArtPageButton();
        artPage.clickInStockButton();
        assertEquals("Art",registrationPage.getTitle(),"Title not match");
        assertEquals(artPage.artInStock(), artPage.stockCount(), "Different stocks");

        artPage.closeSelection();
    }



    @Test
    public void selectionTest() {

        //Login
        String email = ConfigUtility.getProperty("email");
        String password = ConfigUtility.getProperty("password");
        String firstName = ConfigUtility.getProperty("firstName");
        String lastName = ConfigUtility.getProperty("lastName");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        assertEquals("Sign out", loginPage.loggedIn());
        assertEquals("PrestaShop", registrationPage.getTitle());
        assertEquals(firstName + " " + lastName, loginPage.myUserName(), "Name does not match");

        //Art Page Selection
        ArtPage artPage = new ArtPage(driver);
        artPage.clickArtPageButton();
        artPage.clickNewProduct();
        assertEquals("Art",registrationPage.getTitle(),"Title not match");
        assertEquals(artPage.selectionsNewProductCount(), artPage.stockCount(), "Different stocks");

        artPage.closeSelection();
    }

    @Test
    void testSetSliderPrice() {

        //Login
        String email = ConfigUtility.getProperty("email");
        String password = ConfigUtility.getProperty("password");
        String firstName = ConfigUtility.getProperty("firstName");
        String lastName = ConfigUtility.getProperty("lastName");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        assertEquals("Sign out", loginPage.loggedIn());
        assertEquals("PrestaShop", registrationPage.getTitle());
        assertEquals(firstName + " " + lastName, loginPage.myUserName(), "Name does not match");


        ArtPage artPage = new ArtPage(driver);
        artPage.clickArtPageButton();
        int desiredPrice = 15;
        int minPrice = 9; // Replace with the actual minimum price value of the slider
        int maxPrice = 35; // Replace with the actual maximum price value of the slider

        artPage.setSliderPrice(desiredPrice, minPrice, maxPrice);
        artPage.closeSelection();

        // Add assertions to verify that the price has been set correctly
        //laikinai nera

    }

    @Test
    void compositionSelectionTest() {

        //Login
        String email = ConfigUtility.getProperty("email");
        String password = ConfigUtility.getProperty("password");
        String firstName = ConfigUtility.getProperty("firstName");
        String lastName = ConfigUtility.getProperty("lastName");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        assertEquals("Sign out", loginPage.loggedIn());
        assertEquals("PrestaShop", registrationPage.getTitle());
        assertEquals(firstName + " " + lastName, loginPage.myUserName(), "Name does not match");

        ArtPage artPage = new ArtPage(driver);
        artPage.clickArtPageButton();
        artPage.clickCompositionCheckBox();

        assertEquals("Art",registrationPage.getTitle(),"Title not match");
        assertEquals(artPage.stockCount(),artPage.currentMattPaper(), "Different stocks");
        artPage.closeSelection();
    }


    @Test
    void brandSelectionTest() {

        //Login
        String email = ConfigUtility.getProperty("email");
        String password = ConfigUtility.getProperty("password");
        String firstName = ConfigUtility.getProperty("firstName");
        String lastName = ConfigUtility.getProperty("lastName");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        assertEquals("Sign out", loginPage.loggedIn());
        assertEquals("PrestaShop", registrationPage.getTitle());
        assertEquals(firstName + " " + lastName, loginPage.myUserName(), "Name does not match");

        ArtPage artPage = new ArtPage(driver);
        artPage.clickArtPageButton();
        artPage.clickBrandSelection();

        assertEquals("Art",registrationPage.getTitle(),"Title not match");
        assertEquals(artPage.stockCount(),artPage.currentMattPaper(), "Different stocks");
        artPage.closeSelection();
    }

    @Test
    void dimensionSelectionTest() {
        // Login
        String email = ConfigUtility.getProperty("email");
        String password = ConfigUtility.getProperty("password");
        String firstName = ConfigUtility.getProperty("firstName");
        String lastName = ConfigUtility.getProperty("lastName");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        loginPage.clickLoginButton();

        assertEquals("Sign out", loginPage.loggedIn());
        assertEquals("PrestaShop", registrationPage.getTitle());
        assertEquals(firstName + " " + lastName, loginPage.myUserName(), "Name does not match");

        ArtPage artPage = new ArtPage(driver);
        artPage.clickArtPageButton();
        artPage.clickDimensionFirstSelection();

        assertEquals("Art", registrationPage.getTitle(), "Title not match");
        assertEquals(artPage.stockCount(), artPage.currentMattPaper(), "Different stocks");
        artPage.closeSelection();

//        artPage.clickDimensionSecondSelection();
//        assertEquals("Art", registrationPage.getTitle(), "Title not match");
//        assertEquals(artPage.stockCount(), artPage.currentMattPaper(), "Different stocks");
//        artPage.closeSelection();
//
//        artPage.clickDimensionThirdSelection();
//        assertEquals("Art", registrationPage.getTitle(), "Title not match");
//        assertEquals(artPage.stockCount(), artPage.currentMattPaper(), "Different stocks");
//        artPage.closeSelection();
    }

}
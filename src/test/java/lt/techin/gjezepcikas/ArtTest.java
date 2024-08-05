package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class ArtTest extends BaseTest {

    private void retryClick(Runnable clickAction) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                clickAction.run();
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
                WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".btn-unstyle.select-title")))));
            }
        }
        throw new RuntimeException("Failed to click element after several attempts");
    }

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
    void dimensionSelectionTest() throws InterruptedException {
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


        Thread.sleep(1000);

        artPage.clickDimensionSecondSelection();
        assertEquals("Art", registrationPage.getTitle(), "Title not match");
        assertEquals(artPage.stockCount(), artPage.currentMattPaper(), "Different stocks");
        artPage.closeSelection();

        Thread.sleep(1000);

        artPage.clickDimensionThirdSelection();
        assertEquals("Art", registrationPage.getTitle(), "Title not match");
        assertEquals(artPage.stockCount(), artPage.currentMattPaper(), "Different stocks");
        artPage.closeSelection();
    }

    @Test
    void sortBySalesTest() {
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

        assertEquals("Art", registrationPage.getTitle(), "Title not match");

        // Sort by Sales, Highest To Lowest
        ArtPage artSortByPage = new ArtPage(driver);
        retryClick(artSortByPage::clickSortByButton);
        retryClick(artSortByPage::clickSalesHighestToLowest);

        //Assertions nesugalvoju...
    }

    @Test
    void sortByNameAzTest() {
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

        assertEquals("Art", registrationPage.getTitle(), "Title not match");




        // Sort by Sales, Name A-Z
        ArtPage artSortByPage = new ArtPage(driver);
        retryClick(artSortByPage::clickSortByButton);
        retryClick(artSortByPage::clickSortByNameAz);



        //Assertions nesugalvoju...
    }

    @Test
    void sortByNameZaTest() {
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

        assertEquals("Art", registrationPage.getTitle(), "Title not match");




        // Sort by Sales, Name Z-A
        ArtPage artSortByPage = new ArtPage(driver);
        retryClick(artSortByPage::clickSortByButton);
        retryClick(artSortByPage::clickSortByNameZa);



        //Assertions nesugalvoju...
    }

    @Test
    void sortByPriceLowToHighTest() {
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

        assertEquals("Art", registrationPage.getTitle(), "Title not match");




        // Sort by Price, Low to High
        ArtPage artSortByPage = new ArtPage(driver);
        retryClick(artSortByPage::clickSortByButton);
        retryClick(artSortByPage::clickSortByPriceLowToHigh);

        //Assertions nesugalvoju...
    }


    @Test
    void sortByPriceHighToLowTest() {
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

        assertEquals("Art", registrationPage.getTitle(), "Title not match");




        // Sort by Price, High to Low
        ArtPage artSortByPage = new ArtPage(driver);
        retryClick(artSortByPage::clickSortByButton);
        retryClick(artSortByPage::clickSortByPriceHighToLow);

        //Assertions nesugalvoju...
    }


    @Test
    void sortByReferenceAtoZTest() {
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

        assertEquals("Art", registrationPage.getTitle(), "Title not match");




        // Sort by Reference, A to Z
        ArtPage artSortByPage = new ArtPage(driver);
        retryClick(artSortByPage::clickSortByButton);
        retryClick(artSortByPage::clickSortByReferenceAtoZ);

        //Assertions nesugalvoju...
    }

    @Test
    void sortByReferenceZtoATest() {
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

        assertEquals("Art", registrationPage.getTitle(), "Title not match");




        // Sort by Reference, ZtoA
        ArtPage artSortByPage = new ArtPage(driver);
        retryClick(artSortByPage::clickSortByButton);
        retryClick(artSortByPage::clickSortByReferenceZtoA);

        //Assertions nesugalvoju...
    }

}
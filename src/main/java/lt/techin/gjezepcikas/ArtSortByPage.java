package lt.techin.gjezepcikas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArtSortByPage  extends BasePage{

    @FindBy(css = ".btn-unstyle.select-title")
    private WebElement sortByButton;

    @FindBy(css = ".dropdown-menu > a:nth-of-type(1)")
    private WebElement salesHighestToLowest;

    @FindBy(linkText = "Name, A to Z")
    private WebElement sortByNameAz;

    @FindBy(linkText = "Name, Z to A")
    private WebElement sortByNameZa;

    @FindBy(css = ".dropdown-menu .js-search-link:nth-of-type(5)")
    private WebElement sortByPriceLowToHigh;

    @FindBy(css = ".dropdown-menu .js-search-link:nth-of-type(6)")
    private WebElement sortByPriceHighToLow;

    @FindBy(css = ".dropdown-menu .js-search-link:nth-of-type(7)")
    private WebElement sortByReferenceAtoZ;

    @FindBy(css = ".dropdown-menu .js-search-link:nth-of-type(8)")
    private WebElement sortByReferenceZtoA;



    public ArtSortByPage(WebDriver driver) {
        super(driver);
    }








    void clickSortByButton() {
        sortByButton.click();
    }
    void clickSalesHighestToLowest() {
        salesHighestToLowest.click();
    }

    void clickSortByNameAz() {
        sortByNameAz.click();
    }

    void clickSortByNameZa() {
        sortByNameZa.click();
    }

    void clickSortByPriceLowToHigh() {
        sortByPriceLowToHigh.click();
    }

    void clickSortByPriceHighToLow() {
        sortByPriceHighToLow.click();
    }

    void clickSortByReferenceAtoZ() {
        sortByReferenceAtoZ.click();
    }

    void clickSortByReferenceZtoA() {
        sortByReferenceZtoA.click();
    }
}

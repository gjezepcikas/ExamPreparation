package lt.techin.gjezepcikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class ArtPage extends BasePage {


    //Filter By

    @FindBy(css = "li:nth-of-type(3) > .dropdown-item")
    private WebElement clickArtPage;

    @FindBy(css = "section:nth-of-type(1) > .collapse .custom-checkbox")
    private WebElement clickInStock;

    @FindBy(css = "section:nth-of-type(1) > .collapse .magnitude")
    private WebElement artInStock;

    @FindBy(css = "div#js-product-list-top  p")
    private WebElement stockCount;

    @FindBy(css = ".js-search-filters-clear-all")
    private WebElement closeSelection;

    @FindBy(css = "section:nth-of-type(2) > .collapse .custom-checkbox")
    private WebElement newProduct;

    @FindBy(css = "section:nth-of-type(2) > .collapse .magnitude")
    private WebElement selectionsNewProductCount;

    @FindBy(css = ".ui-corner-all.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content > .ui-corner-all.ui-slider-range.ui-widget-header")
    private WebElement sliderPrice;

    @FindBy(css = ".ui-corner-all.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content > a:nth-of-type(1)")
    private WebElement sliderHandle;

    @FindBy(css = ".filter-block")
    private WebElement sliderValueDisplay;


    @FindBy(css = "section:nth-of-type(4) > .collapse .custom-checkbox")
    private WebElement compositionCheckBox;

    @FindBy(css = "section:nth-of-type(4) > .collapse .magnitude")
    private WebElement currentMattPaper;

    @FindBy(css = "section:nth-of-type(5) > .collapse .custom-checkbox")
    private WebElement brandSelection;

    @FindBy(css = "section:nth-of-type(6) > .collapse > li:nth-of-type(1) > .facet-label > .custom-checkbox")
    private WebElement dimensionFirstSelection;

    @FindBy(css = "li:nth-of-type(2) > .facet-label > .custom-checkbox")
    private WebElement dimensionSecondSelection;

    @FindBy(css = "li:nth-of-type(3) > .facet-label > .custom-checkbox")
    private WebElement dimensionThirdSelection;

    //Sort by

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


    public ArtPage(WebDriver driver) {
        super(driver);
    }

    //Slider Calculation
    public void setSliderPrice(int desiredPrice, int minPrice, int maxPrice) {
        int sliderWidth = sliderPrice.getSize().width;

        // Calculate the offset to move the slider
        int xOffset = (desiredPrice - minPrice) * sliderWidth / (maxPrice - minPrice);

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderHandle, xOffset, 0).perform();
    }
        // Compares prices in Slider assertion
    public List<Double> getDisplayedItemPrices() {
        List<WebElement> priceElements = driver.findElements(By.cssSelector(".price-class-selector")); // Replace with the actual selector
        List<Double> prices = new ArrayList<>();
        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("$", "").trim();
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }


    // Filter By

    void clickArtPageButton() {
        clickArtPage.click();
    }

    void clickInStockButton() {
        clickInStock.click();
    }

    public int stockCount() {
        return Integer.parseInt(stockCount.getText().replaceAll("\\D+", ""));
    }

    public int artInStock() {
        return Integer.parseInt(artInStock.getText().replaceAll("\\D+", ""));
    }

    public void closeSelection() {
        closeSelection.click();
    }

    public void clickNewProduct() {
        newProduct.click();
    }

    public int selectionsNewProductCount() {
        return Integer.parseInt(selectionsNewProductCount.getText().replaceAll("\\D+", ""));
    }

    public void clickCompositionCheckBox() {
        compositionCheckBox.click();
    }

    public int currentMattPaper() {
        return Integer.parseInt(artInStock.getText().replaceAll("\\D+", ""));
    }

    public void clickBrandSelection() {
        brandSelection.click();
    }

    public void clickDimensionFirstSelection() {
        wait.until(ExpectedConditions.elementToBeClickable(dimensionFirstSelection)).click();
    }

    public void clickDimensionSecondSelection() {
        wait.until(ExpectedConditions.elementToBeClickable(dimensionSecondSelection)).click();
    }

    public void clickDimensionThirdSelection() {
        wait.until(ExpectedConditions.elementToBeClickable(dimensionThirdSelection)).click();
    }

    // Sort By

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
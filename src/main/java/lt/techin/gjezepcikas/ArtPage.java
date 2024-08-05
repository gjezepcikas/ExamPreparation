package lt.techin.gjezepcikas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ArtPage extends BasePage {

    @FindBy(xpath = "//ul[@id='top-menu']//a[@href='http://192.168.68.112/9-art']")
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

    void closeSelection() {
        closeSelection.click();
    }

    void clickNewProduct() {
        newProduct.click();
    }

    public int selectionsNewProductCount() {
        return Integer.parseInt(selectionsNewProductCount.getText().replaceAll("\\D+", ""));
    }

    void clickCompositionCheckBox() {
        compositionCheckBox.click();
    }

    public int currentMattPaper() {
        return Integer.parseInt(artInStock.getText().replaceAll("\\D+", ""));
    }

    void clickBrandSelection() {
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
}
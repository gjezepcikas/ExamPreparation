package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SearchTest extends BaseTest {

    @Test
    void positiveSearchCatalogTest() {

        String randomItems = RandomDataGenerator.getRandomItem();

        SearchPage searchPage = new SearchPage(driver);

        searchPage.SearchField(randomItems);
        assertEquals(randomItems.toUpperCase(), searchPage.getItemName().toUpperCase(),
                "The product name should match.");

    }
}

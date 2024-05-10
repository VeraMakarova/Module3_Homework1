package ru.inno.module3.pageObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.module3.pageObject.pages.CartPage;
import ru.inno.module3.pageObject.pages.LabirintFirstPage;
import ru.inno.module3.pageObject.pages.SearchResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageObjectLabirintTest {

    private WebDriver driver;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void buyBooks() {
        LabirintFirstPage firstPage = new LabirintFirstPage(driver);
        SearchResultPage searchPage = new SearchResultPage(driver);
        CartPage cartPage = new CartPage(driver);

        String textToBe = "В корзине 60 товаров";

        firstPage.openPage();

        firstPage.getHeader().searchBooks("Java");

        searchPage.addToCart();
        searchPage.openCart();

        String textAsIs = cartPage.getCartText();

        assertEquals(textToBe, textAsIs);
    }

}

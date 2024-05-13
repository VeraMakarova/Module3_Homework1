package ru.inno.module3.pageObject;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.module3.pageObject.pages.CartPage;
import ru.inno.module3.pageObject.pages.LabirintFirstPage;
import ru.inno.module3.pageObject.pages.SearchResultPage;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("Vera Makarova")
@DisplayName("Домашняя работа 3. Селениум, тесты Лабиринта с PageObject")
@Epic("Каталог")
@Feature("Поиск по сайту")
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
    @DisplayName("Поиск и добавление книг в корзину")
    @Description("Проверяем успешное добавление книг в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Как пользователь я могу искать товары на сайте")
    @TmsLink("INNO-1")
    @Issue("JIRA-123")
    public void buyBooksWithSteps() {
        LabirintFirstPage firstPage = new LabirintFirstPage(driver);
        SearchResultPage searchPage = new SearchResultPage(driver);
        CartPage cartPage = new CartPage(driver);

        String textToBe = "В корзине 60 товаров";

        step("Открыть главную страницу", () -> firstPage.openPage());
        step("Сделать поиск по слову Java", () -> firstPage.getHeader().searchBooks("Java"));
        step("Добавить в корзину все найденное", () -> searchPage.addToCart());
        step("Перейти на страницу Корзина", () -> searchPage.openCart());

        String textAsIs = cartPage.getCartText();

        //step("Проверить, что сообщении о содержимом корзины правильное"), ()->  assertEquals(textToBe, textAsIs);
        assertEquals(textToBe, textAsIs);
    }

    @Test
    @DisplayName("Поиск и добавление книг в корзину")
    @Description("Проверяем успешное добавление книг в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Как пользователь я могу искать товары на сайте")
    @TmsLink("INNO-1")
    @Issue("JIRA-123")
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

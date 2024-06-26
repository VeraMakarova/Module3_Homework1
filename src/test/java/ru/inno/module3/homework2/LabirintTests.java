package ru.inno.module3.homework2;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("Vera Makarova")
@DisplayName("Домашняя работа 2. Селениум, тесты Лабиринта")
@Epic("Каталог")
@Feature("Поиск по сайту")
public class LabirintTests {
    private WebDriver driver;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.labirint.ru/");
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Поиск и добавление книг в корзину 2")
    @Description("Проверяем успешное добавление книг в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Как пользователь я могу искать товары на сайте")
    @TmsLink("INNO-2")
    public void buyBooks() {
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.navigate().refresh();

        WebElement form = driver.findElement(By.cssSelector("#search-field"));
        form.sendKeys("Java");
        form.submit();

        List<WebElement> buttons = driver.findElements(By.cssSelector(".buy-link"));
        for (WebElement button : buttons) {
            button.click();
        }

        driver.findElement(By.cssSelector(".cart-icon-js")).click();

        String text1 = driver.findElement(By.cssSelector(".mb10 .vue-object")).getText();
        String text2 = driver.findElement(By.cssSelector("#basket-default-prod-count2")).getText();

        String text = text1 + " " + text2;
        String textToBe = "В корзине 60 товаров";
        assertEquals(textToBe, text);
    }

}

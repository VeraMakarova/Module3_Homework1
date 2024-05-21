package ru.inno.module3.selenide;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideLabirintTest {

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://www.labirint.ru";
    }

    @Test
    public void checkCookieMessage() {

        open("/");

        $(".cookie-policy").shouldHave(text("""
                Мы используем файлы cookie и другие средства сохранения предпочтений и анализа действий посетителей сайта. Подробнее в пользовательском соглашении. Нажмите «Принять», если даете согласие на это.
                Принять"""));

    }

    @Test
    public void selenideBuyBooks() {
        open("/");
        $("#search-field").setValue("java").pressEnter();

        ElementsCollection books = $$(".product-card");
        books.should(CollectionCondition.size(60));

        ElementsCollection buttons = $$(".buy-link");
        buttons.forEach(b -> b.pressEnter());

        $(".cart-icon-js").pressEnter();

        $(".mb10 .vue-object").shouldHave(text("В корзине"));
        $("#basket-default-prod-count2").shouldHave(text("60 товаров"));
    }

}

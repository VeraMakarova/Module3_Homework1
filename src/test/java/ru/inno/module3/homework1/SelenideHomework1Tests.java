package ru.inno.module3.homework1;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideHomework1Tests {

    @Test
    @DisplayName("Успешная авторизация")
    @Description("Проверяем успешную авторизацию с паролем pwd")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("INNO-3")
    public void auth() {
        open("http://uitestingplayground.com/sampleapp");
        $("[name=UserName]").setValue("inno");
        $("[name=Password]").setValue("pwd");
        $("#login").pressEnter();
        $(".text-success").shouldHave(text("Welcome, inno!"));

    }

    @Test
    @DisplayName("Изменение текста на кнопке")
    @Description("Проверяем появление на кнопке введенного текста")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("INNO-4")
    public void changeButtonName() {
        open("http://uitestingplayground.com/textinput");
        $("#newButtonName").setValue("Привет");
        $("#updatingButton").pressEnter();
        $("#updatingButton").shouldHave(text("Привет"));

    }

    @Test
    @DisplayName("Заполнение формы")
    @Description("Проверяем появление на кнопке введенного текста")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("INNO-5")
    public void fillForm() {
        open("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        $("[name = first-name]").setValue("Vera");
        $("[name = last-name]").setValue("Makarova");
        $("[name = address]").setValue("MyStreet 16, 42");
        $("[name = city]").setValue("Krasnogorsk");
        $("[name = country]").setValue("Russia");
        $("[name = job-position]").setValue("QA");
        $("[name = company]").setValue("inno");

        $("button").pressEnter();

        $("#zip-code").shouldHave(cssValue("background-color", "rgba(248, 215, 218, 1)"));
        $("#e-mail").shouldHave(cssValue("background-color", "rgba(248, 215, 218, 1)"));
        $("#phone").shouldHave(cssValue("background-color", "rgba(248, 215, 218, 1)"));

        $("#first-name").shouldHave(cssValue("background-color", "rgba(209, 231, 221, 1)"));
        $("#last-name").shouldHave(cssValue("background-color", "rgba(209, 231, 221, 1)"));
        $("#address").shouldHave(cssValue("background-color", "rgba(209, 231, 221, 1)"));
        $("#city").shouldHave(cssValue("background-color", "rgba(209, 231, 221, 1)"));
        $("#country").shouldHave(cssValue("background-color", "rgba(209, 231, 221, 1)"));
        $("#job-position").shouldHave(cssValue("background-color", "rgba(209, 231, 221, 1)"));
        $("#company").shouldHave(cssValue("background-color", "rgba(209, 231, 221, 1)"));

        $("#zip-code").shouldHave(text("N/A"));
    }

    @Test
    @DisplayName("Появление картинки - Тест 2")
    @Description("Проверяем появление третьей картинки с использованием неявного ожидания")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("INNO-6")
    public void waitPicture2() throws InterruptedException {
        open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        $("#award")
                .shouldBe(Condition.visible, Duration.ofSeconds(16))
                .shouldHave(Condition.attributeMatching("src", ".*img/award.png"));

    }

}

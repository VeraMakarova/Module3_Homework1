package ru.inno.module3.homework1;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Vera Makarova")
@DisplayName("Домашняя работа 1. Тесты Селениум")
@Epic("Формы и картинки")
@Feature("Авторизация")
public class HomeworkTests {

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
    @DisplayName("Успешная авторизация")
    @Description("Проверяем успешную авторизацию с паролем pwd")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("INNO-3")
    public void auth() {
        driver.get("http://uitestingplayground.com/sampleapp");
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys("inno");
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys("pwd");
        driver.findElement(By.cssSelector("#login")).click();
        String text = driver.findElement(By.cssSelector(".text-success")).getText();

        assertEquals("Welcome, inno!", text);
    }

    @Test
    @DisplayName("Изменение текста на кнопке")
    @Description("Проверяем появление на кнопке введенного текста")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("INNO-4")
    public void changeButtonName() {
        driver.get("http://uitestingplayground.com/textinput");
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys("Привет");
        driver.findElement(By.cssSelector("#updatingButton")).click();
        String text = driver.findElement(By.cssSelector("#updatingButton")).getText();

        assertEquals("Привет", text);

    }

    @Test
    @DisplayName("Заполнение формы")
    @Description("Проверяем появление на кнопке введенного текста")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("INNO-5")
    public void fillForm() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        driver.findElement(By.cssSelector("[name = first-name]")).sendKeys("Vera");
        driver.findElement(By.cssSelector("[name = last-name]")).sendKeys("Makarova");
        driver.findElement(By.cssSelector("[name = address]")).sendKeys("MyStreet 16, 42");
        driver.findElement(By.cssSelector("[name = city]")).sendKeys("Krasnogorsk");
        driver.findElement(By.cssSelector("[name = country]")).sendKeys("Russia");
        driver.findElement(By.cssSelector("[name = job-position]")).sendKeys("QA");
        driver.findElement(By.cssSelector("[name = company]")).sendKeys("inno");

        driver.findElement(By.cssSelector("button")).click();

        String zipCodeColor = driver.findElement(By.cssSelector("#zip-code")).getCssValue("background-color");
        String emailColor = driver.findElement(By.cssSelector("#e-mail")).getCssValue("background-color");
        String phoneColor = driver.findElement(By.cssSelector("#phone")).getCssValue("background-color");

        String nameColor = driver.findElement(By.cssSelector("#first-name")).getCssValue("background-color");
        String lastNameColor = driver.findElement(By.cssSelector("#last-name")).getCssValue("background-color");
        String addressColor = driver.findElement(By.cssSelector("#address")).getCssValue("background-color");
        String cityColor = driver.findElement(By.cssSelector("#city")).getCssValue("background-color");
        String countryColor = driver.findElement(By.cssSelector("#country")).getCssValue("background-color");
        String jobColor = driver.findElement(By.cssSelector("#job-position")).getCssValue("background-color");
        String companyColor = driver.findElement(By.cssSelector("#company")).getCssValue("background-color");

        String zipCodeText = driver.findElement(By.cssSelector("#zip-code")).getText();

        assertEquals("rgba(248, 215, 218, 1)", zipCodeColor);
        assertEquals("rgba(248, 215, 218, 1)", emailColor);
        assertEquals("rgba(248, 215, 218, 1)", phoneColor);

        assertEquals("rgba(209, 231, 221, 1)", nameColor);
        assertEquals("rgba(209, 231, 221, 1)", lastNameColor);
        assertEquals("rgba(209, 231, 221, 1)", addressColor);
        assertEquals("rgba(209, 231, 221, 1)", cityColor);
        assertEquals("rgba(209, 231, 221, 1)", countryColor);
        assertEquals("rgba(209, 231, 221, 1)", jobColor);
        assertEquals("rgba(209, 231, 221, 1)", companyColor);

        assertEquals("N/A", zipCodeText);
    }


    @Test
    @DisplayName("Появление картинки")
    @Description("Проверяем появление третьей картинки")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("INNO-6")
    public void waitPicture1() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        Thread.sleep(7000L);
        String srcValue = driver.findElement(By.cssSelector("#award")).getAttribute("src");

        assertTrue(srcValue.endsWith("award.png"));
    }

    @Test
    @DisplayName("Появление картинки - Тест 2")
    @Description("Проверяем появление третьей картинки с использованием неявного ожидания")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("INNO-6")
    public void waitPicture2() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String srcValue = driver.findElement(By.cssSelector("#award")).getAttribute("src");

        assertTrue(srcValue.endsWith("award.png"));
    }

}

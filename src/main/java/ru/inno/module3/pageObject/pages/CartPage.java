package ru.inno.module3.pageObject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {

    private final WebDriver driver;
    private HeaderElement header;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Получить текст о содержимом корзины")
    public String getCartText() {
        String text1 = driver.findElement(By.cssSelector(".mb10 .vue-object")).getText();
        String text2 = driver.findElement(By.cssSelector("#basket-default-prod-count2")).getText();
        String text = text1 + " " + text2;
        return text;
    }

    public HeaderElement getHeader() {
        if (header == null) {
            this.header = new HeaderElement(driver);
        }
        return header;
    }

}

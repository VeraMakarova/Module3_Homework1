package ru.inno.module3.pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    private final WebDriver driver;
    private HeaderElement header;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".buy-link"));
        for (WebElement button : buttons) {
            button.click();
        }
    }

    public void openCart() {
        driver.findElement(By.cssSelector(".cart-icon-js")).click();
    }


    public HeaderElement getHeader() {
        if (header == null) {
            this.header = new HeaderElement(driver);
        }
        return header;
    }


}

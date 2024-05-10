package ru.inno.module3.pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HeaderElement {

    private final WebElement header;

    public HeaderElement(WebDriver driver) {
        this.header = driver.findElement(By.cssSelector(".top-header"));
    }


    public void searchBooks(String book) {
        WebElement form = header.findElement(By.cssSelector("#search-field"));
        form.sendKeys(book);
        form.submit();
    }

}

package ru.inno.module3.pageObject.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LabirintFirstPage {

    private final WebDriver driver;
    private HeaderElement header;

    public LabirintFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://www.labirint.ru/");
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.navigate().refresh();
    }


    public HeaderElement getHeader() {

        if (header == null) {
            this.header = new HeaderElement(driver);
        }
        return header;
    }

}

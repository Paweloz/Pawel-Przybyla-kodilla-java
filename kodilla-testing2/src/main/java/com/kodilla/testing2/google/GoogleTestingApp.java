package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q";
    public static final String ALLOWCOOKIESID = "L2AGLb";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        WebElement allowButton = driver.findElement(By.id(ALLOWCOOKIESID));
        allowButton.click();
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
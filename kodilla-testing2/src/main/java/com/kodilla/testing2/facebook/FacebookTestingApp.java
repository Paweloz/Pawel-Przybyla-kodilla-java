package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {
    private static final String XPATH_COOKIESBUTTON = "//div[contains(@class, \"_9o-r\")]/button[2]";
    private static final String XPATH_REGBUTTON = "//div[contains(@class, \"_6ltg\")]/a";
    private static final String XPATH_NAME = "//div[@class=\"_5dbb\"]/input";
    private static final String XPATH_LASTNAME = "//div[@class=\"_5dbb\"]/div/input";
    private static final String XPATH_EMAIL = "//div[@class=\"mbm _a4y\"]/div/div/input";
    private static final String XPATH_REPEATE_EMAIL = "//div[@class=\"mbm _a4y\"]/div/div/input[@name=\"reg_email_confirmation__\"]";
    private static final String XPATH_PASSWORD = "//div[@class=\"mbm _br- _a4y\"]/div/div/input";
    private static final String XPATH_DAYOFBIRTH = "//div[(@class=\"_5k_5\")]/span/span/select[1]";
    private static final String XPATH_MONTHOFBIRTH = "//div[(@class=\"_5k_5\")]/span/span/select[2]";
    private static final String XPATH_YEAROFBIRTH = "//div[(@class=\"_5k_5\")]/span/span/select[3]";
    private static final String XPATH_SEX_MALE = "//input[@name=\"sex\" and @value=\"2\"]";
    private static final String XPATH_SECONDREG = "//div[@class=\"_1lch\"]/button";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("https://www.facebook.com/");

        WebElement cookiesButton = driver.findElement(By.xpath(XPATH_COOKIESBUTTON));
        cookiesButton.click();

        WebElement regButton = driver.findElement(By.xpath(XPATH_REGBUTTON));
        regButton.click();

        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_NAME)));
        nameField.sendKeys("Jan");

        WebElement lastnameField = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastnameField.sendKeys("Kowalski");

        WebElement emailField = driver.findElement(By.xpath(XPATH_EMAIL));
        emailField.sendKeys("example@email.com");

        WebElement repeatEmail = driver.findElement(By.xpath(XPATH_REPEATE_EMAIL));
        repeatEmail.sendKeys("example@email.com");

        WebElement passwordField = driver.findElement(By.xpath(XPATH_PASSWORD));
        passwordField.sendKeys("12345");

        WebElement birthDay = driver.findElement(By.xpath(XPATH_DAYOFBIRTH));
        Select select = new Select(birthDay);
        select.selectByIndex(12);

        WebElement birthMonth = driver.findElement(By.xpath(XPATH_MONTHOFBIRTH));
        Select selectMonth = new Select(birthMonth);
        selectMonth.selectByIndex(10);

        WebElement birthYear = driver.findElement(By.xpath(XPATH_YEAROFBIRTH));
        Select selectYear = new Select(birthYear);
        selectYear.selectByIndex(23);

        WebElement chooseMaleSex = driver.findElement(By.xpath(XPATH_SEX_MALE));
        chooseMaleSex.click();

        WebElement secondRegButton = driver.findElement(By.xpath(XPATH_SECONDREG));
        secondRegButton.click();

    }
}

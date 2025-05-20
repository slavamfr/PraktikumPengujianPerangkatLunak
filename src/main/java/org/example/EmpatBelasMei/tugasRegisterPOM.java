package org.example.EmpatBelasMei;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class tugasRegisterPOM {
    private WebDriver driver;
    private WebDriverWait wait;

    public tugasRegisterPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openRegistrationPage() {
        driver.get("https://www.automationexercise.com");
        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/login']")));
        signUpButton.click();
    }

    public void fillPersonalDetails(String name, String email) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='signup-name']")));
        nameField.sendKeys(name);

        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailField.sendKeys(email);

        WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpButton.click();
    }

    public void fillAccountDetails(String password, String day, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1"))).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("days")).sendKeys(day);
        driver.findElement(By.id("months")).sendKeys(month);
        driver.findElement(By.id("years")).sendKeys(year);
    }

    public void selectPreferences() {
        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(newsletterCheckbox)).click();

        WebElement specialOffersCheckbox = driver.findElement(By.id("optin"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", specialOffersCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(specialOffersCheckbox)).click();
    }

    public void fillAddressDetails(String firstName, String lastName, String company,
                                   String address, String city, String state, String zipcode, String country, String mobileNumber) {
        driver.findElement(By.id("first_name")).sendKeys(firstName);
        driver.findElement(By.id("last_name")).sendKeys(lastName);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address1")).sendKeys(address);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);
    }

    public String submitRegistration() {
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[@data-qa='account-created']")));
        return successMessage.getText().trim();
    }
}
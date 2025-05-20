package Pertemuan30April;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class tugasTigaPuluhAprilB {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void registrationTest() {
        driver.get("https://www.automationexercise.com");

        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/login']")));
        signUpButton.click();

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='signup-name']")));
        nameField.sendKeys("John Doe");

        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailField.sendKeys("john.doe" + System.currentTimeMillis() + "@example.com");

        WebElement signUpButton2 = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpButton2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("days")).sendKeys("1");
        driver.findElement(By.id("months")).sendKeys("January");
        driver.findElement(By.id("years")).sendKeys("1990");

        // SCROLL dan klik hingga elemen terlihat
        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(newsletterCheckbox)).click();

        WebElement specialOffersCheckbox = driver.findElement(By.id("optin"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", specialOffersCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(specialOffersCheckbox)).click();

        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Doe");
        driver.findElement(By.id("company")).sendKeys("TechCorp");
        driver.findElement(By.id("address1")).sendKeys("123 Tech Street");
        driver.findElement(By.id("city")).sendKeys("TechCity");
        driver.findElement(By.id("state")).sendKeys("TechState");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("country")).sendKeys("United States");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-qa='account-created']")));
        String successText = successMessage.getText().trim();
        System.out.println("Success message: " + successText);
        assert successText.equalsIgnoreCase("ACCOUNT CREATED!");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

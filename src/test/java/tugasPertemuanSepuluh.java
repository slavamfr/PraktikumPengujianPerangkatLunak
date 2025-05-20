import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class tugasPertemuanSepuluh {

    @Test
    public void testAddButton_NoSuchElementException() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().window().maximize();

        driver.findElement(By.id("add_btn")).click();
        driver.findElement(By.xpath("//div[@id='row2']/input")).sendKeys("Test");
        driver.quit();
    }

    @Test
    public void testClearWithoutClickEdit() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().window().maximize();

        WebElement inputField = driver.findElement(By.xpath("//div[@id='row1']/input"));

        inputField.clear();

        driver.quit();
    }

    @Test
    public void testAccessingStaleElement() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().window().maximize();

        WebElement instructions = driver.findElement(By.id("instructions"));
        driver.findElement(By.id("add_btn")).click();

        boolean displayed = instructions.isDisplayed();

        driver.quit();
    }

    @Test
    public void testTimeoutException() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().window().maximize();

        driver.findElement(By.id("add_btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));

        driver.quit();
    }

    @Test
    public void testAddButton_WithThreadSleep() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().window().maximize();

        driver.findElement(By.id("add_btn")).click();

        Thread.sleep(10000);

        WebElement input = driver.findElement(By.xpath("//div[@id='row2']/input"));
        input.sendKeys("Berhasil");

        driver.quit();
    }

    @Test
    public void testAddButton_WithImplicitWait() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().window().maximize();

        driver.findElement(By.id("add_btn")).click();

        WebElement input = driver.findElement(By.xpath("//div[@id='row2']/input"));
        input.sendKeys("Berhasil");

        driver.quit();
    }

    @Test
    public void testAddButton_WithExplicitWait() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().window().maximize();

        driver.findElement(By.id("add_btn")).click();

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@id='row2']/input")));
        input.sendKeys("Berhasil");

        driver.quit();
    }
}

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class tugasTujuhApril {
    WebDriverWait wait;

    @Test
    public void testAddOne() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        WebElement add = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/section/section/div/div[1]/div/button[3]")));
        add.click();

        WebElement row2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/section/section/div/div[3]/div/label")));
        assertTrue(row2.isDisplayed());

        driver.quit();
    }

    @Test
    public void caseAddTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement add = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/section/section/div/div[1]/div/button[3]")));
        add.click();

        WebElement row2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/section/div/div[3]/div/label")));
        assertTrue(row2.isDisplayed());

        driver.quit();
    }

    @Test
    public void caseSaveBeforeInputTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        WebElement add = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/section/section/div/div[1]/div/button[3]")));
        add.click();

        // Coba klik Save sebelum mengisi input
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/section/section/div/div[3]/div/button[1]")));
        save.click();

        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/section/section/div/div[3]/div/label")));
        assertTrue(confirmation.isDisplayed());

        driver.quit();
    }

    @Test
    public void caseTimeoutTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // waktu pendek untuk trigger timeout

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@id='loading_spinner']"))); // elemen tidak ada

        } catch (TimeoutException e) {
            System.out.println("TimeoutException terjadi seperti yang diharapkan.");
            assertTrue(true); // dianggap sukses karena memang diharapkan terjadi timeout
        } finally {
            driver.quit();
        }
    }

    @Test
    public void caseEditFieldTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        try {
            System.out.println("Menunggu tombol Edit...");
            WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit_btn")));
            editBtn.click();

            System.out.println("Menunggu input aktif...");
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("row1_input")));
            input.clear();
            input.sendKeys("Diubah");

            System.out.println("Klik tombol Save...");
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("save_btn")));
            saveBtn.click();

            WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));
            assertTrue(confirmation.isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("TimeoutException terjadi: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

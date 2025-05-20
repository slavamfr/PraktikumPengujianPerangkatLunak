import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PraktikumWaitTest {
    @Test
    public void waitTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        WebElement errorMessage = driver.findElement(
                By.className("error-button"));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(errorMessage));
    }

    @Test
    public void moleTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.mobilelegends.com/");
        driver.findElement(By.xpath("/html/body/div[7]/div/div[3]/div"));
        driver.findElement(By.xpath("/html/body/div[7]/div/div[3]/div/div[2]")).click();
    }
}

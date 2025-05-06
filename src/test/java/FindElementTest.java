import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FindElementTest {
    @Test
    public void bingTest(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.bing.com/");
        System.out.println(driver.getTitle());

        WebElement queryInput = driver.findElement(By.id("sb_form_q"));
        WebElement form = driver.findElement(By.id("sb_form"));

        queryInput.sendKeys("revandra");
        form.submit();
    }

    @Test
    public void swagLabsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}

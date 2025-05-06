import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tugasTigaPuluhAprilA {
    WebDriver driver;
    Actions actions;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement image = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        actions.moveToElement(image).perform();

        Thread.sleep(1000);

        WebElement caption = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[1]"));

        System.out.println("Hover result: " + caption.getText());
        assert caption.getText().equals("name: user1");
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        actions.clickAndHold(source).moveToElement(target).release().perform();

        Thread.sleep(1000);

        String header = driver.findElement(By.cssSelector("#column-a header")).getText();
        System.out.println("After drag and drop, Column A: " + header);
        assert header.equals("B");
    }

    @Test
    public void keyPressTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement input = driver.findElement(By.id("target"));
        input.sendKeys(Keys.SHIFT);

        Thread.sleep(500);

        WebElement result = driver.findElement(By.id("result"));
        System.out.println("Key press result: " + result.getText());
        assert result.getText().equals("You entered: SHIFT");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

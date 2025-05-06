import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {
    @Test
    public void dtediTest(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://tedi.sv.ugm.ac.id/id/muka/");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Website Departemen Teknik Elektro dan Informatika (TEDI), Sekolah Vokasi, UGM – TEDI SV UGM", driver.getTitle());
        driver.quit();
    }
}

package Pertemuan14Mei;

import org.example.EmpatBelasMei.resultPage;
import org.example.EmpatBelasMei.searchPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTestDua {
    @Test
    public void testGoogle(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://bing.com/");
        searchPage lamanPencarian = new searchPage(driver);
        lamanPencarian.setSearchBar("revandra");
        lamanPencarian.formSubmit();
        resultPage result = new resultPage(driver);
        //Assert
        result.getTitle();
        //driver.quit();
    }

    @Test
    public void testGoogleNoValue(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://bing.com/");
        searchPage lamanPencarian = new searchPage(driver);
        lamanPencarian.setSearchBar("");
        lamanPencarian.formSubmit();
        //driver.quit();
    }
}

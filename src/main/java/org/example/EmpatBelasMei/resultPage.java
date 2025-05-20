package org.example.EmpatBelasMei;

import org.openqa.selenium.WebDriver;

//Latihan
public class resultPage {
    WebDriver driver;

    public resultPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }
}

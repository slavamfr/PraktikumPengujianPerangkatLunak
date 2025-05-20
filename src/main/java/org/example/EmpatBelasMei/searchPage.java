package org.example.EmpatBelasMei;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchPage {
    WebDriver driver;
    public searchPage(WebDriver driver) {
        this.driver = driver;
    }

    //locator
    By searchBar = By.id("sb_form_q");
    By searchForm = By.id("sb_form");

    //interaction

    public void setSearchBar(String query) {
        driver.findElement(searchBar).sendKeys(query);
    }

    public void formSubmit() {
        driver.findElement(searchForm).submit();
    }
}
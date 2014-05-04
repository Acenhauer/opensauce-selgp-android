package com.selgp.opensauce.android;

import com.selgp.opensauce.BaseSaucelabsAndroid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class AndroidContactsTest extends BaseSaucelabsAndroid {
    @Test
    public void addContact() {
        WebElement el = driver().findElement(By.name("Add Contact"));
        el.click();
        List<WebElement> textFieldsList = driver().findElements(By.tagName("textfield"));
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(2).sendKeys("Some@selgp.com");
        driver().findElement(By.name("Save")).click();
    }
}


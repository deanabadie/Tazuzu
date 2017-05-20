package com.mysite.selenium;


import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@Config(
        browser = Browser.CHROME,
        url     = "http://tazuzuapp.com/login"
)
public class SeleniumHQTest extends Locomotive {

    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testLoginBtnExists() {
        validatePresent(HomePage.LOC_BTN_LOGIN);
    }

    @Test
    public void testRegisterBtnExists() {
        validatePresent(HomePage.LOC_BTN_REGISTER);
    }


//    @Before
//    public void setUp() throws Exception {
//        driver = new ChromeDriver();
////        baseUrl = "http://www.tazuzuapp.com/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
    @Test
    public void testSelenium() throws Exception {
//        waitForElement(By.name("idNumber"));
//        driver.wait(50);
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("idNumber")));
        driver.findElement(By.name("idNumber")).clear();
        driver.findElement(By.name("idNumber")).sendKeys("1234");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1234");
        click(HomePage.LOC_BTN_LOGIN);
        validatePresent(By.xpath("(//button[@type='button'])[2]"));
    }
//
    @After
    public void tearDown() throws Exception {
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
    }


//    @Before
//    public void setUp() throws Exception {
//
////        validatePresent(HomePage.LOC_LNK_DOWNLOADSELENIUM);


//    }

//    @Test
//    public void testTabsExist() {
//        validatePresent(HomePage.LOC_LNK_PROJECTSTAB)
//                .validatePresent(HomePage.LOC_LNK_DOWNLOADTAB)
//                .validatePresent(HomePage.LOC_LNK_DOCUMENTATIONTAB)
//                .validatePresent(HomePage.LOC_LNK_SUPPORTTAB)
//                .validatePresent(HomePage.LOC_LNK_ABOUTTAB)
//        ;
//    }
}
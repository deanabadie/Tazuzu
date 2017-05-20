package com.mysite.selenium;

import org.openqa.selenium.By;

public class HomePage {
    // the tabs
    public static final String LOC_BTN_REGISTER = "a.btn.btn-link";
    public static final String LOC_BTN_LOGIN = "button.mdl-button.mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored";
    public static final String LOC_TXT_PASSWORD= "li#menu_download a[href$='download/']";
    // download link
    public static final By LOC_LNK_DOWNLOADSELENIUM = By.linkText("Download Selenium");
}
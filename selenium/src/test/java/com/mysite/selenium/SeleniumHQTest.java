package com.mysite.selenium;


import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.Before;
import org.junit.Test;

@Config(
        browser = Browser.CHROME,
        url     = "http://tazuzuapp.com"
)
public class SeleniumHQTest extends Locomotive {
    @Test
    public void testDownloadLinkExists() {
//        validatePresent(HomePage.LOC_BTN_LOGIN);
        validatePresent(HomePage.LOC_BTN_REGISTER);
    }

//    @Before
//    public void setUp() throws Exception {
//
////        validatePresent(HomePage.LOC_LNK_DOWNLOADSELENIUM);


//    }

    @Test
    public void testTabsExist() {
//        validatePresent(HomePage.LOC_LNK_PROJECTSTAB)
//                .validatePresent(HomePage.LOC_LNK_DOWNLOADTAB)
//                .validatePresent(HomePage.LOC_LNK_DOCUMENTATIONTAB)
//                .validatePresent(HomePage.LOC_LNK_SUPPORTTAB)
//                .validatePresent(HomePage.LOC_LNK_ABOUTTAB)
//        ;
    }
}
package tests.day19_testNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PozitifLoginTesti {

    //dinamik olamayan birşey
    //AfterMethod ile test pass olunca kapatıyor fakat test failed olunca da kapatıyor bu sayede acık sayfa kalmıyor.

    @Test
    public void pozitifLogitTest(){


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();


        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));


        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //5- Login butonuna basarak login olun
        testotomasyonuPage
                .loginSiginButonu
                .click();

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logOutButonu.isDisplayed());

      //  Driver.quitDriver();
    }


        @AfterMethod
        public void teardown(){
            Driver.quitDriver();
        }


}

package tests.day18_testNGFrameworkHazirlama;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C02_PageClassKullanimi {


    @Test (groups = {"smoke","E2E", "regression"})
    public void test01(){

        // testotomasyonu sayfasina gidin
        Driver.getdriver().get("https://www.testotomasyonu.com");

        // phone icin arama yapin

        // POM'de Page class'larindaki locate'leri kullanmak icin
        // page class'larindan Obje Olusturma yontemi benimsenmistir
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();  //obje olusturduk
        testotomasyonuPage.aramakutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = testotomasyonuPage.aramaSonucElementi.getText();

        Assert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu);

        // sayfayi kapatin
        Driver.quitDriver();


    }

}

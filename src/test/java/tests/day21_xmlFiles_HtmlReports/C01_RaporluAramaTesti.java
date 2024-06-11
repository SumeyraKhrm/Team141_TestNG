package tests.day21_xmlFiles_HtmlReports;

//calıstırma sonucu kayıt etmek içic raporlama mümkün..ama farklı kütüphanelerden yardım almamız gerekir !


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluAramaTesti extends TestBaseRapor {

    //eger test fail yaparsak screenshotta getiriyor.

    @Test
    public void aramaTesti(){

        extentTest = extentReports.createTest("arama testi","belirlenen kelimenin bulunabildigini test eder");

        // testotomasyonu anasayfaya gidin
        Driver.getdriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");  //test adımları raporluyor
        // belirlenen arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi icin arama yapar");
        // arama sonucunda urun bulunabildigini test edin

        Assert.assertTrue(testotomasyonuPage.sonucElementleriList.size()>0);
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");




    }
}

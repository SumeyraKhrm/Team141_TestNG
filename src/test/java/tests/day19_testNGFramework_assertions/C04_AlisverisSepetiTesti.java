package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_AlisverisSepetiTesti {

    //PAGE_DOWN keys'i çok onemli !!

    @Test
    public void sepetTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getdriver().get(ConfigReader.getProperty("toUrl"));

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu
                        .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage.sonucElementleriList.get(0).click();


        //4- urun ismini kaydedin
        String ilkUrunIsmi = testotomasyonuPage.ilkUrunSayfasindaUrunIsimElementi.getText();

        ReusableMethods.bekle(2);

        //bilgisayarimda ilk sayfada login portal gorunuyor, asagi inmeye gerek yok
        Actions action = new Actions(Driver.getdriver());
        action.sendKeys(Keys.PAGE_DOWN).build().perform();


        // ve urunu sepete ekleyin
        testotomasyonuPage.addToCartButonu.click();

        action.sendKeys(Keys.PAGE_UP).build().perform();
        ReusableMethods.bekle(6);


        //5- your cart linkine tiklayin
        testotomasyonuPage.yourCartLinki.click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String sepettekiUrunIsmi = testotomasyonuPage.sepettekiUrunIsimElementi
                .getText();

        Assert.assertEquals(ilkUrunIsmi,sepettekiUrunIsmi);

        //7- sayfayi kapatin
        Driver.quitDriver();



        //bug bulundu urun ısmınde farklılık var
        //Expected :APPLEL iPhone 13 (Starlight, 128 GB)
        //Actual   :APPLEL IPhone 13 (Starlight, 128 GB)




    }
}

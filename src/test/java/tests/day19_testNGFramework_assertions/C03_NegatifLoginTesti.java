package tests.day19_testNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NegatifLoginTesti {


    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
      public void NegatifLoginTesti(){

        Driver.getdriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        testotomasyonuPage.loginSiginButonu.click();
        Assert.assertTrue(testotomasyonuPage.loginSiginButonu.isDisplayed());
        //sign in butonu hala görünüyorsa basarılı bir giris yapamadım demektir
        Driver.quitDriver();


    }

    @Test
    public void gecersizEmailTesti(){

        Driver.getdriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        testotomasyonuPage.loginSiginButonu.click();
        Assert.assertTrue(testotomasyonuPage.loginSiginButonu.isDisplayed());
        //sign in butonu hala görünüyorsa basarılı bir giris yapamadım demektir
        Driver.quitDriver();

    }


    @Test (groups = "smoke")
    public void gecersizEmailGecersizPasswordTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getdriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- gecersiz email, gecersiz password girin
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSiginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailKutusu.isDisplayed());
        ReusableMethods.bekle(3);
        //6- Sayfayi kapatin
        Driver.quitDriver();

    }

}

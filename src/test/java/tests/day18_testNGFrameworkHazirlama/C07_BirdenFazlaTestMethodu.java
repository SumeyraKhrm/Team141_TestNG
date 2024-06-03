package tests.day18_testNGFrameworkHazirlama;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C07_BirdenFazlaTestMethodu {


    @Test(priority = -17)
    public void testOtomasyonuTesti(){

        Driver.getdriver().get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edelim

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getdriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Driver.quitDriver();
    }

    @Test (priority = -17)
    public void wisequarterTesti(){

        Driver.getdriver().get("https://www.wisequarter.com");

        // url'in wisequarter icerdigini test edelim

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = Driver.getdriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Driver.quitDriver();
    }

    @Test (priority = 4)
    public void bestbuyTesti(){

        Driver.getdriver().get("https://www.bestbuy.com");

        // url'in bestbuy icerdigini test edelim

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = Driver.getdriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Driver.quitDriver();
    }




}


package tests.day17_testNGFramework;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassIlkTest {


    // TextNG Page Object Model'de
    // bizim elimiz kolumuz, gozumuz olan webdriver objesi olusturmak icin
    // Driver class'indaki static getDriver() kullanilir

    @Test
    public void test01() throws InterruptedException {

        Driver.getdriver().get("https://www.testotomasyonu.com");

        Thread.sleep(3);

        Driver.quitDriver();

    }
}

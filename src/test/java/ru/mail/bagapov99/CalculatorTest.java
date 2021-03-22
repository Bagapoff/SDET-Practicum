package ru.mail.bagapov99;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    public static GooglePage googlePage;
    public static CalcPage calcPage;
    public static WebDriver driver;
    /**
     * Начальная настройка
     */

    public static void setup(){
        System.setProperty("webdriver.chrome.driver",ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        calcPage = new CalcPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("page"));
    }

    @Test
    public void integerTest(){
        setup();
        googlePage.inputQuery("Калькулятор");
        googlePage.clickSearchBtn();
        calcPage.inputExample("(1+2)*3-40/5");
        calcPage.clickEqlBtn();
        String calcHistory = calcPage.getCalcHist();
        String calcResult = calcPage.getResult();
        Assert.assertEquals("(1 + 2) × 3 - 40 ÷ 5 =",calcHistory);
        Assert.assertEquals("1",calcResult);
        tearDown();
    }

    @Test
    public void zeroDivisionTest(){
        setup();
        googlePage.inputQuery("Калькулятор");
        googlePage.clickSearchBtn();
        calcPage.inputExample("6/0");
        calcPage.clickEqlBtn();
        String calcHistory = calcPage.getCalcHist();
        String calcResult = calcPage.getResult();
        Assert.assertEquals("6 ÷ 0 =",calcHistory);
        Assert.assertEquals("Infinity",calcResult);
        tearDown();
    }

    @Test
    public void notValueErrorTest(){
        setup();
        googlePage.inputQuery("Калькулятор");
        googlePage.clickSearchBtn();
        calcPage.inputExample("s");
        calcPage.clickEqlBtn();
        String calcHistory = calcPage.getCalcHist();
        String calcResult = calcPage.getResult();
        Assert.assertEquals("sin() =",calcHistory);
        Assert.assertEquals("Error",calcResult);
        tearDown();
    }


    public static void tearDown(){
        driver.quit();
    }
}

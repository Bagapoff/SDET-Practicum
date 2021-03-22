package ru.mail.bagapov99;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalcPage {
    /**
     * Конструктор класса
     */
    public WebDriver driver;
    public CalcPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    /**
     * Нахождение локатора поля ввода
     */
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div")
    private WebElement calcField;
    /**
     * Нахождение локатора истории вычислений
     */
    @FindBy(xpath = "//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/span")
    private WebElement histField;
    /**
     * Метод для ввода запроса
     */
    public void inputExample(String example){
        calcField.sendKeys(example);
    }
    /**
     * Метод для нажатия кнопки "равно"
     */
    public void clickEqlBtn(){
        calcField.sendKeys(Keys.ENTER);
    }
    /**
     * Метод для получения истории вычисления
     */
    public String getCalcHist() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/span")));
        String calcHist = histField.getText();
        return calcHist; }
    /**
     * Метод для получения результата
     */
    public String getResult(){
        String result = calcField.getText();
        return result;
    }
}

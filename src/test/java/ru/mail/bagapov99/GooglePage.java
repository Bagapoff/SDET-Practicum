package ru.mail.bagapov99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    /**
     * Конструктор класса
     */
    public WebDriver driver;
    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * Нахождение локатора поисковой строки
     */
    @FindBy(name = "q")
    private WebElement searchField;
    /**
     * Нахождение локатора кнопки поиска
     */
    @FindBy(name = "btnK")
    private WebElement searchBtn;
    /**
     * Метод для ввода запроса
     */
     public void inputQuery(String query){
         searchField.sendKeys(query);
     }
    /**
     * Метод для нажатие кнопки поиска
     */
    public void clickSearchBtn(){
        searchBtn.click();
    }
}

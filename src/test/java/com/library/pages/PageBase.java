package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    public PageBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Dashboard']")
    public  WebElement dashboardButton;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersButton;

    @FindBy(xpath = "//span[.='Books']")
    public  WebElement booksButton;



}

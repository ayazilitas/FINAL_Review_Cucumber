package com.SDET_Review.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(){}

    @FindBy(xpath = "//input[@id='inputEmail']  ")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='inputPassword']  ")
    public WebElement passWord;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signBtn;

    @FindBy(xpath = "//span[.='Test Student 1']")
    public WebElement studentDashboard;

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']/span")
    public WebElement librarianDashboard;

    @FindBy(xpath = "//a[.='Log Out']")
    public WebElement logOut;

}

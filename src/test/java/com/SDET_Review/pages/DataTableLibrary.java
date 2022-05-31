package com.SDET_Review.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataTableLibrary extends BasePage {

    public DataTableLibrary(){}
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

    @FindBy(xpath = "//span[.='Test Librarian 1'] ")
    public WebElement userNameText;

    @FindBy(id = "month")
    public WebElement monthDropdown;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersLink;

    @FindBy(xpath = "//select[@name='tbl_users_length' ]")
    public WebElement pageDropDown;

    /**
     *https:https://library2.cydeo.com/login.html
     * C#27: Library Login
     * Scenario: User should be able to login with
     * correct credentials
     *  Given User is on the login page of Library App
     *  When User enters below info
     *  |username|student1@library|
     *  |password|d5fv9BtX|
     *  Then User should see dashboard
     */

    /**
     * TC##0020  https://practice.cydeo.com/dropdown
     * Feature: Simple examples of how dataTables work
     *erjon
     *   @dataTable
     *   Scenario: User should be able to see all 12 months in months dropdown
     *     Given User is on the dropdowns page of practice tool
     *     Then User should see below info in month dropdown
     *       | January   |
     *       | February  |
     *       | March     |
     *       | April     |
     *       | May       |
     *       | June      |
     *       | July      |
     *       | August    |
     *       | September |
     *       | October   |
     *       | November  |
     *       | December  |
     */

    /**
     * TC#4: Data tables task
     * Task summary:
     * -> Create a new feature file named ShowRecords.feature
     * -> Create a new scenario.
     * -> Login as a librarian
     * -> Click on Users link
     * -> Show records dropdown value should be 10 by default.
     * -> And show records should have following options: 5, 10, 15, 50, 100, 200, 500
     *
     *
     * TC#5: Data tables task
     * Task summary:
     * -> Create a new feature file named SearchResults.feature
     * -> As a user, I should be able to login as librarian. When I go to Users page, table
     * should have following columns:
     * • Actions
     * • UserID
     * • Full Name
     * • Email
     * • Group
     * • Status
     */
}

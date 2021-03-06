package com.SDET_Review.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaPage extends BasePage{


    public WikipediaPage(){
         }

    @FindBy(xpath = "//input[@class='vector-search-box-input']")
    public WebElement searchBox;

    @FindBy(id = "searchButton")
    public WebElement searchBtn;

    @FindBy(xpath = "//h1[@id='firstHeading']")
    public WebElement headertext;

    @FindBy(xpath = "(//div[.='Steve Jobs'])[1]")
    public WebElement imgHeader;

    /**
     * TC#25: Wikipedia Search Functionality Title Verification
     * 1. User is on Wikipedia home page
     * 2. User types Steve Jobs in the wiki search box
     * 3. User clicks wiki search button
     * 4. User sees Steve Jobs is in the wiki title
     *
     * Note: Follow POM
     * TC#26: Wikipedia Search Functionality Header Verification
     * 1. User is on Wikipedia home page
     * 2. User types Steve Jobs in the wiki search box
     * 3. User clicks wiki search button
     * 4. User sees Steve Jobs is in the main header
     *
     * Note: Follow POM
     * TC#27: Wikipedia Search Functionality Image Header Verification
     * 1. User is on Wikipedia home page
     * 2. User types Steve Jobs in the wiki search box
     * 3. User clicks wiki search button
     * 4. User sees Steve Jobs is in the image header
     *
     *
     * Note: Use parameterization
     * Scenario: Wikipedia Search header verification
     *     Given user is on the wikipedia main page
     *     When user searches for "Steve Jobs"
     *     And user clicks search button
     *     Then user should see "Steve Jobs" on the main header
     *
     *   Scenario: Wikipedia Search image verification
     *     Given user is on the wikipedia main page
     *     When user searches for "Steve Jobs"
     *     And user clicks search button
     *     Then user should see "Steve Jobs" on the image
     *
     *
     *  Note:Use Scenario Outline
     *   Scenario Outline: Wekipedia Search for the above examples.
     *
     */
}

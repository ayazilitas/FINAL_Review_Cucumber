package com.SDET_Review.StepDefs;

import com.SDET_Review.pages.WikipediaPage;
import com.SDET_Review.utilities.ConfigurationReader;
import com.SDET_Review.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class WikipediaStepDefs {

WikipediaPage wikipediaPage=new WikipediaPage();

    @Given("user is in the wikipedia main page")
    public void user_is_in_the_wikipedia_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikiUrl"));
    }

    @When("user searches for Steve Job")
    public void user_searches_for_steve_job() {
        wikipediaPage.searchBox.sendKeys("Steve Job");
    }
    @When("user clicks search button")
    public void user_clicks_search_button() {
      wikipediaPage.searchBtn.click();
    }
    @Then("user should see Steve Jobs in title")
    public void user_should_see_steve_jobs_in_title() {
        String expectedTitle="Steve Job";
        String actualTitle=Driver.getDriver().getTitle();
        assertTrue("Title did not match",actualTitle.contains(expectedTitle));
    }

    @Then("user should see Steve Jobs on the header")
    public void user_should_see_steve_jobs_on_the_header() {
        String expected="Steve Job";
        String actualHeader= wikipediaPage.headertext.getText();

        assertTrue("The header did not match",actualHeader.contains(expected));
    }

    @Then("user should see Steve Jobs in Image header text")
    public void user_should_see_steve_jobs_in_image_header_text() {
        String expected="Steve Job";
        String actualimgHeader= wikipediaPage.imgHeader.getText();

        assertTrue("The img header did not match",actualimgHeader.contains(expected));
    }


    @When("user searches for {string}")
    public void user_searches_for(String keyWord) {
        wikipediaPage.searchBox.sendKeys(keyWord);

    }

    @Then("user should see {string} in title")
    public void user_should_see_in_title(String KeyWordResult) {
        wikipediaPage.headertext.getText().contains(KeyWordResult);
        System.out.println("wikipediaPage.headertext.getText() = " + wikipediaPage.headertext.getText());

    }

    @Then("user should see {string} on the header")
    public void userShouldSeeOnTheHeader(String keyword) {

        Driver.getDriver().getTitle().contains(keyword);
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
    }

    @Then("user should see {string} in Image header text")
    public void userShouldSeeInImageHeaderText(String keyword2) {

        wikipediaPage.imgHeader.getText().contains(keyword2);
        System.out.println("wikipediaPage.imgHeader.getText() = " + wikipediaPage.imgHeader.getText());
    }
    @Then("user should see {string} on the title")
    public void user_should_see_on_the_title(String expectedTitles) {
        String  actualTitles=Driver.getDriver().getTitle();
        assertTrue(actualTitles.contains(expectedTitles));
    }


    @Then("user should see  {string}  on the header")
    public void user_should_see_on_the_header(String expectedHeader) {
     String actualheadertext= wikipediaPage.headertext.getText();
     assertTrue(actualheadertext.contains(expectedHeader));

    }
    @Then("user should see {string} on the Image")
    public void user_should_see_on_the_image(String expectedImageText) {
      String actualImageText= wikipediaPage.imgHeader.getText();
      assertTrue(actualImageText.contains(expectedImageText));
    }

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

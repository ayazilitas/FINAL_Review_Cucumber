package com.SDET_Review.StepDefs;

import com.SDET_Review.pages.EtsyPage;
import com.SDET_Review.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyStepDefinition  {

    EtsyPage etsyPage=new EtsyPage();


    @Given("user is on etsy main page")
    public void user_is_on_etsy_main_page() {
      Driver.getDriver().get("https://www.etsy.com");
        etsyPage.acceptBtn.click();
    }
    @Then("user verifies that title is Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone")
    public void user_verifies_that_title_is_etsy_shop_for_handmade_vintage_custom_and_unique_gifts_for_everyone() {
       String expectedTitle="Etsy The Netherlands - Shop for handmade, vintage, custom, and unique gifts for everyone";
       String actualTitle=Driver.getDriver().getTitle();
       Assert.assertEquals("Titledid not Match",expectedTitle,actualTitle);
    }

    @When("User searches for keyword")
    public void user_searches_for_keyword() {
        String key="Wooden Spoon";
    etsyPage.searchBox.sendKeys(key);
    etsyPage.searchButton.click();
    }
    @Then("keyword displays in the title")
    public void keyword_displays_in_the_title() {

        String expected="Wooden spoon";
        String actual=Driver.getDriver().getTitle();

        Assert.assertTrue("Title did not Match",actual.contains(expected));
    }


/**
 * TC#51: Etsy Title Verification
 * 1. User is on https://www.etsy.com
 * 2. User sees title is as expected.
 * Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for
 * everyone
 * Note: Follow POM
 *
 * TC#52: Etsy Search Functionality Title Verification (without parameterization)
 * 1. User is on https://www.etsy.com
 * 2. User types Wooden Spoon in the search box
 * 3. User clicks search button
 * 4. User sees Wooden Spoon is in the title
 * Note: Follow POM
 *
 *
 * TC#53: Etsy Search Functionality Title Verification (with parameterization)
 * 1. User is on https://www.etsy.com
 * 2. User types Wooden Spoon in the search box
 * 3. User clicks search button
 * 4. User sees Wooden Spoon is in the title
 */
}

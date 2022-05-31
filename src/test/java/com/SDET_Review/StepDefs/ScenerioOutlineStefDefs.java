package com.SDET_Review.StepDefs;

import com.SDET_Review.pages.DataTableLibrary;
import com.SDET_Review.utilities.ConfigurationReader;
import com.SDET_Review.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScenerioOutlineStefDefs {
    DataTableLibrary dataTableLibrary=new DataTableLibrary();


    @Given("user is on the login page of the library app")
    public void user_is_on_the_login_page_of_the_library_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryURL"));
    }

   @When("user enters {string} and {string}")
    public void user_enters_and(String email, String password) {
        dataTableLibrary.emailInput.sendKeys(email);
        dataTableLibrary.passWord.sendKeys(password);
    }
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        dataTableLibrary.signBtn.click();
    }

    @Then("user should see {string}")
    public void user_should_see(String username) {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(dataTableLibrary.userNameText));

        Assert.assertEquals("The username did not match",username,dataTableLibrary.userNameText.getText());
    }

}


package com.SDET_Review.StepDefs;

import com.SDET_Review.pages.LoginPage;
import com.SDET_Review.utilities.ConfigurationReader;
import com.SDET_Review.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs {

    LoginPage loginPage=new LoginPage();
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(),20);


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("libraryURL");
        Driver.getDriver().get(url);
    }

    @When("student enters username")
    public void student_enters_username() {

        //wait.until(ExpectedConditions.elementToBeClickable(loginPage.emailInput));
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("studentUsername"));
    }
    @When("student enters password")
    public void student_enters_password() {
       //wait.until(ExpectedConditions.elementToBeClickable(loginPage.passWord));
       loginPage.passWord.sendKeys(ConfigurationReader.getProperty("studentPassword"));
    }
    @When("student clicks login button")
    public void student_clicks_login_button() {
       loginPage.signBtn.click();
    }
    @Then("student should see dashboard")
    public void student_should_see_dashboard() {

        wait.until(ExpectedConditions.visibilityOf(loginPage.studentDashboard));

        String expectedText="Test Student 1";
      String actualText= loginPage.studentDashboard.getText();

        Assert.assertTrue("The dashboard did not match ",actualText.contains(expectedText));
        loginPage.studentDashboard.click();
        loginPage.logOut.click();
    }
    @When("librarian enters username")
    public void librarian_enters_username() {
       loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("librarianUsername"));
    }
    @When("librarian enters password")
    public void librarian_enters_password() {
        loginPage.passWord.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
    }
    @When("librarian click login button")
    public void librarian_click_login_button() {
        loginPage.signBtn.click();
    }
    @Then("librarian should see his username displayed.")
    public void librarian_should_see_his_username_displayed() {

        wait.until(ExpectedConditions.titleIs("Library"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.librarianDashboard));

        String expected= "Test Librarian 1";
        String actual=loginPage.librarianDashboard.getText();

        Assert.assertTrue("The dashboard did not match",actual.contains(expected));
    }

}

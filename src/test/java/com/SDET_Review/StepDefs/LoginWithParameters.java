package com.SDET_Review.StepDefs;

import com.SDET_Review.pages.DataTableLibrary;
import com.SDET_Review.pages.LoginPage;
import com.SDET_Review.utilities.ConfigurationReader;
import com.SDET_Review.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginWithParameters {
    LoginPage loginPage=new LoginPage();
    DataTableLibrary dataTableLibrary=new DataTableLibrary();

    @Given("user is in the login page of library application")
    public void user_is_in_the_login_page_of_library_application() {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryURL"));
    }

    @When("librarian enters username {string} and password {string}")
    public void librarian_enters_username_and_password(String username, String password) {
      loginPage.emailInput.sendKeys(username);
      loginPage.passWord.sendKeys(password);

    }
    @When("librarian clicks login button")
    public void librarian_clicks_login_button() {
        loginPage.signBtn.click();
    }
    @Then("librarian should see his username {string} displayed in the page")
    public void librarian_should_see_his_username_displayed_in_the_page(String userName) {
       dataTableLibrary.userNameText.getText().contains(userName);
        System.out.println("dataTableLibrary.userNameText.getText() = " + dataTableLibrary.userNameText.getText());
    }

    @When("student enters username {string} and password {string}")
    public void student_enters_username_and_password(String stdtUserName, String stdPassword) {
        loginPage.emailInput.sendKeys(stdtUserName);
        loginPage.passWord.sendKeys(stdPassword);
    }

    @When("students clicks login button")
    public void students_clicks_login_button() {
       loginPage.signBtn.click();
    }
    @Then("student should see his username {string} displayed in the page")
    public void student_should_see_his_username_displayed_in_the_page(String username) {
        dataTableLibrary.studentDashboard.getText().contains(username);
        System.out.println("dataTableLibrary.userNameText.getText() = " + dataTableLibrary.studentDashboard.getText());
    }

}

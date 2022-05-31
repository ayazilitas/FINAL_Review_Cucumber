package com.SDET_Review.StepDefs;

import com.SDET_Review.pages.DataTableLibrary;
import com.SDET_Review.pages.LoginPage;
import com.SDET_Review.utilities.ConfigurationReader;
import com.SDET_Review.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DataTableSteps {
    DataTableLibrary dataTableLibrary = new DataTableLibrary();
    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page of Library App")
    public void user_is_on_the_login_page_of_library_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryURL"));
    }

    @When("user enters username and password and clicks login button")
    public void user_enters_username_and_password_and_clicks_login_button(Map<String, String> Cridentials) {

        String username = Cridentials.get("username");
        String password = Cridentials.get("password");

        dataTableLibrary.emailInput.sendKeys(username);
        dataTableLibrary.passWord.sendKeys(password);

        dataTableLibrary.signBtn.click();


    }

    @Then("user should see dashboard")
    public void user_should_see_dashboard() throws InterruptedException {

        Thread.sleep(2000);
        String expected = "Test Student 1";
        String actualText = dataTableLibrary.userNameText.getText();

        Assert.assertEquals("The Username did not match", expected, actualText);

    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectationsMonth) {
        Select select=new Select(dataTableLibrary.monthDropdown);
        List<WebElement> list=select.getOptions();
        List<String> actualMonths=list.stream().map(WebElement::getText).collect(Collectors.toList());
        //for (WebElement each: list) {
        //   actualMonths.add(each.getText());
        //}

        for (int i = 0; i <=expectationsMonth.size()-1 ; i++) {
            System.out.println("actualMonths = " + actualMonths.get(i));
            System.out.println("expectedMonths = " + expectationsMonth.get(i));
            assertEquals("Month did not match.",expectationsMonth.get(i),actualMonths.get(i));
        }

    }


    @Given("librarian is on the login page of the app")
    public void librarian_is_on_the_login_page_of_the_app() {

        Driver.getDriver().get(ConfigurationReader.getProperty("libraryURL"));
    }

    @When("librarian enters {string} and {string} and clicks login button")
    public void librarian_enters_and_and_clicks_login_button(String username, String password) {
        dataTableLibrary.emailInput.sendKeys(username);
        dataTableLibrary.passWord.sendKeys(password);
        dataTableLibrary.signBtn.click();
    }
    @When("librarian clicks user link")
    public void librarian_clicks_user_link() {
        dataTableLibrary.usersLink.click();
    }
    @Then("librarian should see page dropdown numbers")
    public void librarian_should_see_page_dropdown_numbers(List<Integer>numberPage) {

        Select select=new Select(dataTableLibrary.pageDropDown);
        List<WebElement>list=select.getOptions();
       List<Integer> actualNumberPage=new ArrayList<>();

        for (WebElement eachPage : list) {
            actualNumberPage.add(Integer.parseInt(eachPage.getText().trim()));

        }

        assertEquals("Page Size did Not match",numberPage.size(),actualNumberPage.size());

        for (int i = 0; i <=numberPage.size()-1 ; i++) {
            System.out.println("actualNumberPerPage = " + actualNumberPage.get(i));
            System.out.println("numberPerPage = " + numberPage.get(i));
            assertEquals("Numbers did not match.",numberPage.get(i),actualNumberPage.get(i));
        }
    }

}


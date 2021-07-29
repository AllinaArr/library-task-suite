package com.library.stepDefinition;

import com.library.pages.LandingPage;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url = ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        String username = ConfigurationReader.getProperty("lib22_user");
        String password = ConfigurationReader.getProperty("lib22_pass");

        loginPage.inputEmail.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.signInButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expectedTitle = "dashboard";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expectedTitle));

        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expectedTitle));

       //Driver.closeDriver();
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        String usernameStudent = ConfigurationReader.getProperty("student95_user");
        String passwordStudent = ConfigurationReader.getProperty("student95_pass");

        loginPage.inputEmail.sendKeys(usernameStudent);
        loginPage.inputPassword.sendKeys(passwordStudent);
        loginPage.signInButton.click();
    }

    //---------------------Task 2--------------------------
    @When("I enter username {string}")
    public void i_enter_username(String string1) {
       // String username = string1;
        loginPage.inputEmail.sendKeys(string1);

    }
    @When("I enter password {string}")
    public void i_enter_password(String string2) {
       // String password = string2;
        loginPage.inputPassword.sendKeys(string2);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInButton.click();
    }

    @When("there should be {int} users")
    public void there_should_be_users(Integer int1) {
        int expectedUserNumber = int1;
        wait.until(ExpectedConditions.visibilityOf(landingPage.userCount));

        String expected = String.valueOf(expectedUserNumber);
        String actual = landingPage.userCount.getText();

        Assert.assertEquals("Actual user number is not as expected!", actual, expected);

    }

    @Then("books should be displayed")
    public void books_should_be_displayed() {
        String expected = "books";

        wait.until(ExpectedConditions.urlContains(expected));

        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));

        Driver.closeDriver();
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String stringName, String stringPassword) {
        loginPage.inputEmail.sendKeys(stringName);
        loginPage.inputPassword.sendKeys(stringPassword);
        loginPage.signInButton.click();

    }


}

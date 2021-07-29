package com.library.stepDefinition;

import com.library.pages.LandingPage;
import com.library.pages.LoginPage;
import com.library.pages.PageBase;
import com.library.pages.UsersPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Locale;

public class PageNavigations_stepDefinitions {
    UsersPage usersPage = new UsersPage();
    LandingPage landingPage = new LandingPage();
    PageBase pageBase = new PageBase();
    Select select;

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        switch(link.toLowerCase()){
            case "dashboard":
                pageBase.dashboardButton.click();
                break;
            case "users":
                pageBase.usersButton.click();
                break;
            case "books":
                pageBase.booksButton.click();
                break;

        }
    }
    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {
        BrowserUtils.waitForVisibility(usersPage.showRecordsDropdown, 5);
        select = new Select(usersPage.showRecordsDropdown);
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected+"", actual);
    }


    @Then("show records should have following options:")
    public void show_records_should_have_following_options(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}

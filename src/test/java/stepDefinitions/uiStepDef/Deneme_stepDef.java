package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import java.util.List;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class Deneme_stepDef {


    @Given("tag kullanarak")
    public void tagKullanarak() {

    }

    @Given("Scenario Outline {string} and {string}")
    public void scenarioOutlineAnd(String email, String password) {
     //Assert.fail();
        BrowserUtilities.loginMethod(email, password);
    }

    @Given("Configuration properties kullanarak")
    public void configurationPropertiesKullanarak() {
        BrowserUtilities.loginMethod(
                ConfigurationReader.getProperty("sellerEmail"),
                ConfigurationReader.getProperty("sellerPassword"));
    }

    @Given("Data table kullanarak")
    public void dataTableKullanarak(DataTable dataTable) {
        List<String> emails = dataTable.column(0);
        List<String> passwords = dataTable.column(1);

        for (int i = 0; i < emails.size(); i++) {
            BrowserUtilities.loginMethod(emails.get(i), passwords.get(i));
            BrowserUtilities.localClear();
            BrowserUtilities.wait(3);


        }
    }

    @Given("Scenario icinde {string} and {string}")
    public void scenarioIcindeAnd(String email, String password) {
        BrowserUtilities.loginMethod(email, password);

    }
}

package com.qa.stepDefinitions;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomePageSteps extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	@Given("^user opens browser$")
	public void user_opens_browser() {
		TestBase.initialization();

	}

	@Then("^user is on login Page$")
	public void user_is_on_login_Page() {
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);

	}

	@Then("^user logs into app$")
	public void user_enters_username_and_password() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Then("^validate home page title$")
	public void validate_home_page_title() {
		String homeTitle = homePage.validateHomePageTitle();
		Assert.assertEquals("CRMPRO", homeTitle);

	}

}

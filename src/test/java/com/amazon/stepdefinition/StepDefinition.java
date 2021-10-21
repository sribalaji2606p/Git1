package com.amazon.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.adactin.helper.FileReaderManager;
import com.amazon.runner.TestRunner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import newCart.BaseClass;

public class StepDefinition extends BaseClass {
	
	
	public static WebDriver driver = TestRunner.driver;
	
	@Given("Launch the application sign-in page")
	public void launch_the_application_sign_in_page() {
		
		BaseClass.getUrl("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	}
	
	@When("Enter UserName")
	public void enter_user_name() throws Throwable {
		
		String userName = FileReaderManager.getInstanceFRM().getInstanceCR().getUserName();
		driver.findElement(By.id("ap_email")).sendKeys(userName);
	}
	
	@When("Click continue button")
	public void click_continue_button() {
		driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
	}
	
	@When("Enter Password")
	public void enter_password() throws Throwable {
		String password = FileReaderManager.getInstanceFRM().getInstanceCR().getPassword();
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
	}
	
	@When("Click sign-in button")
	public void click_sign_in_button() {
		driver.findElement(By.className("a-button-input")).click();
	}
	
	@Then("User to be navigated to Homepage")
	public void user_to_be_navigated_to_homepage() {
		BaseClass.getTitle().equalsIgnoreCase(" Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	
	@Given("Refresh the homepage")
	public void refresh_the_homepage() {
		
	}
	
	@When("Click Returns and Orders icon")
	public void click_returns_and_orders_icon() {
		driver.findElement(By.xpath("//a[@href=\"/gp/css/order-history?ref_=nav_orders_first\"]")).click();
	}
	
	@Then("User to be naviagted to Your Orders page")
	public void user_to_be_naviagted_to_your_orders_page() {
		
		BaseClass.getTitle().equalsIgnoreCase("Your Orders");
		
	}
	
	@Given("Your order page to be opened")
	public void your_order_page_to_be_opened() {
		
		BaseClass.getTitle().equalsIgnoreCase("Your Orders");
	}
	
	@When("Extract the order number and paste it in search bar")
	public void extract_the_order_number_and_paste_it_in_search_bar() throws Throwable {
		String orderNumber = FileReaderManager.getInstanceFRM().getInstanceCR().getOrderNumber();
		
		WebElement searchBar = driver.findElement(By.xpath("//input[@type=\"search\"]"));
		searchBar.sendKeys(orderNumber);		
	}
	
	@And("Click serach button")
	public void click_serach_button() {
		
		driver.findElement(By.className("a-button-input")).click();
	}
	
	@Then("Order details have to be displayed")
	public void order_details_have_to_be_displayed() throws Throwable {
		
		String orderNumVerification = driver.findElement(By.xpath("(//span[@class=\"a-color-secondary value\"])[3]")).getText();
		orderNumVerification.equalsIgnoreCase(FileReaderManager.getInstanceFRM().getInstanceCR().getOrderNumber());
	}
	
	@When("Click Track Package button")
	public void click_track_package_button() {
		
		driver.findElement(By.xpath("(//a[@class=\"a-button-text\"])[1]")).click();
	}
	
	@Then("Road map along with ETA and shipping address to be displayed")
	public void road_map_along_with_eta_and_shipping_address_to_be_displayed() throws InterruptedException {
		
		driver.findElement(By.xpath("(//h1[@class=\"a-spacing-small widgetHeader\"])[1]")).getText().equalsIgnoreCase("Shipping Address");
		BaseClass.getScreenShot("E:\\Java\\AmazonAutomation\\Screenshots\\Tracking.png");
	}
	
	@When("Click Cancel Item button")
	public void click_cancel_item_button() {
		driver.get("https://www.amazon.in/gp/your-account/order-details/?orderID=408-1058337-8689920&ref=ppx_pt2_dt_b_breadcrumb_detail");
		driver.findElement(By.id("Request-cancellation_1")).click();

	}
	@When("Select the items to be cancelled")
	public void select_the_items_to_be_cancelled() {
		
	}
	@When("Select the cancellation reason")
	public void select_the_cancellation_reason() {
		
		WebElement cancellationReason = driver.findElement(By.xpath("//select[@name=\"cancel.reason\"]"));
		BaseClass.SelectDropDown(cancellationReason, "Index", "1");
	
	}
	@When("Click Request Cancellation")
	public void click_request_cancellation() {
		driver.findElement(By.xpath("//*[@id=\"cancelButton\"]/span/input")).click();
	}
	@Then("User to be navigated to your order page")
	public void user_to_be_navigated_to_your_order_page() {
		
		BaseClass.getTitle().equalsIgnoreCase("Your Orders");
		driver.close();
	}


	

}

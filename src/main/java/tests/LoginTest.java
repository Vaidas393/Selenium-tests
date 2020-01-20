package tests;

import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Utils.Utils;
import pageobject.*;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest {

	public WebDriver driver;
	public Login login;
	Utils util = new Utils();

	@Test
	public void Should_Not_Be_Able_To_Login_When_Providing_Invalid_Password() {
		Login login = new Login(driver);
		login.login("belekas", "1213213");

		Assert.assertEquals(login.getLoginError().getText(), "Incorrect value: Invalid login or password.",
				"Validation message is missing");
	}

	@Test
	public void Should_Not_Be_Able_To_Login_When_Providing_Invalid_UserName() throws InterruptedException {
		Login login = new Login(driver);
		login.login("error", util.getUsername());

		Assert.assertEquals(login.getLoginError().getText(), "Incorrect value: Invalid login or password.",
				"Validation message is missing");
	}

	@Test
	public void Should_Be_Able_To_Login() throws InterruptedException {
		Login login = new Login(driver);
		login.login(util.getUsername(), "vaidas393@gmail.com");

		Assert.assertTrue(driver.manage().getCookies().toString().contains("WebIssuesSID"),
				"WebIssues cookies does exist");
	}

	@Test(groups = { "smooke", "checkintest" })
	public void Should_Not_Find_Cookies() throws InterruptedException {
		Login login = new Login(driver);
		login.login("vaidas393@gmail.com", "vaidas393@gmail.com");
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();
		Cookie cookie = driver.manage().getCookieNamed("WebIssuesSID");
		boolean noCookieFound = false;
		try {
			cookie.getValue();
		} catch (Exception e) {
			noCookieFound = true;
		}

		Assert.assertTrue(noCookieFound, "cookie was found");
	}

	@BeforeClass(groups = { "smooke", "checkintest" })
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		Login login = new Login(driver);
		Utils util = new Utils();
		driver.manage().window().maximize();
		login.login(util.getUsername(), util.getUsername());
	}

	@AfterClass(groups = { "smooke", "checkintest" })
	public void afterClass() {
//      driver.quit();
	}

}

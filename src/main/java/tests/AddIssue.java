package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utils.Utils;
import pageobject.*;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddIssue {

	public WebDriver driver;
	public CreateIssue createIssue;
	Login login = new Login(driver);
	Utils utils = new Utils();

	@Test
	public void Should_Create_Issue_Ok() throws InterruptedException {
		createIssue = new CreateIssue(driver);

		createIssue.add(utils.generateName(15), "asdasdasddas", "Vaidas", utils.status(), "Fixed",
				utils.generateSeverity(1, 2));

		Assert.assertEquals(createIssue.getCommentDescription().getText(), "asdasdasddas", "Issue exists");

	}

	@Test
	public void Should_Not_Create_Issue_Without_Name() throws InterruptedException {
		createIssue = new CreateIssue(driver);

		createIssue.add("", utils.generateDescription(20), "Vaidas", utils.status(), "Fixed",
				utils.generateSeverity(10, 100));

		Assert.assertEquals(createIssue.getErrorMessage().getText(), "Some of the values you entered are incorrect.",
				"Issue exists");

	}


	@Test
	public void Should_Not_Create_Issue_Wit_Severity_Too_Big() throws InterruptedException {
		createIssue = new CreateIssue(driver);

		createIssue.add(utils.generateName(15), utils.generateDescription(20), "vaidas", utils.status(), "Fixed",
				utils.generateSeverity(10, 25));

		Assert.assertEquals(createIssue.getSeverityError().getText(), "Incorrect value: Number is too big.", "Ok");

	}

	@Test
	public void Should_Create_Issue_Wit_Assigned_Valid() throws InterruptedException {
		createIssue = new CreateIssue(driver);

		createIssue.add(utils.generateName(15), "asdasdasddas", "Vaidas", utils.status(), "Fixed",
				utils.generateSeverity(1, 2));

		Assert.assertEquals(createIssue.getCommentDescription().getText(), "asdasdasddas", "Issue exists");

	}

	@Test
	public void Should_Not_Create_Issue_Wit_Assigned_Invalid() throws InterruptedException {
		createIssue = new CreateIssue(driver);

		createIssue.add(utils.generateName(15), utils.generateDescription(20), "asdasdasdasd", utils.status(), "Fixed",
				utils.generateSeverity(10, 25));

		Assert.assertEquals(createIssue.getAssignedError().getText(), "Incorrect value: No matching item is selected.",
				"Ok");

	}

	@Test
	public void Should_Create_Issue_Wit_Reason_Fixed() throws InterruptedException {
		createIssue = new CreateIssue(driver);

		createIssue.add(utils.generateName(15), "asdasdasddas", "Vaidas", utils.status(), "Fixed",
				utils.generateSeverity(1, 2));

		Assert.assertEquals(createIssue.getCommentDescription().getText(), "asdasdasddas", "Issue exists");

	}

	@Test
	public void Should_Not_Create_Issue_Wit_Reason_Invalid() throws InterruptedException {
		createIssue = new CreateIssue(driver);

		createIssue.add(utils.generateName(15), "asdasdasddas", "asdasdasdasd", utils.status(), "sadasdasdds",
				utils.generateSeverity(10, 25));

		Assert.assertEquals(createIssue.getAssignedError().getText(), "Incorrect value: No matching item is selected.",
				"Ok");

	}

	@Test
	public void Should_Not_Create_Issue_Severity_Too_Big() throws InterruptedException {
		createIssue = new CreateIssue(driver);

		createIssue.add(utils.generateName(15), "asdasdasddas", "asdasdasdasd", utils.status(), "sadasdasdds",
				utils.generateSeverity(10, 25));

		Assert.assertEquals(createIssue.getSeverityError().getText(), "Incorrect value: Number is too big.", "Ok");

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Login login = new Login(driver);
		login.login("vaidas393@gmail.com", "vaidas393@gmail.com");
	}

	@AfterClass
	public void afterClass() {
//      driver.quit();
	}

}

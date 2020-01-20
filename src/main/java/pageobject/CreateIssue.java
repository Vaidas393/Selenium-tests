package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Utils;
import pageobject.*;

public class CreateIssue extends PageObject {
	
	public Utils util = new Utils();

    @FindBy(linkText="Add Issue")
    private WebElement addBtn;

    @FindBy(id="field-issues-issueName")
    private WebElement issueName;

    @FindBy(id="field-issues-descriptionText")
    private WebElement description;
    
    @FindBy(id = "field-issues-okSubmit")
    private WebElement submitBtn;
    
    @FindBy(className = "comment-text")
    private WebElement commentDescription;
    
    @FindBy(id = "field-issues-value4")
    private WebElement severity;

    @FindBy(className = "error")
    private WebElement errorMessage;
      
    @FindBy(xpath = "//*[@id=\"form-issues\"]/div/div[2]/div[5]/p")
    private WebElement severityError;
    
    @FindBy(id = "field-issues-value1")
    private WebElement assignedTo;
    
    @FindBy(id = "field-issues-value2")
    private WebElement status;
    
    @FindBy(id = "field-issues-value3")
    private WebElement reason;
    
    @FindBy(xpath = "//*[@id=\"form-issues\"]/div/div[2]/div[2]/p")
    private WebElement assignedError;
    
    @FindBy(xpath = "//*[@id=\"form-issues\"]/div/div[2]/div[3]/p")
    private WebElement statusError;
    
    public CreateIssue(WebDriver driver) {
        super(driver);
    }

 
      public void add(String name, String description, String assigned, String status, String reason, String severity) throws InterruptedException{
      driver.get("http://www.qaontime.com/register/client/index.php?folder=5)");
      this.addBtn.click();
      
      boolean nameExists = false;
      while(!nameExists) {
          this.issueName.clear();
          this.issueName.sendKeys(name);
          if(this.issueName.getAttribute("value").equals(name)) {
        	  nameExists = true;
          }
      }
      
      this.issueName.clear();
      this.issueName.sendKeys(name);
      this.severity.sendKeys(severity);
      this.severity.clear();
      this.severity.sendKeys(severity);
      this.assignedTo.sendKeys(assigned);
      this.status.clear();
      this.status.sendKeys(status);
      this.reason.clear();
      this.reason.sendKeys(reason);
      this.description.clear();
      this.description.sendKeys(description);
      this.submitBtn.click();
    }
    
    public WebElement getAddBtn() {
    	return addBtn;
    }
    
    public WebElement getIssueName() {
    	return issueName;
    }
    
    public WebElement getDescription() {
    	return description;
    }
    
    public WebElement getSubmitBtn() {
    	return submitBtn;
    }
    
    public WebElement getCommentDescription() {
    	return commentDescription;
    }
    
    public WebElement getSeverity() {
    	return severity;
    }
    
    public WebElement getErrorMessage() {
    	return errorMessage;
    }
    
    public WebElement getSeverityError() {
    	return severityError;
    }
    
    public WebElement getAssignedTo() {
    	return assignedTo;
    }
    
    public WebElement getAssignedError() {
    	return assignedError;
    }
    
    public WebElement getStatus() {
    	return status;
    }
    
    public WebElement getReasons() {
    	return reason;
    }
 }


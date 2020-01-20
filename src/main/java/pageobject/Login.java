package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.*;

public class Login extends PageObject {

    @FindBy(id="field-login-login")
    private WebElement logInField;

    @FindBy(id="field-login-password")
    private WebElement passField;

    @FindBy(id="field-login-loginSubmit")
    private WebElement loginSubmitButton;
    
    @FindBy(className = "error")
    private WebElement loginError;
    
    @FindBy(xpath = "//*[@id=\"infobar-right\"]/a[2]")
    private WebElement logOut;

    public Login(WebDriver driver) {
        super(driver);
    }

   public void login(String userName, String password){
	   driver.get("http://www.qaontime.com/register");
	   this.logInField.clear();
	   this.passField.clear();
       this.logInField.sendKeys(userName);
       this.passField.sendKeys(password);
       this.loginSubmitButton.click();
    }
    
    public WebElement getLogInField() {
    	return logInField;
    }
    
    public WebElement getPassField() {
    	return passField;
    }
    
    public WebElement getLoginSubmitButton() {
    	return loginSubmitButton;
    }
    
    public WebElement getLoginError() {
    	return loginError;
    }
    
    public WebElement getLogOut() {
        return logOut;
    }
}
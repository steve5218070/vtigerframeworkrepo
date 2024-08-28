package vtiger.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//this is a constructor for LoginPage
	public LoginPage(WebDriver driver){
PageFactory.initElements(driver, this);
	}
	//here identifying the elements of login page
	@FindBy(name="user_name")
	private WebElement username_TextField;
	@FindBy(name="user_password")
	private WebElement password_TextField;
	@FindBy(id="submitButton")
	private WebElement LoginButton;
	public WebElement getUsername_TextField() {
		return username_TextField;
	}
	public WebElement getPassword_TextField() {
		return password_TextField;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}

	/**
	 * This method is used login as user 
	 */
	public void loginAction(String username,String password)
	{
		username_TextField.sendKeys(username);
		password_TextField.sendKeys(password);
		LoginButton.click();
	}
}


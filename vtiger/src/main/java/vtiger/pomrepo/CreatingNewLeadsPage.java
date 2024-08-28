  package vtiger.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadsPage {
public CreatingNewLeadsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(name="salutationtype")
private WebElement leadSalutionDropdown;
@FindBy(name="firstname")
private WebElement leadFirstNameTextField;
@FindBy(name="lastname")
private WebElement lastNameTextField;
@FindBy(name="company")
private WebElement leadCompanyNameTextField;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement leadSaveButton;
public WebElement getLeadSalutionDropdown() {
	return leadSalutionDropdown;
}
public WebElement getLeadFirstNameTextField() {
	return leadFirstNameTextField;
}
public WebElement getLastNameTextField() {
	return lastNameTextField;
}
public WebElement getLeadCompanyNameTextField() {
	return leadCompanyNameTextField;
}
public WebElement getLeadSaveButton() {
	return leadSaveButton;
}
public void selectFromLeadSalutationDropDown(String salutation)
{
	Select select= new Select(leadSalutionDropdown);
	select.selectByVisibleText(salutation);
}
public void enterLeadFirstName(String leadFirstName) {
	leadFirstNameTextField.sendKeys(leadFirstName);
}
public void enterLeadLastName(String leadLastName) {
	lastNameTextField.sendKeys(leadLastName);
}
public void enterLeadCompanyName(String leadCompanyName) {
	leadCompanyNameTextField.sendKeys(leadCompanyName);
}
public void clickOnSaveButton() {
	leadSaveButton.click();

}
}

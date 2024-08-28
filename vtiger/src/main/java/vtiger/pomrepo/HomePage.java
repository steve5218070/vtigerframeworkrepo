  package vtiger.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is an object repository for Home Page
 * 
 * @author Bal Krishna Sharma
 *
 */
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(linkText="Leads")
	private WebElement leadLinks;
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLinks;
	@FindBy(linkText="Contacts")
	private WebElement ContactsLinks;
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLinks;
	@FindBy(linkText="Products")
	private WebElement ProductsLinks;
	@FindBy(linkText="More")
	private WebElement moredropdownLinks;
	@FindBy(linkText="Vendors")
	private WebElement VendorsLinks;
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLinks;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministrationLinks;
	@FindBy(linkText="Sign Out")
	private WebElement SignoutLinks;
	public WebElement getLeadLinks() {
		return leadLinks;
	}
	//Getter Methods
	public WebElement getOrganizationLinks() {
		return OrganizationLinks;
	}
	public WebElement getContactsLinks() {
		return ContactsLinks;
	}
	public WebElement getOpportunitiesLinks() {
		return OpportunitiesLinks;
	}
	public WebElement getProductsLinks() {
		return ProductsLinks;
	}
	public WebElement getMoredropdownLinks() {
		return moredropdownLinks;
	}
	public WebElement getVendorsLinks() {
		return VendorsLinks;
	}
	public WebElement getCampaignsLinks() {
		return CampaignsLinks;
	}
	public WebElement getAdministrationLinks() {
		return AdministrationLinks;
	}
	public WebElement getSignoutLinks() {
		return SignoutLinks;
	}
	public void  clickOnLeadModule() {
		leadLinks.click();
	}
	public void clickOnOrganizationsModule() {
		OrganizationLinks.click();
	}
	public void clickOnOpportunitiesModule() {
		OpportunitiesLinks.click();
	}
	public void clickOnProductsModule() {
		ProductsLinks.click();
	}
	public void clickOnmoredropdownModule() {
		moredropdownLinks.click();
	}
	/**
	 * This method is used to mouse hover on More dropdown and click on Vendor
	 * Module
	 */
	 
	public void clickOnVendorsModule() {
		Actions action =new Actions(driver);
		action.moveToElement(moredropdownLinks).perform();
		action.click(VendorsLinks).perform();
	}
	/**
	 * This method is used to mouse hover on More dropdown and click on Campaign
	 * Module
	 */
	 
	public void clickOnCampaignsModule() {
		Actions action = new Actions(driver);
		action.moveToElement(moredropdownLinks).perform();
		action.click(CampaignsLinks).perform();
	}
	public void clickOnAdministrationModule() {
		AdministrationLinks.click();
	}
	/**
	 * This method is used to mouse hover on administrator icon and click on sign
	 * out module
	 */
	public void clickOnleadModule() {
		leadLinks.click();
	}
	public void logoutAction() {
		Actions action = new Actions(driver);
		action.moveToElement(AdministrationLinks).perform();
		action.click(SignoutLinks).perform();;
	}
	
}

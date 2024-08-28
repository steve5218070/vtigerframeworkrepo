 package vtiger.opportunity_module;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.genericutility.BaseClass;
import vtiger.genericutility.IPathConstant;
import vtiger.pomrepo.CompaignInformationPage; 
import vtiger.pomrepo.CompaignPage;
import vtiger.pomrepo.CreatingNewCompaignPage;
import vtiger.pomrepo.CreatingNewOpportunity;
import vtiger.pomrepo.CreatingNewOrganizationPage;
import vtiger.pomrepo.HomePage;
import vtiger.pomrepo.OpportunityInformationPage;
import vtiger.pomrepo.OpportunityPage;
import vtiger.pomrepo.OrganizationInformationPage;
import vtiger.pomrepo.OrganizationPage;
//implimentation class ka path dikhaunga with the help of listeners agar testcase fail ho jaye to uska screenshot lena hai
@Listeners(vtiger.genericutility.ItestListenersImplemantationClass.class)
public class ToCreateOpportunityTest extends BaseClass {
	@Test(retryAnalyzer = vtiger.genericutility.IRetryAnalyzerImplementationClass.class)
	//method name should be kept same as test case name 
	public void createOpportunityAndVerifyOpportunity() throws EncryptedDocumentException, IOException {

		String organizationName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.ORGANIZATION_SHEAT_NAME, 1, 0);
		String campaignName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.CAMPAIGN_SHEAT_NAME, 1, 0);
		String opportunityName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEAT_NAME, 1, 0);
		String organizationLookUpPageTitle = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEAT_NAME,
				1, 1);
		String campaignLookUpPageTitle = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEAT_NAME, 1,
				2);

		HomePage home = new HomePage(driver);
		OrganizationPage organization = new OrganizationPage(driver);
		CreatingNewOrganizationPage createOrganization = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo = new OrganizationInformationPage(driver);
		
		
		CompaignPage compaign = new CompaignPage(driver);
		CreatingNewCompaignPage createCampaign = new CreatingNewCompaignPage(driver);
		CompaignInformationPage campagnInfo = new CompaignInformationPage(driver);

		OpportunityPage opportunity = new OpportunityPage(driver);
		CreatingNewOpportunity createOpportunity = new CreatingNewOpportunity(driver);
		OpportunityInformationPage opportunityInfo = new OpportunityInformationPage(driver);

		Assert.fail();
		home.clickOnOrganizationsModule();
		organization.clickOnAddOrganizationButton();
		createOrganization.enterOrganizationName(organizationName);
		createOrganization.clickOnSaveButton();
		String actualOrganization = organizationInfo.verifyOrganizationInformation(organizationName);

		Assert.assertTrue(actualOrganization.contains(organizationName));
		System.out.println("Pass: organization has been created");

		home.clickOnCampaignsModule();
		compaign.clickOnAddCampagnButton();
		createCampaign.enterCampaignName(campaignName);
		createCampaign.clickOnSaveButton();
		String actualCampaignName = campagnInfo.verifyCampaignInformation(campaignName);

		Assert.assertTrue(actualCampaignName.contains(campaignName));
		System.out.println("Pass: campaign has been created");

		home.clickOnOpportunitiesModule();
		opportunity.clickOnAddOpportunityButton();
		createOpportunity.enterOpportunityName(opportunityName);
		createOpportunity.selectOrganizationNameFromOrganizationLookUpPage(organizationLookUpPageTitle,
				organizationName);
		createOpportunity.selectCampagnNameFromCampaignLookUpPage(campaignLookUpPageTitle, campaignName);
		createOpportunity.clickOnSaveButton();

		String actualOpportunityName = opportunityInfo.verifyOpportunityInformation(opportunityName);

		Assert.assertTrue(actualOpportunityName.contains(opportunityName));
		System.out.println("Pass: opportunity has been created");

	}
}

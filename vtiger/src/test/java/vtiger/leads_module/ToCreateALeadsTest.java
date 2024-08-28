package vtiger.leads_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.genericutility.BaseClass;
import vtiger.genericutility.IPathConstant;
import vtiger.pomrepo.CreatingNewLeadsPage;
import vtiger.pomrepo.HomePage;
import vtiger.pomrepo.LeadInformationPage;
import vtiger.pomrepo.LeadsPage;

@Listeners(vtiger.genericutility.ItestListenersImplemantationClass.class)
public class ToCreateALeadsTest extends BaseClass {

		
		@Test
		public void toCreateALeadAndToVerifyTheLeadinformationTest() throws EncryptedDocumentException, IOException {
			String leadSalutation = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEAT_NAME, 1, 0);
			String leadFirstName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEAT_NAME, 1, 1);
			String leadLastName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEAT_NAME, 1, 2);
			String leadCompanyName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEAT_NAME, 1, 3);

			HomePage home = new HomePage(driver);
			LeadsPage leads = new LeadsPage(driver);
			CreatingNewLeadsPage createLeads = new CreatingNewLeadsPage(driver);
			LeadInformationPage leadInfo = new LeadInformationPage(driver);
			
			home.clickOnleadModule();
			leads.clickOnAddLeadButton();
			createLeads.selectFromLeadSalutationDropDown(leadSalutation);
			createLeads.enterLeadFirstName(leadFirstName);
			createLeads.enterLeadLastName(leadLastName);
			createLeads.enterLeadCompanyName(leadCompanyName); 
			createLeads.clickOnSaveButton();
			
			String actualLeadInfo = leadInfo.verifyleadInformation(leadFirstName, leadLastName);
			
			Assert.assertTrue(actualLeadInfo.contains(leadLastName));
			System.out.println("Pass: the lead has been created");
			
		}
}

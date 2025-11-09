package projectMilestonesTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.basetest.BaseClass;
import com.crm.objectRepositoryUtility.CreateNewMilestonePage;
import com.crm.objectRepositoryUtility.CreateNewProjectsPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.MilestoneWindowPage;
import com.crm.objectRepositoryUtility.ProjectMilestoneInfoPage;
import com.crm.objectRepositoryUtility.ProjectMilestonePage;
import com.crm.objectRepositoryUtility.ProjectsPage;
@Listeners(com.crm.listenerutility.ListImpClass.class)
public class ProjectMilestoneNameTest extends BaseClass {
	@Test(groups="SmokeTest")
	public void MilestoneNameTest() throws Throwable {
	    String milestoneName = eutil.getDataFromExcel("MilestoneName",1,2);
	    String projectName = eutil.getDataFromExcel("MilestoneName",1,3);
	    String childWindow = eutil.getDataFromExcel("MilestoneName",1,4);
	    String projparentWindow = eutil.getDataFromExcel("MilestoneName",1,5);
		
		HomePage hp=new HomePage(driver);
		hp.getMoreLink().click();
		hp.getProjectsLink().click();
		
		ProjectsPage pp=new ProjectsPage(driver);
		pp.getCreatenewprojectlookupimgicon().click();
		
		CreateNewProjectsPage cnpp=new CreateNewProjectsPage(driver);
		cnpp.getProjectnameTextfield().sendKeys(projectName);
		cnpp.getSavebutton().click();
		Reporter.log("project name created successfully",true);
		
		hp.getMoreLink().click();
		hp.getProjectMilestonesLink().click();
		Reporter.log("navigate to project milestone page successfully",true);
	    ProjectMilestonePage pmp=new ProjectMilestonePage(driver);
	    pmp.getProjectMilestoneLookupImgIcon().click();
	    
	    CreateNewMilestonePage cnmp=new CreateNewMilestonePage(driver);
	    cnmp.getProjectmilestonenameTextfield().sendKeys(milestoneName);
	    cnmp.getCreateprojectmilestonenamelookUpIcon().click();
		wutil.toHandleWindowByTitle(driver, childWindow);
		MilestoneWindowPage mwp=new MilestoneWindowPage(driver);
		mwp.getSearch_txtTextfield().sendKeys(projectName);
		mwp.getSearchButton().click();
		mwp.getProjectNameTextfield().click();
		wutil.toHandleWindowByTitle(driver,projparentWindow);
		cnmp.getSaveButton().click();
		Reporter.log("milestone name created successfully",true);
		
		ProjectMilestoneInfoPage pmip=new ProjectMilestoneInfoPage(driver);
		String actualProjMilestoneInfo =pmip.getMilestoneInfo().getText();
		boolean status = actualProjMilestoneInfo.contains(milestoneName);
		Assert.assertEquals(status, true);
		}
}

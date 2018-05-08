/**
 * 
 */
/**
 * @author Administrator
 *
 */
package BaiduTestCase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import PageAction.HomePage;
import PageAction.ResultPage;
import Utils.DriverHelper;
import junit.framework.Assert;


public class HomePageTestCase{
	public WebDriver driver = DriverHelper.get();
	public HomePage homePage;
	public ResultPage resultPage;
	public WebDriverWait wait;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws Exception{
		homePage = PageFactory.initElements(driver, HomePage.class);
		resultPage = PageFactory.initElements(driver, ResultPage.class);
		wait = new WebDriverWait(driver, 3000);
		
	}
	@Test(description = "should open baidu home page",priority = 1)
	public void testHomePage() throws Exception{
		homePage.openHomePage();
		wait.until(ExpectedConditions.visibilityOf(homePage.baiduLogo));
		homePage.inputSearchBox("Selenium");
		homePage.clickSubmitBtn();
		Assert.assertEquals(true, resultPage.firstAdSection.isDisplayed());
		
	}
	
	
	
}

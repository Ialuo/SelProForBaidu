/**
 * 
 */
/**
 * @author Administrator
 *
 */
package PageAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

	public HomePage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='lg']")
	public WebElement baiduLogo;
	@FindBy(xpath = "//input[@id='su']")
	public WebElement submitBtn;
	@FindBy(xpath = "//input[@id='kw']")
	public WebElement searchBox;
	
	
	public void clickSubmitBtn() throws Exception{
		click(submitBtn, "submit button", true);
	}
	public void inputSearchBox(String values) throws Exception{
		input(searchBox	, "search box",values);
	}
	public void openHomePage() throws Exception{
		driver.get("https://www.baidu.com/");
	}
	
	
}
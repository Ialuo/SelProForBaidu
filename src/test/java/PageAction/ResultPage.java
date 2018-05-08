package PageAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage  extends BasePage{

	public ResultPage(WebDriver driver) throws Exception {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//div[@id='content_left']")
	public WebElement firstAdSection;
	

}

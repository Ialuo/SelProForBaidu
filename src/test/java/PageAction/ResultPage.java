package PageAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage  extends BasePage{

	protected ResultPage(WebDriver driver) throws Exception {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//idv[@class='FwmJCe']")
	public WebElement firstAdSection;
	

}

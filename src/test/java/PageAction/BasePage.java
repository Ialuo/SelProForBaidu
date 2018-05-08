package PageAction;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected Logger logger = LogManager.getLogger(this.getClass().getName());
	protected String pageTitle;
	protected WebDriverWait wait;

	protected BasePage(WebDriver driver) throws Exception {
		this.driver = driver;
	}

	protected void input(WebElement e, String elementName, String values) throws Exception {
		e = findElement(e);
		e.clear();
		logger.info("Input " + elementName + ": " + values);
		e.sendKeys(values);
	}

	protected void click(WebElement e, String elementName, boolean isRedirect) throws Exception {
		e = findElement(e);
		logger.info("Click " + elementName);
		e.click();
		if (isRedirect)
			Thread.sleep(3000);
	}

	protected void select(WebElement e, String elementName, String value) throws Exception {
		Select select = new Select(e);
		try {
			logger.info("Select " + elementName + ": " + value);
			select.selectByValue(value);
		} catch (Exception notByValue) {
			logger.info("Select by VisibleText " + value);
			select.selectByVisibleText(value);
		}
	}

	public void clickTab() throws Exception {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB);
	}

	public String GetElementInputValue(WebElement e) {
		return e.getAttribute("value");
	}

	public String GetElementSelectValue(WebElement e) {
		String selectedOption = new Select(e).getFirstSelectedOption().getText();
		return selectedOption;
	}

	public boolean isElementExsit(WebElement e) {
		wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.visibilityOf(e)) == null) {
			logger.error("Element is not found!");
			return false;
		} else
			return true;
	}

	public WebElement findElement(WebElement e) {
		wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.visibilityOf(e)) == null) {
			logger.error("Element is not found!");
			return null;
		} else
			return e;
	}

	public boolean isPageLoaded(WebElement e) {
		wait = new WebDriverWait(driver, 30);
		boolean isDocComplete = wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
		if (!isDocComplete)
			logger.error("Page document is not completed!");
		wait = new WebDriverWait(driver, 30);
		boolean isCorrectTitle = wait.until(ExpectedConditions.titleContains(this.pageTitle));
		if (!isCorrectTitle)
			logger.error("Page title is incorrect!");
		boolean isElementFound = isElementExsit(e);
		return isDocComplete && isCorrectTitle && isElementFound;
	}

}

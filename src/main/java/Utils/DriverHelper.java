package Utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
	protected static WebDriver driver;
	protected static Properties p;
	protected static String config="D:\\Program Files (x86)\\SmartGit\\bin\\github.com\\zhiminliao\\SelProForBaidu\\config.properties";
	protected static String chromeDriver;
	protected static int iWaitTime;
	protected static Logger logger = LogManager.getLogger(DriverHelper.class);
	
	
	
	public synchronized static WebDriver get(){
		//if driver = null get it from config
		if(driver == null){
			try{
				p= ConfigUtils.getProperties(config);
			}
			catch(IOException e){
				e.printStackTrace();
			}
			if(p!= null){
				chromeDriver = p.getProperty("chromedriver");
				iWaitTime = Integer.parseInt(p.getProperty("WaitTime"));	
			}
			System.setProperty("webdriver.chrome.driver",chromeDriver);
			driver= new ChromeDriver();
			//logger.info("Start WebDriver");
			System.out.println();
			driver.manage().window().maximize();				  
		}
		return driver;
		
	}
	public static void stop(){
		driver.quit();
		logger.info("Stop WebDriver");
	}
	

}

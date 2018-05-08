package Utils;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
	protected static WebDriver driver;
	protected static Properties p;
	protected static String config="xxx";
	protected static String chromeDriver;
	protected static int iWaitTime;
	
	
	
	public synchronized static WebDriver get() throws IOException{
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
			System.setpro'
			
			
		}
		
	}
	

}

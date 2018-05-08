/**
 * 
 */
/**
 * @author Administrator
 *
 */
package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConfigUtils {
	protected static Logger logger = LogManager.getLogger(ConfigUtils.class);

	public static Properties getProperties(String config) throws IOException {
		Properties properties = new Properties();
		logger.info("Get the config file: "+config);
		FileInputStream inStream = new FileInputStream(new File(config));
		properties.load(inStream);
		return properties;
	}
}

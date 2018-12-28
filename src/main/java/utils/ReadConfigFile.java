package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	protected InputStream input = null;
	protected Properties prop = null;
	
	public ReadConfigFile() {
		//This method is used to read config file within properties package - read more!
		try {
			ReadConfigFile.class.getClassLoader().getResourceAsStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();
			prop.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		if (prop.getProperty("browser") ==null)
				return "";
		return prop.getProperty("browser");
	}

}

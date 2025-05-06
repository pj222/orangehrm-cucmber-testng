package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
 private Properties prop;
 
 public Properties init_prop() throws FileNotFoundException
 {
	  prop=new Properties();
	  FileInputStream fp=new FileInputStream("./src/test/resources/data.properties");
	  try {
		prop.load(fp);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return prop;
 }
}

package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility {
public String getDataFromPropertiesFile(String key) throws Throwable {
	FileInputStream fis=new FileInputStream("./comData/commonData.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String data = pobj.getProperty(key);
	return data;
}
}

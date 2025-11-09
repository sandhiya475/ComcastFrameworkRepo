package com.crm.generic.fileutility;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import com.google.gson.JsonObject;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws Throwable {
	FileReader fr=new FileReader("./comData/commonData.properties");
	JSONParser jp=new JSONParser();
	Object obj = jp.parse(fr);
	JsonObject map=(JsonObject) obj;
	String data = map.get(key).toString();
	return data;
}
}

package com.resolve.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

public class ReadProperties {
	public ReadProperties() {

	}

	private static HashMap<String, String> propertyMap = new HashMap<>(); // converting property into HashMap
	private static Properties property = new Properties();
	static {
		try {
			FileInputStream fil = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			property.load(fil);

			property.forEach((key, value) -> propertyMap.put(key.toString(), value.toString()));
			
		 /*  for (Map.Entry<Object, Object> entry : property.entrySet()) {
			 propertyMap.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())); }
		*/	 
       
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(propertyMap.get(key))) {
			throw new Exception("property Name" + key + " is not found please check config.properties file ");

		}

		return propertyMap.get(key);

	}

}

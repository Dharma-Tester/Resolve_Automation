package com.resolve.generic;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import com.creditdatamw.zerocell.Reader;
import com.resolve.generic.zerocell.TestData;

public class ExcelReader {
	
	private ExcelReader() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<TestData> testdatas = null;
	
	
	public static List<TestData> getTestdata() {
		return testdatas;
	}




	static {
		 testdatas = Reader.of(TestData.class)
				.from(new File("E:\\Dharma\\Resolve\\Mobile automation\\Test Project\\Resolve_Automation\\Resolve_web\\src\\test\\resources\\Automatecredential.xlsx"))
				.sheet("Sheet1")
				.skipHeaderRow(true)
				.list();
			}

}

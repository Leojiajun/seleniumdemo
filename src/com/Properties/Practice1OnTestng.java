package com.Properties;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice1OnTestng {
	//private String projectpath = System.getProperty("user.dir");
	
	//����xml�ļ��е�TestData
	@Parameters({"TestData"})
	@Test
	public void test(String TestData){
		ParseProperties pp = new ParseProperties( System.getProperty("user.dir")+TestData);
		System.out.println(pp.getValue("username"));
		
	}
}

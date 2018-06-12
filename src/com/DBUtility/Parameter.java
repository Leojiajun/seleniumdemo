package com.DBUtility;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class Parameter {
	private String username;
	private String password;
	public Parameter(String username,String password){
		this.username=username;
		this.password=password;
	}
	@Parameters
	public static Collection<String[]> getData(){
		//return DBUtility.jdbcDriver("jdbc:mysql://192.168.6.205:3306/autotest", "autotest", "autotest");
		return DBUtility.csvDriver("C:/Users/jiajun.wu/workspace/seleniumdemo/src/com/DBUtility/userInfo.csv");
	}
	
	
	@Test
	public void TestParameter(){
		System.out.println(username+"----"+password);
	}
	
}

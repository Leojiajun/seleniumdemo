package com.DBUtility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import com.mysql.jdbc.PreparedStatement;

public class DBUtility {
	public static List<String[]> jdbcDriver(String url,String username,String password){
		List<String[]> list = new ArrayList<String[]>();
		//连接
		Connection con = null;
		//执行查询
		PreparedStatement ps = null;
		//语句
		String sql ="select username,password from user";
		//结果
		ResultSet rs = null;
		
		try {
			//加载驱动
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//jdbc:mysql://localhost:3306/Dbname username password
		try {
			//定义一个数据库连接对象
			con =DriverManager.getConnection(url,username,password);
			//执行查询
			ps = (PreparedStatement) con.prepareStatement(sql);
			//存放查询结果
			rs =ps.executeQuery();
			while(rs.next()){
				String[] user=new String[2];
				user[0] = rs.getString("username");
				user[1] = rs.getString("password");
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	public static List<String[]> csvDriver(String filepath){
		List<String[]> list = new ArrayList<String[]>();
		InputStream in = null;//读取字节流
		BufferedReader buf = null;//一行一行读取
		try {
			//读取文件
			in = new FileInputStream(filepath);
			//一行一行读取，括号内是把in转化为字符流
			buf = new BufferedReader(new InputStreamReader(in));
			try {
				String tmp = null;
				while(!(tmp=StringUtils.trimToEmpty(buf.readLine())).equals("")){
					String user[]=tmp.split(",");
					list.add(user);
				}
					
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				buf.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 return list;

		}	
	}
}

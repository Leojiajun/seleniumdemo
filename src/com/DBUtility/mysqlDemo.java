package com.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;



public class mysqlDemo {
	static String sql = null;  
	    static DBHelper db1 = null;  
	    static ResultSet ret = null;  
	  
	    public static void main(String[] args) {  
	        sql = "select *from user";//SQL���  
	        db1 = new DBHelper(sql);//����DBHelper����  
	  
	        try {  
	            ret = db1.pst.executeQuery();//ִ����䣬�õ������  
	            while (ret.next()) {  
	                String username = ret.getString(1);  
	                String password = ret.getString(2);  
 
	                System.out.println(username + "\t" + password  );  
	            }//��ʾ����  
	            ret.close();  
	            db1.close();//�ر�����  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	}  



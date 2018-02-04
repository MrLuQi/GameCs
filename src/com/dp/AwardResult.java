package com.dp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dp.JdbcUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 从接口得到开奖数据并插入数据库
 * @author 14142
 *
 */

public class AwardResult{
	/**
	 * pcdd中将数据定时插入
	 */
	public static void pcdd_kj_json() {
		JSONObject httpRequest = json_KJ_Data.httpRequest(
				"http://f.apiplus.net/bjkl8-1.json", "GET");
		// 开奖数据
		String jsonData = httpRequest.get("data").toString();
		JSONArray new_jsonData = JSONArray.fromObject(jsonData);
		JSONObject jsonObject = new_jsonData.getJSONObject(0);
		String opencode = jsonObject.optString("opencode").toString();
		String[] s = opencode.split(",");
	int num1 =(Integer.parseInt(s[0])+Integer.parseInt(s[1])+Integer.parseInt(s[2])+Integer.parseInt(s[3])+Integer.parseInt(s[4])+Integer.parseInt(s[5]))%10;
	int num2 =(Integer.parseInt(s[6])+Integer.parseInt(s[7])+Integer.parseInt(s[8])+Integer.parseInt(s[9])+Integer.parseInt(s[10])+Integer.parseInt(s[11]))%10;
	int num3 =(Integer.parseInt(s[12])+Integer.parseInt(s[13])+Integer.parseInt(s[14])+Integer.parseInt(s[15])+Integer.parseInt(s[16])+Integer.parseInt(s[17]))%10;
	System.out.println(num1);
	int totalNum=num1+num2+num3;
	String expect = jsonObject.optString("expect").toString();
	String opentime=jsonObject.optString("opentime").toString();
		
		    Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	            // 获取连接
	            connection = JdbcUtils.getConnection();
	            // 准备sql语句
	           // String sql="insert into pcdd VALUES('"+periodNo+"','"+openDate+"',"+num1+","+num2+","+num3+","+totalNum+")";
	            String sql = "INSERT INTO pcdd(periodNo,openDate,num1,num2,num3,totalNum) VALUES(?,?,?,?,?,?)";
	            // 获取PrepareStatement对象
	            preparedStatement = connection.prepareStatement(sql);
	            // 填充占位符
	            preparedStatement.setString(1, "p"+expect);
	            preparedStatement.setString(2, opentime);
	            preparedStatement.setInt(3, num1);
	            preparedStatement.setInt(4, num2);
	            preparedStatement.setInt(5, num3);
	            preparedStatement.setInt(6, totalNum);
	            // 执行sql
	            int num = preparedStatement.executeUpdate();// 返回影响到的行数

	            System.out.println("一共影响到" + num + "行");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            JdbcUtils.releaseDB(connection, preparedStatement, null);
	        }
	      
		
	
	}
	  public static void bjsc_kj_json(){
      	//http://f.apiplus.net/bjpk10-1.json
		  JSONObject httpRequest = json_KJ_Data.httpRequest(
					"http://f.apiplus.net/bjpk10-1.json", "GET");
			// 开奖数据
			String jsonData = httpRequest.get("data").toString();
			System.out.println(jsonData);
			JSONArray new_jsonData = JSONArray.fromObject(jsonData);
			JSONObject jsonObject = new_jsonData.getJSONObject(0);
			String opencode = jsonObject.optString("opencode").toString();
			String[] s = opencode.split(",");
			int num1=Integer.parseInt(s[0]);
			int num2=Integer.parseInt(s[1]);
			int num3=Integer.parseInt(s[2]);
			int num4=Integer.parseInt(s[3]);
			int num5=Integer.parseInt(s[4]);
			int num6=Integer.parseInt(s[5]);
			int num7=Integer.parseInt(s[6]);
			int num8=Integer.parseInt(s[7]);
			int num9=Integer.parseInt(s[8]);
			int num10=Integer.parseInt(s[9]);
			int totalNum=num1+num2;
			String expect = jsonObject.optString("expect").toString();
			String opentime=jsonObject.optString("opentime").toString();
			
			
		    Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	            // 获取连接
	            connection = JdbcUtils.getConnection();
	            // 准备sql语句
	           // String sql="insert into pcdd VALUES('"+periodNo+"','"+openDate+"',"+num1+","+num2+","+num3+","+totalNum+")";
	            String sql = "INSERT INTO bjsc(periodNo,openDate,num1,num2,num3,num4,num5,num6,num7,num8,num9,num10,totalNum) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            // 获取PrepareStatement对象
	            preparedStatement = connection.prepareStatement(sql);
	            // 填充占位符
	            preparedStatement.setString(1, "B"+expect);
	            preparedStatement.setString(2, opentime);
	            preparedStatement.setInt(3, num1);
	            preparedStatement.setInt(4, num2);
	            preparedStatement.setInt(5, num3);
	            preparedStatement.setInt(6, num4);
	            preparedStatement.setInt(7, num5);
	            preparedStatement.setInt(8, num6);
	            preparedStatement.setInt(9, num7);
	            preparedStatement.setInt(10, num8);
	            preparedStatement.setInt(11, num9);
	            preparedStatement.setInt(12, num10);
	            preparedStatement.setInt(13, totalNum);
	            // 执行sql
	            int num = preparedStatement.executeUpdate();// 返回影响到的行数

	            System.out.println("一共影响到" + num + "行");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            JdbcUtils.releaseDB(connection, preparedStatement, null);
	        }
      }
	  
	  public static void jsks_kj_json(){
		  JSONObject httpRequest = json_KJ_Data.httpRequest(
					"http://f.apiplus.net/jsk3-1.json", "GET");
			// 开奖数据
			String jsonData = httpRequest.get("data").toString();
			System.out.println(jsonData);
			JSONArray new_jsonData = JSONArray.fromObject(jsonData);
			JSONObject jsonObject = new_jsonData.getJSONObject(0);
			String opencode = jsonObject.optString("opencode").toString();
			String[] s = opencode.split(",");
			int num1=Integer.parseInt(s[0]);
			int num2=Integer.parseInt(s[1]);
			int num3=Integer.parseInt(s[2]);
			int totalNum=num1+num2+num3;
			String expect = jsonObject.optString("expect").toString();
			String opentime=jsonObject.optString("opentime").toString();


		    Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	            // 获取连接
	            connection = JdbcUtils.getConnection();
	            // 准备sql语句
	           // String sql="insert into pcdd VALUES('"+periodNo+"','"+openDate+"',"+num1+","+num2+","+num3+","+totalNum+")";
	            String sql = "INSERT INTO jsks(periodNo,openDate,num1,num2,num3,totalNum) VALUES(?,?,?,?,?,?)";
	            // 获取PrepareStatement对象
	            preparedStatement = connection.prepareStatement(sql);
	            // 填充占位符
	            preparedStatement.setString(1, "J"+expect);
	            preparedStatement.setString(2, opentime);
	            preparedStatement.setInt(3, num1);
	            preparedStatement.setInt(4, num2);
	            preparedStatement.setInt(5, num3);
	            preparedStatement.setInt(6, totalNum);
	            // 执行sql
	            int num = preparedStatement.executeUpdate();// 返回影响到的行数

	            System.out.println("一共影响到" + num + "行");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            JdbcUtils.releaseDB(connection, preparedStatement, null);
	        }

	  }
	  public static void cqssc_kj_json(){
		  JSONObject httpRequest = json_KJ_Data.httpRequest(
					"http://f.apiplus.net/cqssc-1.json", "GET");
			// 开奖数据
			String jsonData = httpRequest.get("data").toString();
			System.out.println(jsonData);
			JSONArray new_jsonData = JSONArray.fromObject(jsonData);
			JSONObject jsonObject = new_jsonData.getJSONObject(0);
			String opencode = jsonObject.optString("opencode").toString();
			String[] s = opencode.split(",");
			int num1=Integer.parseInt(s[0]);
			int num2=Integer.parseInt(s[1]);
			int num3=Integer.parseInt(s[2]);
			int num4=Integer.parseInt(s[3]);
			System.out.println(num4);
			int num5=Integer.parseInt(s[4]);
			
			int totalNum=num1+num2+num3+num4+num5;
			String expect = jsonObject.optString("expect").toString();
			String opentime=jsonObject.optString("opentime").toString();
			
			Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	            // 获取连接
	            connection = JdbcUtils.getConnection();
	            // 准备sql语句
	            String sql = "INSERT INTO cqssc(periodNo,openDate,num1,num2,num3,num4,num5,totalNum) VALUES(?,?,?,?,?,?,?,?)";
	            // 获取PrepareStatement对象
	            preparedStatement = connection.prepareStatement(sql);
	            // 填充占位符
	            preparedStatement.setString(1, "C"+expect);
	            preparedStatement.setString(2, opentime);
	            preparedStatement.setInt(3, num1);
	            preparedStatement.setInt(4, num2);
	            preparedStatement.setInt(5, num3);
	            preparedStatement.setInt(6, num4);
	            preparedStatement.setInt(7, num5);
	            preparedStatement.setInt(8, totalNum);
	            // 执行sql
	            int num = preparedStatement.executeUpdate();// 返回影响到的行数

	            System.out.println("一共影响到" + num + "行");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {

	        	JdbcUtils.releaseDB(connection, preparedStatement, null);}
	  }
public static void main(String[] args) {
	//pcdd_kj_json();
	//bjsc_kj_json();
	//jsks_kj_json();
	cqssc_kj_json();
}
}

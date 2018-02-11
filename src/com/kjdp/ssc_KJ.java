package com.kjdp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.crypto.Data;

import com.dp.AwardResult;
import com.pojo.Cqssc;
import com.util.JdbcUtils;

public class ssc_KJ {
	/**
	 * 重庆时时彩中两面玩法开奖结果
	 */
	public static void ssc_kj_LM(String[] args){
		int nums[]=new int[5];
		//String data[]=AwardResult.cqssc_kj_json();
		String data[]=args;
		nums[0]=Integer.parseInt(data[1]);
		nums[1]=Integer.parseInt(data[2]);
		nums[2]=Integer.parseInt(data[3]);
		nums[3]=Integer.parseInt(data[4]);
		nums[4]=Integer.parseInt(data[5]);
		Connection connection = null;
	    try {
	        // 获取连接
	        connection = JdbcUtils.getConnection();
	      
		String	sqlQT=	"select * FROM orders where status='0' ";
		Statement st=connection.createStatement();
		ResultSet rsQT=st.executeQuery(sqlQT);
		while(rsQT.next()){
		//Orders orders=new Orders();
		if(rsQT.getString("orderType").equals("sscLM")){
			
		int zjje=(int)Test_SSC.SSC_LM_cal(rsQT.getString("orderStatus"), nums);
		String sqlJG="update orders set status=?,hitflag=? ,hitamount=?,bigflag=? where oid=?";
		PreparedStatement pst=connection.prepareStatement(sqlJG);
		 pst.setString(1, "1");
		 if(zjje > 0){
		 pst.setString(2, "1");
		 }else{
			 pst.setString(2, "0");
		 }
		 pst.setInt(3, zjje);
		 if(zjje > 10000){
			 pst.setString(4, "1");
			 }else{
				 pst.setString(4, "0");
			 }
		 pst.setInt(5, rsQT.getInt("oid"));
		 pst.executeUpdate();
		}
		}
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {

	    	JdbcUtils.releaseDB(connection, null, null);
	    	}
	}
	/**
	 * 重庆时时彩中第一球玩法开奖结果
	 */
public static void ssc_kj_DYIQ(String[] args){
	int nums[]=new int[5];
	String data[]=args;
	nums[0]=Integer.parseInt(data[1]);
	nums[1]=Integer.parseInt(data[2]);
	nums[2]=Integer.parseInt(data[3]);
	nums[3]=Integer.parseInt(data[4]);
	nums[4]=Integer.parseInt(data[5]);
	Connection connection = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
      
	String	sqlQT=	"select * FROM orders where status='0' ";
	Statement st=connection.createStatement();
	ResultSet rsQT=st.executeQuery(sqlQT);
	while(rsQT.next()){
	//Orders orders=new Orders();
	if(rsQT.getString("orderType").equals("sscONE")){
		
	int zjje=(int)Test_SSC.SSC_DYIQ_cal(rsQT.getString("orderStatus"), nums);
	String sqlJG="update orders set status=?,hitflag=? ,hitamount=?,bigflag=? where oid=?";
	PreparedStatement pst=connection.prepareStatement(sqlJG);
	 pst.setString(1, "1");
	 if(zjje > 0){
	 pst.setString(2, "1");
	 }else{
		 pst.setString(2, "0");
	 }
	 pst.setInt(3, zjje);
	 if(zjje > 10000){
		 pst.setString(4, "1");
		 }else{
			 pst.setString(4, "0");
		 }
	 pst.setInt(5, rsQT.getInt("oid"));
	 pst.executeUpdate();
	}
	}
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {

    	JdbcUtils.releaseDB(connection, null, null);
    	}
}
/**
 * 重庆时时彩中第二球玩法开奖结果
 */
public static void ssc_kj_DERQ(String[] args){
	int nums[]=new int[5];
	String data[]=args;
	nums[0]=Integer.parseInt(data[1]);
	nums[1]=Integer.parseInt(data[2]);
	nums[2]=Integer.parseInt(data[3]);
	nums[3]=Integer.parseInt(data[4]);
	nums[4]=Integer.parseInt(data[5]);
	Connection connection = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
      
	String	sqlQT=	"select * FROM orders where status='0' ";
	Statement st=connection.createStatement();
	ResultSet rsQT=st.executeQuery(sqlQT);
	while(rsQT.next()){
	//Orders orders=new Orders();
	if(rsQT.getString("orderType").equals("sscTWO")){
		
	int zjje=(int)Test_SSC.SSC_DERQ_cal(rsQT.getString("orderStatus"), nums);
	String sqlJG="update orders set status=?,hitflag=? ,hitamount=?,bigflag=? where oid=?";
	PreparedStatement pst=connection.prepareStatement(sqlJG);
	 pst.setString(1, "1");
	 if(zjje > 0){
	 pst.setString(2, "1");
	 }else{
		 pst.setString(2, "0");
	 }
	 pst.setInt(3, zjje);
	 if(zjje > 10000){
		 pst.setString(4, "1");
		 }else{
			 pst.setString(4, "0");
		 }
	 pst.setInt(5, rsQT.getInt("oid"));
	 pst.executeUpdate();
	}
	}
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {

    	JdbcUtils.releaseDB(connection, null, null);
    	}
}
/**
 * 重庆时时彩中第三球玩法开奖结果
 */
public static void ssc_kj_DSANQ(String[] args){
	int nums[]=new int[5];
	String data[]=args;
	nums[0]=Integer.parseInt(data[1]);
	nums[1]=Integer.parseInt(data[2]);
	nums[2]=Integer.parseInt(data[3]);
	nums[3]=Integer.parseInt(data[4]);
	nums[4]=Integer.parseInt(data[5]);
	Connection connection = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
      
	String	sqlQT=	"select * FROM orders where status='0' ";
	Statement st=connection.createStatement();
	ResultSet rsQT=st.executeQuery(sqlQT);
	while(rsQT.next()){
	//Orders orders=new Orders();
	if(rsQT.getString("orderType").equals("sscTHREE")){
		
	int zjje=(int)Test_SSC.SSC_DSANQ_cal(rsQT.getString("orderStatus"), nums);
	String sqlJG="update orders set status=?,hitflag=? ,hitamount=?,bigflag=? where oid=?";
	PreparedStatement pst=connection.prepareStatement(sqlJG);
	 pst.setString(1, "1");
	 if(zjje > 0){
	 pst.setString(2, "1");
	 }else{
		 pst.setString(2, "0");
	 }
	 pst.setInt(3, zjje);
	 if(zjje > 10000){
		 pst.setString(4, "1");
		 }else{
			 pst.setString(4, "0");
		 }
	 pst.setInt(5, rsQT.getInt("oid"));
	 pst.executeUpdate();
	}
	}
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {

    	JdbcUtils.releaseDB(connection, null, null);
    	}
}
/**
 * 重庆时时彩中第四球玩法开奖结果
 */
public static void ssc_kj_DSIQ(String[] args){
	int nums[]=new int[5];
	String data[]=args;
	nums[0]=Integer.parseInt(data[1]);
	nums[1]=Integer.parseInt(data[2]);
	nums[2]=Integer.parseInt(data[3]);
	nums[3]=Integer.parseInt(data[4]);
	nums[4]=Integer.parseInt(data[5]);
	Connection connection = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
      
	String	sqlQT=	"select * FROM orders where status='0' ";
	Statement st=connection.createStatement();
	ResultSet rsQT=st.executeQuery(sqlQT);
	while(rsQT.next()){
	//Orders orders=new Orders();
	if(rsQT.getString("orderType").equals("sscFOUR")){
		
	int zjje=(int)Test_SSC.SSC_DSIQ_cal(rsQT.getString("orderStatus"), nums);
	String sqlJG="update orders set status=?,hitflag=? ,hitamount=?,bigflag=? where oid=?";
	PreparedStatement pst=connection.prepareStatement(sqlJG);
	 pst.setString(1, "1");
	 if(zjje > 0){
	 pst.setString(2, "1");
	 }else{
		 pst.setString(2, "0");
	 }
	 pst.setInt(3, zjje);
	 if(zjje > 10000){
		 pst.setString(4, "1");
		 }else{
			 pst.setString(4, "0");
		 }
	 pst.setInt(5, rsQT.getInt("oid"));
	 pst.executeUpdate();
	}
	}
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {

    	JdbcUtils.releaseDB(connection, null, null);
    	}
}
/**
 * 重庆时时彩中第五球玩法开奖结果
 */
public static void ssc_kj_DWUQ(String[] args){
	int nums[]=new int[5];
	String data[]=args;
	nums[0]=Integer.parseInt(data[1]);
	nums[1]=Integer.parseInt(data[2]);
	nums[2]=Integer.parseInt(data[3]);
	nums[3]=Integer.parseInt(data[4]);
	nums[4]=Integer.parseInt(data[5]);
	Connection connection = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
      
	String	sqlQT=	"select * FROM orders where status='0' ";
	Statement st=connection.createStatement();
	ResultSet rsQT=st.executeQuery(sqlQT);
	while(rsQT.next()){
	//Orders orders=new Orders();
	if(rsQT.getString("orderType").equals("sscFIVS")){
		
	int zjje=(int)Test_SSC.SSC_DWUQ_cal(rsQT.getString("orderStatus"), nums);
	String sqlJG="update orders set status=?,hitflag=? ,hitamount=?,bigflag=? where oid=?";
	PreparedStatement pst=connection.prepareStatement(sqlJG);
	 pst.setString(1, "1");
	 if(zjje > 0){
	 pst.setString(2, "1");
	 }else{
		 pst.setString(2, "0");
	 }
	 pst.setInt(3, zjje);
	 if(zjje > 10000){
		 pst.setString(4, "1");
		 }else{
			 pst.setString(4, "0");
		 }
	 pst.setInt(5, rsQT.getInt("oid"));
	 pst.executeUpdate();
	}
	}
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {

    	JdbcUtils.releaseDB(connection, null, null);
    	}
}
public static void main(String[] args) {
	//ssc_kj_DYIQ();
}
}

package com.kjdp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Cqssc;
import com.util.JdbcUtils;

public class ssc_KJ {
	/**
	 * 重庆时时彩开奖结果
	 * @param date 开奖时间
	 * @return 开奖结果
	 */
public static int[] ssc_kjjg(String date){
	int num[] = new int[5];
	Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
        // 准备sql语句
        String sql = "select * FROM cqssc where openDate='2018-02-06 19:50:40'";
        // 获取PrepareStatement对象
       preparedStatement=connection.prepareStatement(sql);

        ResultSet rs=preparedStatement.executeQuery();
   
         while(rs.next()){			            	
			num[0]=rs.getInt("num1");
			num[1]=rs.getInt("num2");
			num[2]=rs.getInt("num3");
			num[3]=rs.getInt("num4");
			num[4]=rs.getInt("num5");
         }
         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {

	        	JdbcUtils.releaseDB(connection, preparedStatement, null);
	        	}
	return num;
    }
/**
 * 
 * @param date 开奖时间
 * @return 当前时间开奖期数
 */
public static Cqssc ssc_kjqs(String date){
	Cqssc cq=new Cqssc();
	Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
        // 准备sql语句
        String sql = "select * FROM cqssc where openDate='2018-02-06 19:50:40'";
        // 获取PrepareStatement对象
       preparedStatement=connection.prepareStatement(sql);

        ResultSet rs=preparedStatement.executeQuery();
   
         while(rs.next()){			            	
        	 cq.setPeriodno(rs.getString("periodNo"));
			 cq.setOpendate(rs.getString("openDate"));
         }
         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {

	        	JdbcUtils.releaseDB(connection, preparedStatement, null);
	        	}
	return cq;
    }
public static void ssc_kj_DYIQ(int[] num,Cqssc cq){
	Connection connection = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
	String	sqlQT=	"select * FROM orders where periodno='1' ";
	PreparedStatement st=connection.prepareStatement(sqlQT);
	ResultSet rsQT=st.executeQuery(sqlQT);
	while(rsQT.next()){
	//Orders orders=new Orders();
	if(rsQT.getString("orderType").equals("sscONE")){
		
	int zjje=(int)Test_SSC.SSC_DYIQ_cal(rsQT.getString("orderStatus"), num);
	String sqlJG="update orders set status=?,hitflag=?,hitamount=?,periodno=?,bigflag=? where oid=?";
	PreparedStatement pst=connection.prepareStatement(sqlJG);
	 pst.setString(1, "已结");
	 if(zjje > 0){
	 pst.setString(2, "中奖");
	 }else{
		 pst.setString(2, "未中");
	 }
	 pst.setInt(3, zjje);
	 pst.setString(4, cq.getPeriodno());
	 pst.setInt(5, rsQT.getInt("oid"));
	 if(zjje > 30){
		 pst.setString(6, "是");
		 }else{
			 pst.setString(6, "否");
		 }
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
}

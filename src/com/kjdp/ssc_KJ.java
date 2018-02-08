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
public static void ssc_kj_DYIQ(){
	int nums[]=new int[5];
	String data[]=AwardResult.cqssc_kj_json();
	nums[0]=Integer.parseInt(data[1]);
	nums[1]=Integer.parseInt(data[2]);
	nums[2]=Integer.parseInt(data[3]);
	nums[3]=Integer.parseInt(data[4]);
	nums[4]=Integer.parseInt(data[5]);
	Connection connection = null;
    try {
        // 获取连接
        connection = JdbcUtils.getConnection();
      
	String	sqlQT=	"select * FROM orders where periodno='1' ";
	Statement st=connection.createStatement();
	ResultSet rsQT=st.executeQuery(sqlQT);
	while(rsQT.next()){
	//Orders orders=new Orders();
	if(rsQT.getString("orderType").equals("sscONE")){
		
	int zjje=(int)Test_SSC.SSC_DYIQ_cal(rsQT.getString("orderStatus"), nums);
	String sqlJG="update orders set status=?,hitflag=? ,hitamount=?,periodno=? where oid=?";
	PreparedStatement pst=connection.prepareStatement(sqlJG);
	 pst.setString(1, "已结");
	 if(zjje > 0){
	 pst.setString(2, "中奖");
	 }else{
		 pst.setString(2, "未中");
	 }
	 pst.setInt(3, zjje);
	 pst.setString(4, data[0]);
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

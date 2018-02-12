package com.dp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.kjdp.UpdateCommon;
import com.kjdp.Util_PCDD;
import com.pojo.Orders;
import com.util.JdbcUtils;

public  class Pcdd_Winning_Amount {
	/**
	 * 更新用户下注信息
	 */
	 public static void retrieve(String[] arg) {
		 String args[]=arg;
		 //String periodNo="P"+args[0];
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        
	        try {
	            connection = JdbcUtils.getConnection();
	       //     String status="1";
	            String sql = "SELECT * FROM orders WHERE status='0' and orderType LIKE '%pcdd'";
	                preparedStatement = connection.prepareStatement(sql);
	            resultSet = preparedStatement.executeQuery();
	            
	            // 遍历结果集
	            while (resultSet.next()) {
	            	String updatesql = "update orders set status=?,hitflag=? ,bigflag=?,hitamount=? where oid=?";
	            	   preparedStatement = connection.prepareStatement(updatesql);
	            	Orders orders = new Orders();
               orders.setOrderno(resultSet.getString("orderno"));
               orders.setOrderstatus(resultSet.getString("orderstatus"));
               //订单号
               String orderno = orders.getOrderno();
               //状态值
               String orderstatus = orders.getOrderstatus();
               System.out.println(orderno+"++++"+orderstatus);
               int pcdd_pcdd_cal = (int)PCDD_pcdd_cal(orderstatus,args);
               System.out.println("中奖金额"+pcdd_pcdd_cal);
               //修改语句
               preparedStatement.setString(1, "1");
               if(pcdd_pcdd_cal > 0){
            	   preparedStatement.setString(2, "1");  
               }else{
            	   preparedStatement.setString(2, "0");   
               }
               if(pcdd_pcdd_cal > 10000){
            	   preparedStatement.setString(3, "1");  
               }else{
            	   preparedStatement.setString(3, "0");   
               }
               preparedStatement.setInt(4, pcdd_pcdd_cal);
               preparedStatement.setInt(5, resultSet.getInt("oid"));
               preparedStatement.executeUpdate();
               UpdateCommon.updateMoney(pcdd_pcdd_cal,resultSet.getInt("mid"));
	            }
	         
	          
	        } catch (Exception e) {
	            // TODO: handle exception
	        } finally {
	
	        	JdbcUtils.releaseDB(connection, preparedStatement, resultSet);
	        }


	        
	    }
	 
	 /**
	  * 用户下注金额中奖分析
	  * @param json 用户下注情况
	  * @return 用户中奖金额
	  */
		public static double  PCDD_pcdd_cal(String json,String[] args){
		String[] pcdd_kj_json =args;
	    int	kaijiang=Integer.parseInt(pcdd_kj_json[1]);
			double sum=0;
			 JSONObject topJson = JSONObject.fromObject(json); 
			 // String category =topJson.get("category").toString();
			 // String subcategory =topJson.get("subCategory").toString();
			  JSONObject leafListJson=(JSONObject)topJson.get("leafList");
			  JSONObject  hhwf  =(JSONObject)leafListJson.get("HHWF");
			  JSONObject   dmwf =(JSONObject)leafListJson.get("DMWF");
	//����淨
		if (hhwf!=null) {
			 sum=sum+Util_PCDD.da_HH(hhwf.optDouble("DA"), kaijiang, 2.00);
			 sum=sum+Util_PCDD.xiao_HH(hhwf.optDouble("XIAO"), kaijiang, 2.00);
			 sum=sum+Util_PCDD.dan_HH(hhwf.optDouble("DAN"), kaijiang, 2.00);
			 sum=sum+Util_PCDD.shuang_HH(hhwf.optDouble("SHUANG"), kaijiang, 2.00);
			 sum=sum+Util_PCDD.daShuang_HH(hhwf.optDouble("DASHUANG"), kaijiang, 4.00);
		     sum=sum+Util_PCDD.daDan_HH(hhwf.optDouble("DADAN"), kaijiang, 4.10);
			 sum=sum+Util_PCDD.xiaoDan_HH(hhwf.optDouble("XIAODAN"), kaijiang, 4.00);		
			 sum=sum+Util_PCDD.xiaoShuang_HH(hhwf.optDouble("XIAOSHUANG"), kaijiang, 4.10);
			 sum=sum+Util_PCDD.jiDa_HH(hhwf.optDouble("JIDA"), kaijiang, 15.00);
			 sum=sum+Util_PCDD.jixiao_HH(hhwf.optDouble("JIXIAO"), kaijiang, 15.00);
	}
	if (dmwf!=null) {
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("ZERO"), 0, kaijiang, 800.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("ONE"), 1, kaijiang, 260.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWO"), 2, kaijiang, 130.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("THREE"), 3, kaijiang, 80.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("FOUR"), 4, kaijiang, 53.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("FIVE"), 5, kaijiang, 38.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("SIX"), 6, kaijiang, 28.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("SEVEN"), 7, kaijiang, 22.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("EIGHT"), 8, kaijiang, 18.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("NINE"), 9, kaijiang, 15.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TEN"), 10, kaijiang, 13.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("ELEVEN"), 11, kaijiang, 13.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWELVE"), 12, kaijiang, 12.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("THIRTEEN"), 13, kaijiang, 12.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("FOURTEEN"), 14, kaijiang, 12.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("FIFTEEN"), 15, kaijiang, 12.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("SIXTEEN"), 16, kaijiang, 13.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("SENENTEEN"), 17, kaijiang, 13.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("EIGHTEEN"), 18, kaijiang, 15.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("NINETEEN"), 19, kaijiang, 18.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWENTY"), 20, kaijiang, 22.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWENTY-ONE"), 21, kaijiang, 28.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWENTY-TWO"), 22, kaijiang, 38.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWENTY-THREE"), 23, kaijiang, 53.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWENTY-FOUR"), 24, kaijiang, 80.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWENTY-FIVE"), 25, kaijiang, 130.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWENTY-SIX"), 26, kaijiang, 260.00);
		sum=sum+Util_PCDD.twentySeven_DM(dmwf.optDouble("TWENTY-SEVEN"), 27, kaijiang, 800.00);
		
	}
			 return sum;
			}
public static void main(String[] args) {
	//System.out.println("aa");
	//retrieve();

}
}

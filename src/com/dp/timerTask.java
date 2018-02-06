package com.dp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.kjdp.Test_SSC;
import com.kjdp.ssc_KJ;
import com.pojo.Cqssc;
import com.pojo.Orders;
import com.util.JdbcUtils;

public class timerTask {
	static JiangSet jsks = new JiangSet(); // 江苏快三
	static JiangSet pcdd = new JiangSet(); // PC蛋蛋
	static JiangSet ssc = new JiangSet(); // 时时彩
	static JiangSet bjsc = new JiangSet(); // 北京赛车
	static JiangSet lhc = new JiangSet(); // 六合彩
	static  int  minuts_effct=0;//误差值
	static {
		jsks.setBeginTime("8:40");
		jsks.setEndTime("22:10");
		jsks.setFrequency(10);
		bjsc.setBeginTime("09:02");
		bjsc.setEndTime("23:57");
		bjsc.setFrequency(5);
		pcdd.setBeginTime("9:00");
		pcdd.setEndTime("23:55");
		pcdd.setFrequency(5);
		ssc.setBeginTime("10:00");
		ssc.setEndTime("23:00");
		ssc.setFrequency(1);
		/*
		 * lhc.setBeginTime(""); lhc.setEndTime(endTime);
		 * lhc.setFrequency(frequency);
		 */
	}

	public static void startJSKS() {
		Timer timer_jsks = new Timer();
		timer_jsks.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				// --取当前最新时间(时、分)--//
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int minute = c.get(Calendar.MINUTE);
				// --取系统设定的时间--//
				int set_beginHour = Integer.parseInt(jsks.getBeginTime().split(
						":")[0]);
				int set_beginMinute = Integer.parseInt(jsks.getBeginTime()
						.split(":")[1]);
				int set_endHour = Integer
						.parseInt(jsks.getEndTime().split(":")[0]);
				int set_endMinute = Integer.parseInt(jsks.getEndTime().split(
						":")[1]);
				/* 判断当前时间是否有效 */
				if ((hour > set_beginHour && hour < set_endHour)
						|| (hour == set_beginHour && minute >= set_beginMinute)
						|| (hour == set_endHour && minute <= set_endMinute)) {
					int minute_dif = (hour * 60 + minute)
							- (set_beginHour * 60 + set_beginMinute); // 分钟差
					if (minute_dif % jsks.getFrequency() == 0) {
						System.out.println("当前时间" + (new Date().toString()));
						System.out.println("-------江苏快三定时任务启动--------");
						AwardResult.jsks_kj_json();
						// 1.调用获取开奖数据接口，把开奖数据送入 江苏快三 开奖表
						// 2.获取下注单表中获取所有未开的江苏快三数据，并分析每条记录的下单json数据
						// 3.分析中奖金额(调用江苏快3的中奖规则),更新该下注单数据的中奖金额字段。
					}
				}
			}

		//}, 1000, jsks.getFrequency() * 1000*60);
		}, 1000, 60 * 1000);
	}

	public static void startBJSC() {
		Timer timer_jsks = new Timer();
		timer_jsks.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				// --取当前最新时间(时、分)--//
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int minute = c.get(Calendar.MINUTE);
				// --取系统设定的时间--//
				int set_beginHour = Integer.parseInt(bjsc.getBeginTime().split(
						":")[0]);
				int set_beginMinute = Integer.parseInt(bjsc.getBeginTime()
						.split(":")[1]);
				int set_endHour = Integer
						.parseInt(bjsc.getEndTime().split(":")[0]);
				int set_endMinute = Integer.parseInt(bjsc.getEndTime().split(
						":")[1]);
				/* 判断当前时间是否有效 */
				if ((hour > set_beginHour && hour < set_endHour)
						|| (hour == set_beginHour && minute >= set_beginMinute)
						|| (hour == set_endHour && minute <= set_endMinute)) {
					int minute_dif = (hour * 60 + minute)
							- (set_beginHour * 60 + set_beginMinute); // 分钟差
					if (minute_dif % (bjsc.getFrequency()*60) == 0) {
						System.out.println("当前时间" + (new Date().toString()));
						System.out.println("-------北京赛车定时任务启动--------");
						AwardResult.bjsc_kj_json();
						// 1.调用获取开奖数据接口，把开奖数据送入 江苏快三 开奖表
						// 2.获取下注单表中获取所有未开的江苏快三数据，并分析每条记录的下单json数据
						// 3.分析中奖金额(调用江苏快3的中奖规则),更新该下注单数据的中奖金额字段。
					}
				}
			}

		//}, 1000, bjsc.getFrequency() * 1000);
		}, 1000, 60 * 1000);
	}

	public static void startPCDD() {
		Timer timer_jsks = new Timer();
		timer_jsks.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				// --取当前最新时间(时、分)--//
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int minute = c.get(Calendar.MINUTE);
				// --取系统设定的时间--//
				int set_beginHour = Integer.parseInt(pcdd.getBeginTime().split(
						":")[0]);
				int set_beginMinute = Integer.parseInt(pcdd.getBeginTime()
						.split(":")[1]);
				int set_endHour = Integer
						.parseInt(pcdd.getEndTime().split(":")[0]);
				int set_endMinute = Integer.parseInt(pcdd.getEndTime().split(
						":")[1]);
				/* 判断当前时间是否有效 */
				if ((hour > set_beginHour && hour < set_endHour)
						|| (hour == set_beginHour && minute >= set_beginMinute)
						|| (hour == set_endHour && minute <= set_endMinute)) {
					int minute_dif = (hour * 60 + minute)
							- (set_beginHour * 60 + set_beginMinute); // 分钟差
					if (minute_dif % pcdd.getFrequency() == 0) {
						System.out.println("当前时间" + (new Date().toString()));
						System.out.println("-------PCDD定时任务启动--------");
						Pcdd_Winning_Amount.retrieve();
						// 1.调用获取开奖数据接口，把开奖数据送入 PCDD 开奖表
						// 2.获取下注单表中获取所有未开的PCDD数据，并分析每条记录的下单json数据
						// 3.分析中奖金额(调用PCDD的中奖规则),更新该下注单数据的中奖金额字段。
					}
				}
			}

		//}, 1000, pcdd.getFrequency() * 1000*60);
		}, 1000, 60 * 1000);
	}

	public static void startSSC() {
		Timer timer_jsks = new Timer();
		timer_jsks.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				// --取当前最新时间(时、分)--//
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int minute = c.get(Calendar.MINUTE);
				// --取系统设定的时间--//
				int set_beginHour = Integer.parseInt(ssc.getBeginTime().split(":")[0]);
				int set_beginMinute = Integer.parseInt(ssc.getBeginTime().split(":")[1]);
				int set_endHour = Integer.parseInt(ssc.getEndTime().split(":")[0]);
				int set_endMinute = Integer.parseInt(ssc.getEndTime().split(":")[1]);
				/* 判断当前时间是否有效 */
				if ((hour > set_beginHour && hour < set_endHour)
						|| (hour == set_beginHour && minute >= set_beginMinute)
						|| (hour == set_endHour && minute <= set_endMinute)) {
					int minute_dif = (hour * 60 + minute)
							- (set_beginHour * 60 + set_beginMinute); // 分钟差
					if (minute_dif % ssc.getFrequency() == 0) {
						System.out.println("当前时间" + (new Date().toString()));
						System.out.println("-------时时彩定时任务启动--------");
						AwardResult.cqssc_kj_json();
						// 1.调用获取开奖数据接口，把开奖数据送入 时时彩 开奖表
						int num[]=ssc_KJ.ssc_kjjg(null);
						Cqssc cq=ssc_KJ.ssc_kjqs(null);
						ssc_KJ.ssc_kj_DYIQ(num, cq);
				/*		//int num[] = new int[5];
						
						Connection connection = null;
				     //   PreparedStatement preparedStatement = null;
				        try {
				            // 获取连接
				            connection = JdbcUtils.getConnection();
				            // 准备sql语句
				            String sql = "select * FROM cqssc where openDate='2018-02-06 19:50:40'";
				            // 获取PrepareStatement对象
				            PreparedStatement  preparedStatement=connection.prepareStatement(sql);

				            ResultSet rs=preparedStatement.executeQuery();
				            cq=new Cqssc();
				             while(rs.next()){			            	
								cq.setPeriodno(rs.getString("periodNo"));
								cq.setOpendate(rs.getString("openDate"));
								cq.setNum1(rs.getInt("num1"));
								cq.setNum2(rs.getInt("num2"));
								cq.setNum3(rs.getInt("num3"));
								cq.setNum4(rs.getInt("num4"));
								cq.setNum5(rs.getInt("num5"));
								num[0]=rs.getInt("num1");
								num[1]=rs.getInt("num2");
								num[2]=rs.getInt("num3");
								num[3]=rs.getInt("num4");
								num[4]=rs.getInt("num5");
				             }
						String	sqlQT=	"select * FROM orders where periodno='1' ";
						Statement st=connection.createStatement();
						ResultSet rsQT=st.executeQuery(sqlQT);
						while(rsQT.next()){
						//Orders orders=new Orders();
						if(rsQT.getString("orderType").equals("sscONE")){
							
						int zjje=(int)Test_SSC.SSC_DYIQ_cal(rsQT.getString("orderStatus"), num);
						String sqlJG="update orders set status=?,hitflag=? ,hitamount=?,periodno=? where oid=?";
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
						 pst.executeUpdate();
						}
						}
				        } catch (SQLException e) {
				            // TODO Auto-generated catch block
				            e.printStackTrace();
				        } finally {

				        	JdbcUtils.releaseDB(connection, null, null);
				        	}*/
						// 2.获取下注单表中获取所有未开的时时彩数据，并分析每条记录的下单json数据
						// 3.分析中奖金额(调用时时彩的中奖规则),更新该下注单数据的中奖金额字段。
					}
				}
			}

		//}, 1000, ssc.getFrequency() * 1000*60);
		}, 1000, 60 * 1000);
	}

	public static void main(String[] args) {
		//startJSKS();
		//startPCDD();
		startSSC();
		//startBJSC();

	}
}

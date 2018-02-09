package com.dp;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import com.kjdp.jsks_KJ;
import com.kjdp.ssc_KJ;

public class timerTask {
	static JiangSet jsks = new JiangSet(); // 江苏快三
	static JiangSet pcdd = new JiangSet(); // PC蛋蛋
	static JiangSet ssc_day = new JiangSet(); // 重庆时时彩--白场
	static JiangSet ssc_night = new JiangSet(); // 重庆时时彩--夜场
	static JiangSet bjsc = new JiangSet(); // 北京赛车
	static JiangSet lhc = new JiangSet(); // 六合彩
	static  int  minuts_effct=0;//误差值
	static {
		jsks.setBeginTime("8:40");
		jsks.setEndTime("22:10");
		//jsks.setFrequency(600);
		jsks.setFrequency(120);
		bjsc.setBeginTime("09:02");
		bjsc.setEndTime("23:57");
		//bjsc.setFrequency(300);
		bjsc.setFrequency(120);
		pcdd.setBeginTime("9:00");
		pcdd.setEndTime("23:55");
		//pcdd.setFrequency(300);
		pcdd.setFrequency(120);
		ssc_day.setBeginTime("10:00");
		ssc_day.setEndTime("22:00");
		//ssc_day.setFrequency(600);
		ssc_day.setFrequency(120);
		ssc_night.setBeginTime("22:00");
		ssc_night.setEndTime("2:00");
		ssc_night.setFrequency(300);
	}

	public static void startJSKS() {
		Timer timer_jsks = new Timer();
		timer_jsks.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				// --取当前最新时间(时、分)--//
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int minute = c.get(Calendar.MINUTE);
				int second = c.get(Calendar.SECOND);
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
					int minute_dif = (hour * 3600 + minute * 60 +second)
							- (set_beginHour * 3600 + set_beginMinute * 60); // 分钟差
					if (minute_dif % jsks.getFrequency() == 0) {
						System.out.println("当前时间" + (new Date().toString()));
						System.out.println("-------江苏快三定时任务启动--------");
						//jsks_KJ.jsks_KJ_LM();
						// 1.调用获取开奖数据接口，把开奖数据送入 江苏快三 开奖表
						// 2.获取下注单表中获取所有未开的江苏快三数据，并分析每条记录的下单json数据
						// 3.分析中奖金额(调用江苏快3的中奖规则),更新该下注单数据的中奖金额字段。
					}
				}
			}

		//}, 1000, jsks.getFrequency() * 1000*60);
		}, 1000,1000);
	}

	public static void startBJSC() {
		Timer timer_jsks = new Timer();
		timer_jsks.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				// --取当前最新时间(时、分)--//
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int minute = c.get(Calendar.MINUTE);
				int second = c.get(Calendar.SECOND);
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
					int minute_dif = (hour * 3600 + minute * 60 + second)
							- (set_beginHour * 3600 + set_beginMinute * 60); // 分钟差
					if (minute_dif % (bjsc.getFrequency()) == 0) {
						System.out.println("当前时间" + (new Date().toString()));
						System.out.println("-------北京赛车定时任务启动--------");
						//AwardResult.bjsc_kj_json();
						// 1.调用获取开奖数据接口，把开奖数据送入 江苏快三 开奖表
						// 2.获取下注单表中获取所有未开的江苏快三数据，并分析每条记录的下单json数据
						// 3.分析中奖金额(调用江苏快3的中奖规则),更新该下注单数据的中奖金额字段。
					}
				}
			}

		//}, 1000, bjsc.getFrequency() * 1000);
		}, 1000,1000);
	}

	public static void startPCDD() {
		Timer timer_jsks = new Timer();
		timer_jsks.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				// --取当前最新时间(时、分)--//
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int minute = c.get(Calendar.MINUTE);
				int second = c.get(Calendar.SECOND); 
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
					int minute_dif = (hour * 3600 + minute * 60 +second)
							- (set_beginHour * 3600 + set_beginMinute * 60); // 分钟差
					if (minute_dif % pcdd.getFrequency() == 0) {
						System.out.println("当前时间" + (new Date().toString()));
						System.out.println("-------PCDD定时任务启动--------");
						//Pcdd_Winning_Amount.retrieve();
						// 1.调用获取开奖数据接口，把开奖数据送入 PCDD 开奖表
						// 2.获取下注单表中获取所有未开的PCDD数据，并分析每条记录的下单json数据
						// 3.分析中奖金额(调用PCDD的中奖规则),更新该下注单数据的中奖金额字段。
					}
				}
			}

		//}, 1000, pcdd.getFrequency() * 1000*60);
		}, 1000,1000);
		}
		public static void startSSC_day() {
			Timer timer_jsks = new Timer();
			timer_jsks.scheduleAtFixedRate(new TimerTask() {
				public void run() {
					// --取当前最新时间(时、分)--//
					Calendar c = Calendar.getInstance();
					int hour = c.get(Calendar.HOUR_OF_DAY);
					int minute = c.get(Calendar.MINUTE);
					int second = c.get(Calendar.SECOND);
					// --取系统设定的时间--//
					int set_beginHour = Integer.parseInt(ssc_day.getBeginTime().split(":")[0]);
					int set_beginMinute = Integer.parseInt(ssc_day.getBeginTime().split(":")[1]);
					int set_endHour = Integer.parseInt(ssc_day.getEndTime().split(":")[0]);
					int set_endMinute = Integer.parseInt(ssc_day.getEndTime().split(":")[1]);
					/* 判断当前时间是否有效 */
					if ((hour > set_beginHour && hour < set_endHour)
							|| (hour == set_beginHour && minute >= set_beginMinute)
							|| (hour == set_endHour && minute <= set_endMinute)) {
						int minute_dif = (hour * 3600 + minute * 60 + second)
								- (set_beginHour * 3600 + set_beginMinute * 60); // 分钟差
						if (minute_dif % ssc_day.getFrequency() == 0) {
							System.out.println("当前时间" + (new Date().toString()));
							System.out.println("-------重庆时时彩白场定时任务启动--------");
							String args[]=AwardResult.cqssc_kj_json();
							ssc_KJ.ssc_kj_LM(args);//重庆时时彩两面玩法判断
							ssc_KJ.ssc_kj_DYIQ(args);//重庆时时彩第一球玩法判断
							ssc_KJ.ssc_kj_DERQ(args);//重庆时时彩第二球玩法判断
							ssc_KJ.ssc_kj_DSANQ(args);//重庆时时彩第三球玩法判断
							ssc_KJ.ssc_kj_DSIQ(args);//重庆时时彩第四球玩法判断
							ssc_KJ.ssc_kj_DWUQ(args);//重庆时时彩第五球玩法判断
							
							// 1.调用获取开奖数据接口，把开奖数据送入 时时彩 开奖表
							// 2.获取下注单表中获取所有未开的时时彩数据，并分析每条记录的下单json数据
							// 3.分析中奖金额(调用时时彩的中奖规则),更新该下注单数据的中奖金额字段。
						}
					}
				}

			//}, 1000, ssc.getFrequency() * 1000*60);
			}, 1000,1000);
		}

		public static void startSSC_night() {
			Timer timer_jsks = new Timer();
			timer_jsks.scheduleAtFixedRate(new TimerTask() {
				public void run() {
					// --取当前最新时间(时、分)--//
					Calendar c = Calendar.getInstance();
					int hour = c.get(Calendar.HOUR_OF_DAY);
					int minute = c.get(Calendar.MINUTE);
					int second = c.get(Calendar.SECOND); 
					// --取系统设定的时间--//
					int set_beginHour = Integer.parseInt(ssc_night.getBeginTime().split(":")[0]);
					int set_beginMinute = Integer.parseInt(ssc_night.getBeginTime().split(":")[1]);
					int set_endHour = Integer.parseInt(ssc_night.getEndTime().split(":")[0]);
					int set_endMinute = Integer.parseInt(ssc_night.getEndTime().split(":")[1]);
					/* 判断当前时间是否有效 */
					if (!(hour > set_endHour  && hour < set_beginHour)  //重庆时时彩夜场特殊处理，取反操作。
							|| (hour == set_beginHour && minute >= set_beginMinute)
							|| (hour == set_endHour && minute <= set_endMinute)) {
						int minute_dif = (hour * 3600 + minute * 60 + second)
								- (set_beginHour * 3600 + set_beginMinute * 60); // 分钟差
						if (minute_dif % ssc_day.getFrequency() == 0) {
							System.out.println("当前时间" + (new Date().toString()));
							System.out.println("-------重庆时时彩夜场定时任务启动--------");
							String args[]=AwardResult.cqssc_kj_json();
							ssc_KJ.ssc_kj_LM(args);//重庆时时彩两面玩法判断
							ssc_KJ.ssc_kj_DYIQ(args);//重庆时时彩第一球玩法判断
							ssc_KJ.ssc_kj_DERQ(args);//重庆时时彩第二球玩法判断
							ssc_KJ.ssc_kj_DSANQ(args);//重庆时时彩第三球玩法判断
							ssc_KJ.ssc_kj_DSIQ(args);//重庆时时彩第四球玩法判断
							ssc_KJ.ssc_kj_DWUQ(args);//重庆时时彩第五球玩法判断
							// 1.调用获取开奖数据接口，把开奖数据送入 时时彩 开奖表
							// 2.获取下注单表中获取所有未开的时时彩数据，并分析每条记录的下单json数据
							// 3.分析中奖金额(调用时时彩的中奖规则),更新该下注单数据的中奖金额字段。
						}
					}
				}

			//}, 1000, ssc.getFrequency() * 1000*60);
			}, 1000,1000);
	}
	
	public static void main(String[] args) {
		//startJSKS();
		//startPCDD();
		//startBJSC();
		//startSSC_day();
		//startSSC_night();

	}
}

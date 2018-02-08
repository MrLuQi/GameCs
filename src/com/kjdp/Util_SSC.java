package com.kjdp;

import java.util.Arrays;

import net.sf.json.JSONObject;

/**
 * 
 * @author 钟传文
 *
 */
public class Util_SSC {
	/**
     * 两面玩法中--开奖号码之和判断是否大数，并且计算中奖金额
     * @param jsonObject    投注节点数据
     * @param nums          待校验的一个数
     * @return              中奖金额
     */
	public static double daNums_LM(Double unitValue, Integer nums,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (nums >= 23) {
				rt = unitValue * rate;
			}
		}
		return rt;
	}
	
	/**
     * 两面玩法中--一个数判断是否大数，并且计算中奖金额
     * @param jsonObject    投注节点数据
     * @param para          待校验的一个数
     * @return              中奖金额
     */
	public static double da_LM(Double unitValue, Integer para,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (para >= 5) {
				rt = unitValue * rate;
			}
		}
		return rt;
	}
	
	 /**
     * 两面玩法中--开奖号码之和判断是否小数，并且计算中奖金额
     * @param jsonObject    投注节点数据
     * @param nums         待校验的一个数
     * @return              中奖金额
     */
	public static double xiaoNums_LM(Double unitValue, Integer nums,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (nums <= 23) {
				rt = unitValue * rate;
			}
		}
		return rt;
	}
	
	 /**
     * 两面玩法中--开奖号码之和判断是否小数，并且计算中奖金额
     * @param jsonObject    投注节点数据
     * @param para         待校验的一个数
     * @return              中奖金额
     */
	public static double xiao_LM(Double unitValue, Integer para,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (para <= 4) {
				rt = unitValue * rate;
			}
		}
		return rt;
	}
	
	/**
     * 两面玩法中--一个数判断是否单数，并且计算中奖金额
     * @param jsonObject    投注节点数据
     * @param para          待校验的一个数
     * @return              中奖金额
     */
	public static double dan_LM(Double unitValue, Integer para,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (para % 2 != 0) {
				rt = unitValue * rate;
			}
		}
		return rt;
	}
	
	/**
     * 两面玩法中--一个数判断是否双数，并且计算中奖金额
     * @param jsonObject    投注节点数据
     * @param para          待校验的一个数
     * @return              中奖金额
     */
	public static double shuang_LM(Double unitValue, Integer para,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (para % 2 == 0) {
				rt = unitValue * rate;
			}
		}
		return rt;
	}
	/**
     * 两面玩法中--判断是否为龙，并且计算中奖金额
     * @param jsonObject    投注节点数据   
     * @param para1          待校验的一个数
     * @param para1          待校验的另一个数  
     * @return              中奖金额
     */
	public static double long_LM(Double unitValue,Integer para1,Integer para2,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (para1>para2) {
				rt = unitValue * rate;
			}
		}
		return rt;
}
	/**
     * 两面玩法中--判断是否为虎，并且计算中奖金额
     * @param jsonObject    投注节点数据   
     * @param para1          待校验的一个数
     * @param para1          待校验的另一个数  
     * @return              中奖金额
     */
	public static double hu_LM(Double unitValue,Integer para1,Integer para2,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (para1<para2) {
				rt = unitValue * rate;
			}
		}
		return rt;
}
	/**
     * 两面玩法中--判断是否为和，并且计算中奖金额
     * @param jsonObject    投注节点数据   
     * @param para1          待校验的一个数
     * @param para1          待校验的另一个数  
     * @return              中奖金额
     */
	public static double he_LM(Double unitValue,Integer para1,Integer para2,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			if (para1==para2) {

				rt = unitValue * rate;
			}
		}
		return rt;
}
	
	/**
     * 两面玩法中--一个数判断是否为0-9，并且计算中奖金额
     * @param jsonObject    投注节点数据
     * @param para          0-9中哪一个节点
     * @param para          待校验的一个数
     * @return              中奖金额
     */
	public static double  ssc_DH(Double unitValue, Integer mode,Integer para,double rate) {
		double rt = 0.0;
		if (!unitValue.isNaN()) {
			
			switch (mode)
			{
			case 0:
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 1:
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 2:
				
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 3:
			
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 4:
				
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 5:
				
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 6:
				
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 7:
				
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 8:
				
				rt=(para==mode)?unitValue* rate:0;
				break;
			case 9:
				rt=(para==mode)?unitValue* rate:0;
				break;
			}
		}
		return rt;
	}
	/**
     * 两面玩法中--判断是否为豹子并且计算中奖金额
     * @param jsonObject    投注节点数据   
     * @param para1          待校验的一个数
     * @param para1          待校验的另一个数  
     * @return              中奖金额
     */
	public static double bz_LM(Double daValue,Integer para1,Integer para2,Integer para3,double rate) {
		double rt = 0.0;
		int sorts[]={para1,para2,para3};
		Arrays.sort(sorts);
		if (!daValue.isNaN()){
			if (sorts[0]==sorts[1] && sorts[1]==sorts[2]) {			
				rt = daValue * rate;		
			}
		}
		return rt;
}
	/**
     * 两面玩法中--判断是否为顺子并且计算中奖金额
     * @param jsonObject    投注节点数据   
     * @param para1          待校验的一个数
     * @param para1          待校验的另一个数  
     * @return              中奖金额
     */
	public static double sz_LM(Double daValue,Integer para1,Integer para2,Integer para3,double rate) {
		double rt = 0.0;
		int sorts[]={para1,para2,para3};
		Arrays.sort(sorts);
		if (!daValue.isNaN()){
				if (sorts[0]==sorts[1] && sorts[1]==sorts[2]) {			
					rt = 0.0;		
				}
				else if(sorts[0]==sorts[1]-1 && sorts[1]+1==sorts[2]){
				rt = daValue * rate;
		}
			}
		return rt;
}
	/**
     * 两面玩法中--判断是否为对子并且计算中奖金额
     * @param jsonObject    投注节点数据   
     * @param para1          待校验的一个数
     * @param para1          待校验的另一个数  
     * @return              中奖金额
     */
	public static double dz_LM(Double daValue,Integer para1,Integer para2,Integer para3,double rate) {
		double rt = 0.0;
		int sorts[]={para1,para2,para3};
		Arrays.sort(sorts);
		if (!daValue.isNaN()){
			if (sorts[0]==sorts[1] && sorts[1]==sorts[2]) {			
				rt = 0.0;		
			}else if(sorts[0]==sorts[1]-1 && sorts[1]+1==sorts[2]){
				rt = 0.0;
			}else if(para1==para2 || para2==para3 || para1==para3){
				rt = daValue * rate;
			}
		}
		return rt;
}
	/**
     * 两面玩法中--判断是否为半顺并且计算中奖金额
     * @param jsonObject    投注节点数据   
     * @param para1          待校验的一个数
     * @param para1          待校验的另一个数  
     * @return              中奖金额
     */
	public static double bs_LM(Double daValue,Integer para1,Integer para2,Integer para3,double rate) {
		double rt = 0.0;
		int sorts[]={para1,para2,para3};
		Arrays.sort(sorts);
		if (!daValue.isNaN()){
			if (sorts[0]==sorts[1] && sorts[1]==sorts[2]) {			
				rt = 0.0;		
			}else if(sorts[0]==sorts[1]-1 && sorts[1]+1==sorts[2]){
				rt = 0.0;
			}else if(para1==para2 || para2==para3 || para1==para3){
				rt = 0.0;
			}else if(sorts[0]==sorts[1]-1 && sorts[1]+1!=sorts[2] || sorts[0]!=sorts[1]-1 && sorts[1]+1==sorts[2]){
				rt = daValue * rate;
			}
		}
		return rt;
}
	/**
     * 两面玩法中--判断是否为杂六并且计算中奖金额
     * @param jsonObject    投注节点数据   
     * @param para1          待校验的一个数
     * @param para1          待校验的另一个数  
     * @return              中奖金额
     */
	public static double zl_LM(Double daValue,Integer para1,Integer para2,Integer para3,double rate) {
		double rt = 0.0;
		int sorts[]={para1,para2,para3};
		Arrays.sort(sorts);
		if (!daValue.isNaN()){
			if (sorts[0]==sorts[1] && sorts[1]==sorts[2]) {			
				rt = daValue * 0.0;		
			}else if(sorts[0]==sorts[1]-1 && sorts[1]+1==sorts[2]){
				rt = daValue * 0.0;
			}else if(para1==para2 || para2==para3 || para1==para3){
				rt = daValue * 0.0;
			}else if(sorts[0]==sorts[1]-1 && sorts[1]+1!=sorts[2] || sorts[0]!=sorts[1]-1 && sorts[1]+1==sorts[2]){
				rt = daValue * 0.0;
			}else {
				rt = daValue * rate;
			}
		}
		return rt;
}
}
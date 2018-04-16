package com.wx.util;

import java.util.ArrayList;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;


/**
 * 基础方法的工具类
 * @author 崔为满
 * @date 2018年3月29日 下午8:40:46
 */
public class BaseUtil {
	
	private BaseUtil() {}
	
	
	public static int sendVerifyCode(String tel,String verifyCode){
		
		try {	
    		int appid = 1400079903;
            String appkey = "4f9f1bc7fd7e3251f1237197a8fcdde1";
            String phoneNumber = tel;
            int tmplId = 101090;
            

            //初始化单发
            SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
            
            @SuppressWarnings("unused")
			SmsSingleSenderResult singleSenderResult;

            //指定模板单发
            //假设短信模板 id 为 1，模板内容为：测试短信，{1}，{2}，{3}，上学。
            ArrayList<String> params = new ArrayList<String>();
            
            params.add(verifyCode);
            params.add("1");
            singleSenderResult = singleSender.sendWithParam("86", phoneNumber, tmplId, params, "", "", "");
            
            return 1;
            
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    
		
	}
	
	
	public static void main(String[] args) {
		sendVerifyCode("17694807898","3456");
		
	}
	
	
	
	
	
	
	
	
}

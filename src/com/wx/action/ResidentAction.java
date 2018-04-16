package com.wx.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.entity.Middle;
import com.wx.entity.Resident;
import com.wx.service.MiddleService;
import com.wx.service.ResidentService;
import com.wx.util.BaseUtil;

import net.sf.json.JSONObject;

/**
 * 居民类 控制器
 * @author 崔为满
 * @date 2018年3月30日 下午3:17:42
 */

@Controller
@RequestMapping(value="/resident")
public class ResidentAction {
	
	
	private ResidentService residentService;
	private MiddleService middleService;
	
	@Resource(name="residentServiceID")
	public void setResidentService(ResidentService residentService) {
		this.residentService = residentService;
	}
	
	@Resource(name="middleServiceID")
	public void setMiddleService(MiddleService middleService) {
		this.middleService = middleService;
	}
	
	
	/**
	 * 用户登录接口
	 * @param request
	 * @param response
	 * @param tel
	 * @param password
	 * @throws IOException
	 */
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response,String tel,String password) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		JSONObject jsonObject=new JSONObject();
		
		Resident re=new Resident();
		re.setTel(tel);
		re.setPassword(password);
		
		try {
			
			Resident resident=residentService.getResidentByTelPass(re);
			if(null == resident){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else{
				
				jsonObject.put("status", 1);
				jsonObject.put("message", resident);
				
			}
			
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
				
	}
	
	
	
	
	
	
	/**
	 * 用户注册接口
	 * @param request
	 * @param response
	 * @param name
	 * @param tel
	 * @param password
	 * @param province
	 * @param city
	 * @param county
	 * @param cid
	 * @throws IOException
	 */
	@RequestMapping(value="/register.action",method=RequestMethod.POST)
	public void register(HttpServletRequest request,HttpServletResponse response,String name,String tel,String password,String province,String city,String county,String cid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			
		Resident re=new Resident();
		re.setId();
		re.setName(name);
		re.setTel(tel);
		re.setPassword(password);
		re.setProvince(province);
		re.setCity(city);
		re.setCounty(county);
		
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			residentService.addResident(re);
			
			Middle middle=new Middle();
			middle.setCid(cid);
			middle.setRid(re.getId());
			middleService.addMiddle(middle);
							
			jsonObject.put("status", 1);
			jsonObject.put("message", "Register SUCCESS");
			
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
		
	}
	
	
	
	
	
	
	/**
	 * 居民修改密码/忘记密码
	 * @param request
	 * @param response
	 * @param tel
	 * @param password
	 * @throws IOException
	 */
	@RequestMapping(value="/updatePass.action",method=RequestMethod.POST)
	public void updatePass(HttpServletRequest request,HttpServletResponse response,String tel,String password) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	

		JSONObject jsonObject=new JSONObject();
		
		Resident re=residentService.findResidentByTel(tel);
		
		if(re!=null){
			
			re.setTel(tel);
			re.setPassword(password);
			
			
			try {
				
				residentService.updateResidentPass(re);
				
				jsonObject.put("status", 1);
				jsonObject.put("message", "Password Modification SUCCESS ");
				
				
			} catch (Exception e) {
				
				jsonObject.put("status", 0);
				jsonObject.put("message", e.toString());
				
			}
		}else{
			jsonObject.put("status", 0);
			jsonObject.put("message", "手机号错误");
		}
		
		response.getWriter().write(jsonObject.toString());
				
	}
	
	
	
	
	
	
	
	/**
	 * 居民获取验证码
	 * @param request
	 * @param response
	 * @param tel
	 * @throws IOException
	 */
	@RequestMapping(value="/getVerifyingCode.action",method=RequestMethod.POST)
	public void getVrifyingCode(HttpServletRequest request,HttpServletResponse response,String tel) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int code=(int)((Math.random()*9+1)*1000);
		String verifyCode=""+code;
		
		JSONObject jsonObject=new JSONObject();
		
		int flag=BaseUtil.sendVerifyCode(tel, verifyCode);
		
		if(1==flag){
			jsonObject.put("status", 1);
			jsonObject.put("message", verifyCode);
		}else{
			jsonObject.put("status", 0);
			jsonObject.put("message", "短信发送失败");
		}
			
		response.getWriter().write(jsonObject.toString());
		
	}
	
	
	
	
	
	
	
}
















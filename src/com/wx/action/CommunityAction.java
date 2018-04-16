package com.wx.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.entity.Community;
import com.wx.service.CommunityService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 社区类 控制器
 * @author 崔为满
 * @date 2018年3月29日 下午1:46:15
 */

@Controller
@RequestMapping(value="/community")
public class CommunityAction {
	
	private CommunityService communityService;
	
	@Resource(name="communityServiceID")
	public void setCommunityService(CommunityService communityService) {
		this.communityService = communityService;
	}
	
	
	
	
	
	/**
	 * 根据 居民ID 获取社区列表
	 * @param request
	 * @param response
	 * @param rid
	 * @throws IOException
	 */
	@RequestMapping(value="/getCommunityListByRid",method=RequestMethod.POST)
	public void getCommunityListByRid(HttpServletRequest request,HttpServletResponse response,String rid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			List<Community> communityList=communityService.getCommunityList(rid);
			
			if(0==communityList.size()||null==communityList){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else{
				
				JSONArray jsonArray=JSONArray.fromObject(communityList);
				
				jsonObject.put("status", 1);
				jsonObject.put("message", jsonArray);
				
			}
			
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * 获取社区名称和ID
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/getCommunityList",method=RequestMethod.POST)
	public void getCommunityList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			List<Community> communityList=communityService.getCommunity();
			
			if(0==communityList.size()||null==communityList){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else{
				
				JSONArray jsonArray=JSONArray.fromObject(communityList);
				
				jsonObject.put("status", 1);
				jsonObject.put("message", jsonArray);
				
			}
			
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
		
		
	}
	
	
	
	
}











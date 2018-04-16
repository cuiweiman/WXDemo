package com.wx.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.entity.Notice;
import com.wx.service.NoticeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 通知类 控制器
 * @author 崔为满
 * @date 2018年3月27日 下午3:49:26
 */

@Controller
@RequestMapping(value="/notice")
public class NoticeAction {
	
	private NoticeService noticeService;
	
	@Resource(name="noticeServiceID")
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	
	
	
	/**
	 * 接口
	 * 根据社区id获取该社区发布的通知
	 * @param request
	 * @param response
	 * @param cid	社区id
	 * @throws IOException
	 */
	@RequestMapping(value="/getNoticeList.action",method=RequestMethod.POST)
	public void getNoticeList(HttpServletRequest request,HttpServletResponse response,String cid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
	
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			List<Notice> noticeList=noticeService.getNoticeList(cid);
			
			if(0==noticeList.size()||null==noticeList){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else {
				
				JSONArray jsonArray=JSONArray.fromObject(noticeList);
				
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
	 * 接口
	 * 根据通知id获取该通知的详情
	 * @param request
	 * @param response
	 * @param nid	通知的id
	 * @throws IOException
	 */
	@RequestMapping(value="/getNoticeById.action",method=RequestMethod.POST)
	public void getNoticeById(HttpServletRequest request,HttpServletResponse response,String nid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
	
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			Notice notice=noticeService.getNoticeById(nid);
			
			if(null==notice){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else {
								
				jsonObject.put("status", 1);
				jsonObject.put("message", notice);
				
			}
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
		
	}
	
	
	
	
	
	
	/**
	 * 接口
	 * 根据社区id获取该  社区 的 最新通知
	 * @param request
	 * @param response
	 * @param nid	通知的id
	 * @throws IOException
	 */
	@RequestMapping(value="/getNoticeNew.action",method=RequestMethod.POST)
	public void getNoticeNew(HttpServletRequest request,HttpServletResponse response,String cid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
	
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			Notice notice=noticeService.getNoticeNew(cid);
			
			if(null==notice){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else {
								
				jsonObject.put("status", 1);
				jsonObject.put("message", notice);
				
			}
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
		
	}
	
	
	
	
	
	
	
	
	
	
	
}





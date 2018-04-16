package com.wx.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.entity.Fault;
import com.wx.service.FaultService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 故障类 控制器
 * @author 崔为满
 * @date 2018年3月29日 上午11:59:31
 */

@Controller
@RequestMapping(value="/fault")
public class FaultAction {
	
	private FaultService faultService;
	
	@Resource(name="faultServiceID")
	public void setFaultService(FaultService faultService) {
		this.faultService = faultService;
	}
	
	
	/**
	 * 添加故障内容
	 * @param fault 故障实体类对象
	 * @throws IOException 
	 */
	@RequestMapping(value="/addFault.action",method=RequestMethod.POST)
	public void addFault(HttpServletRequest request,HttpServletResponse response,String area,String thing,String descripe,int flag,String rid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			Fault fault=new Fault();
			fault.setArea(area);
			fault.setDescripe(descripe);
			fault.setFlag(flag);
			fault.setRid(rid);
			fault.setThing(thing);
			
			faultService.addFault(fault);
			
			jsonObject.put("status", 1);
			
			
		} catch (Exception e) {
			
			jsonObject.put("status", 1);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());		
		
	}
	
	
	
	
	/**
	 * 根据居民id查询该居民汇报的故障
	 * @param rid 居民id
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/findFaultList.action",method=RequestMethod.POST)
	public void findFaultList(HttpServletRequest request,HttpServletResponse response,String rid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			List<Fault> faultList=faultService.findFaultList(rid);
			
			if(0==faultList.size()||null==faultList){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else{
				
				JSONArray jsonArray=JSONArray.fromObject(faultList);
				
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
	 * 根据fid查询该故障的详情
	 * @param fid 故障id
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/findFaultById.action",method=RequestMethod.POST)
	public void findFaultById(HttpServletRequest request,HttpServletResponse response,String fid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			Fault fault=faultService.findFaultById(fid);
			
			if(null==fault){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else{
								
				jsonObject.put("status", 1);
				jsonObject.put("message", fault);
				
			}
			
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
		
	}
	
	
	
	
	
	
}

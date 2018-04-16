package com.wx.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.entity.Article;
import com.wx.service.ArticleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 文章类 控制器
 * @author 崔为满
 * @date 2018年3月28日 下午5:16:14
 */

@Controller
@RequestMapping(value="/article")
public class ArticleAction {
	
	private ArticleService articleService;
	
	@Resource(name="articleServiceID")
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
	
	/**
	 * 接口
	 * 根据社区id获取该社区发布的文章，只选取前三篇以便首页展示
	 * @param request
	 * @param response
	 * @param cid	社区id
	 * @throws IOException
	 */
	@RequestMapping(value="/getArticleList.action",method=RequestMethod.POST)
	public void getArticleList(HttpServletRequest request,HttpServletResponse response,String cid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			List<Article> articleList=articleService.getArticleList(cid);
			
			if(0==articleList.size()||null==articleList){
				
				jsonObject.put("status", 0);
				jsonObject.put("message", "查询数据为空");
				
			}else{
				
				JSONArray jsonArray=JSONArray.fromObject(articleList);
				
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
	 * 根据社区id获取该社区发布的所有文章，
	 * @param request
	 * @param response
	 * @param cid	社区id
	 * @throws IOException
	 */
	@RequestMapping(value="/getAllArticleList.action",method=RequestMethod.POST)
	public void getAllArticleList(HttpServletRequest request,HttpServletResponse response,String cid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			List<Article> articleList=articleService.getAllArticleList(cid);
			
			int status=1;
			JSONArray jsonArray=JSONArray.fromObject(articleList);
			
			jsonObject.put("status", status);
			jsonObject.put("message", jsonArray);
			
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
		
	
	}
	
	
	
	
	
	
	
	/**
	 * 接口
	 * 根据文章id获取该文章的详情
	 * @param request
	 * @param response
	 * @param aid	文章id
	 * @throws IOException
	 */
	@RequestMapping(value="/getArticleById.action",method=RequestMethod.POST)
	public void getArticleById(HttpServletRequest request,HttpServletResponse response,String aid) throws IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		JSONObject jsonObject=new JSONObject();
		
		try {
			
			Article article=articleService.getArticleById(aid);
			
			if(null == article){
				jsonObject.put("status", 0);
				jsonObject.put("message", "数据为空");
			}else{
				jsonObject.put("status", 1);
				jsonObject.put("message", article);
			}
			
		} catch (Exception e) {
			
			jsonObject.put("status", 0);
			jsonObject.put("message", e.toString());
			
		}
		
		response.getWriter().write(jsonObject.toString());
		
	
	}
	
	
	
}











package com.wx.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.dao.ArticleDao;
import com.wx.dao.FaultDao;
import com.wx.dao.MiddleDao;
import com.wx.dao.NoticeDao;
import com.wx.dao.ResidentDao;
import com.wx.entity.Article;
import com.wx.entity.Fault;
import com.wx.entity.Middle;
import com.wx.entity.Notice;
import com.wx.entity.Resident;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestDao {
	
	@Test
	public void testNoticeDao(){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring.xml"});	
		NoticeDao noticeDao=(NoticeDao) ac.getBean("noticeDaoID");
		List<Notice> notices=noticeDao.getNoticeList("171115120856");
		
		JSONObject jsonObject=new JSONObject();
		
		JSONArray jsonArray=JSONArray.fromObject(notices);
		
		jsonObject.put("status", "1");
		jsonObject.put("notices", jsonArray);
		
		String str=jsonObject.toString();
		System.out.println(str);
		
	}
	
	
	
	
	
	@Test
	public void testArticleDao(){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		
		ArticleDao articleDao=(ArticleDao) ac.getBean("articleDaoID");
		List<Article> articles=articleDao.getArticleList("171115120856");
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("status", 1);
		
		JSONArray jsonArray=JSONArray.fromObject(articles);
		jsonObject.put("message", jsonArray);
		
		System.out.println(jsonObject.toString());
		
	}
	
	
	
	@Test
	public void testFaultDaoAddFault(){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		FaultDao faultDao=(FaultDao) ac.getBean("faultDaoID");
		
		Fault fault=new Fault();
		fault.setArea("颐安花园6门305");
		fault.setThing("厨房里的水龙头");
		fault.setDescripe("水龙头一直漏水");
		fault.setFlag(0);
		fault.setRid("7822901adb634a8f85");
		
		faultDao.addFault(fault);
		
		
	}
	
	
	
	
	@Test
	public void testFaultDaogetFaultListByResidengId(){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		
		FaultDao faultDao=(FaultDao) ac.getBean("faultDaoID");
		List<Fault> faultList=faultDao.findFaultList("7822901adb634a8f85");
		
		JSONObject jsonObject=new JSONObject();
		
		JSONArray jsonArray=JSONArray.fromObject(faultList);
		
		jsonObject.put("status",1);
		jsonObject.put("message", jsonArray);
		
		System.out.println(jsonObject.toString());
		
		
	}
	
	
	
	
	
	@Test
	public void testResidentDaoGetResidentByTelPass(){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		ResidentDao residentDao=(ResidentDao) ac.getBean("residentDaoID");
		
		Resident resident=new Resident();
		resident.setTel("13177776666");
		resident.setPassword("123");
		
		Resident resident0=residentDao.getResidentByTelPass(resident);
		System.out.println(resident0.toString());
		
	}
	
	
	
	@Test
	public void testResidentDaoAddResident(){
		
		Resident resident=new Resident();
		resident.setId();
		resident.setName("橙子");
		resident.setTel("17677776666");
		resident.setPassword("123");
		resident.setSex("男");
		resident.setProvince("广东");
		resident.setCity("广州");
		resident.setCounty("天河区");
		
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		ResidentDao residentDao=(ResidentDao) ac.getBean("residentDaoID");
		
		residentDao.addResident(resident);
		
		
		
	}
	
	
	

	
	@Test
	public void testResidentDaoUpdateResidentPass(){
		
		Resident resident=new Resident();
		resident.setId();
		resident.setTel("17677776666");
		resident.setPassword("123");
		
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		ResidentDao residentDao=(ResidentDao) ac.getBean("residentDaoID");
		
		residentDao.updateResidentPass(resident);
		
		
		
	}
	
	
	
	
	
	@Test
	public void testMiddleDaoAddMiddle(){
		
		Middle middle=new Middle();
		middle.setCid("171115120856");
		middle.setRid("6538b57df17d4108a2");
		
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		MiddleDao middleDao=(MiddleDao) ac.getBean("middleDaoID");
		
		middleDao.addMiddle(middle);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
























package com.wx.service.impl;

import com.wx.dao.ResidentDao;
import com.wx.entity.Resident;
import com.wx.service.ResidentService;

public class ResidentServiceImpl implements ResidentService {
	
	private ResidentDao residentDao;
	
	public void setResidentDao(ResidentDao residentDao) {
		this.residentDao = residentDao;
	}
	
	
	
	

	@Override
	public Resident getResidentByTelPass(Resident resident) {

		return residentDao.getResidentByTelPass(resident);
	}
	
	
	

	@Override
	public void addResident(Resident resident) {
		
		residentDao.addResident(resident);
		
	}
	
	
	
	
	
	

	@Override
	public void updateResidentPass(Resident resident) {
		
		residentDao.updateResidentPass(resident);
		
	}





	@Override
	public Resident findResidentByTel(String tel) {
		
		return residentDao.findResidentByTel(tel);
	}

	
	
}



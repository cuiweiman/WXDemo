package com.wx.service.impl;

import java.util.List;

import com.wx.dao.FaultDao;
import com.wx.entity.Fault;
import com.wx.service.FaultService;

public class FaultServiceImpl implements FaultService {
	
	private FaultDao faultDao;
	
	public void setFaultDao(FaultDao faultDao) {
		this.faultDao = faultDao;
	}

	@Override
	public void addFault(Fault fault) {
		
		faultDao.addFault(fault);
		
	}

	@Override
	public List<Fault> findFaultList(String rid) {

		return faultDao.findFaultList(rid);
		
	}

	@Override
	public Fault findFaultById(String fid) {
		
		return faultDao.findFaultById(fid);
	}

}

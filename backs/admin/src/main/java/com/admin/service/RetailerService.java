package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dao.ReatilerDaoInt;
import com.admin.dao.RetailerDao;
import com.admin.model.Retailer;

@Service("retailerService")
public class RetailerService  implements RetailerServiceInt{
	
	@Autowired
	  public ReatilerDaoInt retailerDao;
	
	public List<Retailer> getRetailers() {
		 List<Retailer>  retailer =retailerDao. getRetailers();
		  return retailer;
		  
	}
	public boolean removeRetailer(String id){
		return retailerDao.removeRetailer(id);
	}

}
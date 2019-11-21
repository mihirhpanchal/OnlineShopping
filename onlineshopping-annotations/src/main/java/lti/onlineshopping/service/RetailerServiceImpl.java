package lti.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lti.onlineshopping.dao.ReatilerDaoIntf;
import lti.onlineshopping.model.Retailer;


@Service("retailerService")
public class RetailerServiceImpl  implements RetailerServiceInt{
	
	@Autowired
	public ReatilerDaoIntf retailerDao;
	
	@Transactional
	public List<Retailer> getRetailers() {
		 List<Retailer>  retailer = retailerDao. getRetailers();
		  return retailer;
		  
	}
	
	@Transactional
	public boolean removeRetailer(String id){
		return retailerDao.removeRetailer(id);
	}

}
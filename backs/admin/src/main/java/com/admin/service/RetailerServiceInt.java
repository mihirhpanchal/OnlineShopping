package com.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.model.Retailer;

@Service
public interface RetailerServiceInt {
	
	public List<Retailer> getRetailers();
	public boolean removeRetailer(String id);

}
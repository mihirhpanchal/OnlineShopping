package com.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.admin.model.Retailer;
import com.admin.service.RetailerServiceInt;




@Repository("retailerDao")
public class RetailerDao implements ReatilerDaoInt{
	
	public List<Retailer> getRetailers(){
		
			  EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			  EntityManager em = emf.createEntityManager();	  
			  @SuppressWarnings("unchecked")
				List<Retailer> retailer = em.createQuery("SELECT u FROM  Retailer u").getResultList();
			  return  retailer;
			  }
	
	
	public boolean removeRetailer(String id){
		boolean flag=false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		  EntityManager em = emf.createEntityManager();	  
		  EntityTransaction t = em.getTransaction();
		  t.begin();
		  Retailer re= em.find(Retailer.class,id);
		  if(re!=null){
		  em.remove(re);
		  t.commit();
		  flag=true;
		  }
		 em.close();
		  return flag;
	
	}
	}
	


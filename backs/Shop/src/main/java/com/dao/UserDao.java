package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.model.Users;


@Repository("userDao")
public class UserDao {
	
	public List<Users> getUsers(){
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		  EntityManager em = emf.createEntityManager();	  
		  @SuppressWarnings("unchecked")
			List<Users> users = em.createQuery("SELECT u FROM  Users u").getResultList();
		  em.close();
		  return  users;
		  }
	
	public Users getUser(String userid){
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		  EntityManager em = emf.createEntityManager();
		  Users users = em.find(Users.class,userid);
	
		return users;
		
	}

}
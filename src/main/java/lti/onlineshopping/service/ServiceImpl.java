package lti.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.onlineshopping.dao.DaoIntf;
import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;

@Service("myService")
public class ServiceImpl implements ServiceIntf {

	@Autowired
	DaoIntf myDao;
	public boolean insertProduct(Product product) {
		System.out.println("Service is called");
		boolean flag=myDao.insertProduct(product);
		
		return flag;
	}

	public Category getCategory(String categoryname){
		System.out.println("Category service is called");
		Category c =myDao.getCategory(categoryname);
		return c;
	}

	public SubCategory getSubCategory(String scategoryname) {
		System.out.println("Category service is called");
		SubCategory s =myDao.getSubCategory(scategoryname);
		return s;
	}
	
	public List<Object[]> getUsers() {
		List<Object[]> list = myDao.getProducts();
		return list;
	}
	
}

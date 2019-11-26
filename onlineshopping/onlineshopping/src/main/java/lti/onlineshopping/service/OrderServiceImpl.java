package lti.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lti.onlineshopping.dao.OrderDaoIntf;
import lti.onlineshopping.model.Order;
@Service("orderService")
public class OrderServiceImpl implements OrderServiceIntf {

	@Autowired
	OrderDaoIntf orderDao;
	
	@Transactional
	public boolean addOrder(Order order) {
		System.out.println("Service is called");
		boolean flag=orderDao.addOrder(order);
		
		return flag;
	}

}

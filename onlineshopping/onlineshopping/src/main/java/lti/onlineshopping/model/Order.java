package lti.onlineshopping.model;

import java.util.List;

public class Order {
	
	private int orderid;
	private String username;
	private List<OrderItem> orderItem;
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", username=" + username + ", orderItem=" + orderItem + "]";
	}
	

	
	
}

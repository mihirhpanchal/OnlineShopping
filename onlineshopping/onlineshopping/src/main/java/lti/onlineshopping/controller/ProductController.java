package lti.onlineshopping.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lti.onlineshopping.model.CartItem;
import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.MyCart;
import lti.onlineshopping.model.Order;
import lti.onlineshopping.model.OrderItem;
import lti.onlineshopping.model.Payment;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;
import lti.onlineshopping.service.OrderServiceIntf;
import lti.onlineshopping.service.ProductServiceIntf;
  
@Controller("productController")
public class ProductController {
	@Autowired
	ProductServiceIntf productService;
	@Autowired
	OrderServiceIntf orderService;
	@RequestMapping(value="/placeorder",method=RequestMethod.GET)
	public ModelAndView placeorder(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart"); 
		String total=request.getParameter("total");
		String username = session.getAttribute("username").toString();
		List<CartItem> clist = mycart.getCartItem();
		Order myorder = new Order();
		Calendar cal = Calendar.getInstance();
	    Date date=cal.getTime();
		myorder.setUsername(username);
		myorder.setTotal(total);
		myorder.setDate_added(date);
		myorder.setOrderItem(new ArrayList<OrderItem>());
		 for (CartItem item : clist) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProdid(item.getProduct_id());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setPrice(item.getPrice());
			myorder.getOrderItem().add(orderItem);
		 }
		boolean flag = orderService.addOrder(myorder);
		int myorderid = myorder.getOrderid();
		ModelAndView mav = new ModelAndView("ordersucessful");
		mav.addObject("myorderid",myorderid);
		return mav;
	}
	
	@RequestMapping(value = "/orderconfirm", method = RequestMethod.GET)
	public ModelAndView orderconfirm(MyCart cart, HttpServletRequest request) {
			HttpSession session = request.getSession();
			MyCart mycart = (MyCart)session.getAttribute("mycart"); 
			String total=request.getParameter("total");
			List<CartItem> clist = mycart.getCartItem();
			Order myorder = new Order();
			myorder.setOrderItem(new ArrayList<OrderItem>());
			 for (CartItem item : clist) {
				OrderItem orderItem = new OrderItem();
				orderItem.setProdid(item.getProduct_id());
				orderItem.setQuantity(item.getQuantity());
				orderItem.setPrice(item.getPrice());
				myorder.getOrderItem().add(orderItem);
			 }
			myorder.setTotal(total);
			ModelAndView mav = new ModelAndView("orderconfirm");
			mav.addObject("myorder",myorder);
			mav.addObject("total",total);
			return mav;
		}
		

	@RequestMapping(value="/viewallprods",method=RequestMethod.GET)
	public ModelAndView viewallprods(HttpServletRequest request,HttpServletResponse response)
	{
	ModelAndView mav = new ModelAndView("viewallprod");
	return mav;
	}
	
	@RequestMapping(value = "/viewmycart", method = RequestMethod.GET)
	public ModelAndView viewmycart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart");
		
		ModelAndView mav = new ModelAndView("viewmycart");
		mav.addObject("mycart",mycart);
		return mav;
	}
	
	
	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public ModelAndView addtocart(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		int quantity=Integer.parseInt(request.getParameter("qty"));
		String price = request.getParameter("unitprice");
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart");
		if(mycart==null){
			mycart = new MyCart();
			mycart.setCartItem(new ArrayList<CartItem>());
		}
		CartItem cartItem = new CartItem();
		cartItem.setProduct_id(prodid);
		cartItem.setQuantity(quantity);
		cartItem.setPrice(price);
		mycart.getCartItem().add(cartItem);
		session.setAttribute("mycart", mycart);
		ModelAndView mav = new ModelAndView("viewallprod");
		return mav;
	}
	
	 @RequestMapping(value = "/insertproduct.do", method = RequestMethod.GET)
	  public ModelAndView showRegister2(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("regproduct");
	    mav.addObject("product", new Product());
	    return mav;
	  }
		
	@RequestMapping(value="/insertproduct.do",method=RequestMethod.POST)
	public ModelAndView insertContact(HttpServletRequest request,HttpServletResponse response,   @RequestParam("file") MultipartFile files[])
	{
		String product_name=request.getParameter("product_name");
		String brand=request.getParameter("brand");
		String product_description=request.getParameter("product_description");
		String unit_price=request.getParameter("unit_price");
		String quantity=request.getParameter("quantity");
		String categoryname=request.getParameter("category");
		String subcategoryname=request.getParameter("subcategory");
		String filename=request.getParameter("filename");
		
		Category category = productService.getCategory(categoryname);
		String cid = category.getCategory_id();

		SubCategory subcategory = productService.getSubCategory(subcategoryname);
		String sid = subcategory.getSub_id();
		
		Calendar cal = Calendar.getInstance();
	    Date date=cal.getTime();
		
		
		Product product=new Product();
		product.setProduct_name(product_name);
		product.setBrand(brand);
		product.setProduct_description(product_description);
		product.setUnit_price(unit_price);
		product.setQuantity(quantity);
		product.setCategory(category);
		product.setSubcategory(subcategory);
		product.setDate_added(date);
		product.setFilename(filename);
		
		String product_name1 = product.getProduct_name();
		
		//uploading files
		for (int i = 0; i < files.length; i++) {
		/*String*/ filename="";
		if(i==0)
						filename=(product_name+i)+".jpg";
		MultipartFile file = files[i];
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()+ File.separator + filename);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			
			if(i==0)
           product.setFilename(filename);
			
			} catch (Exception e) {
			System.out.println( "You failed to upload " + (product_name+i) + " => " + e.getMessage());
		}
		}
	
		
		
		boolean flag= productService.insertProduct(product);
		ModelAndView mav=new ModelAndView();
		mav.addObject("product_name",product_name);
		mav.addObject("product_description",product_description);
		mav.addObject("unit_price",unit_price);
		mav.addObject("quantity",quantity);
		mav.addObject("category_id",cid);
		mav.addObject("sub_id",sid);
		mav.addObject(date);
		mav.addObject(filename, filename);
		if(flag)
		{
			mav.addObject("status","Thanks msg is accepted");
		}else{
			mav.addObject("status","sorry msg is not accepted");
		}
		mav.setViewName("productadded");
		return mav;
	}
		@RequestMapping(value="/viewallprod", method=RequestMethod.GET)
	public ModelAndView viewusers(HttpServletRequest request,HttpServletResponse response){
		
		List<Object[]> products = productService.getProducts();
		ModelAndView mav = new ModelAndView("viewallprod");
		mav.addObject("products", products);
		return mav;
	}
	
	@RequestMapping(value = "/singleproduct", method = RequestMethod.GET)
	public ModelAndView fetchDetails(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		
		Product products = productService.fetchDetails(prodid);
	   
		
		ModelAndView mav = new ModelAndView("singleproduct");
		mav.addObject("prodid", prodid);
		mav.addObject("products",products);
		return mav;
	}
	
	
	@RequestMapping(value = "/singleproductforcompare", method = RequestMethod.GET)
	public ModelAndView compare(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		Product products = productService.compareProduct(prodid);
		ModelAndView mav = new ModelAndView("compare");
		mav.addObject("products",products);
		
		return mav;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView viewSearchResults(HttpServletRequest request,HttpServletResponse response){
		
		String search = request.getParameter("search");
		
		List<Product> searchList = productService.searchKeywords(search);
		if(searchList.size()!=0){
			ModelAndView mav = new ModelAndView("viewsearchresults");
			mav.addObject("searchList", searchList);
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView("nosearchresult");
			mav.addObject("result", "Sorry, no product for the proposed search found");
			return mav;
		}

	}
	
	/*@RequestMapping(value="/payment.do", method = RequestMethod.POST)
	public ModelAndView makepayment(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String card_type=request.getParameter("card_type");
		System.out.println("card_type"+card_type);
		String card_number=request.getParameter("card_name");
		System.out.println("card_number");
		//order_id = request.getAttribute(order_id);
		String category=request.getParameter("category");
		String expirydate = request.getParameter(expirydate);

		Order order =(Order)session.getAttribute("order");
		Payment payment = new Payment();
		payment.setCard_number(card_number);
		payment.setCard_type(card_type);
		payment.setCategory(category);
		payment.setCvv(cvv);
		payment.setDate(date);
		payment.setExpirydate(expirydate);
		payment.setOrder_id(order_id);
		payment.setPayment_id(payment_id);
		private String payment_id;
		private String order_id;

		private String category;
		private String cvv;
		private Date date;
		
		
		
	}*/
	
	@RequestMapping(value = "/removeproduct", method = RequestMethod.GET)
	public ModelAndView removeProduct( HttpServletRequest request,HttpServletResponse response){
		
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		boolean flag = productService.removeProduct(prodid);
		ModelAndView mav = new ModelAndView("deletedproduct");
		mav.addObject("text","Product successfully deleted");
		 return mav;
		}
	
}

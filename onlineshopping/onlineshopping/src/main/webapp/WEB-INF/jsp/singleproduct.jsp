<%@page import="java.util.List"%>
<%@page import="lti.onlineshopping.service.ProductServiceImpl"%>
<%@page import="lti.onlineshopping.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="security" --%>
<%-- 	uri="http://www.springframework.org/security/tags"%> --%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/assets/js/jquery.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<style>

<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
  float:left;
  width:75%;
}

.price {
 
  color: grey;
  font-size: 22px;
  
  border: none;
  outline: 0;
  padding: 12px;
  color: black;
  background-color: #a1887f ;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button {
  
}

.card button:hover {
  opacity: 0.7;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .card {
    width: 100%;
    display: table;
    margin-bottom: 20px;
  }
}


}

body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
.w3-sidenav a, .w3-sidenav h4 {
	font-weight: bold
}

</style>
</head>
<body>
<div><%@ include file="/shared/navbar2.jsp"%></div>
<%-- <%
int prodid;
Product products = null;
 products = new ProductServiceImpl().compareProduct(products.getProduct_id());
%> --%>
	<hr><div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
	<%-- <c:forEach items="${products}" var="product"> --%>
	 <%-- <%
	    for( Object[] product :products){
	         String url = "singleproduct.do?prodid="+product[0]; 		    
	 %> --%>
	 

	 
	 <%
	 String url = "addtocart.do";
	 %>
	 
	 <div class="card">
	   <div class="price">

		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/assets/images/products/two.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
			</div>
			</div>
			
	  <div class="card">
	  <div class="price">
			
				<h2>Product Name: <c:out value="${products.product_name }"/></h2>
	<h2>Price: <c:out value="${products.unit_price }"/></h2>
	Product Description: <c:out value="${products.product_description }"></c:out><br> <br>
	Category: <c:out value="${products.category.category_name}"/><br><br>
	Sub Category: <c:out value="${products.subcategory.sub_name}"/><br> <br>
	Brand: <c:out value="${products.brand}"/><br><br>
	<form action="addtocart.do" method="post">
	<input type="hidden" name="prodid" id="prodid" value="${prodid}"/>
	Quatity:
	<input type="number" name="qty" id="qty" required><br><br>
	<input type="submit" value="Add to cart">
	</form>
			</div>
		</div>
	
		</div>
		</div>
		<div><%@ include file="../../shared/footer.jsp"%></div> 	
	<%-- <hr><div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/assets/images/products/two.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<h1>Product Name: <c:out value="${products.product_name }"/></h1><br>
	<h2>Price: <c:out value="${products.unit_price }"/></h2><br>
	Product Description:<c:out value="${products.product_description }"></c:out><br>
	Category<c:out value="${products.category.category_name}"/><br>
	Sub Category<c:out value="${products.subcategory.sub_name}"/><br> 
	Brand:<c:out value="${products.brand}"/><br>
			</div>
		</div> --%>
	<!-- </div> -->
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
  <jsp:include page="/shared/navbar.jsp" />
 <c:if test="${empty mycart or empty mycart.cartItem}">
       <h2>There is no items in Cart</h2>
       <a href="${pageContext.request.contextPath}/viewallprod.do">Show
           Product List</a>
 </c:if>
 <c:if test="${not empty mycart and not empty mycart.cartItem}">
 <table align="center" cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
</tr>
<c:set var="total" value="0"></c:set>
<c:forEach items="${mycart.cartItem}" var="cartItem">
<c:set var="total" value="${total + cartItem.price * cartItem.quantity }"></c:set>
<tr>
<%-- 				<td align="center"><a
					href="${pageContext.request.contextPath }/cart/remove/${item.product.id }"
					onclick="return confirm('Are you sure?')">Remove</a></td> --%>
				<td>${cartItem.product_id }</td>
				<td>${cartItem.product_name }</td>
				<td>product photo</td>
				<td>${cartItem.price }</td>
				<td>${cartItem.quantity }</td>
				<td>${cartItem.price * cartItem.quantity }</td>
			</tr>
<%-- <c:out value="${cartItem.product_id}"/> &nbsp;<c:out value="${cartItem.quantity}"/>  &nbsp;<c:out value="${cartItem.price}"/><br>  --%>

</c:forEach>



		<tr>
			<td colspan="6" align="right">Sum</td>
			<td>${total } Rupees</td>
		</tr>
	</table>
	

<center><a href="/orderconfirm.do" class="btn btn-default">Confirm Order</a></center>

</c:if>
  <jsp:include page="/shared/footer.jsp" />
</body>
</html>
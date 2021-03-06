<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.topnav .search-container {
  float: right;
}
.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}
.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}
.topnav .search-container button:hover {
  background: #ccc;
}
@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/x-icon" href="<c:url value="/assets/images/favicon1.png"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/assets/js/jquery.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/css/overall.css"/>">

</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<div class="nav navbar">
		</div>

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/" />">VPshop.ML</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href=" <c:url value="/" />">Home</a></li>
				<li><a href=" <c:url value="viewallprod.do" />">Product
						List</a></li>
				<li><a href=" <c:url value="/aboutUs.jsp" />">About Us</a></li>
				
<!-- 				<security:authorize access="hasRole('ROLE_USER')"> -->
				<li><a href=" <c:url value="/contact.jsp" />">Contact Us</a></li>
<!-- 				</security:authorize> -->
				
				<!-- 			Only admin can view this link -->
<!-- 				<security:authorize access="hasRole('ROLE_ADMIN')"> -->
				<%-- <li><a href=" <c:url value="regproduct.jsp" />">Add Product</a></li> --%>
				 	<%-- <li><a href=" <c:url value="retailer.jsp" />">Sell Products</a></li>  --%>
				<li><div class="search-container">
    <form action="search.do">
      <input type="text" name="search" placeholder="Search..">
      <button type="submit"><i class="fa fa-search"></i></button>
      
      
      
    </form>
  </div></li>
				<%String uname = (String)session.getAttribute("username"); %>
				<%if(uname==null){ %>
				<li><font style="color: white; font-size:20px;">&nbsp;&nbsp;&nbsp;Hello, Guest</font></li>
				<%} %>
				<%if(uname!=null){ %>
				<li><font style="color: white; font-size: 20px;">&nbsp;&nbsp;&nbsp;Hello, ${username}</font></li>
				<%} %>
				
					
				
<!-- 				</security:authorize> -->
			</ul>

			<ul class="nav navbar-nav navbar-right">

				<c:if test="${!empty pageContext.request.userPrincipal.name}">
					<li><a href="<c:url value="/index" />"><span
							class="glyphicon glyphicon-shopping-user"></span>Welcome..${pageContext.request.userPrincipal.name}</a></li>

<!-- 					<security:authorize access="hasRole('ROLE_USER')"> -->
						<li><a href="<c:url value="/viewmycart.do" />"><span
								class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
<!-- 					</security:authorize> -->
					<li><a href="<c:url value="/logout" />"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
			</ul>


			<ul class="nav navbar-nav navbar-right">

				<c:if test="${pageContext.request.userPrincipal.name==null}">
					<li><a href="<c:url value="/viewmycart.do" />"><span
							class="glyphicon glyphicon-shopping-cart"></span>My Cart</a></li>
							<%String uname1 = (String)session.getAttribute("username");
							if(uname1==null){ %>
							<li><a href="<c:url value="/signup.do" />"><span
							class="glyphicon glyphicon-log-user"></span> SignUp</a></li>
							<li><a href="<c:url value="/loginProcess.do" />"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
							<%} %>
							<%if(uname1!=null){ %>
							<li><a href="<c:url value="/logoutProcess.do" />"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
							<%} %>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>



</body>
</html>
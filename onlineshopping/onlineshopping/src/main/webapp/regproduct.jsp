
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE tml PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Registration</title>
<style>
.containerrp{
position:absolute;

top:32%;
left:28%;
width:55%;
height:143%;



font-family:arial;
z-index:100;
background-color:#F1F1F1;
}
.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

.product{
position:relative;


padding-left: 176px;
color:black;

font-size:20px;
font-weight:bold;


line-height:35px;

}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
input,
.btn {
  width: 100%;
  padding: 12px;
  border: none;
  border-radius: 4px;
  margin: 5px 0;
  opacity: 0.85;
  display: inline-block;
  font-size: 17px;
  line-height: 20px;
  text-decoration: none; /* remove underline from anchors */
}


input:hover,
.btn:hover {
  opacity: 1;
}

input[type=text], select, textarea{
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  resize: vertical;
}

input[type=number], select, textarea{
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  resize: vertical;
}


/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
}







</style>
</head>
<body>
 <header><%@ include file="shared/retailernavbar.jsp"%></header> 


<div class="containerrp">

<div class="product">Add New Product<br> </div>


<div class="col" style="position:absolute;top:65px;left:175px;width:50%;z-index:105">

<form action= "insertproduct.do" method= "post"  id= "register" modelAttribute= "product" enctype= "multipart/form-data">

	
<!--   <form action="insertproduct.do" method="post"> -->
	<div class="row">
      <div class="col-25">
 	<label >Product Name: </label>
	</div>
	<div class="col-75">
    <input type="text" id="product_name" name="product_name" placeholder="Enter Product Name" required>
	</div>
	</div>
    <br><br>

	<div class="row">
      <div class="col-25">
    <label >Product Description: </label>
	</div>
	<div class="col-75">
    <textarea rows="4" cols="15" name="product_description" autofocus required
		title="Please write the Description of Product"></textarea>
	</div>
	</div>
    <br><br>
	<div class="row">
      <div class="col-25">
    <label >Category: </label>
	</div>
	<div class="col-75">
    <select name="category">
      <option value="Electronics">Electronics</option>
      <option value="Fashion">Fashion</option>
      <option value="Health">Health</option>
    </select>
	</div>
	</div>
    <br><br>
	
	<div class="row">
      <div class="col-25">
    <label >SubCategory: </label>
	</div>
	<div class="col-75">
    <select name="subcategory">
      <option value="Mobile">Mobile</option>
      <option value="Shoes">Shoes</option>
      <option value="Medicine">Medicine</option>
    </select>
	</div>
	</div>
	<br><br>

	<div class="row">
      <div class="col-25">
    <label >Brand: </label>
	</div>
	<div class="col-75">
    <input type="text" id="brand" name="brand" placeholder="Enter your brand name" autofocus required
		title="Brand Name cannot be in numbers">
	</div>
	</div>
    <br><br>

<div class="row">
      <div class="col-25">
    <label ><b>Upload Product Image&nbsp; :</b> </label>
	</div>
	<div class="col-75">
    <input type="file" name="file" id="product_nmae">
	</div>
	</div>
    <br><br>    
    

	<div class="row">
      <div class="col-25">
    <label >Unit price: </label>
	</div>
	<div class="col-75">
    <input type="text" id="unit_price" pattern="\d+(\.\d{2})?" name="unit_price" placeholder="Unit price of the product" autofocus required
		title="Unit Price should be in Numbers only. Eg:111.11">
	</div>
	</div>
    <br><br>

	<div class="row">
      <div class="col-25">
    <label >Stock </label>
	</div>
	<div class="col-75">
    <input type="number" id="quantity" name="quantity" min="0" step="1" placeholder="Enter the stock for product" autofocus required
		title="Stock should only contain Numeric values ">
	</div>
	</div>
    <br><br>
	<div class="row">
      
    <input type="submit" value="Submit">
	</div>

 
  </form>

</div>

</div>
 <div><%@ include file="shared/footer.jsp"%></div>


</body>
</html>
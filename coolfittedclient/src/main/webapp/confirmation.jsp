<%-- 
    Document   : cart
    Created on : May 30, 2017, 12:52:46 PM
    Author     : arca
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="script.js"></script>
<head>
	<title>CoolFitted hats</title>
</head>
<body>
	<center>
		<div class='main'>
			<div class='content'>
				<div class='menubar'>
				<div class='name'>
					<a href="home" class="label compname">CoolFitted</a>
				</div>
				<div class='menu'>
					<a href="home" class='label home'>Home</a>
					<a href="newarrivals" class='label snap'>New Arrivals</a>
					<a href="snaps" class='label snap'>Snapbacks</a>
					<a href="straps" class='label strap'>Strapbacks</a>
					<a href="aboutus.jsp" class='label aboutus'>About Us</a>
                                        <a href="cart.jsp" class='label cart active'>Cart</a>
					</div>
				</div>
                                <div class="featcombo">
                                    <div class="combocontent">
                                            Confirmation - Order #${orderid}
                                    </div>
                                    <div class="thank" style="margin-top:2%;color:#000;font-size: 16px;text-align: left;">
                                        Name: ${name} <br>Email: ${email}<br>Total amount charged: $${total}<br/>Shipping Address: ${address}<br>Paid with card ending in: ****${last}
                                    	<br/>
                                    	<br/>
                                    	<form action="/editorder" method="DELETE" onsubmit="return confirm('Are you sure you want to delete this order? Please click OK to confirm.');">
                                    		<input type="submit" id="delete" value="Cancel Order"/>
                                    	</form> 
                                    	&middot;   
                                    	<form action="/editorder" method="UPDATE" onsubmit="return confirm('Are you sure you want to update this order?');">
                                    		<input type="submit" id="update" value="Update shipping details" />
                                    	</form> 
                                    </div>
                         
				</div>
                                <div class='footercombo' style="margin-top:20%;">
                                        <div class='combocontent' style="font-size: 20px">
                                                CoolFitted<span style='font-size: 13px'>&reg;</span> 2017 &#8209; All Rights Reserved
                                        </div>
                                </div>
				<br/>
				<br/>
			</div>
		</div>
	</center>
</body>
</html>

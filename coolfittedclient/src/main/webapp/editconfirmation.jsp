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
                                            Order #${status}
                                    </div>
                                    <center>
                                    <div class="thank" style="margin-top:2%;color:#000;font-size: 16px;text-align: left;">
                                    Your order has been updated!
                                    <br/>
                                    You will receive an email with the updated order details.
                                    </div>
                                    </center>
                                    
                         	
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

<%-- 
    Document   : details
    Created on : May 30, 2017, 2:41:06 AM
    Author     : arca
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="script.js?v=5"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script>
    function itemAdded(){
        alert("Item has been added to cart.")
    }
</script>
<head>
	<title>CoolFitted hats</title>
</head>
<body>
	<div class='main'>
		<div class='content'>
			<center>
			<div class='menubar'>
				<div class='name'>
					<a href="index" class="label compname">CoolFitted</a>
				</div>
					<div id='men' class='menu'>
						<a href="home" class='label home active'>Home</a>
						<a href="newarrivals" class='label newarr'>New Arrivals</a>
						<a href="snaps" class='label snap'>Snapbacks</a>
						<a href="straps" class='label strap'>Strapbacks</a>
						<a href="aboutus.jsp" class='label aboutus'>About us</a>
                        <a href="cart.jsp" class='label cart'>Cart</a>
					</div>
			</div>
			<div class='itemtitle'>
				<div id='title' class='titlecontent'>
                                        ${hatlist[0].imagetitle} - ${hatlist[0].imageprice}
				</div>
			</div>
			<br/>
			<div class = "detailimg">
                            <a class = "cell">
                                    <div class = "col-1">
                                            <img src = "${hatlist[0].imagepath}" width = "140" height = "140">
                                    </div>
                            </a>
                            <a class = "cell">
                                    <div class = "col-2">
                                            <img src = "${hatlist[1].imagepath}" width = "140" height = "140">
                                    </div>
                            </a>
                            <a class = "cell">
                                    <div class = "col-3">
                                            <img src = "${hatlist[2].imagepath}" width = "140" height = "140">
                                    </div>
                            </a>
			</div>
			<br/>
			<div class='itemdetail'>
				<div id ='detail' class='detailcontent'>
					The Details:
					<br/>
                                        <ul>
					<c:set var="detailslist" value="${fn:split(hatlist[0].imagedetails, '-')}" />
                                        <c:forEach var="element" items="${detailslist}">
                                            <li>${element}</li>
                                        </c:forEach>
                                        </ul>
				</div>
			</div>
			<br/>
			</center>
			<div class="additembox">
                            <form name="additem" class="orderdetails" action="/coolfittedclient/cart" method="POST" onclick="itemAdded()">
                                <table>
                                    <tr>
                                        <td><label for="quantity">Quantity: </label></td>
                                        <td><input hidden="true" name="model" value="${hatlist[0].imagetitle}"/>
                                            <td><input hidden="true" name="price" value="${hatlist[0].imageprice}"/>
					<td><input id='quantity' style='width:35px;' name='quant' type='number' min='1' maxlength='2' value='1' required></td>
                                        <td><input type='submit' id='submit' name='submit' value='Add to Cart'></td>
                                    </tr>
                                </table>
                            </form>
			</div>
			<center>
			<div class='footercombo' style="margin-top:100px;">
				<div class='combocontent' style="padding-top:1%; font-size: 20px;margin-left: 125px;">
					CoolFitted&reg; 2017 &#8209; All Rights Reserved
				</div>
			</div>
			</center>
			<br/>
			<br/>
		</div>
	</div>
</body>
</html>
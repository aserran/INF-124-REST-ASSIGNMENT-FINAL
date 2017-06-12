<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>


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
						<a href="index" class='label compname'>CoolFitted</a>
					</div>
					<div id='men' class='menu'>
						<a href="home" class='label home active'>Home</a>
						<a href="newarrivals" class='label newarr'>New Arrivals</a>
						<a href="snaps" class='label snap'>Snapbacks</a>
						<a href="straps" class='label strap'>Strapbacks</a>
						<a href="aboutus.html" class='label aboutus'>About us</a>
                                                <a href="cart.jsp" class='label cart'>Cart</a>
					</div>
				</div>
				<div class='slideshow'>
					<div class= "slides fade">
						<div class= "slidenumber"></div>
						<img src='Media/headwear.jpg' height="380" width="70%" style='margin-top: 3%'>
					</div>

					<div class= "slides fade">
						<div class= "slidenumber"></div>
						<img src='Media/headwear2.jpg' height="380" width="70%" style='margin-top: 3%'>
					</div>

					<div class= "slides fade">
						<div class= "slidenumber"></div>
						<img src='Media/headwear3.jpg' height="380" width="70%" style='margin-top: 3%'>
					</div>

					<div class= "slides fade">
						<div class= "slidenumber"></div>
						<img src='Media/headwear4.jpg' height="380" width="70%" style='margin-top: 3%'>
					</div>

					<div class= "slides fade">
						<div class= "slidenumber"></div>
						<img src='Media/headwear5.jpg' height="380" width="70%" style='margin-top: 3%'>
					</div>
				</div>
				<br/>
				<div style="text-align:center">
					<span class="dot" onclick="currentSlide(1)"></span>
					<span class="dot" onclick="currentSlide(2)"></span>
					<span class="dot" onclick="currentSlide(3)"></span>
					<span class="dot" onclick="currentSlide(4)"></span>
					<span class="dot" onclick="currentSlide(5)"></span>
				</div>
				<script src="slides.js"></script>
				<div class='featcombo'>
					<div class='combocontent'>
						Featured Hats
					</div>
				</div>
				<table class='gridedhats'>
                                    
                                   
                                        <tr class = "row">
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${hatlist[0].imagepath}"/>')" href ="detailspage?param=${hatlist[0].imagename}">
                                                    <div class ="col-1">
                                                        <img src="<c:out value ="${hatlist[0].imagepath}"/>" width = "160" height="120">
                                                            <p><c:out value="${hatlist[0].imagetitle}"/>"<span><br><c:out value="${hatlist[0].imageprice}"/>"</span></p>
                                                    </div>
                                                </a>
                                            </td>
                                        
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${hatlist[1].imagepath}"/>')" href ="detailspage?param=${hatlist[1].imagename}">
                                                    <div class ="col-2">
                                                        <img src="<c:out value ="${hatlist[1].imagepath}"/>" width ="160" height="120">
                                                        <p><c:out value="${hatlist[1].imagetitle}"/>"<span><br><c:out value="${hatlist[1].imageprice}"/>"</span></p>
                                                    </div>
                                                </a>
                                            </td>
                                        
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${hatlist[2].imagepath}"/>')" href ="detailspage?param=${hatlist[2].imagename}">
                                                    <div class ="col-3">
                                                        <img src="<c:out value ="${hatlist[2].imagepath}"/>" width ="160" height="120">
                                                        <p><c:out value="${hatlist[2].imagetitle}"/>"<span><br><c:out value="${hatlist[2].imageprice}"/>"</span></p>
                                                    </div>
                                                </a>
                                            </td>
                                        
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${hatlist[3].imagepath}"/>')" href ="detailspage?param=${hatlist[3].imagename}">
                                                    <div class ="col-4">
                                                        <img src="<c:out value ="${hatlist[3].imagepath}"/>" width ="160" height="120">
                                                        <p><c:out value="${hatlist[3].imagetitle}"/>"<span><br><c:out value="${hatlist[3].imageprice}"/>"</span></p>
                                                    </div>
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class = "row">
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${hatlist[4].imagepath}"/>')" href ="detailspage?param=${hatlist[4].imagename}">
                                                    <div class ="col-1">
                                                        <img src="<c:out value ="${hatlist[4].imagepath}"/>" width = "160" height="120">
                                                            <p><c:out value="${hatlist[4].imagetitle}"/>"<span><br><c:out value="${hatlist[4].imageprice}"/>"</span></p>
                                                    </div>
                                                </a>
                                            </td>
                                        
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${hatlist[5].imagepath}"/>')" href ="detailspage?param=${hatlist[5].imagename}">
                                                    <div class ="col-2">
                                                        <img src="<c:out value ="${hatlist[5].imagepath}"/>" width ="160" height="120">
                                                        <p><c:out value="${hatlist[5].imagetitle}"/>"<span><br><c:out value="${hatlist[5].imageprice}"/>"</span></p>
                                                    </div>
                                                </a>
                                            </td>
                                        
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${hatlist[6].imagepath}"/>')" href ="detailspage?param=${hatlist[6].imagename}">
                                                    <div class ="col-3">
                                                        <img src="<c:out value ="${hatlist[6].imagepath}"/>" width ="160" height="120">
                                                        <p><c:out value="${hatlist[6].imagetitle}"/>"<span><br><c:out value="${hatlist[6].imageprice}"/>"</span></p>
                                                    </div>
                                                </a>
                                            </td>
                                        
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${hatlist[7].imagepath}"/>')" href ="detailspage?param=${hatlist[7].imagename}">
                                                    <div class ="col-4">
                                                        <img src="<c:out value ="${hatlist[7].imagepath}"/>" width ="160" height="120">
                                                        <p><c:out value="${hatlist[7].imagetitle}"/>"<span><br><c:out value="${hatlist[7].imageprice}"/>"</span></p>
                                                    </div>
                                                </a>
                                            </td>
                                        </tr>
           
				</table>
                                <div class='featcombo'>
					<div class='combocontent'>
						Recently Viewed Items
					</div>
				</div>
                                <table class = 'gridedhats'>
                                    <c:if test="${empty hatqueue}">
                                        <p>
                                            You have not recently viewed any items!
                                        </p>
                                    </c:if>
                                    <c:if test="${not empty hatqueue}">
                                        <tr class ='row'>
                                        <c:forEach var="im" items="${hatqueue}">
                                            <td>
                                                <a class ="cell" onclick="itemclicked('<c:out value="${im}"/>')" href ="detailspage?param=${im}">
                                                    <div class ="col-1">
                                                        <img src="Media/<c:out value="${im}"/>.jpg" width ="160" height="120">
                                                    </div>
                                                </a>
                                            </td>
                                        </c:forEach>
                                        </tr>
                                    </c:if>
                                </table>
					<div class='footercombo'>
						<div class='combocontent' style="padding-top:1%; font-size: 20px">
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

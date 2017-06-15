INF-124
Internet Applications Engineering
Group Account: inf124grp01
Anthony Serrano - 53934109
Francisco Arca - 95184171

client link: http://andromeda-40.ics.uci.edu:5540/coolfittedclient/
REST link: http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/home

Our website is an ecommerce site for hats and caps.
The navigation of the website is generally easy. There are only
6 different tabs a user can click on to view our products. These
links/tabs are available at the top of our webpage in our menu next
to our company logo. Each tab name represents what you will find
once you follow the link. There is a zoom in effect when you hover over an 
image of a hat in order to let the user know you are selecting it. Clicking on a hat will
redirect you to a details page where you will see more information regarding the chosen hat and
the option of adding the hat to your current cart.

Requirements Met:

1) Using JSP to reimplement the product list page
	-> All of our "webapp" files our now implemented as JSP files and the following pages show the product list:
		[index.jsp, newarr.jsp, snapbacks.jsp, strapbacks.jsp]

2) Create REST services to allow for interaction with the order and product resources stored in your application database.
	-> CoolFitted_REST is our RESTful API that interacts with our database. All REST methods are in this API distributed
	  among the servlet java files.
	  
	->GET - Multiple GET requests were implemented to extract information from our database including images and product information.
			For each of the pages where we actually show our company's products, we make GET request which will in turn return the
			types of hats that are descriped by the page banner/tab. GET requests are also created when you click 
			on a hat on a product page, which depending on what item was clicked, attaches an "id" to the URL to allow 
			for accurate extraction of information for the hat at the server. GET requests are also made to extract information regarding
			orders or a specific order.
	->POST - We create a POST request whenever the user places an order. After pressing 'Place Order' their is a POST request
			containing form information regarding who placed the order. This POST inserts order information into the database.
	->PUT -	We create a PUT request whenever the user wants to edit their most recent order. They have the option of doing this
			after they place an order. They can only update their shipping information. The PUT requests calls database UPDATE.
	->DELETE - We create a DELETE request when a customer decideds that the order they most recently placed is not wanted anymore.
				The server will then go into our database and DELETE the most recently added order if it still exists. If nothing is found
				then a 404 error is returned letting the user know that there order does not exist anymore or that they have not placed one yet.
				
3) RESTful methods
	->GET Requests
		1 - Method: getHats() *Same method in ArrivalResource, SnapResourc, StrapResource, and ArrivalResource*
		2 - URL: http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/home
				 http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/newarrivals
				 http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/snaps
				 http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/straps
		3 - Sample Response (JSON): 
		{
        "imagepath": "Media/NBAstrap1.jpg",
        "imagename": "NBAstrap1",
        "imagetitle": "New Era 9Twenty NBA Logo Dad Hat - Denim",
        "imageprice": "$28.99",
        "imagedetails": " Navy Denim Crown & Visor- Navy Denim Undervisor- Official NBA Logo Embroidered on Front- 100% Cotton"
		},
		{
        "imagepath": "Media/NikeCamostrap1.jpg",
        "imagename": "NikeCamostrap1",
        "imagetitle": "Nike Army Dad Hat - Camo",
        "imageprice": "$28.99",
        "imagedetails": " Camo CrownVisor& Undervisor- Embroidered Naike Logo on Front- 100% Cotton"
		}
		
		1 - Method: sayHtmlResponse(@PathParam("param") String item) *in details.java in REST API*
		2 - URL: http://andromeda-40.ics.uci.edu:5540/coolfittedclient/details?param=PinkDolphinSnap1
				 http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/details?param=PinkDolphinSnap1
		3 - Sample Response (HTML): 
		*HTML page which displays the details on the specified hat param*
		*Array from REST API that has hat information extracted from the database all on the REST API Server side
		
	->POST Requests
		1 - Method: generatePOSTresponse(MultivaluedMap<String, String> formParams) *in Confirmation.java in API*
		2 - URL: http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/conf
		3 - Sample Response:
		{
        "fname": "Anthony",
        "lname": "Serrano",
        "phone": "(310)3103102",
        "email": "agserran@uci.edu",
        "street": "Street Street",
		"city": "Irvine",
		"state": "CA",
		"zip": "99999",
		"owner": "Name on Card",
		"card": "1234564789",
		"cvv": "123",
		"date": "07/16",
		"total": "$99.99",
		"quant": "1"
		}
		
	->PUT Requests
		1 - Method: generatePUTresponse(MultivaluedMap<String, String> formParams) *in UpdateResource.java*
		2 - URL: http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/edit
		3 - Sample Response: 
		{
        "fname": "Anthony",
        "lname": "Serrano",
        "phone": "(310)3103102",
        "email": "agserran@uci.edu",
        "street": "Street Street",
		"city": "Irvine",
		"state": "CA",
		"zip": "99999"
		}
		
	->DELETE Requests
		1 - Method: deleteOrder(@PathParam("orderid") int orderid) *in Confirmation.jave in our REST server*
		2 - URL: http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/conf/orders/{id}
		3 - Sample Response:
		<result>success</result>
		
		
		
		
		
	
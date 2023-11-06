<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST Example</title>
</head>
<body>
    <form action= "http://localhost:8080/DSCA1_2/restful-services/CustomerCRUD/hello" method="GET">
        
        
        <input type="submit" value="Hello World Test">
    </form>
	
	  <form action= "http://localhost:8080/resteasyJPACRUD/restful-services/sampleserviceDBCRUD/echo/message" method="GET">
        
        <input type="submit" value="Print Message ">
    </form>

	<form action= "http://localhost:8080/resteasyJPACRUD/restful-services/sampleserviceDBCRUD/employees" method="GET">  
        <input type="submit" value="View All Employees">
    </form>
	
	<form action= "http://localhost:8080/resteasyJPACRUD/restful-services/sampleserviceDBCRUD/json/employees" method="GET">  
        <input type="submit" value="View JSON All Employee ">
    </form>
	
	<form action= "http://localhost:8080/resteasyJPACRUD/restful-services/sampleserviceDBCRUD/json/employee/1" method="GET">  
        <input type="submit" value="View JSON Employee 1">
    </form>
	
</body>
</html>
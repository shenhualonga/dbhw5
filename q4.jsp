<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
	<h1>Hello World from JSP</h1>
	<script>
		$(function(){
			alert("Hello from JQuery");
			var site = {
					id: 5,
					name: "new site 4",
					latitude: 82.456,
					longitude: 114.54,
					towers: [ ]
			};
			
			// POST
			/* $.ajax({
				url: "/cs5200hw5/api/site/",
				type:'POST',
				dataType: "json",
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify(site),
				success: function(response){
					console.log("yahoo~");
				}
			}) */
			
			// DELETE
			/* $.ajax({
				url: "/cs5200hw5/api/site/5",
				type:'delete',
				dataType: "json",
				contentType: "application/json; charset=utf-8",
				success: function(response){
					console.log("yahoo~");
				}
			}) */
			
			// PUT
			$.ajax({
				url: "/cs5200hw5/api/site/563",
				type:"PUT",
				dataType: "json",
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify(site),
				success: function(response){
					console.log("yahoo~");
				}
			})
		});
	
	</script>
</body>
</html>
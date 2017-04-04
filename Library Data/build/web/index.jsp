<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Table</title>
<link href="https://fonts.googleapis.com/css?family=Spirax" rel="stylesheet">
<style type="text/css">
table, td, th
{
border:1px solid aquamarine;
font-family: 'Spirax', cursive;
}
th
{
background-color:aquamarine;
color:white;
}
body
{
	text-align: center;
}
.container
{
	margin-left: auto;
	margin-right: auto;
	width: 40em;
}
h4
{
	font-family: 'Spirax', cursive;
	color:#1E90FF;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#tablediv").hide();
     $("#showTable").click(function(event){
           $.get('PopulateTable',function(responseJson) {
        	   if(responseJson!==null){
            	   $("#bookstable").find("tr:gt(0)").remove();
            	   var table1 = $("#bookstable");
	               $.each(responseJson, function(key,value) { 
	               		   var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	                       rowNew.children().eq(0).text(value['id']);
                               rowNew.children().eq(1).text(value['callno']); 
	                       rowNew.children().eq(2).text(value['name']); 
	                       rowNew.children().eq(3).text(value['author']); 
	                       rowNew.children().eq(4).text(value['publisher']);
                               rowNew.children().eq(5).text(value['quantity']);
	                       rowNew.children().eq(6).text(value['issued']); 
	                       rowNew.children().eq(7).text(value['addeddate']);
                               rowNew.children().eq(8).text(value['genre']);
	                       rowNew.appendTo(table1);
	               });
                }
            });
            $("#tablediv").show();          
	 });      
});
</script>
</head>
<body class="container">
<h1>Library Table</h1>
<h4>Please click the button below!</h4>
<input type="button" value="Show Table" id="showTable"/>
<br/>
<br/>
<div id="tablediv">
<table cellspacing="0" id="bookstable"> 
    <tr> 
        <th scope="col">Id</th> 
        <th scope="col">CallNo</th> 
        <th scope="col">Name</th> 
        <th scope="col">Author</th> 
        <th scope="col">Publisher</th> 
        <th scope="col">Quantity</th>
        <th scope="col">Issued</th>
        <th scope="col">Date</th>
        <th scope="col">Genre</th>
    </tr> 
</table>
</div>
</body>
</html>
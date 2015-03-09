<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/mytheme/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/mytheme/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/mytheme/js/main.js" />"></script>
<script type="text/javascript">
function madeAjaxCall(x){
	  var sname = "hello123";  
	  
	  
$.ajax({
  type: "POST",
  url: "ShowAll.htm",
  cache: false,    
  data: "sname=" + sname,
  success: function(response){
		// alert(response);
	     $('#result').html("");
	     var arr = response;
	       // alert(arr);
	        var i;
	        var out = "<table border='1px'><tr><td>NAME</td><td>ROLE</td><td>AGE</td><td>ADDRESS1</td><td>ADDRESS2</td><td>ZIPCODE</td><td>DELETE</td></tr>";
	       
	        for(i = 0; i < arr.length; i++) {
	            out += "<tr><td>" + 
	            arr[i].name +
	            "</td><td>" +
	            arr[i].role +
	            "</td><td>" +
	            arr[i].age +
	            "</td><td>" +
	            arr[i].addrStudent.addressline1 +
	            "</td><td>" +
	            arr[i].addrStudent.addressline2 +
	            "</td><td>" +
	            arr[i].addrStudent.zipcode +
	            "</td><td>" +
	            "<input type=button value=Delete onclick=madeAjaxCall1("+ arr[i].role+")>"+
	            "</td><td>" +
	            "<input type=button value=Update onclick=updateCall1("+ arr[i].role+")>"+
	            "</td><td>" +
	            "</td></tr>";
	        }
	        out += "</table>"
	      
	   $('#result').html("Student Info "+out);
	    },
  error: function(){      
   alert('Error while request..');
  }
 });
}

function madeAjaxCall1(x){
	  var srole = x;  
	  alert("HI" +x);
	  
$.ajax({
type: "POST",
url: "DeleteById.htm",
cache: false,    
data: "srole=" + srole,
success: function(response){
		// alert(response);
	     $('#result').html("");
	     var arr = response;
	        //alert(arr);
	        var i;
	        var out = "<table border='1px'><tr><td>NAME</td><td>ROLE</td><td>AGE</td><td>ADDRESS1</td><td>ADDRESS2</td><td>ZIPCODE</td><td>DELETE</td></tr>";
	       
	        for(i = 0; i < arr.length; i++) {
	            out += "<tr><td>" + 
	            arr[i].name +
	            "</td><td>" +
	            arr[i].role +
	            "</td><td>" +
	            arr[i].age +
	            "</td><td>" +
	            arr[i].addrStudent.addressline1 +
	            "</td><td>" +
	            arr[i].addrStudent.addressline2 +
	            "</td><td>" +
	            arr[i].addrStudent.zipcode +
	            "</td><td>" +
	            "<input type=button value=Delete onclick=madeAjaxCall1("+ arr[i].role+")>"+
	            "</td><td>" +
	            "<input type=button value=Update onclick=updateCall1("+ arr[i].role+")>"+
	            "</td><td>" +
	            "</td></tr>";
	        }
	        out += "</table>"
	      
	   $('#result').html("Student Info "+out);
	    },
error: function(){      
 alert('Error while request..');
}
});
}

function updateData(role){
	
	var s_role=role;
	var s_name=document.getElementById("sname1").value;
	var s_age=document.getElementById("sage1").value;
	var s_zipcode=document.getElementById("zipcode1").value
	alert(s_role);
	alert(s_name);
	alert(s_age);
	alert(s_zipcode);
	$.ajax({
		type: "POST",
		url: "UpdateByIdAction.htm",
		cache: false,    
		data:{
			 s_role:s_role,
			 s_name:s_name,
			 s_age:s_age,
			 s_zipcode:s_zipcode
		   },
		success: function(response){
				// alert(response);
			     $('#result').html("");
			     var arr = response;
			        //alert(arr);
			        var i;
			        var out = "<table border='1px'><tr><td>NAME</td><td>ROLE</td><td>AGE</td><td>ADDRESS1</td><td>ADDRESS2</td><td>ZIPCODE</td><td>DELETE</td></tr>";
			       
			        for(i = 0; i < arr.length; i++) {
			            out += "<tr><td>" + 
			            arr[i].name +
			            "</td><td>" +
			            arr[i].role +
			            "</td><td>" +
			            arr[i].age +
			            "</td><td>" +
			            arr[i].addrStudent.addressline1 +
			            "</td><td>" +
			            arr[i].addrStudent.addressline2 +
			            "</td><td>" +
			            arr[i].addrStudent.zipcode +
			            "</td><td>" +
			            "<input type=button value=Delete onclick=madeAjaxCall1("+ arr[i].role+")>"+
			            "</td><td>" +
			            "<input type=button value=Update onclick=updateCall1("+ arr[i].role+")>"+
			            "</td><td>" +
			            "</td></tr>";
			        }
			        out += "</table>"
			      
			   $('#result').html("Student Info "+out);
			    },
		error: function(){      
		 alert('Error while request..');
		}
		});
	
	
	
	
}

function updateCall1(role) {

	var srole = role;
	alert(srole);
	$
			.ajax({
				type : "post",
				url : "SearchById.htm",
				cache : false,
				data : "srole=" + srole,
				success : function(response) {
					//alert(response);
					$('#result').html("");
					var obj = response;

					var out = "<table border='1px'><tr><td>NAME</td><td>ROLE</td><td>AGE</td><td>ADDRESS1</td><td>ADDRESS2</td><td>ZIPCODE</td></tr>";

					out += "<tr><td>"
				    +"<input type=text value='"+ obj.name+"' id=sname1 name=sname1>"+
					
					"</td><td>"
					+ obj.role+
					"</td><td>"
					 +"<input type=text value='"+ obj.age +"' id=sage1 name=sage1>"+
					 
					"</td><td>"
					+ obj.addrStudent.addressline1 +
					"</td><td>"
					+ obj.addrStudent.addressline2 + 
					"</td><td>"
					 +"<input type=text value='"+ obj.addrStudent.zipcode +"' id=zipcode1 name=zipcode1>"+
					 "</td><td>"
					  +"<input type=button value=UPDATE id=update name=update onclick=updateData("+obj.role+")>"+
					"</td></tr>";

					out += "</table>"

					$('#result').html("Student Info " + out);
				},
				error : function() {
					alert('Error while request..');
				}
			});
}


</script>
</head>
<body>
<div id="wrapper">
            <div id="header">header    </div>
            <div id="content">
                <div id="CL">left
                <h2>Unordered List with Disc Bullets</h2>

<div class="nav">
      <ul>
        <li class="index"><a  href="index.htm">AddStudent</a></li>
        <li class="ShowAll"><a  href="ShowAll.htm">ShowAll</a></li>
        <li class="SearchById"><a href="SearchById.htm">SearchById</a></li>
        <li class="SearchByContent"><a href="SearchByContent.htm">SearchByContent</a></li>
        <li class="Delete"><a class="active" href="Delete.htm">Delete</a></li>
      </ul>
    </div>
                 </div>
                <div id="CM">middle hello
                
                <form action="" name="form2">
<input type="button" value="GetData" onclick="madeAjaxCall()"/>
</form>
 
 <div id="result" align="center">output</div>
                 </div>
                <div id="CR">right </div>
                </div>
            <div id="footer">footer </div>
        </div>
</body>
</html>
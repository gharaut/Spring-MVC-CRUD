<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/mytheme/css/style.css" />" rel="stylesheet">
<%-- <script src="<c:url value="/resources/mytheme/js/jquery.1.10.2.min.js" />"></script> --%>
<script src="<c:url value="/resources/mytheme/js/main.js" />"></script>
<script src="<c:url value="/resources/mytheme/js/json2.js" />"></script>
<script src="<c:url value="/resources/mytheme/js/jquery.js" />"></script>
<script src="<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.11.1/jquery.validate.min.js" />"></script>
<script type="text/javascript">
$(document).ready(function () {
    //validation rules
    
    $("#form123").validate({
        rules: {
            "sname": {
                required: true
                
            },  
            "srole": {
                required: true,
                minlength: 5
            }, 
            "sage": {
                required: true,
               
            } ,
            "add1": {
                required: true,
               
            } ,
            "add2": {
                required: true,
               
            }, 
            "zip": {
                required: true,
               
            } 
        },
        messages: {
        	sname: {
        	required: "Please enter your name",
        	//minlength: "your name must consist of at least 2 characters"
        	},
        	srole: {
            required: "Please enter your role number",	
            minlength: "your role must consist of at least 5 characters"
        	},
        	sage: {
            	required: "Please enter your age",
            	//minlength: "your name must consist of at least 2 characters"
            	},
            add1: {
                required: "Please enter your primary address",
                	//minlength: "your name must consist of at least 2 characters"
               	},
            add2: {
                 required: "Pleas enter your secondary address",
                    	//minlength: "your name must consist of at least 2 characters"
                 },   	
            zip: {
                  required: "Please enter your zip",
                        	//minlength: "your name must consist of at least 2 characters"
                  }, 
        	}, 
        //perform an AJAX post to ajax.php
        submitHandler: function() {
        	$.ajax({
        		  type: "post",
        		  url: "AddUser.htm",
        		  cache: false,    
        		  data:$(form123).serialize(),
        		  success: function(response){
        			  //alert("hello1"+response);
        		      
        		    
        			   $('#result').html("");
        			   var obj = JSON.parse(response);
        			  // alert(obj);
        			   var out = "<table border='1px'><tr><td>NAME</td><td>ROLE</td><td>AGE</td><td>ADDRESS1</td><td>ADDRESS2</td><td>ZIPCODE</td></tr>";
        			   
        			   out += "<tr><td>" + 
        			   obj.name +
        			   "</td><td>" +
        			   obj.role +
        			   "</td><td>" +
        			   obj.age +
        			   "</td><td>" +
        			   obj.addrStudent.addressline1 +
        			   "</td><td>" +
        			   obj.addrStudent.addressline2 +
        			   "</td><td>" +
        			   obj.addrStudent.zipcode +
        			   "</td></tr>";
        			   
        			   out += "</table>"
        			      
        			   $('#result').html("Student Info "+out); 
        		    },
        		  error: function(){      
        		   alert('Error while request..');
        		  }
        		 });
        }
    });
});



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
        <li class="index"><a class="active" href="index.htm">AddStudent</a></li>
        <li class="ShowAll"><a  href="ShowAll.htm">ShowAll</a></li>
        <li class="SearchById"><a href="SearchById.htm">SearchById</a></li>
        <li class="SearchByContent"><a href="SearchByContent.htm">SearchByContent</a></li>
        <li class="Delete"><a href="Delete.htm">Delete</a></li>
      </ul>
    </div>
                 </div>
                <div id="CM">middle hello
                
                 <form name="form123" id="form123" > 
  <table cellpadding="0" cellspacing="0" border="1" class="GridOne" align="center">
   <tr>
    <td>Name</td>
    <td><input type="text" name="sname" id="sname" value=""></td>
   </tr>
   <tr>
    <td>Role</td>
    <td><input type="text" name="srole" id="srole" value=""></td>
   </tr>
   <tr>
    <td>Age</td>
    <td><input type="text" name="sage" id="sage" value=""></td>
   </tr>
   <tr>
    <td>Address Line1</td>
    <td><input type="text" name="add1" id="add1" value=""></td>
   </tr>
   <tr>
    <td>Address Line2</td>
    <td><input type="text" name="add2" id="add2" value=""></td>
   </tr>
   <tr>
    <td>Zip Code</td>
    <td><input type="text" name="zip" id="zip" value=""></td>
   </tr>
    
   <tr>
    <td colspan="2" align="center"><input type="submit" value="ADDSTUDENT" name="action"></td>
   </tr>
  </table>
 </form>
 
 <div id="result" align="center"></div>
                
                
                 </div>
                <div id="CR">right </div>
                </div>
            <div id="footer">footer </div>
        </div>
</body>
</html>
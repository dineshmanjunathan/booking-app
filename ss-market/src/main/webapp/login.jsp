<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <%@ include file = "header.jsp" %> 
</head>

	<div class="row text-center">
			<div class="text-center m-b-md custom-login">
				<a href="/"><img class="main-logo" src="../../img/logo/logo.jpeg" alt="" /></a><br/><br/>
			</div>
			<div class="well col-md-4 col-md-offset-4">
			<h3 >LOGIN</h3> 
                  <form action="/login" method="post">
                      	<p style="color:red" align="center">${errormsg}</p>  
                      	<p style="color:green" align="center">${adminlogout}</p> 
                     <div class="row">
                         <div class="col-md-12">
                             <div class="form-group">
                                 <input type="text" placeholder="User Name" title="Please enter you username" required="Enter your Card Number" value="" name="admin_card_no" id="admin_card_no" class="form-control">
                             </div>
                         </div>
                     </div>
					<div class="row">
                         <div class="col-md-12">
                             <div class="form-group">
                                 <input type="password" title="Please enter your password" placeholder="******" required="" value="" name="password1" id="password-field" class="form-control">
                             </div>
                         </div>
                     </div> 
                     <div class="row">
                     	 <div class="col-md-3"></div>
                         <div class="col-md-6">
                              <button class="btn btn-success btn-block loginbtn" type="submit" name="submit" value="login">Login</button>
                         </div>
                         <div class="col-md-3"></div>
                     </div>
                 </form> 
             </div>
    </div>
   
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="../../fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="../../css/incoming/style.css">
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>

<body>

	<div class="wrapper">
		<div class="inner">
			<div class="image-holder">
				<img src="../../img/product/parcel.jpg" alt="">
			</div>
			<form action="/addLocation" method="post">
				<h3> Location</h3>
				<p style="color: green" align="center">${successMessage}</p>
				
					<div class="form-row">
						<input type="text" class="form-control" name="location" id="location" placeholder="Location">
					</div>
					<br>
					<textarea name="address" id="address" placeholder="Address" class="form-control"
						style="height: 130px;"></textarea>
					<br>
					<div class="row control-margin">
						<div class="col-md-4">
							<button type="submit" class="btn btn-primary button-margin" id="btnClear">Save</button>
						</div>
						<div class="col-md-4">
							<button type="reset" class="btn btn-primary button-margin" id="btnClear">Clear</button>
						</div>
						<div class="col-md-4">
							<button href="menu.jsp" type="button" class="btn btn-primary button-margin" id="btnClear">Back</button>
						</div>
					</div>
			</form>
		</div>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/main.js"></script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
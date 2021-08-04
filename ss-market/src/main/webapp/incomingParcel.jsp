<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Incoming Parcel</title>
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
			<form action="">
				<h3>Incoming Parcel</h3>
				<div class="form-row">
					<div class="form-holder">
					<select name="from" id="from" class="form-control">
						<option value="">-Select From Location-</option>
						<c:forEach var="options" items="${locationList}"
							varStatus="status">
							<option value="${options.id}">${options.location}</option>
						</c:forEach>
					</select><i class="zmdi zmdi-chevron-down"></i>
						
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-holder">
						<select name="to" id="to" class="form-control">
						<option value="">-Select To Location-</option>
						<c:forEach var="options" items="${locationList}"
							varStatus="status">
							<option value="${options.id}">${options.location}</option>
						</c:forEach>
					</select><i class="zmdi zmdi-chevron-down"></i>
					</div>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-primary button-margin"
						id="import">Import</button>
				</div>
				<div class="form-row">
					<input type="text" class="form-control" placeholder="No"> <input
						type="date" class="form-control" placeholder="Date">
				</div>
				<div class="form-row">
					<input type="text" class="form-control" placeholder="OGPL No">
					<input type="date" class="form-control" placeholder="OGPL Date">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="defaultCheck1"> <label class="form-check-label"
							for="defaultCheck1"> Manual </label>
					</div>
				</div>
				<p class="fw-bold">Items</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">No.</th>
							<th scope="col">Name</th>
							<th scope="col">Nos LR</th>
							<th scope="col">Paid</th>
							<th scope="col">To Pay</th>
							<th scope="col">Charges</th>
							<th scope="col">Hamali Rem</th>
							<th scope="col">Free Hold Status To</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Name</td>
							<td>NOs LR</td>
							<td>Paid</td>
							<td>To Pay</td>
							<td>Charges</td>
							<td>Hamali Rem</td>
							<td>Free Hold Status To</td>
						</tr>
					</tbody>
				</table>
				<br>
				<div class="form-row">
					<div class="form-holder">
						<select name="" id="" class="form-control">
							<option value="" disabled selected>Vechile No</option>
							<option value="class 01">Class 01</option>
							<option value="class 02">Class 02</option>
							<option value="class 03">Class 03</option>
						</select> <i class="zmdi zmdi-chevron-down"></i>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-holder">
						<select name="" id="" class="form-control">
							<option value="" disabled selected>Delivered By</option>
							<option value="class 01">Class 01</option>
							<option value="class 02">Class 02</option>
							<option value="class 03">Class 03</option>
						</select> <i class="zmdi zmdi-chevron-down"></i>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="defaultCheck1"> <label class="form-check-label"
							for="defaultCheck1"> Verified </label>
					</div>
					</div>
					<div class="form-row">
						<input type="text" class="form-control" placeholder="Driver">
					</div>
					<br>
					<div class="form-row">
						<input type="text" class="form-control" placeholder="Conductor">
					</div>
					<br>
					<div class="form-row">
						<input type="text" class="form-control" placeholder="Prepared By">
					</div>
					<br>
					<textarea name="" id="" placeholder="Details" class="form-control"
						style="height: 130px;"></textarea>
					<br>
					<div class="row control-margin">
						<div class="col-md-12">
							<button type="button" class="btn btn-primary button-margin"
								id="btnClear">Save</button>
							<button type="submit" class="btn btn-primary button-margin"
								name="submit">Clear</button>
							
							<button type="button" class="btn btn-primary button-margin"
								id="btnPrint">Help</button>
								<a class="btn btn-primary button-margin" href="menu.jsp">Back</a>
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
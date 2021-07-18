<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RegistrationForm_v6 by Colorlib</title>
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
				<h3>Outgoing Parcel</h3>
				<div class="form-row">
					<input type="text" class="form-control" placeholder="OGPL NO">
					<input type="date" class="form-control" placeholder="Date">
				</div>
				<div class="form-row">
					<div class="form-holder">
						<select name="" id="" class="form-control">
							<option value="" disabled selected>From</option>
							<option value="class 01">Class 01</option>
							<option value="class 02">Class 02</option>
							<option value="class 03">Class 03</option>
						</select> <i class="zmdi zmdi-chevron-down"></i>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-holder">
						<select name="" id="" class="form-control">
							<option value="" disabled selected>To</option>
							<option value="class 01">Class 01</option>
							<option value="class 02">Class 02</option>
							<option value="class 03">Class 03</option>
						</select> <i class="zmdi zmdi-chevron-down"></i>
					</div>
				</div>
				<div class="form-row">
					<div class="form-holder">
						<select name="" id="" class="form-control">
							<option value="" disabled selected>Delivered By</option>
							<option value="class 01">Class 01</option>
							<option value="class 02">Class 02</option>
							<option value="class 03">Class 03</option>
						</select> <i class="zmdi zmdi-chevron-down"></i>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-holder">
						<select name="" id="" class="form-control">
							<option value="" disabled selected>Vechile No</option>
							<option value="class 01">Class 01</option>
							<option value="class 02">Class 02</option>
							<option value="class 03">Class 03</option>
						</select> <i class="zmdi zmdi-chevron-down"></i>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
						<th scope="col">LR No.</th>
							<th scope="col">OGP</th>
							<th scope="col">To Name</th>
							<th scope="col">NOs</th>
							<th scope="col">Remarks</th>
							<th scope="col">Paid</th>
							<th scope="col">To Pay</th>
							<th scope="col">Charges</th>
							<th scope="col">Date</th>
							<th scope="col">Br</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>OGP</td>
							<td>To Name</td>
							<td>NOs</td>
							<td>Remarks</td>
							<td>Paid</td>
							<td>To Pay</td>
							<td>Charges</td>
							<td>Date</td>
							<td>Br</td>
						</tr>
					</tbody>
				</table>
				<br>
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
			<button type="button" class="btn btn-primary button-margin" id="btnClear">Save </button>
				<button type="submit" class="btn btn-primary button-margin" name="submit">Clear</button>
				<button type="button" class="btn btn-primary button-margin" id="btnPrint">Quit</button>
				<button type="button" class="btn btn-primary button-margin" id="btnPrint">Help</button>
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
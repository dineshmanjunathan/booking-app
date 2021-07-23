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
<script type="text/javascript" charset="utf-8">
function saveconfigure(prodCode, price) {
	
	//Need to write for save

}
</script>
</head>

<body>

	<div class="wrapper">
		<div class="inner">
			<div class="image-holder">
				<img src="../../img/product/parcel.jpg" alt="">
			</div>
			<form action="">
				<h3>Configure Details</h3>
					<div class="form-row">
						<input type="text" class="form-control" name="location" id="${location.location}" placeholder="Location">
					</div>
					<br>
					<textarea name="address" id="${location.address}" placeholder="Address" class="form-control"
						style="height: 130px;"></textarea>
					<br>
					<div class="row control-margin">
						<div class="col-md-12">
							<button type="button" class="btn btn-primary button-margin"
								id="btnClear" onclick="return saveconfigure('${location.location}', '${location.address}');">Save</button>
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
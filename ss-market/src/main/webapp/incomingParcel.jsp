<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Outgoing Parcel</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="../../fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="../../css/styles.css">
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
					<div class="form-input">
                                    <label for="opglNo" >OPGL No.</label>
                                    <input type="text" name="opglNo" id="opglNo" />
                     </div>
						<div class="form-input">
                                    <label for="date" >Date</label>
                                    <input type="date" name="date" id="date" />
                     </div>
                     <div class="form-input">
                                    <label for="From" >From</label>
                                    <select name="from" id="from">
                                            <option value="Coimbatore">Coimbatore</option>
                                            <option value="Chennai">Chennai</option>
                                            
                                        </select>
                     </div>
                     <div class="form-input">
                                    <label for="To" >To</label>
                                    <select name="to" id="to">
                                            <option value="Coimbatore">Coimbatore</option>
                                            <option value="Chennai">Chennai</option>
                                        </select>
                     </div>
                     <div class="form-input">
                                    <label for="DeliveryBy" >Delivery By</label>
                                    <select name="DeliveryBy" id="DeliveryBy">
                                            <<option value="Coimbatore">Coimbatore</option>
                                            <option value="Chennai">Chennai</option>
                                        </select>
                     </div>
                     <div class="form-input">
                                    <label for="Vechile No" >Vechile No</label>
                                    <select name="VechileNo" id="VechileNo">
                                           <option value="Coimbatore">TN 43</option>
                                            <option value="Chennai">TN 38</option>
                                        </select>
                     </div>
                     
					</div>
					<!--Dashboard  -->
					<div class="form-row">
				<thead class="form-input">
					<tr>
						<th>LR No.</th>
						<th>OGP</th>
						<th>To Name</th>
						<th>NOs</th>
						<th>Remarks</th>
						<th>Paid</th>
						<th>To Pay</th>
						<th>Charges</th>
						<th>Date</th>
						<th>Br</th>
					</tr>
				</thead>
				</div>
				<tbody>
				<div class="form-row">
				<tr>
				<td>LR No.</td>
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
						</div>
						</tbody>
				<div class="form-row">
						<div class="form-input">
                                    <label for="Driver" >Driver</label>
                                    <input type="text" name="Driver" id="Driver" />
                                    </div>
                     </div>
                     <div class="form-row">
                     <div class="form-input">
                                    <label for="Conductor" >Conductor</label>
                                    <input type="text" name="Conductor" id="Conductor" />
                     </div>
                     </div>
                     <div class="form-row">
                     <div class="form-input">
                                    <label for="PreparedBy" >Prepared By</label>
                                    <input type="text" name="PreparedBy" id="PreparedBy" />
                     </div>
                     </div>
                     <div class="form-row">
                     <div class="form-input">
                                    <label for="Details" >Details</label>
                                    <input type="textarea" name="Details" id="Details" />
                     </div>
                     </div>
					</div>
					<div class="form-row">
						<div class="form-input">
                                    
                                    <input type="button" name="all" id="all" value="All" />
                                    <input type="button" name="none" id="none" value="None" />
                                    <input type="button" name="invert" id="invert" value="Invert" />
                                    </div>
                     </div>
				
				
			</div>
		

		<script src="../../js/jquery-3.3.1.min.js"></script>
		<!-- <script src="../../js/main.js"></script> -->
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>

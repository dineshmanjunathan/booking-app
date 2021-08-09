<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<title>BookingApp</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css">

<style>
.control-margin {
	margin-top: 20px;
}

.element-margin {
	margin-bottom: 5px;
}

.button-margin {
	margin-right: 5px;
}
</style>

</head>

<nav style="background-image: linear-gradient(#0f68b4, #1a1e2c)"
	class="navbar navbar-dark bg-primary">

	<div class="header-right-info">
		<ul class="nav navbar-nav mai-top-nav header-right-menu"
			style="padding: 20px 60px;">
			<li class="nav-item"></li>
		</ul>
	</div>
</nav>
<script type="text/javascript" charset="utf-8">
	function getSearchParcel() {
		 var x = document.getElementById("searchSelection").selectedIndex;
		 var type=document.getElementsByTagName("option")[x].value;
		 var value=document.getElementById("txtSearch").value;
		 if(type=='lrNo'){
			 window.location.href="/searchParcelLRNO/"+value;
		 }else{
			 window.location.href="/searchParcelName/"+value;
		 }
	}
</script>


<!--  <body  style="background-image: url('../../img/bg/Bg2.jpg');" class="bg-light">  -->
<br>
<center>
	<h4>DELIVERY</h4>
</center>

<div class="blog-details-area mg-b-15">
	<div class="container-fluid" style="width: 90%;">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="blog-details-inner">
					<main>
						<form action="/addDelivery" method="post">
							<input type="hidden" class="form-control" name="id" id="id"
								value="${delivery.id}">
							<div class="row">
								<div class="col-md-4 control-margin">
									<div class="row element-margin">
										<div class="input-group">
											<select class="form-select" name="searchSelection" id="searchSelection">
												<option selected disabled value="">Search Type</option>
												<option value="lrNo">LR No.</option>
												<option value="name">Party Name</option>
											</select>
											<input type="text" class="form-control" placeholder="Parcel"
												name="txtSearch" id="txtSearch"> <a
												class="btn btn-primary button-margin"
												onclick="getSearchParcel();">Search</a>
										</div>
										<div class="mt-0">
											<label for="txtSearch" class="form-label"><small>(Type
													LR No. or Party Name and press Search)</small></label>
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-6">
											<input type="checkbox" class="form-check-input"
												name="chkDeliveredParcel"> <label
												class="form-check-label" for="chkDeliveredParcel">Include
												Delivered Parcels</label>
										</div>
										<div class="col-sm-6">
											<input type="checkbox" class="form-check-input"
												name="chkDeliveredParcel"> <label
												class="form-check-label" for="chkDeliveredParcel">Search
												Bill</label>
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="deliverySelection">Delivery
												Section</label>
										</div>
										<div class="col-sm-8">
											<select class="form-select" name="deliverySelection">
												<option selected disabled value="">Choose...</option>
												<option>...</option>
											</select>
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtName">Name</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="name"
												value="${delivery.name}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtPaid">Paid</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="paid" value="${delivery.paid}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtNoofItem">No. of
												Items</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="noOfItems" value="${delivery.noOfItems}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtddVehicle">DD
												Vehicle</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="ddVehicle" value="${delivery.ddVehicle}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<input type="radio" class="form-check-input" name="status"
												value="HOLD"> <label class="form-check-label"
												for="chkHold">Hold</label>
										</div>
										<div class="col-sm-4">
											<input type="radio" class="form-check-input" name="status"
												value="DELIVERED"> <label class="form-check-label"
												for="chkDelivered">Delivered</label>
										</div>
										<div class="col-sm-4">
											<input type="radio" class="form-check-input" name="status"
												value="PRINTED"> <label class="form-check-label"
												for="chkPrinted">Printed</label>
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtDeliveredBy">Delivered
												By</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="deliveredBy" value="${delivery.deliveredBy}">
										</div>
									</div>
								</div>
								<div class="col-md-4 control-margin">
									<div class="row element-margin">
										<div class="col-sm-4">
											<label for="txtNo" class="form-label">No</label>
										</div>
										<div class="col-sm-8">
											<input type="number" class="form-control" name="no" value="${delivery.no}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label for="txtOGPL" class="form-label">OGPL</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="ogpl" value="${delivery.ogpl}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label for="dtFromDate" class="form-label">From Date</label>
										</div>
										<div class="col-sm-8">
											<input type="date" class="form-control" name="fromDate"
												placeholder="From Date" value="${delivery.fromDate}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label for="dtToDate" class="form-label">To Date</label>
										</div>
										<div class="col-sm-8">
											<input type="date" class="form-control" name="toDate"
												placeholder="To Date" value="${delivery.toDate}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label for="dtFrom" class="form-label">From</label>
										</div>

										<div class="col-sm-8">
											<select class="form-select" name="dtFrom">
												<option selected disabled value="">Choose...</option>
												<option>...</option>
											</select>
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label for="dtTo" class="form-label">To</label>
										</div>

										<div class="col-sm-8">
											<select class="form-select" name="dtTo">
												<option selected disabled value="">Choose...</option>
												<option>...</option>
											</select>
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtLRNo">LR No.</label>
										</div>
										<div class="col-sm-8">
											<input type="number" class="form-control" name="lRNo" >
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtDeliveryBillNo">Delivery
												Bill No.</label>
										</div>
										<div class="col-sm-8">
											<input type="number" class="form-control"
												name="deliveryBillNo" value="${delivery.deliveryBillNo}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="dtDeliveryDate">Delivery
												Date</label>
										</div>
										<div class="col-sm-8">
											<input type="date" class="form-control" name="deliveryDate" value="${delivery.deliveryDate}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtToPay">To Pay</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="toPay" value="${delivery.toPay}">
										</div>
									</div>
								</div>
								<div class="col-md-4 control-margin">
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtHamali">Hamali</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="hamali" value="${delivery.hamali}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtUnloadingCharges">Unloading
												Charges</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control"
												name="unloadingCharges" value="${delivery.unloadingCharges}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtDoorDeliveryCharges">Door
												Delivery Charges</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control"
												name="doorDeliveryCharges" value="${delivery.doorDeliveryCharges}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtDemurrage">Demurrage</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="demurrage" value="${delivery.demurrage}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-4">
											<label class="form-label" for="txtOthers">Others</label>
										</div>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="others" value="${delivery.others}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-8">
											<label class="form-label" for="txtTotal">TOTAL</label>
										</div>
										<div class="col-sm-4">
											<input type="number" class="form-control" name="total" value="${delivery.total}">
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-2">
											<label class="form-label" for="txtPaidTotal">Paid</label>
										</div>
										<div class="col-sm-6">
											<input type="text" class="form-control" name="txtPaidBy">
										</div>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="paid" value="${delivery.paid}">
										</div>
										<div class="mt-0" style="padding-left: 80px">
											<label for="txtPaidBy" class="form-label"><small>(Cheque
													No;Bank;Branch)</small></label>
										</div>
									</div>
									<div class="row element-margin">
										<div class="col-sm-8">
											<label class="form-label" for="txtRefund">Refund</label>
										</div>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="refund" value="${delivery.refund}">
										</div>
									</div>
								</div>
							</div>

							<div class="row control-margin">
								<div class="col-md-5 control-margin">
									<button type="submit" class="btn btn-primary button-margin"
										id="btnSave">Save</button>
									<button type="reset" class="btn btn-primary button-margin"
										id="btnClear">Clear</button>
									<a class="btn btn-primary button-margin" href="/menu">Back</a>
								</div>
								<div class="col-md-4 control-margin">
									<button type="button" class="btn btn-primary button-margin"
										id="btnNext">Next</button>
									<button type="button" class="btn btn-primary button-margin"
										id="btnPrevious">Previous</button>
									<button type="button" class="btn btn-primary button-margin"
										id="btnCurrent">Current</button>
								</div>
								<div class="col-md-3 control-margin">
									<button type="button" class="btn btn-primary button-margin"
										id="btnDeliver">Deliver</button>
									<button type="button" class="btn btn-primary button-margin"
										id="btnPrint">Print</button>
									<button type="button" class="btn btn-primary button-margin"
										id="btnPrint">Help</button>
								</div>
							</div>
						</form>
					</main>
				</div>
			</div>
		</div>
	</div>
</div>
</html>
<!doctype html>
<html lang="en">
  <head>
    <title>BookingApp</title>
	 <link rel="stylesheet" href="../../css/bootstrap.min.css">
	
	<style>
		.control-margin{
			margin-top: 20px;
		}
		.element-margin{
			margin-bottom: 5px;
		}
		.button-margin{
			margin-right: 5px;
		}		
	</style>
	
  </head>
 
 <nav style="background-image: linear-gradient(#0f68b4,#1a1e2c)" class="navbar navbar-dark bg-primary">

	<div class="header-right-info">
		<ul class="nav navbar-nav mai-top-nav header-right-menu" style="padding: 20px 60px;">
			<li class="nav-item">
					
				</li>
		</ul>
	</div>
</nav>
 
 
 
  <body class="bg-light">    
  <br>
	<center><h4>DELIVERY PAGE</h4></center>
  
	<div class="blog-details-area mg-b-15">
            <div class="container-fluid" style="width: 90%;">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="blog-details-inner">
	  <main>
		<div class="row">
		  <div class="col-md-4 control-margin">
			 <div class="row element-margin">
				  <div class="input-group">
					<input type="text" class="form-control" placeholder="Parcel" id="txtSearch">
					<button type="submit" class="btn btn-secondary" id="btnSearch">Search</button>				
				  </div>
				  <div class="mt-0">
					<label for="txtSearch" class="form-label"><small>(Type LR No. or Party Name and press Search)</small></label>
				  </div>
			 </div> 
			 <div class="row element-margin">
				  <div class="col-sm-6">
					<input type="checkbox" class="form-check-input" id="chkDeliveredParcel">
					<label class="form-check-label" for="chkDeliveredParcel">Include Delivered Parcels</label>
				  </div>
				  <div class="col-sm-6">
					<input type="checkbox" class="form-check-input" id="chkDeliveredParcel">
					<label class="form-check-label" for="chkDeliveredParcel">Search Bill</label>
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="deliverySelection">Delivery Section</label>
				  </div>
				  <div class="col-sm-8">
					<select class="form-select" id="deliverySelection">
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
					<input type="text" class="form-control" id="txtName">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtPaid">Paid</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtPaid">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtNoofItem">No. of Items</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtNoofItem">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtddVehicle">DD Vehicle</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtddVehicle">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<input type="checkbox" class="form-check-input" id="chkHold">
					<label class="form-check-label" for="chkHold">Hold</label>
				  </div>
				   <div class="col-sm-4">
					<input type="checkbox" class="form-check-input" id="chkDelivered">
					<label class="form-check-label" for="chkDelivered">Delivered</label>
				  </div>
				  <div class="col-sm-4">
					<input type="checkbox" class="form-check-input" id="chkPrinted">
					<label class="form-check-label" for="chkPrinted">Printed</label>
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtDeliveredBy">Delivered By</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtDeliveredBy">
				  </div>
			  </div>
		  </div>
		  <div class="col-md-4 control-margin">
			  <div class="row element-margin">
					<div class="col-sm-4">
					  <label for="txtNo" class="form-label">No</label>
					</div>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="txtNo">
				    </div>					
			  </div>
			  <div class="row element-margin">
					<div class="col-sm-4">
						<label for="txtOGPL" class="form-label">OGPL</label>
					</div>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="txtOGPL">
					</div>
			  </div>
			  <div class="row element-margin">
					<div class="col-sm-4">
						<label for="dtFromDate" class="form-label">Date</label>
					</div>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="dtFromDate" placeholder="">
					</div>
			  </div>
			  <div class="row element-margin">	
					<div class="col-sm-4">
						<label for="dtToDate" class="form-label">Date</label>
					</div>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="dtToDate" placeholder="">
					</div>				
			  </div>
			  <div class="row element-margin">
				<div class="col-sm-4">
				  <label for="dtFrom" class="form-label">From</label>
				</div>

				<div class="col-sm-8">
					<select class="form-select" id="dtFrom">
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
				    <select class="form-select" id="dtTo">
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
					<input type="text" class="form-control" id="txtLRNo">
				  </div>
			   </div>
			   <div class="row element-margin">	
				  <div class="col-sm-4">
					<label class="form-label" for="txtDeliveryBillNo">Delivery Bill No.</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtDeliveryBillNo">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="dtDeliveryDate">Delivery Date</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="dtDeliveryDate">
				  </div>
			   </div>
			  <div class="row element-margin">			   
				<div class="col-sm-4">
					<label class="form-label" for="txtToPay">To Pay</label>
				</div>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="txtToPay">
				</div>
			  </div>
		  </div>
		  <div class="col-md-4 control-margin">
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtHamali">Hamali</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtHamali">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtUnloadingCharges">Unloading Charges</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtUnloadingCharges">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtDoorDeliveryCharges">Door Delivery Charges</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtDoorDeliveryCharges">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtDemurrage">Demurrage</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtDemurrage">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="txtOthers">Others</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="txtOthers">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-8">
					<label class="form-label" for="txtTotal">TOTAL</label>
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="txtTotal">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-2">
					<label class="form-label" for="txtPaidTotal">Paid</label>
				  </div>
				  <div class="col-sm-6">
					<input type="text" class="form-control" id="txtPaidBy">
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="txtPaidTotal">
				  </div>
				  <div class="mt-0" style="padding-left:80px">
					<label for="txtPaidBy" class="form-label"><small>(Cheque No;Bank;Branch)</small></label>
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-8">
					<label class="form-label" for="txtRefund">Refund</label>
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="txtRefund">
				  </div>
			  </div>
		  </div>
		</div>
		<div class="row control-margin">
			<div class="col-md-5 control-margin">
				<button type="button" class="btn btn-primary button-margin" id="btnSave">Save</button>
				<button type="button" class="btn btn-primary button-margin" id="btnClear">Clear</button>
				<a class="btn btn-primary button-margin" href="menu.jsp">Back</button>
			</div>
			<div class="col-md-4 control-margin">
				<button type="button" class="btn btn-primary button-margin" id="btnNext">Next</button>
				<button type="button" class="btn btn-primary button-margin" id="btnPrevious">Previous</button>
				<button type="button" class="btn btn-primary button-margin" id="btnCurrent">Current</button>
			</div>
			<div class="col-md-3 control-margin">
				<button type="button" class="btn btn-primary button-margin" id="btnDeliver">Deliver</button>
				<button type="button" class="btn btn-primary button-margin" id="btnPrint">Print</button>
			</div>
		</div>
	  </main>
	</div>
	</div></div></div></div>

  </body>
</html>

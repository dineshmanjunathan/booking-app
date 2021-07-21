<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
	<center><h4>BOOKING</h4></center>
	
	
  
	<div class="blog-details-area mg-b-15">
            <div class="container-fluid" style="width: 90%;">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="blog-details-inner">
      <form action="/booking/save" method="POST">
	  <main>
		<div class="row">
		  <div class="col-md-4 control-margin">
			<div class="well">
			 <div class="row element-margin">
				<div class="col-sm-4">
				  <label for="from" class="form-label">From</label>
				</div>

				<div class="col-sm-8">
					<select class="form-select bg-info text-dark" id="from" name="from">
					  <option selected disabled value="">Choose...</option>
					  <option>...</option>
					</select>
				</div>				
			  </div>
			  <div class="row element-margin">	
				<div class="col-sm-4">
				  <label for="to" class="form-label">To</label>
				</div>

				<div class="col-sm-8">
				    <select class="form-select bg-info text-dark" id="to" name ="to">
					  <option selected disabled value="">Choose...</option>
					  <option>...</option>
					</select>
				</div>				
			  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="fromName">From Name</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="fromName" name="fromName">
				  </div>
			  </div>
			  
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="from_phone">From Phone No</label>
				  </div>
				  <div class="col-sm-8">
					<input type="number" class="form-control" id="from_phone" name="from_phone">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="remarks">Remarks</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="remarks" name="remarks">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="fromValue">Value</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="fromValue" name="fromValue">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="invNo">Cons INV No</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="invNo" name="invNo">
				  </div>
			  </div>
			  
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="tinNo">Cons TIN No</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="tinNo" name="tinNo">
				  </div>
			  </div>
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="billDesc">Bill Desc</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="billDesc" name="billDesc">
				  </div>
			  </div>
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="billValue">Bill Value</label>
				  </div>
				  <div class="col-sm-8">
					<input type="number" class="form-control" id="billValue" name="billValue">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<input type="checkbox" class="form-check-input" id="isPrinted" name="isPrinted" disabled>
					<label class="form-check-label" for="isPrinted">Printed</label>
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="bookedBy">Booked By</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="bookedBy" name="bookedBy">
				  </div>
			  </div>
		  </div>
		  <div class="col-md-4 control-margin">
		  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
    
    		<div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label"></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label"></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label"></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="toName">To Name</label>
				  </div>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="toName" name="toName">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="to_phone">To Phone No</label>
				  </div>
				  <div class="col-sm-8">
					<input type="number" class="form-control" id="to_phone" name="to_phone">
				  </div>
			  </div>
			  
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="item_count">No Of Items</label>
				  </div>
				  <div class="col-sm-8">
					<input type="number" class="form-control" id="item_count" name="item_count">
				  </div>
			   </div>
			   
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="weight">Weight</label>
				  </div>
				  <div class="col-sm-8">
					<input type="number" class="form-control" id="weight" name="weight">
				  </div>
			   </div>
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="freight_value">Freight</label>
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="freight_value_topay" disabled value="TOPAY">
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="freight_value" name="freight_value">
				  </div>
				  
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="loading_charges">Loading Charges</label>
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="loading_charges_topay" disabled value="TOPAY">
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="loading_charges" name="loading_charges">
				  </div>
				  
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="door_pick_charges">Door Pickup Charges</label>
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="door_pick_charges_topay" disabled value="TOPAY">
				  </div>
				  <div class="col-sm-4">
					<input type="number" class="form-control" id="door_pick_charges" name="door_pick_charges">
				  </div>
				  
			  </div>
			  
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="other_charges">Others</label>
				  </div>
				  <div class="col-sm-8">
					<input type="number" class="form-control" id="other_charges" name ="other_charges">
				  </div>
			   </div>
			  
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="paid">Paid</label>
				  </div>
				  <div class="col-sm-8">
					<input type="number" class="form-control" id="paid" name="paid">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" for="topay">To Pay</label>
				  </div>
				  <div class="col-sm-8">
					<input type="number" class="form-control" id="topay" name="topay">
				  </div>
			  </div>
			  
			  
		  </div>
		  <div class="col-md-4 control-margin">
			  <div class="well">
			  <div class="row element-margin">
					<div class="col-sm-4">
					  <label for="bookingNo" class="form-label">Book No</label>
					</div>
					<div class="col-sm-8">
						<input type="text" class="form-control bg-info text-dark" id="bookingNo" name="bookingNo">
				    </div>					
			  </div>
			  <div class="row element-margin">	
					<div class="col-sm-4">
						<label for="bookedOn" class="form-label">Date</label>
					</div>
					<div class="col-sm-8">
						<input type="datetime" class="form-control bg-info text-dark" id="bookedOn" placeholder="" name="bookedOn">
					</div>				
			  </div>
			   <div class="row element-margin">
				  <div class="input-group">
					<input type="text" class="form-control bg-info text-dark" placeholder="LR No" id="lrNumber" name="lrNumber">
					<button type="submit" class="btn btn-secondary" id="btnSearch">Search</button>				
				  </div>
				  <div class="mt-0">
					<label for="txtSearch" class="form-label"><small>(Type LR No and press Search)</small></label>
				  </div>
			 </div> 
			  </div>
			  
			  
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			  
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label"></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label"></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			  </div>
			   <div class="row element-margin">
				  <div class="col-sm-4">
					<label class="form-label" ></label>
				  </div>
				  <div class="col-sm-8">
					
				  </div>
			 
			  
			  
			  
			  <div class="row element-margin">
				  <div class="col-sm-8">
					<label class="form-label" for="txtTotal">Total</label>
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="total" name="total">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-8">
					<label class="form-label" for="txtTotal">Cash</label>
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="cash" name="cash">
				  </div>
			  </div>
			  <div class="row element-margin">
				  <div class="col-sm-8">
					<label class="form-label" for="txtRefund">Refund</label>
				  </div>
				  <div class="col-sm-4">
					<input type="text" class="form-control" id="refund" name="refund">
				  </div>
			  </div>
			  
		  </div>
		</div>
		<div class="row control-margin">
			<div class="col-md-5 control-margin">
				<button type="button" class="btn btn-primary button-margin" id="btnNew">New</button>
				<button type="button" class="btn btn-primary button-margin" id="btnEdit">Edit</button>
				<button type="button" class="btn btn-primary button-margin" id="btnDelete">Delete</button>
				<button type="button" class="btn btn-primary button-margin" id="btnBill">Bill..</button>
				
			</div>
			<div class="col-md-4 control-margin">
			<button type="button" class="btn btn-primary button-margin" id="btnHelp">Help</button>
				<button type="button" class="btn btn-primary button-margin" id="btnNext">Next</button>
				<button type="button" class="btn btn-primary button-margin" id="btnPrevious">Previous</button>
				<button type="button" class="btn btn-primary button-margin" id="btnCurrent">Current</button>
			</div>
			<div class="col-md-3 control-margin">
				
				<button type="submit" class="btn btn-primary button-margin" id="btnSave">Save</button>
				<button type="button" class="btn btn-primary button-margin" id="btnClear">Clear</button>
				<a class="btn btn-primary button-margin" href="menu.jsp">Quit</a>
				<button type="button" class="btn btn-primary button-margin" id="btnPrint">Print</button>
			</div>
		</div>
		</div>
	  </main>
	  </form>
	</div>
	</div></div></div></div>

 </body> 
</html>

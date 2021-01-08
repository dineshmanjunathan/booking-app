<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<meta charset="ISO-8859-1">
<script type="text/javascript" charset="utf-8">
$(document).ready(function(){
	
//     $('#category').on('change', function (){
//     	window.location.href = "/purchase/loadProduct/"+$( "#category option:selected" ).val();
//     });

});

let cart = new Map();
let cartTotal =  0;

function addToCart(prodCode, price) {
	let qty = $( "#quantity-"+prodCode+" option:selected" ).val();
	if(!qty){
		alert('Please select quantity.');
		return;
	}
	let existingQty = cart.get(prodCode);
	if(!existingQty){
		let total = price * qty; 
		cartTotal = cartTotal + total;
	} else {
		let removeTotal = price * existingQty;
		cartTotal = cartTotal - removeTotal;
		let total = price * qty; 
		cartTotal = cartTotal + total;
	}
	cart.set(prodCode,qty);
	$('#cartTotal').text(cartTotal);
}

function removeFromCart(prodCode, price) {
	if(confirm("Do you want to remove from cart?")) {
		cart.delete(prodCode);
		let qty = cart.get(prodCode);
		let total = price * qty; 
		cartTotal = cartTotal - total;
		if(!cartTotal){
			$('#cartTotal').text(0);
		} else {
			$('#cartTotal').text(cartTotal);
		}
		$("#quantity-"+prodCode+" option:selected").removeAttr("selected");
	}
}

$('#purchaseReview').on('click', function (){
	$.ajax({
        url: "/purchase/review",
        data: {
            "cart": JSON.stringify(cart)
        },
        type: "post",
        cache: false,
        success: function (data) {
            
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('ERROR:' + XMLHttpRequest.status + ', status text: ' + XMLHttpRequest.statusText);
        }
    });
});

</script>
</head>
<body>
	<!-- Single pro tab review Start-->
	<div class="col-md-10 col-md-offset-2 row">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="product-payment-inner-st">
					<ul id="myTabedu1" class="tab-review-design">
						<center>
							<li class="active"><a href="">Review your products to purchase</a></li>
						</center>
					</ul>

					<div id="myTabContent" class="tab-content custom-product-edit">
						<div class="product-tab-list tab-pane fade active in"
							id="description">
							<div class="row">
								<div class="row">
									<a href="/menu"
										class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-1 col-md-2">
										<span><i class="fa fa-arrow-left"></i> <span>Back
												to Main</span> </span>
									</a> 
								</div>
								<br>
								<div class="sparkline13-graph">
									<div class="datatable-dashv1-list custom-datatable-overright">
										<div id="toolbar">
											<select class="form-control dt-tb">
												<option value="">Export Basic</option>
												<option value="all">Export All</option>
												<option value="selected">Export Selected</option>
											</select>
										</div>
										<table id="table" data-toggle="table" data-pagination="true"
											data-search="true" data-show-columns="true"
											data-show-pagination-switch="true" data-show-refresh="false"
											data-key-events="true" data-show-toggle="true"
											data-resizable="true" data-cookie="true"
											data-cookie-id-table="saveId" data-show-export="true"
											data-click-to-select="true" data-toolbar="#toolbar">
											<thead>
												<tr>
													<th data-field="prodCode" data-editable="false">Product
														Code</th>
													<th data-field="quantity" data-editable="false">Quantity</th>
													<th data-field="total">Action</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="entry" items="${cartMap}">
  														<tr>
														<td>${entry.key}</td>
														<td>${entry.value}</td>
														<td>
															<button class="btn btn-danger" type="button"
																onclick="return removeFromCart('${details.prodCode}', '${details.price}');">
																<i class="fa fa-remove"></i>Remove</button>
														</td>
														</tr>
												</c:forEach>
											</tbody>
										</table>

										<div class="row">
											<a href="#"
												class="btn btn-waring m-btn m-btn--custom m-btn--icon col-md-offset-9 col-md-3">
												<span> <i class="fa fa-shopping-cart"
													style="font-size: 20px"></i> <span>Purchase Total:
														&#x20b9; <span id="cartTotal">0</span>
												</span>
											</span>
										</div>
										<div class="row">
											</a> <a href="#"
												class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-9 col-md-3">
												<span> <i class="fa fa-plus"></i> <span>Pay to place you order</span>
											</span>
											</a>

										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
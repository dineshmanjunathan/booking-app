<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file="header.jsp"%>
<meta charset="ISO-8859-1">
<script type="text/javascript" charset="utf-8">
$(document).ready(function(){
    $('#category').on('change', function (){
    	$.ajax({
            url: "/loadProduct",
            data: {
                "categoryId": $( "#category option:selected" ).val()
            },
            type: "get",
            cache: false,
            success: function (data) {
                if(data) {
                	 var options = '<option value="">-Select Product-</option>';
                     for (var i = 0; i < data.length; i++) {
                       options += '<option value="' + data[i].prodCode + '">' + data[i].prodDesc + '</option>';
                     }
                     $("select#prodCode").html(options);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('ERROR:' + XMLHttpRequest.status + ', status text: ' + XMLHttpRequest.statusText);
            }
        });
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
							<li class="active"><a href="">Manual purchase entry</a></li>
						</ul>
						<!-- <form action="/userlisting" method="get"> -->
						<div class="row">
						<div class="col-lg-12">
							<div class="payment-adress">
							<a
							class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
							href="/stock/point/menu" type="submit" name="submit"
							value="adminListing">Back to Main</a>
						<div class="row"><div class="col-lg-12"></div></div>
							<a
							class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
							href="#" type="submit" name="submit"
							value="adminListing">View Purchase List</a>
						</div>
						</div>
						</div>
						<!-- </form> -->
						
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
											<form action="/save/purchase" method="post"  onsubmit="return confirm('Are you sure you want to submit?')">
											<input type="hidden" name="memberid" id="memberid" value="${sessionScope.MEMBER_ID}">
											
											<div id="dropzone1" class="pro-ad">
											
													<p style="color: green" align="center">${successMessage}</p>
													<p style="color: red" align="center">${errormsg}</p>
													<script type="text/javascript">
															</script>
													<div class="row" style="padding-right: 16%;padding-left: 16%;">
														<div class=" well col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<div class="form-group">
															</div>
															<div class="form-group">
															<select name="category" id="category"
																class="form-control">
																<option value="">-Select Category-</option>
																<c:forEach var="options" items="${categoryList}"
																	varStatus="status">
																	<option value="${options.code}">${options.description}</option>
																</c:forEach>
															</select>
														</div>
															<div class="form-group">
															<select name="prodCode" id="prodCode"class="form-control">
															
																<option value="">-Select Product-</option>
																
															</select>
														</div>
															<div class="form-group">
																<input name="quantity" id="quantity" type="number" class="form-control"
																	placeholder="Quantity"  required>
															</div>
															<div class="form-group">
																<input name="amount" type="number" class="form-control"
																	placeholder="Amount"  required>
															</div>
															
													</div>
													</div>
													<div class="row">
														<div class="col-lg-12">
															<div class="payment-adress">
																<button class="btn btn-primary waves-effect waves-light"
																	type="submit" name="submit" value="register">Submit</button>

															</div>
														</div>
													</div>
													
												</form>
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


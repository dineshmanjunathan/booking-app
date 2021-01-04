<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file="header.jsp"%>
<meta charset="ISO-8859-1">
</head>
<body>


	<!-- Single pro tab review Start-->
	<div class="col-md-10 col-md-offset-2 row">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="product-payment-inner-st">
						<ul id="myTabedu1" class="tab-review-design">
							<li class="active"><a href="">Re purchase entry</a></li>
						</ul>
						<!-- <form action="/userlisting" method="get"> -->
						<div class="payment-adress">
						<a
							class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
							href="/wallet" type="submit" name="submit"
							value="adminListing">Back to Wallet</a>
						</div>
						<!-- </form> -->
						
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
										
											<form action="/updateRePurchase" method="post" onsubmit="return validateFormOnSubmit(this);">
											
											<script type="text/javascript">
													function validateFormOnSubmit(frm) {
														var walletbalance =frm.walletbalance.value;
														var repurcahse =frm.repurcahse.value;
														
														if(walletbalance > repurcahse){
															return true;
														}else{
															 	alert("Re Purcahse Points Shouldn't be Greater than Available Balance! ");
																return false;
															}

													}
												</script>
											
											
											<input type="hidden" name="id" id="id" value="${member.id}">
									
											<div id="dropzone1" class="pro-ad">
											
													<div class="row">
														<div class=" well col-lg-6 col-md-6 col-sm-6 col-xs-12">
															<div class="form-group">
															<label>Available Balance:</label>
																<input name="walletbalance" id="walletbalance" type="text" class="form-control"
																	placeholder="" value="${member.walletBalance}" readonly>
															</div>
															

														<div class="form-group">
															<input name="repurcahse" id="repurcahse" type="number" class="form-control"
																placeholder="Re purcahse points" value="${member.repurcahse}"
																required>
														</div>

														</div>
															
													</div>
													</div>
													<div class="row">
														<div class="col-lg-12">
															<div class="payment-adress">
																<button class="btn btn-primary waves-effect waves-light"
																	type="submit" name="submit" value="register">Submit</button>
																<button class="btn btn-primary waves-effect waves-light"
																	type="reset" name="reset" value="reset">Clear</button>

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


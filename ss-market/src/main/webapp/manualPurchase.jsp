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
    $('#product').on('change', function (){
    	$.ajax({
            url: "/loadProduct",
            data: {
                
            },
            type: "get",
            cache: false,
            success: function (data) {
                if(data) {
                	 var options = '<option value="">-Select Product-</option>';
                     for (var i = 0; i < data.length; i++) {
                       options += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                     }
                     $("select#product").html(options);
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
							<div class="payment-adress">
								<a
									class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2" href="/countryCodeListing"
									type="submit" name="submit" value="adminListing">Back</a>
							</div>
						<!-- </form> -->
						
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
										<c:choose>
												<c:when test="${not empty countryCode}">
													<c:url var="action" value="/countryCode/edit"/>
												</c:when>
												<c:otherwise>
													<c:url var="action" value="/countryCode/save"/>
												</c:otherwise>
											</c:choose>
											<form action="${action}" method="post" onsubmit="return ValidateForm(this);">
											<input type="hidden" name="id" id="id" value="${countryCode.id}">
											<div id="dropzone1" class="pro-ad">
											
													<p style="color: green" align="center">${successMessage}</p>
													<p style="color: red" align="center">${deletesuccessmessage}</p>
													<script type="text/javascript">
															</script>
													<div class="row">
														<div class=" well col-lg-6 col-md-6 col-sm-6 col-xs-12">
															<div class="form-group">
															</div>
															<div class="form-group">
															<select name="product" id="product"
																class="form-control">
																<option value="">-Select Product-</option>
																<c:forEach var="options" items="${categoryList}"
																	varStatus="status">
																	<option value="${options.prodCode}">${options.prodDesc}</option>
																</c:forEach>
															</select>
														</div>
															<div class="form-group">
																<input name="countryCode" type="text" class="form-control"
																	placeholder="Quantity" value="${countryCode.countryCode}" required>
															</div>
															<div class="form-group">
																<input name="countryDesc" type="text" class="form-control"
																	placeholder="amount" value="${countryCode.countryDesc}" required>
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


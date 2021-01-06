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
							<li class="active"><a href="">Manage Product</a></li>
						</ul>
							<div class="payment-adress">
								<a
									class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2" href="/admin/productListing"
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
												<c:when test="${not empty productCode}">
													<c:url var="action" value="/admin/product/edit"/>
												</c:when>
												<c:otherwise>
													<c:url var="action" value="/admin/product/save"/>
												</c:otherwise>
											</c:choose>
											<form action="${action}" method="post" onsubmit="return ValidateForm(this);">
											<input type="hidden" name="id" id="id" value="${productCode.id}">
											<div id="dropzone1" class="pro-ad">
											
													<p style="color: green" align="center">${successMessage}</p>
													<p style="color: red" align="center">${deletesuccessmessage}</p>
													<div class="row">
														<div class=" well col-lg-6 col-md-6 col-sm-6 col-xs-12">
															<div class="form-group">
															</div>
															<div class="form-group">
															<select name="category" id="category"
																class="form-control">
																<option value="">-Select category-</option>
																<c:forEach var="options" items="${categoryCodeList}"
																	varStatus="status">
																	<option value="${options.code}" ${options.code == productCode.category ? 'selected' : ''}>${options.description}</option>
																</c:forEach>
															</select>
														</div>
															<div class="form-group">
																<input name="prodCode" type="text" class="form-control"
																	placeholder="Product Code" value="${productCode.prodCode}" required>
															</div>
															<div class="form-group">
																<input name="prodDesc" type="text" class="form-control"
																	placeholder="Product Description" value="${productCode.prodDesc}" required>
															</div>
															
															<div class="form-group">
																<input name="quantity" type="number" class="form-control"
																	placeholder="Quantity" value="${productCode.quantity}" required>
															</div>
															
															<div class="form-group">
																<input name="price" type="text" class="form-control"
																	placeholder="Price Per-Item" value="${productCode.price}" required>
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


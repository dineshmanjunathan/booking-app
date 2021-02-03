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
						<center><ul id="myTabedu1" class="tab-review-design">
							<li class="active"><a href="">SS Configuration</a></li>
						</ul>
						</center>
							<div class="payment-adress">
								<a
									class="rmk btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2" href="/admin/ssconfig/listing"
									type="submit" name="submit" value="adminListing">Back</a>
							</div>
						<!-- </form> -->
						
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding-right: 21%; padding-left: 21%;" >
										<div class="review-content-section">
										
											<c:choose>
												<c:when test="${not empty productCode}">
													<c:url var="action" value="/admin/ssconfig/edit"/>
												</c:when>
												<c:otherwise>
													<c:url var="action" value="/admin/ssconfig/save"/>
												</c:otherwise>
											</c:choose>
											<form action="${action}" method="post" onsubmit="return ValidateForm(this);">
											<div id="dropzone1" class="pro-ad">
											
													<p style="color: green" align="center">${successMessage}</p>
													<p style="color: red" align="center">${errorsuccessmessage}</p>
													<div class="row">
														<div class=" well col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<div class="form-group">
															</div>															
															<div class="form-group">															
															<select name="code" id="code"
																class="form-control">
																<option value="">-Select Type-</option>
																<c:forEach var="options" items="${ssConfigType}" varStatus="status">
																	<option value="${options.code}" ${options.code == ssConfigDetail.code ? 'selected' : ''}>${options.description}</option>
																</c:forEach>
															</select>
															</div>
														
															
															<div class="form-group">
																<input name="value" type="text" class="form-control"
																	placeholder="Value" value="${ssConfigDetail.value}" required>
															</div>
															
															<div class="form-group">
																<input name="comment" type="text" class="form-control"
																	placeholder="Comment" value="${ssConfigDetail.comment}">
															</div>
															
													</div>
													</div>
													<div class="row">
														<div class="col-lg-12">
															<div class="payment-adress">
																<button class="rmk btn btn-primary waves-effect waves-light"
																	type="submit" name="submit" value="register">Submit</button>
																<button class="rmk btn btn-primary waves-effect waves-light"
																	type="reset" name="reset" value="reset">Clear</button>

															</div>
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


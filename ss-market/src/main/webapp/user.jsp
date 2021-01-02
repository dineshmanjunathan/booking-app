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
	<div class="col-md-10 col-md-offset-1 row">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="product-payment-inner-st">
					<ul id="myTabedu1" class="tab-review-design">
						<li class="active"><a href="">Member Registration</a></li>
					</ul>
					<!-- <form action="/userlisting" method="get"> -->
					<div class="payment-adress">
						<a
							class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
							href="/login.jsp" type="submit" name="submit"
							value="adminListing">Back to Main</a>
					</div>
					<!-- </form> -->

					<div id="myTabContent" class="tab-content custom-product-edit">
						<div class="product-tab-list tab-pane fade active in"
							id="description">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="review-content-section">
										<c:choose>
											<c:when test="${not empty member}">
												<c:url var="action" value="/user/edit" />
											</c:when>
											<c:otherwise>
												<c:url var="action" value="/register" />
											</c:otherwise>
										</c:choose>
										<form action="${action}" method="post"
											onsubmit="return ValidateForm(this);">
											<p style="color: red" align="center">${errormsg}</p>
											<input type="hidden" name="id" id="id" value="${member.id}">
											<div id="dropzone1" class="pro-ad">

												<p style="color: green" align="center">${successMessage}</p>
												<p style="color: red" align="center">${deletesuccessmessage}</p>
												<script type="text/javascript">
													function ValidateForm(frm) {
														if (frm.password1.value != frm.password2.value) {
															alert('Passwords do not match');
															frm.password1
																	.focus();
															return false;
														}
														if (frm.mobile.value.length != 10) {
															alert('Required 10 digits, match requested format!');
															frm.mobile.focus();
															return false;
														}

													}
												</script>
												<div class="well row">
													<div class=" col-lg-6 col-md-5 col-sm-6 col-xs-12">
														<div class="form-group"></div>
														<div class="form-group">
															<input name="name" type="text" class="form-control"
																placeholder="Member Name" value="${member.name}"
																required>
														</div>

														<div class="form-group">
															<input name="email" type="text" class="form-control"
																placeholder="Email" value="${member.email}" required>
														</div>
														<div class="form-group">
															<input name="phonenumber" type="text"
																class="form-control" placeholder="Phone Number"
																value="${member.phonenumber}" required>
														</div>
														<div class="form-group">
															<input name="password" type="password" class="form-control"
																placeholder="Password" value="${member.password}"
																required>
														</div>
													</div>
													<div class=" col-lg-6 col-md-5 col-sm-6 col-xs-12">
														<div class="form-group">
															<label>Date of Birth:</label> <input name="dob"
																type="date" class="form-control"
																placeholder="Date of Birth" value="${member.dob}"
																required>
														</div>

														<div class="form-group">
															<label>Gender :</label> <input name="gender"
																class=" required " id="gender" type="radio" value="Male"
																${member.gender eq 'Male' ?'Checked':''}>Male <input
																name="gender" class=" required " id="gender"
																type="radio" value="Female"
																${member.gender eq 'Female' ?'Checked':''}>Female
														</div>
														<div class="form-group">
															<input name="referedby" type="numeric"
																class="form-control" placeholder="Sponser Id"
																value="${member.referedby}" >
														</div>
													</div>

													<%-- <div class="form-group">
																<input name="password" type="password"
																	class="form-control" placeholder="Password"
																	value="${user.password}" required>
															</div>
															<div class="form-group">
																<input name="password2" type="password"
																	class="form-control" placeholder="Confirm Password"
																	required>
															</div> --%>
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


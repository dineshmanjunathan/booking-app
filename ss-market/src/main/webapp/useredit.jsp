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
						<li class="active"><a href="">Member profile</a></li>
					</ul>
					<!-- <form action="/userlisting" method="get"> -->
					
					<div class="payment-adress">
					<c:if test="${fn:contains(sessionScope.ROLE, 'MEMBER')}">
						<a class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2" href="/menu" type="submit" name="submit" value="adminListing">Back to Main</a>
					</c:if>
					<c:if test="${fn:contains(sessionScope.ROLE, 'ADMIN')}">
						<a class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2" href="/admin/member/listing" type="submit" name="submit" value="adminListing">Back to Main</a>
					</c:if>
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
										<form action="${action}" method="post" onsubmit="return ValidateForm(this);">
											<p style="color: red" align="center">${errormsg}</p>
											<input type="hidden" name="id" id="id" value="${member.id}">
											<input type="hidden" name="active_days" id="active_days" value="${member.active_days}">
									
											<div id="dropzone1" class="pro-ad">

												<p style="color: green" align="center">${successMessage}</p>
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
														
														
														<c:choose>
														<c:when test="${not empty member.id}">
															<div class="form-group"><input name="referedby" type="text"	class="form-control" placeholder="Sponser Id"value="${member.referedby}" readonly></div>														
														</c:when>
														<c:otherwise>
															<div class="form-group"><input name="referedby" type="text"	class="form-control" placeholder="Sponser Id"value="${member.referedby}" ></div>

														</c:otherwise>
														</c:choose>
														
														<c:choose>
														<c:when test="${fn:contains(sessionScope.ROLE, 'ADMIN')}">

														<div class="form-group">
															<select name="role" id="role"
																class="form-control">
																<option value="">-Select Role-</option>
																<option value="ADMIN"  ${member.role == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
																<option value="MEMBER" ${member.role == 'MEMBER' ? 'selected' : ''}>MEMBER</option>
																<option value="STOCK_POINT" ${member.role == 'STOCK_POINT' ? 'selected' : ''}>STOCK POINT</option>
															</select>
														</div>
														
														<div class="form-group">
															<select name="status" id="status"
																class="form-control">
																<option value="">-Select Status-</option>
																<option value="true"  ${member.status == true ? 'selected' : ''}>Active</option>
																<option value="false" ${member.status == false ? 'selected' : ''}>Inactive</option>
															</select>
														</div>
														</c:when>		
														<c:otherwise>
																<input type="hidden" name="status" id="status" value="${member.status}">
																<input type="hidden" name="role" id="role" value="${member.role}">
														</c:otherwise>									
														</c:choose>
														

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
															type="submit" name="submit" value="register">Update</button>
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


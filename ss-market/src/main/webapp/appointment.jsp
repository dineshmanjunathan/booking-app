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
            url: "/loadDoctor",
            data: {
                "categoryId": $( "#category option:selected" ).val()
            },
            type: "get",
            cache: false,
            success: function (data) {
                if(data) {
                	 var options = '<option value="">-Select doctor-</option>';
                     for (var i = 0; i < data.length; i++) {
                       options += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                     }
                     $("select#doctor").html(options);
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
						<li class="active"><a href="">Book Patient Appointment</a></li>
					</ul>
					<div class="payment-adress">
						<a
							class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
							href="/menu" type="submit" name="submit"
							value="adminListing">Back</a>
					</div>
					<!-- </form> -->

					<div id="myTabContent" class="tab-content custom-product-edit">
						<div class="product-tab-list tab-pane fade active in"
							id="description">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="review-content-section">
										<c:choose>
											<c:when test="${not empty appointment}">
												<c:url var="action" value="/appointment/edit" />
											</c:when>
											<c:otherwise>
												<c:url var="action" value="/appointment/save" />
											</c:otherwise>
										</c:choose>
											<div id="dropzone1" class="pro-ad">

												<p style="color: green" align="center">${successMessage}</p>
												<p style="color: red" align="center">${deletesuccessmessage}</p>
												
												<div class="row">
													<div class=" well col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<form action="/searchUser" method="POST">
															<div class="form-group">
																<select name="searchOption" class="form-control">
																	<option value="">Search by</option>
																	<option value="id">Patient Id</option>
																	<option value="mobile">Mobile no</option>
																</select>
															</div>
															<div class="form-group">
																<input name="searchBy" type="text" class="form-control"
																	placeholder="Search By" value=""
																	required>
															</div>

															<button
																class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
																type="submit">Search</button>
														</form>
													</div>
													<c:if test="${not empty user }">
													
													<div class=" well col-lg-6 col-md-6 col-sm-6 col-xs-12">
															<div class="form-group">
																<label>Patient Name : </label> ${user.name }
															</div>
															<div class="form-group"> 
															<label>Patient Mobile No : </label> ${user.mobile }
															</div>
															
															<div class="form-group"> 
															<label>Patient Address : </label>${user.address }
															</div>		
															<input type="hidden" id="patientName" name ="patientName" value="${user.name }">
															<input type="hidden" id="patientMobile" name ="patientMobile" value="${user.mobile }">
															<input type="hidden" id="patientAddress" name ="patientAddress" value="${user.address }">																										
													</div>
													</c:if>
												</div>
												
												<c:if test="${not empty user }">
												<div class="row">
													<div class="well col-md-6 col-md-offset-3">
														<form action="${action}" method="POST">
														<input type="hidden" id="name" name ="name" value="${user.name }">
															<input type="hidden" id="mobile" name ="mobile" value="${user.mobile }">
															<input type="hidden" id="address" name ="address" value="${user.address }">
															<div class="form-group">
																<select name="category" id="category" class="form-control">
																	<option value="">-Select Category-</option>
																	<c:forEach var="options" items="${categoryList}"
																		varStatus="status">
																		<option value="${options.id}">${options.categoryDesc}</option>
																	</c:forEach>
																</select>
															</div>
															
															<div class="form-group">
																<select name="doctor"  id="doctor"  class="form-control">
																	<option value="">-Select Doctor-</option>
																	<c:forEach var="options" items="${doctorsList}"
																		varStatus="status">
																		<%-- <option value="${options.id}">${options.name}</option> --%>
																	</c:forEach>
																</select>
															</div>
															
															<div class="form-group">
																<input name="appointmentDate" type="date" class="form-control"
																	placeholder="Select" value="${appointment.name}"
																	required>
															</div>
															
															<div class="form-group">
																<select name="appointmentTime" id="appointmentTime" class="form-control">
																	<option value="">-Select time-</option>
																	 <optgroup label="Forenoon">
																	<option value="09.45am to 10.30am">09.45am to 10.30am</option>
																	<option value="10.45am to 11.30am">10.45am to 11.30am</option>
																	<option value="11.45am to 12.45pm">11.45am to 12.45pm</option>
																	 </optgroup>
																	 <optgroup label="Afternoon">
																	<option value="02.45pm to 03.30pm">02.45pm to 03.30pm</option>
																	<option value="03.45pm to 04.30pm">03.45pm to 04.30pm</option>
																	<option value="04.45pm to 05.30pm">04.45pm to 05.30pm</option>
																	<option value="05.45pm to 06.30pm">05.45pm to 06.30pm</option>
																	 </optgroup>
																</select>
															</div>

															<button
																class="btn btn-primary waves-effect waves-light col-md-offset-9 col-md-3"
																type="submit">Book Appointment</button>
														</form>
													</div>
												</div>
												</c:if>
												
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


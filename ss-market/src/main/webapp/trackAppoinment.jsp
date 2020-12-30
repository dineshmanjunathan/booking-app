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
						<li class="active"><a href="">Track Patient Appointment</a></li>
					</ul>
					<div class="payment-adress">
						<a
							class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
							href="/appointmentListing" type="submit" name="submit"
							value="adminListing">Back</a>
					</div>
					<!-- </form> -->

					<div id="myTabContent" class="tab-content custom-product-edit">
						<div class="product-tab-list tab-pane fade active in"
							id="description">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="review-content-section">
										<div id="dropzone1" class="pro-ad">
											<p style="color: green" align="center">${successMessage}</p>
											<p style="color: red" align="center">${deletesuccessmessage}</p>
											<div class="row">
												<div class="well col-md-6 col-md-offset-3">
													<form action="/track/appoinment" method="POST">
														<div class="form-group">
															<select name="category" id="category"
																class="form-control">
																<option value="">-Select category-</option>
																<c:forEach var="options" items="${categoryList}"
																	varStatus="status">
																	<option value="${options.id}">${options.categoryDesc}</option>
																</c:forEach>
															</select>
														</div>

														<div class="form-group">
															<select name="doctor" id="doctor" class="form-control">
																<option value="">-Select doctor-</option>
																<c:forEach var="options" items="${doctorsList}"
																	varStatus="status">
																	<%-- <option value="${options.id}">${options.name}</option> --%>
																</c:forEach>
															</select>
														</div>

														<div class="form-group">
															<input name="appointmentDate" type="date"
																class="form-control" placeholder="Select"
																value="${appointment.name}" required>
														</div>

														<button
															class="btn btn-primary waves-effect waves-light col-md-offset-9 col-md-3"
															type="submit">Search</button>
													</form>
												</div>
											</div>

											<c:if test="${not empty appointmentTrackList }">
												<table id="table" data-toggle="table" data-pagination="true"
													data-search="true" data-show-columns="true"
													data-show-pagination-switch="true"
													data-show-refresh="false" data-key-events="true"
													data-show-toggle="true" data-resizable="true"
													data-cookie="true" data-cookie-id-table="saveId"
													data-show-export="true" data-click-to-select="true"
													data-toolbar="#toolbar">
													<thead>
														<tr>
															<th data-field="name">Patient Name</th>
															<th data-field="date" data-editable="false">Date</th>
															<th data-field="time" data-editable="false">Time</th>
															<th data-field="status" data-editable="false">Status</th>
															<th data-field="action" data-editable="false">Update Status</th>
														</tr>
													</thead>
													<tbody>
													<tr>
																<td>Manic</td>
																<td>12-10-2019</td>
																<td>10:00 AM</td>
																<td>Awaiting</td>
																<td><a
																	href="<c:url value='/countryCode/edit?id=${details.id}' />"><center>
																			<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																		</center></a> </td>
																</tr>
																<tr>
																<td>Dinesh</td>
																<td>12-10-2019</td>
																<td>09:00 AM</td>
																<td>Done</td>
																<td><a
																	href="<c:url value='/countryCode/edit?id=${details.id}' />"><center>
																			<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																		</center></a> </td>
																</tr>
																</tr>
																<tr>
																<td>Mani</td>
																<td>12-10-2019</td>
																<td>12:00 PM</td>
																<td>Cancelled</td>
																<td><a
																	href="<c:url value='/countryCode/edit?id=${details.id}' />"><center>
																			<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																		</center></a> </td>
																</tr>
																</tr>
																
														<%-- <c:forEach var="details" items="${appointmentTrackList}"
															varStatus="status">
															<tr>
																<td>${details.id}</td>
																<td>${details.countryCode}</td>
																<td>${details.countryDesc}</td>
																<td><a
																	href="<c:url value='/countryCode/edit?id=${details.id}' />"><center>
																			<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																		</center></a> <a class="btn-danger"
																	onclick="return confirm('Are you sure you want to delete?')"
																	href="<c:url value='/countryCode/delete?id=${details.id}' />">
																		<center>
																			<i class="fa fa-trash-o" aria-hidden="true"></i>
																		</center>
																</a></td>

															</tr>
														</c:forEach> --%>
													</tbody>
												</table>

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


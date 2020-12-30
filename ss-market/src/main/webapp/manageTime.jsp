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
																<option value="">-Select doctor-</option>
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
															<select name="doctor" id="doctor" class="form-control">
																<option value="">-Select session-</option>
																<option value="FN">Forenoon</option>
																<option value="AN">Afternoon</option>
																<option value="FD">FullDay</option>
															</select>
														</div>

														<div class="form-group">
															<input name="timeDiff" type="number"
																class="form-control" placeholder="Select"
																value="" required>
														</div>

														<button
															class="btn btn-primary waves-effect waves-light col-md-offset-9 col-md-3"
															type="submit">submit</button>
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
			</div>
		</div>
	</div>
</body>

</html>


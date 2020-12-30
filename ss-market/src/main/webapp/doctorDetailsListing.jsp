<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>
<body> 
				<div class="col-md-10 col-md-offset-2 row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="product-payment-inner-st">
							<ul id="myTabedu1" class="tab-review-design">
								<center><li class="active"><a href="">Doctors</a></li></center>
							</ul>

							<div id="myTabContent" class="tab-content custom-product-edit">
								<div class="product-tab-list tab-pane fade active in"
									id="description">
									<div class="row">
									<table class="full-right">
									<tr>
									<td>
										<a href="/menu"
											class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-1 col-md-12">
											<span><i class="fa fa-arrow-left"></i> <span>Back to Main</span>
										</span>
										</a>
									</td>
									<td>
										<a href="/doctor/detail/create"
											class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-2 col-md-12">
											<span> <i class="fa fa-plus"></i> <span>Create</span>
										</span>
										</a>
									</td>
									</tr> 
									</table>
										 <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div id="toolbar">
                                        <select class="form-control dt-tb">
											<option value="">Export Basic</option>
											<option value="all">Export All</option>
											<option value="selected">Export Selected</option>
										</select>
                                    </div>
                                     <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="false" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
                                     <thead>
										<tr> 
											<th data-field="id">Doctor Id</th>
											<th data-field="name" data-editable="false">Name</th>
											<th data-field="age" data-editable="false">Age</th>
											<th data-field="gender" data-editable="false">Gender</th>
											<th data-field="email" data-editable="false">Email</th>
											<th data-field="phone">Mobile</th>
											<th data-field="address" data-editable="false">Address</th>
											<th data-field="dob" data-editable="false">DOB</th>
											<th data-field="category">Category</th>
											<th data-field="designation">Designation</th>
											<th data-field="action">Action</th>
											<!-- <th data-field="attachment">Attachment</th> -->
										</tr>
									</thead>
                                        <tbody> 
                                        <c:forEach var="details" items="${doctorDetailsList}" varStatus="status">
                                            <tr>
												<td>${details.id}</td>
												<td>${details.name}</td> 
												<td>${details.age}</td>
												<td>${details.gender}</td>
												<td>${details.email}</td>
												<td>${details.countryCode}-${details.mobile}</td>
												<td>${details.address}</td> 
												<td>${details.dob}</td>
												<td>${details.category.categoryCode}</td>
												<td>${details.designation}</td>
                                                <td><a href="<c:url value='/doctor/detail/edit?id=${details.id}' />"><center><i class="fa fa-pencil-square-o" aria-hidden="true"></i></center></a>
		        								 <a class="btn-danger" onclick="return confirm('Are you sure you want to delete?')" 
		        								 href="<c:url value='/doctor/detail/delete?id=${details.id}' />" >
		        								  <center><i class="fa fa-trash-o" aria-hidden="true"></i></center></a></td> 
		        								 <%--  <td>
		        								  <a href="<c:url value='/user/generate/pdf?user_id=${details.id}' />" > <center><i class="fa fa-download" aria-hidden="true"></i></center></a>
		        								 </td> --%>
                                            </tr> 
                                        </c:forEach>
                                        </tbody>
                                    </table>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file="header.jsp"%>
<meta charset="ISO-8859-1">
</head>
<div class="col-md-10 col-md-offset-2 well row">
	<h4>User Management</h4>
	</br>
	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/userlisting">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Manage User</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>

	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/countryCodeListing">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Manage Country Code</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>
</div>

<div class="col-md-10 col-md-offset-2 well row">
	<h4>Appointment Management</h4>
	</br>
	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/categoryCodeListing">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Manage Category</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>

	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/doctorDetailsListing">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Manage Doctor</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>

	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/appoinment">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Book Appointment</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>
	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/track/appoinment">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Track Appointment</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>
	<!-- <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/manage/time">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Manage Time</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div> -->
</div>

</html>

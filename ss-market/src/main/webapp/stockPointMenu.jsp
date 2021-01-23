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
	<h4>Product Manager</h4>
	</br>
	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/purchase/manual/edit">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Manual Purchase</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>
	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/stock/point/inventory">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>My Stock Inventory</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>

</div>

<div class="col-md-10 col-md-offset-2 well row">
	<h4>Transaction Manager</h4>
	</br>
	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/purchase/detail">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Purchase History</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>
	<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
		<a href="/stock/point/salehistory">
			<div class="panel-body">
				<div class="stats-title pull-left">
					<h5>Stock Sales History</h5>
				</div>
				<div class="stats-icon pull-right">
					<i class="educate-icon educate-apps"></i>
				</div>
			</div>
		</a>
	</div>

</div>

</html>

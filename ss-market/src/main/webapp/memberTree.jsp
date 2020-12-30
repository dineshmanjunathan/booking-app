<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="header.jsp"%>
<meta charset="utf-8" />
<title>MemberTree</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
<script type="text/javascript">
	$(function() {

		var jsondata = [ {
			"id" : "ajson1",
			"parent" : "#",
			"text" : "Simple root node"
		}, {
			"id" : "ajson2",
			"parent" : "#",
			"text" : "Root node 2"
		}, {
			"id" : "ajson3",
			"parent" : "ajson2",
			"text" : "Child 1"
		}, {
			"id" : "ajson4",
			"parent" : "ajson2",
			"text" : "Child 2"
		}, ];

		createJSTree(jsondata);
	});

	function createJSTree(jsondata) {
		$('#memberTree').jstree({
			"core" : {
				"check_callback" : true,
				'data' : jsondata
			},
			"plugins" : [ "contextmenu" ]
		});
	}
</script>
</head>
<body>

	<div class="col-md-10 col-md-offset-1 row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="product-payment-inner-st">
				<ul id="myTabedu1" class="tab-review-design">
					<li class="active"><a href="">Member Tree</a></li>
				</ul>

				<div id="myTabContent" class="tab-content custom-product-edit">
					<div class="product-tab-list tab-pane fade active in"
						id="description">
						<div class="row">
							<table class="full-right">
								<tr>
									<td><a href="/menu"
										class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-1 col-md-12">
											<span><i class="fa fa-arrow-left"></i> <span>Back
													to Main</span> </span>
									</a></td>
								</tr>
							</table>
							<div class="row"></div><br>
							<div class="row">
								<div class=" well col-md-offset-2 col-md-6">
									<div id="memberTree"></div>
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
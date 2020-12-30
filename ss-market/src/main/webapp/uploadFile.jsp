<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>
<body><br/><br />
	<form method="POST" action="/upload" enctype="multipart/form-data" onsubmit="return ValidateForm(this);">
	<script type="text/javascript">
	function ValidateForm(frm) {
		if (frm.files.value.length <= 0) {
			alert('Please select your file to upload!');
			frm.files.focus();
			return false;
		}  
	}
	function fileValidation(){
	    var fileInput = document.getElementById('files');
	    var filePath = fileInput.value; 
	    var allowedExtensions = /(\.pdf|\.PDF)$/i;
	    if(!allowedExtensions.exec(filePath)){
	        alert('Please upload image/file having extension .pdf only.');
	        fileInput.value = ''; 
	        return false;
	    }
	}
</script>
		<div class="row"> 
			<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"> 
				<br />
			</div>
			<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12"> 
			 <p style="color:green" align="center">${uploadsuccess}</p><br />
				<div class="file-upload-inner ts-forms">
					<div class="input prepend-small-btn"> 
						<div class="file-button">
							Browse <input type="file" name="files" multiple="multiple"
								onchange="document.getElementById('prepend-small-btn').value = this.value; return fileValidation()">
						</div>
						<input type="text" id="prepend-small-btn" 
							placeholder="no file selected (only .pdf allowed)">
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"></div>
		</div> 
		<div class="form-group-inner">
			<div class="login-btn-inner">
				<div class="row">
					<div class="col-lg-3"></div>
					<div class="col-lg-6">
						<div class="login-horizental cancel-wp pull-left form-bc-ele"> 
							<button class="btn btn-sm btn-primary login-submit-cs"
								type="submit">Upload</button>
							<button class="btn btn-white" type="reset">Cancel</button><br /><br />
							<a href="/menu.jsp">  Back to List  </a>
						</div> 
					</div>
					<div class="col-lg-3"></div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
<!-- 
		<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
			<div class="file-upload-inner form-control file-upload-inner-right ts-forms">
				<div class="input append-small-btn">
					<input type="file" name="files" multiple="multiple" /><br />
					<br />
				</div>
				<div class="form-control">
				<input type="submit" value="Submit" id="btnSubmit" />
			</div>
			</div> 
		</div> --> 
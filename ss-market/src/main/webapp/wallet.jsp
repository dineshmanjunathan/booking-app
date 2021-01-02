<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
<!-- <link rel="stylesheet" href="../../css/bootstrap.css"> -->
</head>
<body> 
   
		   <div class="col-md-10 col-md-offset-2 row">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="product-payment-inner-st">
					<ul id="myTabedu1" class="tab-review-design">
						<center><li class="active"><a href="">MY WALLET</a></li></center>
					</ul>
					<div class="payment-adress">
						<a
							class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
							href="/menu" type="submit" name="submit"
							value="adminListing">Back to Main</a>
					</div>
					<!-- </form> -->

					<div id="myTabContent" class="tab-content custom-product-edit">
						<div class="product-tab-list tab-pane fade active in"
							id="description">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="review-content-section">
										<div class="row">
										
								<br><br>		
								<div class=" col-lg-4 col-md-4 col-sm-4 col-xs-12">
									  <div class="col-md-10">
									    <div class="row">
									      <div class="col-sm-11 btn btn-info">
									        <div class="thumbnail">
									          <div class="caption text-center" onclick="location.href='https://flow.microsoft.com/en-us/connectors/shared_slack/slack/'">
									            <div class="position-relative">
									              <img src="https://az818438.vo.msecnd.net/icons/slack.png" style="width:72px;height:72px;" />
									            </div>
									            <h4 id="thumbnail-label">Total Points</h4>
									            <div class="thumbnail-description smaller">${userwallet.totalbalance}</div>
									          </div>
									        </div>
									      </div>
									    </div>
									  </div>
									</div>



										<div class=" col-lg-4 col-md-4 col-sm-4 col-xs-12">
									  <div class="col-md-10">
									    <div class="row">
									      <div class="col-sm-11 btn btn-warning">
									        <div class="thumbnail">
									          <div class="caption text-center" onclick="location.href='https://flow.microsoft.com/en-us/connectors/shared_slack/slack/'">
									            <div class="position-relative">
									              <img src="https://az818438.vo.msecnd.net/icons/slack.png" style="width:72px;height:72px;" />
									            </div>
									            <h4 id="thumbnail-label">WithDrawn Points</h4>
									            <div class="thumbnail-description smaller">${userwallet.walletWithdrawn}</div>
									          </div>
									        </div>
									      </div>
									    </div>
									  </div>
									</div>
										<div class=" col-lg-4 col-md-4 col-sm-4 col-xs-12">
									  <div class="col-md-10">
									    <div class="row">
									      <div class="col-sm-11 btn btn-success">
									        <div class="thumbnail">
									          <div class="caption text-center" onclick="location.href='https://flow.microsoft.com/en-us/connectors/shared_slack/slack/'">
									            <div class="position-relative">
									              <img src="https://az818438.vo.msecnd.net/icons/slack.png" style="width:72px;height:72px;" />
									            </div>
									            <h4 id="thumbnail-label">Available Points</h4>
									            <div class="thumbnail-description smaller">${userwallet.walletBalance}</div>
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
				</div>
			</div>
		</div>
		<br><br>
		<%-- <center><button type="button" href="#"  class="btn btn-danger btn-lg">POINTS WITHDRAWN</button></center> --%>
		
		   </div>
</body>
</html>
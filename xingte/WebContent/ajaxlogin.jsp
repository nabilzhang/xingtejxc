<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="lib/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<title>兴特进销存登录</title>
</head>
<body>
	<div class="box">
		<div id="maincontainer">
			<div id="top"></div>
			<div id="middle">
				<div id="loginContent">
					<form id="loginform">
						<div class="form-item">
							<label>帐&nbsp;&nbsp;号:</label> <input type="text" name="name"
								id="name" class="textbox" />
						</div>
						<div class="form-item">
							<label>密&nbsp;&nbsp;码:</label> <input type="password"
								name="password" id="password" class="textbox" />
						</div>
						<div class="form-item">
							<div class="formbuttondiv">
								<input type="button" id="submit" class="formbutton"
									value="登   录" />
								<div class="formbuttonshadow"></div>
							</div>
							<div class="formbuttondiv">
								<input type="button" id="cancel" class="formbutton"
									value="取   消" />
								<div class="formbuttonshadow"></div>
							</div>

							<div class="clear"></div>

							<div id="show"></div>

						</div>
					</form>
				</div>
				<div class="clear"></div>
			</div>

			<div id="bottom"></div>
		</div>
	</div>
</body>
</html>
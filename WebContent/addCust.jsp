<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addCust</title>
</head>
<body style="text-align: center">
	<div align="center">
		<h1>Customer Management System__Add a Customer</h1><hr>
		<form action="${pageContext.request.contextPath }/AddCustServlet"
			method="post">
			<table>
				<tr>
					<td>customer name:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>customer gender:</td>
					<td><input type="radio" name="gender" value="male" />male <input
						type="radio" name="gender" value="female" />female</td>
				</tr>
				<tr>
					<td>customer birthday:</td>
					<td><input type="text" name="birthday" /></td>
				</tr>
				<tr>
					<td>customer tel:</td>
					<td><input type="text" name="cellphone" /></td>
				</tr>
				<tr>
					<td>customer email:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>customer preference:</td>
					<td><input type="checkbox" name="preference" value="tennis" />tennis
						<input type="checkbox" name="preference" value="basketball" />basketball
						<input type="checkbox" name="preference" value="swimming" />swimming
						<input type="checkbox" name="preference" value="running" />running
					</td>
				</tr>
				<tr>
					<td>customer type:</td>
					<td><select name="type">
							<option value="vip">vip</option>
							<option value="ip">ip</option>
							<option value="normal">normal</option>
							<option value="new">new</option>
					</select></td>
				</tr>
				<tr>
					<td>customer description:</td>
					<td><textarea name="description" rows="5" cols="40"></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit"/></td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
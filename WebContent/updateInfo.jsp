<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Information</title>
</head>
<body style="text-align: center">
	<div align="center">
		<h1>Customer Management System__Adjust a Customer</h1>
		<hr>
		<form action="${pageContext.request.contextPath }/UpdateCustServlet"
			method="post">
			<input type="hidden" value="${cust.id }"/>
			<table>
				<tr>
					<td>customer name:</td>
					<td><input type="text" name="name" value="${cust.name }" readonly="readonly" style="background-color:silver;"/></td>
				</tr>
				<tr>
					<td>customer gender:</td>
					<td><input type="radio" name="gender" value="male"
						<c:if test="${cust.gender=='male' }">checked="checked"</c:if> />male

						<input type="radio" name="gender" value="female"
						<c:if test="${cust.gender=='female' }">checked="checked"</c:if> />female</td>
				</tr>
				<tr>
					<td>customer birthday:</td>
					<td><input type="text" name="birthday"
						value="${cust.birthday }" /></td>
				</tr>
				<tr>
					<td>customer tel:</td>
					<td><input type="text" name="cellphone"
						value="${cust.cellphone }" /></td>
				</tr>
				<tr>
					<td>customer email:</td>
					<td><input type="text" name="email" value="${cust.email }" /></td>
				</tr>
				<tr>
					<td>customer preference:</td>
					<td><input type="checkbox" name="preference" value="tennis"
						<c:if test="${fn:contains(cust.preference,'tennis')}">checked="checked"</c:if> />tennis
						<input type="checkbox" name="preference" value="basketball"
						<c:if test="${fn:contains(cust.preference,'basketball') }">checked="checked"</c:if> />basketball
						<input type="checkbox" name="preference" value="swimming"
						<c:if test="${fn:contains(cust.preference,'swimming') }">checked="checked"</c:if> />swimming
						<input type="checkbox" name="preference" value="running"
						<c:if test="${fn:contains(cust.preference,'running') }">checked="checked"</c:if> />running
					</td>
				</tr>
				<tr>
					<td>customer type:</td>
					<td><select name="type">
							<option value="vip"
								<c:if test="${cust.type=='vip' }">selected="selected"</c:if>>vip</option>
							<option value="ip"
								<c:if test="${cust.type=='ip' }">selected="selected"</c:if>>ip</option>
							<option value="normal"
								<c:if test="${cust.type=='normal' }">selected="selected"</c:if>>normal</option>
							<option value="new"
								<c:if test="${cust.type=='new' }">selected="selected"</c:if>>new</option>
					</select></td>
				</tr>
				<tr>
					<td>customer description:</td>
					<td><textarea name="description" rows="5" cols="40">${cust.description }</textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit" /></td>

				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Customers</title>
	<script type="text/javascript">
  		function checkAll(allC){
  			var otherCs = document.getElementsByName("delId");
  			for(var i=0;i<otherCs.length;i++){
  				otherCs[i].checked = allC.checked;
  			}
  		}
  	</script>
</head>
<body>
	<div align="center">
		<h1>Customer Management System__All Customers</h1><hr>
		<form action="${pageContext.request.contextPath }/FindCustByCondServlet">
			name:<input type="text" name="name" value="${param.name }"/>
			gender:
				<input type="radio" name="gender" value="male" <c:if test="${param.gender=='male' }">checked="checked"</c:if>>male
				<input type="radio" name="gender" value="female" <c:if test="${param.gender=='female' }">checked="checked"</c:if>>female
			type:<select name="type">
					<option value=""></option>	
					<option value="vip" <c:if test="${param.type=='vip' }">selected="selected"</c:if>>vip</option>
					<option value="ip" <c:if test="${param.type=='ip' }">selected="selected"</c:if>>ip</option>
					<option value="normal" <c:if test="${param.type=='normal' }">selected="selected"</c:if>>normal</option>
					<option value="new" <c:if test="${param.type=='new' }">selected="selected"</c:if>>new</option>
				</select>
			<input type="submit" value="search"/>
		</form>
	
		<form action="${pageContext.request.contextPath }/BatchDelServlet"
			method="post">
			<table border="1" width="100%">
				<tr>
					<th><input type="checkbox" onclick="checkAll(this)" /></th>
					<th>name</th>
					<th>gender</th>
					<th>birthday</th>
					<th>cellphone</th>
					<th>email</th>
					<th>preference</th>
					<th>type</th>
					<th>description</th>

				</tr>
				<c:forEach items="${requestScope.list }" var="cust">
					<tr>
						<td><input type="checkbox" name="delId" value="${cust.id}" /></td>
						<td><c:out value="${cust.name }" /></td>
						<td><c:out value="${cust.gender }" /></td>
						<td><c:out value="${cust.birthday }" /></td>
						<td><c:out value="${cust.cellphone }" /></td>
						<td><c:out value="${cust.email }" /></td>
						<td><c:out value="${cust.preference }" /></td>
						<td><c:out value="${cust.type }" /></td>
						<td><c:out value="${cust.description }" /></td>
						<td><a
							href="${pageContext.request.contextPath }/CustInfoServlet?id=${cust.id}">adjust</a></td>
						<td><a
							href="${pageContext.request.contextPath }/DeleteInfoServlet?id=${cust.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="delete chosen" />
		</form>
	</div>
</body>
</html>
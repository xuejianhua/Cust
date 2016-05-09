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
		<form action="${pageContext.request.contextPath }/BatchDelServlet"
			method="post">
			<h1>Customer Management System__All Customers</h1>
			<hr>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script>
		function changePage(obj){
			if(isNaN(obj.value)){
				alert("must be a number!");
				obj.value=${requestScope.page.thisPage}
				return;
			}else if(obj.value<=0||obj.value>${requestScope.page.countPage}){
				alert("the page must be within the range!");
				obj.value=${requestScope.page.thisPage}
				return;
			}else{
				window.location.href="${pageContext.request.contextPath }/CustPageServlet?thisPage="+obj.value;
			}
		}
	</script>
</head>
<body>
	<div align="center">
		<h1>Customer Management System__Show Customers By Paging</h1><hr>
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
				<c:forEach items="${requestScope.page.list }" var="cust">
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
						<td><a href="${pageContext.request.contextPath }/CustInfoServlet?id=${cust.id}">adjust</a></td>
						<td><a href="${pageContext.request.contextPath }/DeleteInfoServlet?id=${cust.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
			${requestScope.page.countRow } rows in total &nbsp
			${requestScope.page.countPage } pages in total &nbsp
			<a href="${pageContext.request.contextPath }/CustPageServlet?thisPage=${requestScope.page.firstPage}">First</a>
			<a href="${pageContext.request.contextPath }/CustPageServlet?thisPage=${requestScope.page.prePage}">Pre</a>
			<!-- paging starts  -->
			<c:if test="${requestScope.page.countPage<=5 }">
				<c:set var="begin" value="1" scope="page"></c:set>
				<c:set var="end" value="${requestScope.page.countPage }" scope="page"></c:set>
			</c:if>
			<c:if test="${requestScope.page.countPage>5 }">
				<c:choose>
					<c:when test="${requestScope.page.thisPage<=3 }">
						<c:set var="begin" value="1" scope="page"></c:set>
						<c:set var="end" value="5" scope="page"></c:set>
					</c:when>
					<c:when test="${requestScope.page.thisPage>=requestScope.page.countPage-2 }">
						<c:set var="begin" value="${requestScope.page.countPage-4 }" scope="page"></c:set>
						<c:set var="end" value="${requestScope.page.countPage }" scope="page"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="begin" value="${requestScope.page.thisPage-2 }" scope="page"></c:set>
						<c:set var="end" value="${requestScope.page.thisPage+2 }" scope="page"></c:set>
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:forEach begin="${begin }" end="${end }" step="1" var="i">
				<c:if test="${i==requestScope.page.thisPage }">
					${i}
				</c:if>
				<c:if test="${i!=requestScope.page.thisPage }">
					<a href="${pageContext.request.contextPath }/CustPageServlet?thisPage=${i}">${i }</a>
				</c:if>
			</c:forEach>
			
			<!-- paging ends  -->
			<a href="${pageContext.request.contextPath }/CustPageServlet?thisPage=${requestScope.page.nextPage}">Next</a>
			<a href="${pageContext.request.contextPath }/CustPageServlet?thisPage=${requestScope.page.lastPage}">Last</a>	
			&nbsp go to<input type="text" value="${requestScope.page.thisPage }" style="width: 20px" onchange="changePage(this)"/>page
	</div>
	<input type="submit" value="delete chosen" />
</body>
</html>
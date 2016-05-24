<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<base href="${pageContext.request.contextPath}/" />
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>签到时间</th>
			</tr>
			<c:forEach items="${records}" var="r">
			<tr>
				<td><c:out value="${r.stdId}" /> </td>
				<td><c:out value="${r.username}" /> </td>
				<td>${r.attenTime}</td>
			</tr>
			</c:forEach>
			<tr>应到<c:out value="${total }" />人，实到<c:out value="${atten }" />人，缺席<c:out value="${quexi }" />人</tr>
		</tbody>
	</table>



</body>
</html>
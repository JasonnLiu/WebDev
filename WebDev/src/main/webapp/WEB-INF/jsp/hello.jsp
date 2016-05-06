<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<base href="${request.contextPath}" />
</head>
<body>
	用户 : ${user } addr :  ${addr }
	<form action="test">
		<input type="text" name="addr2" value="${addr }"  /> <input
			type="submit"  />
	</form>

</body>
</html>
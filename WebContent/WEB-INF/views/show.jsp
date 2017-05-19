<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<sf:form method="post" commandName="userInfo">
姓名: <sf:input path="userName" />
		<br />
性别: <sf:input path="userSex" />
		<br />
生日: <sf:input path="birthday" />
		<br />
	</sf:form>
</body>
</html>
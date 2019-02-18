<%--
  Created by IntelliJ IDEA.
  User: hoangnhb
  Date: 18/02/2019
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form"	uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Uploading File</title>
</head>
<body>
<h2>File Upload</h2>
<form:form modelAttribute="file" action="/upload" method="post" enctype="multipart/form-data">
    <form:input type="file" path="file"/><br/>
    <button	type="submit">Upload</button>
</form:form>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <tr>
        <td>${one.name}</td>
        <td>${one.serialNumber}</td>
        <td>${one.date}</td>
    </tr>
    <form action="/delete" method="post">
        <input type="hidden" name="serialNumber" value="${serialNumber}">
        <button type="submit">삭제</button>
    </form>
    <form action="/update" method="post">
        <button type="submit">수정</button>
    </form>
</body>
</html>

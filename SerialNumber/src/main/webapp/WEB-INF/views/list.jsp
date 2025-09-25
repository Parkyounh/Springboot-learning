<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/new" method="post">
            <h2>새로 만들기</h2>
            <input type="text" name="name"/>
            <button type="submit">확인</button>
    </form>
    <br>

    <c:forEach var="list" items="${list}">
        <tr>
            <td><a href="/detail/${list.serialNumber}">${list.serialNumber}</a></td>
            <td>${list.name}</td>
            <td><fmt:formatDate value="${list.date}" pattern="yyyy-MM-dd"/></td>
            <br>
        </tr>
    </c:forEach>
</body>

</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="">Add Cate</a></button>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Cate Code</th>
        <th>Cate name</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lists}" var="cate" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
            <td>
                <a href="/category/delete?id2=${cate.id1}">Delete</a>
                <a href="/category/detail?a=${cate.id1}">Detail</a>
                <a href="/category/view-update?id=${cate.id1}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

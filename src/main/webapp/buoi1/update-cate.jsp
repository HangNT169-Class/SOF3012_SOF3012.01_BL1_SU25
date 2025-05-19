<%-- Created by IntelliJ IDEA. User: hangnt Date: 22/01/2023 Time: 12:58 To
change this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="/category/update?a1=${b.id1}" method="post">
      Cate code: <input type="text" name="categoryCode"
                        value="${b.categoryCode}"/>
      <br />
      Cate name: <input type="text" name="categoryName"
                        value="${b.categoryName}" />
      <br />
      <button type="submit">Update</button>
    </form>
  </body>
</html>

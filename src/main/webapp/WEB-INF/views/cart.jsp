<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-05
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="cartItem" items="${cart.cartItems}">
        <tr>
            <td>${cartItem}</td>
        </tr>
    </c:forEach>
</table>
<br><br>
W koszyku jest ${cartItemsCount} pozycji.<br>
W koszyku jest ${productCount} produktów.<br>
Wartość koszyka to: ${sum}
</body>
</html>

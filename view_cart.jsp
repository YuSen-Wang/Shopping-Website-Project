<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<div>
<div style="float:left">
<ul>
	<li><a href="BookForm.html">Books</a></li>
	<li><a href="CdForm.html">Music</a></li>
	<li><a href="LapTopForm.html">Computers</a></li>
</ul>
</div>
<div style = "float:left">

    <b>Items Currently in Your Cart</b> <br/>
	<c:forEach var="tempItem" items="${item_list}">
	<c:url var="deleteLink" value="CartServlet">
		<c:param name="command" value="DELETE" />
		<c:param name="cartId" value="${tempItem.name}" />
	</c:url>
	   ${tempItem.name} $${tempItem.price} <a href="${deleteLink}">Remove</a> <br/>
	</c:forEach>
	
    <c> Total      $${total_price}
    </c>
    
 </div>   
</body>
</html>
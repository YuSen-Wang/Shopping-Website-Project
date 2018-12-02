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

    The following items has been added to your shopping cart successfully<br/>
	<c:forEach var="tempItem" items="${item_list}">
	   ${tempItem}<br/>
	</c:forEach>
  </div>
 </div>
</body>
</html>
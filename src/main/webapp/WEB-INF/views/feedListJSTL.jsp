<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
  <h2>Feed List (JSTL Implementation)</h2>
  <c:forEach var="feed" items="${feeds}">
    <div>
      <h3>${feed.title}</h3>
      <p>${feed.description}</p>
      <p><small>${feed.date}</small></p>
    </div>
  </c:forEach>
</body>
</html>

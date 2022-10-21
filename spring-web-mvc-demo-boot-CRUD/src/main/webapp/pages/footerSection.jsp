<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<footer
	class="container-fluid p-2 bg-dark text-light text-center fixed-bottom">
	<c:forEach var="link" items="${links }">
		<a class="btn btn-sm m-2" href="${link.key }">${link.value }</a>
	</c:forEach>
</footer>
</body>
</html>
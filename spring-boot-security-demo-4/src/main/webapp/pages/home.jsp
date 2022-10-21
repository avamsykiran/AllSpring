<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<base href="/" />
</head>
<body>
	<h2>Welcome Home</h2>
	<nav>
		<c:choose>
		<c:when test="${unm ne null}">
			<a href="admin/dashboard">Dashboard</a><span>|</span>
			<strong>${unm }</strong><span>|</span>
			<a href="logout">Log out</a>
			
		</c:when>
		<c:otherwise>
			<a href="login">Log In</a>
		</c:otherwise>
		</c:choose>
	</nav>
</body>
</html>

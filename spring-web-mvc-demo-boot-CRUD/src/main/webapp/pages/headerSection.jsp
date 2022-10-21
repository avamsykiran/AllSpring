<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>${appTitle }</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar nav-dark bg-dark navbar-expand-sm">

		<a href="#" class="navbar-brand">${appTitle }</a>

		<ul class="nav navbar-nav">
			<c:forEach var="link" items="${links}">
				<li class="nav-item">
					<a class="nav-link" href="${link.key }">${link.value }</a>
				</li>
			</c:forEach>
		</ul>
	</nav>

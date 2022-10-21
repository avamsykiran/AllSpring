<%@page import="java.time.LocalDate"%>
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="resources/site.css" />
</head>
<body>
	<header>
		<h3 style="text-align: right">
			<%=LocalDate.now()%>
		</h3>
		<h1 style="border-bottom: 1px solid black">My First Spring Web
			MVC Application</h1>
	</header>
	<nav>
		<a href="home">Home</a>
		<a href="greet">Greet</a>
		<a href="loan">Loan</a>
		<a href="emp">Employee</a>
	</nav>
<%@page import="java.time.LocalDate"%>
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<header>
		<h3 style="text-align: right">
			<%=LocalDate.now()%>
		</h3>
		<h1 style="border-bottom: 1px solid black">SpringBootWeb</h1>
	</header>
	<nav>
		<a href="home">Home</a>
		<a href="hello">Hello Page</a>
		<a href="arth">Arithmetic Page</a>
		<a href="greet">Greet</a>
		<a href="emp">Employee</a>
		<a href="tasks">TaskList</a>
	</nav>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<div class="jumbotron">
	<h1>
		${appTitle } <small>..a simple crud example..</small>
	</h1>
</div>

<c:if test="${msg ne null }">
	<p class="alert alert-info p-2">
		<strong>${msg }</strong>
	</p>
</c:if>

<jsp:include page="/footer" />
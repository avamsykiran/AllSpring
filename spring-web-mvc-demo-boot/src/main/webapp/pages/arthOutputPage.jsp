<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<jsp:include page="/header" />
<section style="padding: 10px; min-height: 400px;">
	<c:if test="${arth ne null }">
		<table>
			<tr><th>Operand1</th><td>${arth.operand1 }</td></tr>
			<tr><th>Operand2</th><td>${arth.operand2 }</td></tr>
			<c:forEach var="res" items="${arth.results }">
				<tr><th>${res.key }</th><td>${res.value }</td></tr>
			</c:forEach>
		</table>
	</c:if>
</section>
<jsp:include page="/footer" />

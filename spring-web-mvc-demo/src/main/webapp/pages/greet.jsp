<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<jsp:include page="/header" />
<section style="padding: 10px; min-height: 400px;">
	<h2>Greet </h2>
	
	<form>
		<label>Name: <input type="text" name="unm" required/></label>
		<button>Greet Me</button>
	</form>
	
	<c:if test="${greetings ne null }">
		<p><strong>${greetings }</strong>
	</c:if>
	
</section>
<jsp:include page="/footer" />

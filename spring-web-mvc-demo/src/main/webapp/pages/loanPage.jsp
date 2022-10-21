<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<jsp:include page="/header" />
<section style="padding: 10px; min-height: 400px;">
	<h2>Loan Page </h2>
	
	<form method="POST">
		<label>Principal: <input type="decimal" name="principal" required/></label>
		<label>Time: <input type="number" name="time" required/></label>
		<label>Rate: <input type="decimal" name="rate" required/></label>
		<button>Compute Interest</button>
	</form>
	
	<c:if test="${loan ne null }">
		<p>
			The interest on <strong>INR. ${loan.principal }</strong> 
			@ <strong>${loan.rate } pa </strong> 
			for a period of <strong>${loan.time } years</strong> 
			is <strong><u>${loan.interest }</u></strong> .
		</p>
	</c:if>
	
</section>
<jsp:include page="/footer" />

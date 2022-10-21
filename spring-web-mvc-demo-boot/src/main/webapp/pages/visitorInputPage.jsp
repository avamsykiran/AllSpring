
<jsp:include page="/header" />
<section style="padding: 10px; min-height: 400px;">

	<h3>Visitor Registration</h3>
	<form method="post">
		<label>Name: 
			<input type="text" name="firstName" placeholder="first name" required/>
			<input type="text" name="lastName" placeholder="last name" requried/>
		</label>
		<br />
		<label>Date Of Birth:
			<input type="date" name="dateOfBirth" required />
		</label>
		<br />
		<button>REGISTER</button>
	</form>

</section>
<jsp:include page="/footer" />

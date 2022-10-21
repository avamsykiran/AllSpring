<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/header" />

<section class="container-fluid p-4">

	<div class="row">
		<div class="col-sm-6">
			<form:form class="form" method="POST" modelAttribute="emp">

				<form:hidden path="empId" />

				<%-- <div class="form-group">
					<form:errors></form:errors>
				</div> --%>

				<div class="form-group">
					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName" class="form-control" />
					<form:errors path="firstName"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName" class="form-control" />
					<form:errors path="lastName"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="basic">Basic</form:label>
					<form:input path="basic" type="decimal" class="form-control" />
					<form:errors path="basic"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="joinDate">Join Date</form:label>
					<form:input path="joinDate" type="date" class="form-control" />
					<form:errors path="joinDate"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="mobileNumber">Mobile Number</form:label>
					<form:input path="mobileNumber" class="form-control" />
					<form:errors path="mobileNumber"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="email">Mail Id</form:label>
					<form:input path="email" type="email" class="form-control" />
					<form:errors path="email"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="dept">Department</form:label>
					<form:select path="dept" class="form-control">
						<form:option value="">---SELECT---</form:option>
						<form:options items="${depts }"/>
					</form:select>
				</div>
				<div class="form-group">
					<button class="btn btn-primary form-control mb-4">SAVE</button>
				</div>
			</form:form>
		</div>
	</div>

</section>
<jsp:include page="/footer" />
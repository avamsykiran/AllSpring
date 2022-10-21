<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="/header" />
<div class="container-fluid p-4">

	<h3>Employees List</h3>

	<c:choose>
		<c:when test="${emps eq null}">
			<p class="alert alert-warning">
				Sorry! Data could not be fetched!  Or No Records Found!
			</p>
		</c:when>
		<c:when test="${emps.size()==0}">
			<p class="alert alert-info">
				<strong>0</strong> Records Found!
			</p>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered table-striped table-hovered">
				<thead>
					<tr>
						<th>Employee#</th>
						<th>Full Name</th>
						<th>Mobile</th>
						<th>Mail</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${emps }">
						<tr>
							<td class="text-right">${e.empId }</td>
							<td>${e.firstName } ${e.lastName }</td>
							<td>${e.mobileNumber }</td>
							<td>${e.email }</td>
							<td>
								<a href="details" class="btn btn-sm btn-info">View Details</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</div>
<jsp:include page="/footer" />
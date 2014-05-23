<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp" />

<h1>${title}</h1>

<table class="table table-hover">
    <thead>
        <tr>
            <td>ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Salary</td>
            <td>Birthday</td>
            <td>Location</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>1</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.salary}</td>
                <td>${employee.birthday}</td>
                <td>${employee.address.city} / ${employee.address.state}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<jsp:include page="../footer.jsp" />
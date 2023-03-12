<html>
<body>
<h2></h2>
<div>
    <table>
        <tr>
            <td>User Id</td>
            <td>User Name</td>
            <td>User Surname</td>
            <td>Email</td>
            <td>User role</td>
            <td>Created at</td>
            <td>Modified at</td>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
                <td>${user.userRole}</td>
                <td>${user.createdAt}</td>
                <td>${user.modifiedAt}</td>
                <td><button>Edit</button></td>
                <td><button>Delete</button></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

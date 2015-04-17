<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Member Create Form</title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
<div id="wrapper">


    <table id="userTable" class="table table-hover">
        <tr>
            <th>#</th>
            <th>郵便番号</th>
            <th>住所</th>
            <c:if test="${not empty backwardPath}">
                <th>操作</th>
            </c:if>
        </tr>
        <c:forEach var="address" items="${addresses}" varStatus="rowStatus">
            <tr>
                <td>${f:h(rowStatus.count)}</td>
                <td>${f:h(address.zipCode)}</td>
                <td>${f:h(address.address)}</td>
                <c:if test="${not empty backwardPath}">
                    <td>
                        <c:url var="selectUrl" value="${backwardPath}"/>
                        <form:form action="${selectUrl}">
                            <input type="hidden" name="zipCode" value="${address.zipCode}">
                            <input type="hidden" name="address" value="${address.address}">
                            <button name="select" class="btn btn-default">選択</button>
                        </form:form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>

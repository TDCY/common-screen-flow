<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Street Address Search Result</title>
    <jsp:include page="/WEB-INF/views/common/inc/links.jsp"/>
</head>
<body>
<div id="wrapper">
    <table id="userTable" class="table table-hover">
        <tr>
            <th>#</th>
            <th>Zip Code</th>
            <th>Address</th>
            <c:if test="${not empty commonScreenFlowPaths.flowFinishPath}">
                <th>Operation</th>
            </c:if>
        </tr>
        <c:forEach var="address" items="${page.content}" varStatus="rowStatus">
            <tr>
                <td>${f:h(rowStatus.count)}</td>
                <td>${f:h(address.zipCode)}</td>
                <td>${f:h(address.address)}</td>
                <c:if test="${not empty commonScreenFlowPaths.flowFinishPath}">
                    <td>
                        <c:url var="selectPath" value="${commonScreenFlowPaths.flowFinishPath}"/>
                        <form:form action="${selectPath}" method="post">
                            <input type="hidden" name="zipCode" value="${f:h(address.zipCode)}">
                            <input type="hidden" name="address" value="${f:h(address.address)}">
                            <button class="btn btn-primary">Select</button>
                        </form:form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <div class="paginationArea">
        <t:pagination page="${page}"
                      criteriaQuery="${f:query(streetAddressSearchForm)}&${f:query(commonScreenFlowPaths)}"
                      outerElementClass="pagination"/>
    </div>
    <c:url value="/commonFlow/streetAddresses" var="redoPath"/>
    <form:form action="${redoPath}" method="get" modelAttribute="streetAddressSearchForm">
        <form:hidden path="zipCode" />
        <form:hidden path="address" />
        <button name="searchRedo" class="btn btn-primary">Change Criteria</button>
    </form:form>
</div>
</body>
<jsp:include page="/WEB-INF/views/common/inc/scripts.jsp"/>
</html>

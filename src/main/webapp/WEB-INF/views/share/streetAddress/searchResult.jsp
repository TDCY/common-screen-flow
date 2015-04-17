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
            <th>Address(Kana)</th>
            <c:if test="${not empty sharedFlowPaths.flowFinishPath}">
                <th>Operation</th>
            </c:if>
        </tr>
        <c:forEach var="address" items="${page.content}" varStatus="rowStatus">
            <tr>
                <td>${(page.number * page.size) + rowStatus.count}</td>
                <td>${f:h(address.zipCode)}</td>
                <td>${f:h(address.address)}</td>
                <td>${f:h(address.addressKana)}</td>
                <c:if test="${not empty sharedFlowPaths.flowFinishPath}">
                    <td>
                        <c:url var="selectPath" value="${sharedFlowPaths.flowFinishPath}"/>
                        <form action="${selectPath}" method="post">
                            <c:set value="${address}" var="address" scope="request" />
                            <spring:nestedPath path="address">
                                <form:hidden path="zipCode"/>
                                <form:hidden path="address"/>
                            </spring:nestedPath>
                            <sec:csrfInput />
                            <button class="btn btn-primary">Select</button>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${1 < page.totalPages}">
        <div class="paginationArea">
            <t:pagination page="${page}"
                          criteriaQuery="${f:query(streetAddressSearchForm)}&${f:query(sharedFlowPaths)}"
                          outerElementClass="pagination"/>
            <div>
                <fmt:formatNumber value="${page.totalElements}"/> results
            </div>
            <div>
                <fmt:formatNumber value="${page.number + 1}"/> /
                <fmt:formatNumber value="${page.totalPages}"/> Pages
            </div>
        </div>
    </c:if>
    <c:url value="/share/streetAddresses" var="redoPath"/>
    <form:form action="${redoPath}" method="get" modelAttribute="streetAddressSearchForm">
        <form:hidden path="zipCode"/>
        <form:hidden path="address"/>
        <button name="searchRedo" class="btn btn-primary">Change Criteria</button>
    </form:form>
</div>
</body>
<jsp:include page="/WEB-INF/views/common/inc/scripts.jsp"/>
</html>

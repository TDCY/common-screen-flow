<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Street Address Search Result</title>
    <jsp:include page="/WEB-INF/views/common/inc/links.jsp"/>
</head>
<body>
<div id="wrapper">
    <h1>Street Address Search Result : <fmt:formatNumber value="${page.totalElements}"/> results ( <fmt:formatNumber value="${page.number + 1}"/> / <fmt:formatNumber value="${page.totalPages}"/> Pages )</h1>
    <c:if test="${1 < page.totalPages}">
        <div class="paginationArea">
            <t:pagination page="${page}"
                          criteriaQuery="${f:query(streetAddressSearchForm)}&${f:query(sharedFlowPaths)}"
                          outerElementClass="pagination"/>
        </div>
    </c:if>
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
                <td><fmt:formatNumber value="${(page.number * page.size) + rowStatus.count}"/></td>
                <td>${f:h(address.zipCode)}</td>
                <td>${f:h(address.address)}</td>
                <td>${f:h(address.addressKana)}</td>
                <c:if test="${not empty sharedFlowPaths.flowFinishPath}">
                    <td>
                        <c:url var="selectPath" value="${sharedFlowPaths.flowFinishPath}"/>
                        <c:set value="${address}" var="address" scope="request" />
                        <form:form action="${selectPath}" method="post" modelAttribute="address">
                            <form:hidden path="zipCode"/>
                            <form:hidden path="address"/>
                            <form:button class="btn btn-primary">Select</form:button>
                        </form:form>
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
        </div>
    </c:if>
    <c:url value="/share/streetAddresses" var="redoPath"/>
    <a href="<c:url value="/share/streetAddresses?searchRedo"/>&${f:h(f:query(streetAddressSearchForm))}&${f:h(f:query(sharedFlowPaths))}" class="btn btn-primary">Change Criteria</a>
</div>
</body>
<jsp:include page="/WEB-INF/views/common/inc/scripts.jsp"/>
</html>

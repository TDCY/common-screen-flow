<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Street Address Search</title>
    <jsp:include page="/WEB-INF/views/common/inc/links.jsp"/>
</head>
<body>
<div id="wrapper">
    <c:url value="/commonFlow/streetAddresses" var="searchPath"/>
    <form:form action="${searchPath}" method="get" cssClass="form-horizontal" modelAttribute="streetAddressSearchForm">
        <div class="form-group">
            <form:label path="zipCode" cssClass="col-sm-3 control-label required">Zip Code</form:label>
            <div class="col-sm-2">
                <form:input cssClass="form-control" path="zipCode"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="address" cssClass="col-sm-3 control-label required">Address</form:label>
            <div class="col-sm-4">
                <form:input cssClass="form-control" path="address"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="address"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-8">
                <form:button class="btn btn-primary">Search</form:button>
                <form:button class="btn btn-primary" name="searchForm">Clear</form:button>
            </div>
        </div>
    </form:form>

    <a href="<c:url value="${commonScreenFlowPaths.flowCancelPath}"/>">Cancel</a>

</div>
</body>
<jsp:include page="/WEB-INF/views/common/inc/scripts.jsp"/>
</html>

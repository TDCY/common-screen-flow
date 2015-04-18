<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Member Creation</title>
    <jsp:include page="/WEB-INF/views/common/inc/links.jsp"/>
</head>
<body>
<div id="wrapper">
    <h1>Member Creation</h1>
    <c:url value="/members" var="createPath"/>
    <form:form action="${createPath}" cssClass="form-horizontal" modelAttribute="memberForm">
        <div class="form-group">
            <form:label path="id" cssClass="col-sm-3 control-label">Member ID</form:label>
            <div class="col-sm-4">
                <form:input cssClass="form-control" path="id"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="id"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="name" cssClass="col-sm-3 control-label">Personal Name</form:label>
            <div class="col-sm-4">
                <form:input cssClass="form-control" path="name"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="name"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="mainZipCode" cssClass="col-sm-3 control-label">Zip Code</form:label>
            <div class="col-sm-2">
                <form:input cssClass="form-control" path="mainZipCode"/>
            </div>
            <div class="col-sm-2">
                <form:button name="addressSearch" value="mainAddressOnCreation" class="btn btn-primary">Address Search</form:button>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="mainZipCode"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="mainAddress" cssClass="col-sm-3 control-label">Address</form:label>
            <div class="col-sm-4">
                <form:input cssClass="form-control" path="mainAddress"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="mainAddress"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="subZipCode" cssClass="col-sm-3 control-label">Sub Zip Code</form:label>
            <div class="col-sm-2">
                <form:input cssClass="form-control" path="subZipCode"/>
            </div>
            <div class="col-sm-2">
                <form:button name="addressSearch" value="subAddressOnCreation" class="btn btn-primary">Address Search</form:button>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="subZipCode"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="subAddress" cssClass="col-sm-3 control-label">Sub Address</form:label>
            <div class="col-sm-4">
                <form:input cssClass="form-control" path="subAddress"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="subAddress"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-8">
                <form:button class="btn btn-primary" name="createConfirm">Confirm</form:button>
                <a href="${createPath}?clearCreateForm" class="btn btn-primary">Clear</a>
            </div>
        </div>
    </form:form>

    <a href="<c:url value="/members?cancel" />">Cancel</a>

</div>
</body>
<jsp:include page="/WEB-INF/views/common/inc/scripts.jsp"/>
</html>

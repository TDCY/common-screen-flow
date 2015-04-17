<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Member Creation Confirm</title>
    <jsp:include page="/WEB-INF/views/common/inc/links.jsp"/>
</head>
<body>
<div id="wrapper">
    <c:url value="/members" var="createPath"/>
    <form:form action="${createPath}" cssClass="form-horizontal" modelAttribute="memberForm">
        <div class="form-group">
            <form:label path="id" cssClass="col-sm-3 control-label">Member ID</form:label>
            <div class="col-sm-4">
                <span class="form-control">${f:h(memberForm.id)}</span>
                <form:hidden path="id"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="name" cssClass="col-sm-3 control-label">Personal Name</form:label>
            <div class="col-sm-4">
                <span class="form-control">${f:h(memberForm.name)}</span>
                <form:hidden path="name"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="mainZipCode" cssClass="col-sm-3 control-label">Zip Code</form:label>
            <div class="col-sm-2">
                <span class="form-control">${f:h(memberForm.mainZipCode)}</span>
                <form:hidden path="mainZipCode"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="mainAddress" cssClass="col-sm-3 control-label">Address</form:label>
            <div class="col-sm-4">
                <span class="form-control"> ${f:h(memberForm.mainAddress)}</span>
                <form:hidden path="mainAddress"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="subZipCode" cssClass="col-sm-3 control-label">Sub Zip Code</form:label>
            <div class="col-sm-2">
                <span class="form-control">${f:h(memberForm.subZipCode)}</span>
                <form:hidden path="subZipCode"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="subAddress" cssClass="col-sm-3 control-label">Sub Address</form:label>
            <div class="col-sm-4">
                <span class="form-control">${f:h(memberForm.subAddress)}</span>
                <form:hidden path="subAddress"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-8">
                <form:button type="button"
                             onclick="alert('Under Construction ...');"
                             class="btn btn-primary">Create</form:button>
                <form:button class="btn btn-primary" name="createRedo">Redo Input</form:button>
            </div>
        </div>
    </form:form>
</div>
</body>
<jsp:include page="/WEB-INF/views/common/inc/scripts.jsp"/>
</html>

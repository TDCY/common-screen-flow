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

    <c:url value="/member" var="creatingUrl"/>
    <form:form action="${creatingUrl}" cssClass="form-horizontal" modelAttribute="memberForm">
        <div class="form-group">
            <form:label path="id" cssClass="col-sm-3 control-label required">会員ID</form:label>
            <div class="col-sm-4">
                <form:input cssClass="form-control" path="id" readonly="true"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="id"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="name" cssClass="col-sm-3 control-label required">氏名</form:label>
            <div class="col-sm-4">
                <form:input cssClass="form-control" path="name" readonly="true"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="name"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="zipCode" cssClass="col-sm-3 control-label required">郵便番号</form:label>
            <div class="col-sm-2">
                <form:input cssClass="form-control" path="zipCode" readonly="true"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="zipCode"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="address" cssClass="col-sm-3 control-label required">住所</form:label>
            <div class="col-sm-4">
                <form:input cssClass="form-control" path="address" readonly="true"/>
            </div>
            <div class="col-sm-4">
                <form:errors cssClass="control-label" path="address"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-8">
                <form:button class="btn btn-default">
                    <span class="glyphicon glyphicon-ok"></span> 登録</form:button>
                <form:button class="btn btn-default" name="createRedo">
                    <span class="glyphicon glyphicon-ok"></span> 戻る</form:button>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>

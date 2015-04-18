<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Resource Not Found Error!</title>
    <jsp:include page="/WEB-INF/views/common/inc/links.jsp"/>
</head>
<body>
    <div id="wrapper">
        <h1>Resource Not Found Error!</h1>
        <div class="error">
            <c:if test="${!empty exceptionCode}">[${f:h(exceptionCode)}]</c:if>
            <spring:message code="e.xx.fw.5001" />
        </div>
        <t:messagesPanel />
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    </div>
</body>
<jsp:include page="/WEB-INF/views/common/inc/scripts.jsp"/>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Attack Error!</title>
    <jsp:include page="/WEB-INF/views/common/inc/links.jsp"/>
</head>
<body>
    <div id="wrapper">
        <h1>Attack Error!</h1>
        <div class="error">
            <c:if test="${!empty exceptionCode}">[${f:h(exceptionCode)}]</c:if>
            <spring:message code="e.xx.fw.7005" />
        </div>
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
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <jsp:include page="/WEB-INF/views/common/inc/links.jsp"/>
</head>
<body>
<div id="wrapper">
    <h1>Hello world!</h1>
    <p>The time on the server is ${serverTime}.</p>
    <ul>
        <li><a href="<c:url value="/members?clearCreateForm"/>">Member Registration</a></li>
        <li><a href="<c:url value="/commonFlow/streetAddresses?searchForm&flowCancelPath=/"/>">Street Address Search</a></li>
    </ul>
</div>
</body>
<jsp:include page="/WEB-INF/views/common/inc/scripts.jsp"/>
</html>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
<div id="wrapper">
    <h1>Hello world!</h1>

    <p>The time on the server is ${serverTime}.</p>

    <a href="<c:url value="/member?createForm"/>">会員登録</a>
    <a href="<c:url value="/member?createForm"/>">会員変更</a>
</div>
</body>
</html>

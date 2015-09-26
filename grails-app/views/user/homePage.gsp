<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="themeMain"/>
    <title></title>
</head>

<body>
<h3>
    <sec:ifLoggedIn>
        Logged in as <sec:username/>
    </sec:ifLoggedIn>
</h3>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="themeMain"/>
    <title>My Profile</title>
</head>

<body>
<div id="h2tab2" class="col-lg-8">
    <h4 class="space-top">Profile</h4>
    <hr>
    <dl class="dl-horizontal">
        <dt>Name</dt>
        <dd>${currentUser.name}</dd>
        <dt>Username</dt>
        <dd>${currentUser.username}</dd>
        <dt>Phone</dt>
        <dd>${currentUser.mobileNumber}</dd>
    </dl>
    <hr>
</div>

</body>
</html>
<html>
<head>
    <meta name="layout" content="login"/>
    <title><g:message code="springSecurity.login.title"/></title>
</head>

<body>

<div data-effect-delay="300" data-animation-effect="fadeInDownSmall"
     class="object-non-visible animated object-visible fadeInDownSmall">
    <div class="form-block center-block">
        <h2 class="title">Login
        </h2>
        <hr>
        <g:if test='${flash.message}'>
            <div class='login_message'>${flash.message}</div>
        </g:if>
        <form class="form-horizontal" action='${postUrl}' method='POST' autocomplete='off'>
            <div class="form-group has-feedback">
                <label class="col-sm-3 control-label" for="inputUserName">User Name</label>
                <div class="col-sm-8">
                    <input type="text" name="j_username" required="" placeholder="User Name"
                           id="inputUserName" class="form-control">
                    <i class="fa fa-user form-control-feedback"></i>
                </div>
            </div>
            <div class="form-group has-feedback">
                <label class="col-sm-3 control-label" for="inputPassword">Password</label>
                <div class="col-sm-8">
                    <input type="password" required="" placeholder="Password" name='j_password'
                           id="inputPassword" class="form-control">
                    <i class="fa fa-lock form-control-feedback"></i>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-8">
                    <div class="checkbox">
                        <label>
                            <input name='${rememberMeParameter}' type="checkbox"
                                   <g:if test='${hasCookie}'>checked='checked'</g:if>> Remember me.
                        </label>
                    </div>
                    <button class="btn btn-group btn-default btn-sm" type="submit">Log In</button>
                </di v>
            </div>
        </form>
    </div>

    <p class="text-center space-top">Don't have an account yet?
        <g:link controller="public" action="signUp">Sign up</g:link> now.</p>
</div>
<script type='text/javascript'>
    (function () {
        document.forms['loginForm'].elements['j_username'].focus();
    })();
</script>
</body>
</html>

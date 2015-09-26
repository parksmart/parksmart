<html>
<head>
    %{--<meta name='layout' content='themeMain'/>--}%
    <title><g:message code="springSecurity.login.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">



    <asset:javascript src="applicationThemeManifest.js"/>
    <asset:stylesheet href="applicationThemeManifest.css"/>

    <meta charset="utf-8">
    <title>iDea | Home 2</title>
    <meta name="description" content="iDea a Bootstrap-based, Responsive HTML5 Template">
    <meta name="author" content="htmlcoder.me">

    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link rel="shortcut icon" href="images/favicon.ico">

    <!-- Web Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,400,700,300&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=PT+Serif' rel='stylesheet' type='text/css'>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body class="wide">
<div class="fullscreen-bg"></div>
<div class="page-wrapper">

    <!-- main-container start -->
    <!-- ================ -->
    <section class="main-container light-translucent-bg">

        <div class="container">
            <div class="row">

                <!-- main start -->
                <!-- ================ -->
                <div class="main col-md-8 col-md-offset-2">

                    <!-- logo -->
                    <div class="logo">
                        <a href="index.html">
                            <asset:image src="theme/images/logo_red.png" id="logo" alt=""/>
                        </a>
                    </div>

                    <!-- name-and-slogan -->
                    <div class="site-slogan">
                        Clean &amp; Powerful Bootstrap Theme
                    </div>

                    <div data-effect-delay="300" data-animation-effect="fadeInDownSmall" class="object-non-visible animated object-visible fadeInDownSmall">
                        <div class="form-block center-block">
                            <h2 class="title">Login</h2>
                            <hr>
                            <g:if test='${flash.message}'>
                                <div class='login_message'>${flash.message}</div>
                            </g:if>
                            <form class="form-horizontal" action='${postUrl}' method='POST' autocomplete='off'>
                                <div class="form-group has-feedback">
                                    <label class="col-sm-3 control-label" for="inputUserName">User Name</label>
                                    <div class="col-sm-8">
                                        <input type="text"  name="j_username" required="" placeholder="User Name"
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
                                                <input name='${rememberMeParameter}' type="checkbox" <g:if test='${hasCookie}'>checked='checked'</g:if> > Remember me.
                                            </label>
                                        </div>
                                        <button class="btn btn-group btn-default btn-sm" type="submit">Log In</button>
                                        <ul>
                                            <li><a href="#">Forgot your password?</a></li>
                                        </ul>
                                        <span class="text-center text-muted">Login with</span>
                                        <ul class="social-links colored circle clearfix">
                                            <li class="facebook"><a href="http://www.facebook.com" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <p class="text-center space-top">Don't have an account yet? <a href="page-signup-2.html">Sign up</a> now.</p>
                    </div>

                </div>
                <!-- main end -->

            </div>
        </div>

    </section>
    <!-- main-container end -->

</div>
<script type='text/javascript'>
    (function() {
        document.forms['loginForm'].elements['j_username'].focus();
    })();
</script>
</body>
</html>

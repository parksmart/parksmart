<html>
<head>
    %{--<meta name='layout' content='themeMain'/>--}%
    <title>Park Smart | <g:layoutTitle/> </title>

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

                    <div style="display: inline-flex;cursor: pointer;padding-left:300px" onclick="gotoUrl('${createLink(controller: 'public', action: 'home')}');" >
                        <h2>Park</h2><h2 style="color: red;font-weight: bold;">Smart</h2>
                    </div>

                    <!-- name-and-slogan -->
                    <div class="site-slogan">
                    Be smart because it matters..
                    </div>
<g:layoutBody/>

                </div>
                <!-- main end -->
        </div>

        </div>
    </section>

    <!-- main-container end -->

</div>

</body>
</html>

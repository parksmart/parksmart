<html>
<head>
    <meta name="layout" content="login"/>
    <title>Sign Up</title>
</head>

<body>
<div data-effect-delay="300" data-animation-effect="fadeInDownSmall" class="object-non-visible animated object-visible fadeInDownSmall">
    <div class="form-block center-block">
        <h2 class="title">Sign Up</h2>
        <hr>
        <div id="signUpErrorsDiv" role="alert" class="alert alert-danger alert-dismissible fade in"
             style="display: none">
            <p></p>
        </div>

        <div id="signUpSuccessMessageDiv" role="alert" class="alert alert-success alert-dismissible fade in"
             style="display: none">
            <p></p>
        </div>

        <form role="form" class="form-horizontal" id="signUpForm"
              data-submit-url="${createLink(controller: "register", action: "registerUser")}">
            <div class="form-group has-feedback">
                <label class="col-sm-3 control-label" for="name">Name<span class="text-danger small">*</span></label>
                <div class="col-sm-8">
                    <input type="text" required="" placeholder="Name" id="name" name="name" class="form-control">
                    <i class="fa fa-pencil form-control-feedback"></i>
                </div>
            </div>


            <div class="form-group has-feedback">
                <label class="col-sm-3 control-label" for="username">Email <span class="text-danger small">*</span></label>
                <div class="col-sm-8">
                    <input type="email" placeholder="Email" id="username" name="username" class="form-control">
                    <i class="fa fa-envelope form-control-feedback"></i>
                </div>
            </div>
            <div class="form-group has-feedback">
                <label class="col-sm-3 control-label" for="password">Password <span class="text-danger small">*</span></label>
                <div class="col-sm-8">
                    <input type="password" required="" placeholder="Password" id="password" name="password" class="form-control">
                    <i class="fa fa-lock form-control-feedback"></i>
                </div>
            </div>
            <div class="form-group has-feedback">
                <label class="col-sm-3 control-label" for="mobileNumber">Mobile Number<span class="text-danger small"></span></label>
                <div class="col-sm-8">
                    <input type="email" placeholder="Mobile Number" id="mobileNumber" name="mobileNumber" class="form-control">
                    <i class="fa fa-mobile-phone form-control-feedback"></i>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-8">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" required=""> Accept our <a href="#">privacy policy</a> and <a href="#">customer agreement</a>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-8">
                    <button class="btn btn-default" type="button"
                            onclick="submitRegistrationForm('signUpForm')">Sign Up</button>
                </div>
            </div>
        </form>
    </div>
</div>
<asset:javascript src="signUp.js"/>
</body>
</html>

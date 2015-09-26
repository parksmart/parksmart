<%@ page import="java.nio.file.Files" %>
<div class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2" style="margin-top: 50px;" id="signupbox">
    <div class="panel panel-info">
        <div class="panel-heading">
            <div class="panel-title">Sign Up</div>
        </div>

        <div class="panel-body">
            <form role="form" class="form-horizontal" id="signUpForm"
                  data-submit-url="${createLink(controller: "register", action: "registerUser")}">

                <div id="signUpErrorsDiv" role="alert" class="alert alert-danger alert-dismissible fade in"
                     style="display: none">
                    <button aria-label="Close" data-dismiss="alert" class="close" type="button">
                        <span aria-hidden="true">×</span></button>

                    <p></p>
                </div>

                <div id="signUpSuccessMessageDiv" role="alert" class="alert alert-success alert-dismissible fade in"
                     style="display: none">
                    <button aria-label="Close" data-dismiss="alert" class="close" type="button">
                        <span aria-hidden="true">×</span></button>

                    <p></p>
                </div>

                <div class="form-group" style="border-bottom: 1px solid #999; padding-bottom:10px">
                    <div class="col-md-offset-3 col-md-9">
                        <button class="btn btn-primary" type="button" id="btn-fbsignup"><i
                                class="icon-facebook"></i> &nbsp; Sign Up with Facebook</button>
                    </div>
                </div>

                <div style="text-align: center">
                    <div style="text-align: center">or</div>
                </div>


                <div class="form-group">
                    <label class="col-md-3 control-label" for="email">Email</label>

                    <div class="col-md-9">
                        <input type="text" placeholder="Email Address" name="username" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label" for="name">Name</label>

                    <div class="col-md-9">
                        <input type="text" placeholder="Name" name="name" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label" for="password">Password</label>

                    <div class="col-md-9">
                        <input type="password" placeholder="Password" name="password" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label" for="icode">Mobile</label>

                    <div class="col-md-9">
                        <input type="text" placeholder="Mobile Number" name="mobileNumber" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <!-- Button -->
                    <div class="col-md-offset-3 col-md-9">
                        <button class="btn btn-info" type="button" id="btn-signup"
                                onclick="submitRegistrationForm('signUpForm')">
                            <i class="icon-hand-right"></i> &nbsp; Sign Up
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
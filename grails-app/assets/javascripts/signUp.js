var submitRegistrationForm = function (formId) {
    var $form = $('#' + formId);
    jQuery.ajax({
        url: $form.data('submit-url'),
        type: "POST",
        data: $form.serialize(),
        success: function (response) {
            if (response.status != true) {
                var errorList = response.errors;
                var errorString = "";
                for (var index = 0; index < errorList.length; index++) {
                    errorString = errorString + errorList[index] + "</br>";
                }
                showErrorMessage(errorString);
            } else {
                window.location.href = "/login/auth";
            }
        }
    });
};

var showErrorMessage = function (message) {
    showMessage('signUpErrorsDiv', message)
};

var showSuccessMessage = function (message) {
    showMessage('signUpSuccessMessageDiv', message)

};

var showMessage = function (messageDivId, message) {
    var $div = $("#" + messageDivId);
    $div.find('p').html(message);
    $div.css('display', 'block');
    setInterval(function(){
        $div.fadeOut("slow");
    }, 5000);
};
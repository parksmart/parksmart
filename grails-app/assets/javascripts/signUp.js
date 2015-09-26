/**
 * Created by manish on 26/9/15.
 */
var submitRegistrationForm = function (formId) {
    console.log("clicked!!");
    var $form = $('#' + formId);
//    console.log("Dat: ", $form.data('submit-url'));
    jQuery.ajax({
        url: $form.data('submit-url'),
        type: "POST",
        data: $form.serialize(),
        success: function (response) {
            console.log("Response: ", response);
            if (response.status != true) {
                var errorList = response.errors;
                console.log("ErrorList: ", errorList);
                var errorString = "";
                for (var index = 0; index < errorList.length; index++) {
                    errorString = errorString + errorList[index] + "</br>";
                }
                showErrorMessage(errorString);
            } else {
                showSuccessMessage(response.message);
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
    $div.css('display', 'block')
};
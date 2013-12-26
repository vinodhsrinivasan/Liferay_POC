var consentTermsTab;

function detachRegistrationTabs() {
	consentTermsTab = $('registration-consent-terms').detach();
}



function showRegistrationFirstTab() {
	
	// activate the tab 1
	$('#registration-personal-info').toggleClass('tab-pane-hidden');
	$('#registration-personal-info-tab').toggleClass('inactive-tab').toggleClass('active-tab');
	$('#registration-personal-info-tab-top').toggleClass('top-inactive-tab').toggleClass('top-active-tab');
	// inactive tab 2
	$('#registration-consent-terms').toggleClass('tab-pane-hidden');
	$('#registration-consent-terms-tab').toggleClass('active-tab').toggleClass('inactive-tab');
	$('#registration-consent-terms-tab-top').toggleClass('top-active-tab').toggleClass('top-inactive-tab');
	//detach tab 2 and 3
	detachRegistrationTabs();
}

function continueToRegistrationSecondStep() {
	// validate the first tab
	var valid = $('#registerUserCardForm').valid();
	if (valid) {
		// hide the first tab
		$('#registration-personal-info').toggleClass('tab-pane-hidden');
		// show the second tab
		if (consentTermsTab) {
			consentTermsTab.appendTo("body");
			consentTermsTab = null;
			$('#registration-consent-terms').toggleClass('tab-pane-hidden');

			// activate the tab 2
			$('#registration-personal-info-tab').toggleClass('active-tab').toggleClass('inactive-tab');
			$('#registration-personal-info-tab-top').toggleClass('top-active-tab').toggleClass('top-inactive-tab');

			$('#registration-consent-terms-tab').toggleClass('inactive-tab').toggleClass('active-tab');
			$('#registration-consent-terms-tab-top').toggleClass('top-inactive-tab').toggleClass('top-active-tab');
		}
	}
}

function submitRegistration(url) {
	//var valid = $('#registerUserCardForm').valid();
	var valid = true;
	if (valid) {
		$('#registrationModal').modal('show');
		var formJSON = JSON.stringify($('#registerUserCardForm').serializeObject());
		// var serForm = $('#registerUserCardForm').serialize();
		// // Send the data using post
		var posting = $.ajax({ // ajax call starts
			headers : {
				"Content-Type" : "application/json",
				"Accept" : "text/html"
			},
			type : "POST",
			url : url,
			data : formJSON
		});
		// Put the results in a div
		posting.success(function(data) {
			if(isFormValidationErrors(data)){
				$("#registerUserCardForm-validation-errors").html(data);
				showRegistrationFirstTab();
			} else if (isInternalError(data)){ 
				$("#registerUserCardForm-validation-errors").html(data);
			}else {
				$("#card-user-registration-page-content").html(data);
			}
		}).error(function() {
			alert("error");
		}).always(function() {
			$('#registrationModal').modal('hide');
			;
		});
	}
}

// serialize the form to json format
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

function isFormValidationErrors(content){
	var validationErrorPath = "<div id=\"registerUserCardForm-validation-errors\">";
	var matchResult = content.match(validationErrorPath);
	if (validationErrorPath == matchResult) {
		return true;
	}
	return false;
};

function isInternalError(content){
	var validationErrorPath = "<div id=\"server-internal-error\" class=\"tab-content-container\">";
	var matchResult = content.match(validationErrorPath);
	if (validationErrorPath == matchResult) {
		return true;
	}
	return false;
};



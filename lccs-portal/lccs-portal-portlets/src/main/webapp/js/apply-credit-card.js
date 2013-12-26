var financialInfoTab;
var consentTermsTab;

function detachTabs() {
	financialInfoTab = $('financial-info').detach();
	consentTermsTab = $('consent-terms').detach();
}
function initDateOfBirthSelects() {

	var currentYear = new Date().getFullYear() - 18;
	var months = ["", "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" ];

	var daySelect = $('#day');
	var monthSelect = $('#month');
	var yearSelect = $('#year');

	// days
	for (var i = 1; i <= 31; i++) {
		daySelect.append($('<option>', {
			value : i
		}).text(i));
	}
	// Months
	for (var i = 1; i < months.length; i++) {
		monthSelect.append($('<option>', {
			value : i
		}).text(months[i]));
	}
	// years
	for (var i = currentYear; i >= 1900; i--) {
		yearSelect.append($('<option>', {
			value : i
		}).text(i));
	}
}

function updateDaySelectBasedOnYearAndMonth() {
	var daySelect = $('#day');
	var month = $('#month').val();// month value started with 0
	var year = $('#year').val();
	var day = daySelect.val();
	var dateMax = 31;
	if (month) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			dateMax = 30;
		} else if (month == 2) {
			dateMax = 29;
			if (year && (year % 4 != 0)) {
				dateMax = 28;
			}
		}
	}
	daySelect.find('option:not(:first)').remove();
	for (var i = 1; i <= dateMax; i++) {
		daySelect.append($('<option>', {
			value : i
		}).text(i));
	}
	daySelect.val(day);
}

function initStates() {
	var stateMap = {
		'AL' : 'Alabama',
		'AK' : 'Alaska',
		'AZ' : 'Arizona',
		'AR' : 'Arkansas',
		'CA' : 'California',
		'CO' : 'Colorado',
		'CT' : 'Connecticut',
		'DE' : 'Delaware',
		'DC' : 'District Of Columbia',
		'FL' : 'Florida',
		'GA' : 'Georgia',
		'HI' : 'Hawaii',
		'ID' : 'Idaho',
		'IL' : 'Illinois',
		'IN' : 'Indiana',
		'IA' : 'Iowa',
		'KS' : 'Kansas',
		'KY' : 'Kentucky',
		'LA' : 'Louisiana',
		'ME' : 'Maine',
		'MD' : 'Maryland',
		'MA' : 'Massachusetts',
		'MI' : 'Michigan',
		'MN' : 'Minnesota',
		'MS' : 'Mississippi',
		'MO' : 'Missouri',
		'MT' : 'Montana',
		'NE' : 'Nebraska',
		'NV' : 'Nevada',
		'NH' : 'New Hampshire',
		'NJ' : 'New Jersey',
		'NM' : 'New Mexico',
		'NY' : 'New York',
		'NC' : 'North Carolina',
		'ND' : 'North Dakota',
		'OH' : 'Ohio',
		'OK' : 'Oklahoma',
		'OR' : 'Oregon',
		'PA' : 'Pennsylvania',
		'RI' : 'Rhode Island',
		'SC' : 'South Carolina',
		'SD' : 'South Dakota',
		'TN' : 'Tennessee',
		'TX' : 'Texas',
		'UT' : 'Utah',
		'VT' : 'Vermont',
		'VA' : 'Virginia',
		'WA' : 'Washington',
		'WV' : 'West Virginia',
		'WI' : 'Wisconsin',
		'WY' : 'Wyoming'
	};

	var resStates = $('#resState');
	var previousState = $('#previousState');
	var mailingState = $('#mailingState');
	var issuingState = $('#issuingState');
	$.each(stateMap, function(key, val) {
		resStates.append($('<option>', {
			value : key
		}).text(val));
		previousState.append($('<option>', {
			value : key
		}).text(val));
		mailingState.append($('<option>', {
			value : key
		}).text(val));
		issuingState.append($('<option>', {
			value : key
		}).text(val));
	});
}

function showFirstTab() {
	
	// activate the tab 1
	$('#personal-info').toggleClass('tab-pane-hidden');
	$('#personal-info-tab').toggleClass('inactive-tab').toggleClass('active-tab');
	$('#personal-info-tab-top').toggleClass('top-inactive-tab').toggleClass('top-active-tab');
	// inactive tab 3
	$('#consent-terms').toggleClass('tab-pane-hidden');
	$('#consent-terms-tab').toggleClass('active-tab').toggleClass('inactive-tab');
	$('#consent-terms-tab-top').toggleClass('top-active-tab').toggleClass('top-inactive-tab');
	//detach tab 2 and 3
	detachTabs();
}

function continueToSecondStep() {
	//clean server errors if any
	$('#server-form-validation-errors').html('');
	// validate the first tab
	var valid = $('#applyCardForm').valid();
	if (valid) {
		// hide the first tab
		$('#personal-info').toggleClass('tab-pane-hidden');
		// show the second tab
		if (financialInfoTab) {
			financialInfoTab.appendTo("body");
			financialInfoTab = null;
			$('#financial-info').toggleClass('tab-pane-hidden');

			// activate the tab 2
			$('#personal-info-tab').toggleClass('active-tab').toggleClass(
					'inactive-tab');
			$('#personal-info-tab-top').toggleClass('top-active-tab')
					.toggleClass('top-inactive-tab');

			$('#financial-info-tab').toggleClass('inactive-tab').toggleClass(
					'active-tab');
			$('#financial-info-tab-top').toggleClass('top-inactive-tab')
					.toggleClass('top-active-tab');
		}
	}
}

function continueToThirdStep() {
	// validate the second tab
	var valid = $('#applyCardForm').valid();
	if (valid) {
		// hide the second tab
		$('#financial-info').toggleClass('tab-pane-hidden');
		// show the second tab
		if (consentTermsTab) {
			consentTermsTab.appendTo("body");
			consentTermsTab = null;
			$('#consent-terms').toggleClass('tab-pane-hidden');

			// activate the tab 3
			$('#financial-info-tab').toggleClass('active-tab').toggleClass(
					'inactive-tab');
			$('#financial-info-tab-top').toggleClass('top-active-tab')
					.toggleClass('top-inactive-tab');

			$('#consent-terms-tab').toggleClass('inactive-tab').toggleClass(
					'active-tab');
			$('#consent-terms-tab-top').toggleClass('top-inactive-tab')
					.toggleClass('top-active-tab');
		}
	}
}

function submitApplication(url) {
	var valid = $('#applyCardForm').valid();
	if (valid) {
		$('#myModal').modal('show');
		var formJSON = JSON.stringify($('#applyCardForm').serializeObject());
		// var serForm = $('#applyCardForm').serialize();
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
				$("#server-form-validation-errors").html(data);
				showFirstTab();
			} else if (isInternalError(data)){ 
				$("#server-form-validation-errors").html(data);
			}else {
				$("#apply-credit-card-page-content").html(data);
			}
		}).error(function() {
			alert("Internal Error....");
		}).always(function() {
			$('#myModal').modal('hide');
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
	var validationErrorPath = "<div id=\"server-bean-validation-errors-content\">";
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

//Onload function
$(function() {
	initDateOfBirthSelects();
	initStates();
	detachTabs();
	
	$('input[name=addressMoreOneYear]').bind("change", function() {
		var value = $(this).val();
		var $preInputs = $("#previous-residential-address").find(":input");
		if (value == 'Yes') {
			$preInputs.prop("disabled",true);
			$preInputs.removeClass("error");
		} else {
			$preInputs.prop("disabled",false);
		}
	});
	
	
	$('input[name=sameMailingAddress]').bind("change", function() {
		var value = $(this).val();
		var $mailingInputs = $("#mailing-address").find(":input");
		if (value == 'Yes') {
			$mailingInputs.prop("disabled",true);
			$mailingInputs.removeClass("error");
		} else {
			$mailingInputs.prop("disabled",false);
		}
	});
	
	$('input[name=residenceStatus]').bind("change", function() {
		var value = $(this).val();
		if (value == 'rent_other') {
			$('#monthlyPaymentBloc').show();
		} else {
			$('#monthlyPaymentBloc').hide();
		}
	});

	$("#month").bind("change", function() {
		updateDaySelectBasedOnYearAndMonth();
	});

	$("#year").bind("change", function() {
		updateDaySelectBasedOnYearAndMonth();
	});
	//disabled confirm email copy past
	$('#confirmEmailAddress').bind('cut copy paste', function(event) {
        event.preventDefault();
    });
	
	var zipCodeCheck = function(val,params){
		try{
			return (val.length ==5 || val.length ==9);
			}catch(e){return false;}
		};
	
	$.validator.addMethod("zipCodeCheck", function(val, element, params) {
        return this.optional(element) || zipCodeCheck(val,params);
	});
	//added rules to form
	$("#applyCardForm")
				.validate(
						{
							errorContainer: $('#form-validation-errors'),
							errorLabelContainer: $('ul', '#form-validation-errors'),
							wrapper: 'li',
							rules : {
								confirmEmailAddress : {
									equalTo : "#emailAddress"
								},
								phone1: {
									minlength:3,
									maxlength:3,
									digits:true	
								},
								phone2: {
									minlength:3,
									maxlength:3,
									digits:true	
								},
								phone3: {
									minlength:4,
									maxlength:4,
									digits:true	
								}
								,
								workPhone1: {
									required: false,
									minlength:3,
									maxlength:3,
									digits:true	
								},
								workPhone2: {
									required: false,
									minlength:3,
									maxlength:3,
									digits:true	
								},
								workPhone3: {
									required: false,
									minlength:4,
									maxlength:4,
									digits:true	
								},
								ssn1: {
									minlength:3,
									maxlength:3
								},
								ssn2: {
									minlength:2,
									maxlength:2
								},
								ssn3: {
									minlength:4,
									maxlength:4
								},
								annualIncome:{
									number: true
								},
								monthlyPayment:{
									number: true
								},
								zipCode:{
									number:true,
									zipCodeCheck:true,
								},
								previousZipCode:{
									number:true,
									zipCodeCheck:true,
								},
								mailingZipCode:{
									number:true,
									zipCodeCheck:true,
								}
							},
							messages : {
								confirmEmailAddress : "Please check Confirm Email Address.",
								phone1 :{
									minlength: "Home Phone Number first field must be 3 digits.",
									maxlength: "Home Phone Number first field must be 3 digits.",
									digits:"Home Phone Number must first field be 3 digits."
								},
								phone2 :{
									minlength: "Home Phone Number second field must be 3 digits.",
									maxlength: "Home Phone Number second field must be 3 digits.",
									digits:"Home Phone Number second field must be 3 digits."
								},
								phone3 :{
									minlength: "Home Phone Number third field must be 4 digits.",
									maxlength: "Home Phone Number third field must be 4 digits.",
									digits:"Home Phone Number third field must be 4 digits."
								},
								workPhone1 :{
									minlength: "Work Phone Number first field must be 3 digits.",
									maxlength: "Work Phone Number first field must be 3 digits.",
									digits:"Work Phone Number first field must be 3 digits."
								},
								workPhone2 :{
									minlength: "Work Phone Number second field must be 3 digits.",
									maxlength: "Work Phone Number second field must be 3 digits.",
									digits:"Work Phone Number second field must be 3 digits."
								},
								workPhone3 :{
									minlength: "Work Phone Number third field must be 4 digits.",
									maxlength: "Work Phone Number third field must be 4 digits.",
									digits:"Work Number third field must be 4 digits."
								},
								ssn1 :{
									minlength: "Social Security Number first field must be 3 characters.",
									maxlength: "Social Security Number first field must be 3 characters."
								},
								ssn2 :{
									minlength: "Social Security Number second field must be 2 characters.",
									maxlength: "Social Security Numbersecond field  must be 2 characters."
								},
								ssn3 :{
									minlength: "Social Security Number third field must be 4 characters.",
									maxlength: "Social Security Number third field must be 4 characters."
								},
								annualIncome:{
									number: "ANNUAL Gross Income from ALL sources must be a number."
								},
								monthlyPayment:{
									number: "Monthly payment must be a number."
								},
								zipCode :{
									number:"Residential Address Zip Code should be either 5 or 9 digits in length.",
									zipCodeCheck: "Residential Address Zip Code should be either 5 or 9 digits in length.",
								},
								previousZipCode :{
									number:"Previous Residential Address Zip Code should be either 5 or 9 digits in length.",
									zipCodeCheck: "Previous Residential Address Zip Code should be either 5 or 9 digits in length.",
								},
								mailingZipCode :{
									number:"Mailing Address Zip Code should be either 5 or 9 digits in length.",
									zipCodeCheck: "Mailing Address Zip Code should be either 5 or 9 digits in length.",
								}
							}
						});
});


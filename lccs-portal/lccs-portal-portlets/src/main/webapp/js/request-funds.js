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

var requestFundsSearchObj={
	init:function(url){
		//alert("hi");
		//added rules to form
		$("#requestFundsSearchForm").validate(
							{
								errorContainer: $('#form-validation-errors'),
								errorLabelContainer: $('ul', '#form-validation-errors'),
								wrapper: 'li',
								rules : {
									sacwisId: {
										minlength:5,
										maxlength:20,
									}
								},
								messages : {
									sacwisId :{
										minlength: "Sacwis ID must have minimum 5 characters",
										maxlength: "Sacwis ID can have maximum 20 characters.",
									}
								}
							});
		$("#requestFundsSearchFormSubmit").click(function(){
			/*var valid=$("#requestFundsSearchForm").valid();
			if(valid){
				requestFundsSearch.init();
			}else{
				return false;
			}*/
		});
		$("#requestFundsSearchForm").submit(function(){
			var valid=$("#requestFundsSearchForm").valid();
			if(valid){
			//alert('hi.....submit');
				$('#myModal').modal('show');
				var formJSON = JSON.stringify($('#requestFundsSearchForm').serializeObject());
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
					if(requestFundsCommonObj.isInternalError(data) || requestFundsCommonObj.isFormValidationErrors(data)){
						$("#server-form-validation-errors").html(data);
					}else {
						$("#lccs-request-for-funds-main-content").html(data);
						requestFundsCaseDetailsObj.init();
					}
				}).error(function() {
					alert("Internal Error....");
				}).always(function() {
					$('#myModal').modal('hide');
					;
				});
			}
			return false;
		});
	}
};

var requestFundsCaseDetailsObj={
		url:undefined,
		click:function(urlLink){
			requestFundsCaseDetailsObj.url=urlLink;
			//alert(requestFundsCaseDetailsObj.url);
		},
		init:function(){
			//alert("hi");
			//added rules to form
			$("#requestFundsCaseDetailsForm").validate(
								{
									errorContainer: $('#form-validation-errors'),
									errorLabelContainer: $('ul', '#form-validation-errors'),
									wrapper: 'li',
									rules : {
										personRespForPurchase: {
											minlength:5,
											maxlength:20,
										}
									},
									messages : {
										personRespForPurchase :{
											minlength: "Person(s) responsible for making purchase must have minimum 5 characters",
											maxlength: "Person(s) responsible for making purchase can have maximum 20 characters.",
										}
									}
								});
			$("#requestFundsCaseDetailsForm").submit(function(){
				var valid=$("#requestFundsCaseDetailsForm").valid();
				if(valid){
					//alert(requestFundsCaseDetailsObj.url);
				//alert('hi.....submit');
					$('#myModal').modal('show');
					var formJSON = JSON.stringify($('#requestFundsCaseDetailsForm').serializeObject());
					// var serForm = $('#applyCardForm').serialize();
					// // Send the data using post
					var posting = $.ajax({ // ajax call starts
						headers : {
							"Content-Type" : "application/json",
							"Accept" : "text/html"
						},
						type : "POST",
						url : requestFundsCaseDetailsObj.url,
						data : formJSON
					});
					// Put the results in a div
					posting.success(function(data) {
						$("#lccs-request-for-funds-main-content").html(data);
					}).error(function() {
						alert("Internal Error....");
					}).always(function() {
						$('#myModal').modal('hide');
						;
					});
				}
				return false;
			});
		}
	};

var requestFundsCommonObj={
		isInternalError:function(content) {
			var validationErrorPath = "<div id=\"server-internal-error\" class=\"tab-content-container\">";
			var matchResult = content.match(validationErrorPath);
			if (validationErrorPath == matchResult) {
				return true;
			}
			return false;
		},
		isFormValidationErrors:function(content) {
			var validationErrorPath = "<div id=\"server-validation-error\">";
			var matchResult = content.match(validationErrorPath);
			if (validationErrorPath == matchResult) {
				return true;
			}
			return false;
		}
};




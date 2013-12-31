var requestFundsSearch={
	init:function(){
		alert("hi");
	}
};
//Onload function
$(function() {
	$(document).keydown(function(e) { if (e.keyCode == 27) {return false;}//prevent escape resets the form.
	 if ($.browser.msie && e.keyCode === 13 && e.target.tagName != 'TEXTAREA') {return false;}});//prevent enter submits the form and alow textarea.
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
		var valid=$("#requestFundsSearchForm").valid();
		if(valid){
			requestFundsSearch.init();
		}else{
			return false;
		}
	});
	$("#requestFundsSearchForm").submit(function(){
		alert('hi.....submit');
		return false;
	});
});


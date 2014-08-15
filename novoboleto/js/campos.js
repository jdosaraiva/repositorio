$(":input[type='number']").on('keyup', function (e) { 
	if ($(this).val().length > $(this).attr('maxLength')) {
		$(this).val($(this).val().slice(0,-1));
		return false;
	}
});
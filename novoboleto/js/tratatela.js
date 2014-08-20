$(":input[type='number']").on('keyup', function (e) { 
	if ($(this).val().length >= $(this).attr('maxLength')) {
		//$(this).val($(this).val().slice(0,0));

		var next = '#'.concat($(this).attr('next'));
		
		$(next).focus();

		return false;
	}
});

$("#campo7").focusout(function() {
	var boleto = new Boleto();
	var strValor = String($('#campo7').val());
	var valor = 0;
	
	var linhaDigitavel = String($('#campo1').val())
							.concat(String($('#campo2').val()))
							.concat(String($('#campo3').val()))
							.concat(String($('#campo4').val()))
							.concat(String($('#campo5').val()))
							.concat(String($('#campo6').val()))
							.concat(String($('#campo7').val()));
	boleto.setLinhaDigitavel(linhaDigitavel);
	
	$('#dv1').val(boleto.calculaDigito());
	$('#vencimento').val(boleto.getDataBoletoFmt());

	if (strValor.length > 4 ) {
		strValor = strValor.substr(4, strValor.length - 4);
		valor = Number(strValor);
		$('#valor').val(valor);
	}

	$('#valor').focus();

});


$('#multa').focusout(function () {

	var valor = $('#valor').val().replace(/\./g, '').replace(/,/g, '');
	var multa = $('#multa').val().replace(/\./g, '').replace(/,/g, '');
	var valorCobrado = String(Number(valor) + Number(multa));

	$('#valorCobrado').val(valorCobrado);

});


$('#multa').focusout(function () {
	calculaValorCobrado();
});

$('#btnRecalcular').click(function() {

	var vencimento = $('#vencimento').val();
	var newVencto = null;
	var year = 0;
	var month = -1;
	var day = 0;
	var boleto = new Boleto();
	var valorCobrado = "";
	var diasBoleto = "";
	var linhaDigitavel = "";

	if (vencimento == null || "" == vencimento.trim()) {
		return false;
	}

	year = Number(vencimento.substr(0, 4));
	month = Number(vencimento.substr(5, 2));
	day = Number(vencimento.substr(8, 2));
	newVencto = new Date(year, month - 1, day);
	diasBoleto = "0000".concat(boleto.getDiasVencto(newVencto)).substr(-4, 4);

	calculaValorCobrado();

	valorCobrado = $('#valorCobrado').val().replace(/\./g, '').replace(/,/g, '');
	valorCobrado = diasBoleto.concat("0000000000".concat(valorCobrado).substr(-10, 10));

	$('#campo7').val(valorCobrado);

	linhaDigitavel = String($('#campo1').val())
							.concat(String($('#campo2').val()))
							.concat(String($('#campo3').val()))
							.concat(String($('#campo4').val()))
							.concat(String($('#campo5').val()))
							.concat(String($('#campo6').val()))
							.concat(String($('#campo7').val()));
	boleto.setLinhaDigitavel(linhaDigitavel);
	$('#dv1').val(boleto.calculaDigito());

});


function calculaValorCobrado() {
	var valor = $('#valor').val().replace(/\./g, '').replace(/,/g, '');
	var multa = $('#multa').val().replace(/\./g, '').replace(/,/g, '');
	var valorCobrado = 0;

	if (valor == null || "" == valor.trim() || "000" == valor) {
		return false;
	}

	valorCobrado = Number(valor) + Number(multa);
	$('#valorCobrado').val(valorCobrado);

	return true;
}

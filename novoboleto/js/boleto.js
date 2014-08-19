function Boleto() {
	var _DATAINICIOBOLETO = new Date(1997, 9, 7);
	var _linhaDigitavel = "";
    var _banco = "";
    var _moeda;
    var _strVencimento;
    var _strValor;
    var _campoLivre;
    var _dac;

	this.setLinhaDigitavel = setLinhaDigitavel;
	this.getLinhaDigitavel = getLinhaDigitavel;
	this.getDataBoleto = getDataBoleto;
	this.calculaDigito = calculaDigito;

	function getDataBoleto() {
		var numeroDeDias = 0;
		var dataBoleto = new Date();

		if (_strVencimento == null || _strVencimento.trim() === "") {
			return null;
		}

		console.log("Inicio:[" + _DATAINICIOBOLETO + "]");

		numeroDeDias = parseInt(_strVencimento);
		console.log("Numero de Dias:[" + numeroDeDias + "]");

		dataBoleto.setDate(_DATAINICIOBOLETO.getDate() + numeroDeDias);

		return dataBoleto;

	}

	function setLinhaDigitavel(linhaDigitavel) {
		_linhaDigitavel = linhaDigitavel;

        _banco = _linhaDigitavel.substr(0, 3);
        _moeda = _linhaDigitavel.substr(3, 1);
        _strVencimento = _linhaDigitavel.substr(33, 4);
        _strValor = _linhaDigitavel.substr(37, 10);
        _campoLivre = _linhaDigitavel.substr(4, 5) +
                      _linhaDigitavel.substr(10, 10) +
                      _linhaDigitavel.substr(21, 10);
	}

	function getLinhaDigitavel() {
		return _linhaDigitavel;
	}

	function calculaDigito() {
        var num = 0;
        var produto = 0;
        var soma = 0;
        var multiplicador = 2;
        var resto = 0;
        var sb = "";

		if (_linhaDigitavel == null || _linhaDigitavel.trim() === "") {
			return null;
		}
		console.log("Linha Digitavel:[" + _linhaDigitavel + "]");        	

        sb = _banco.concat(_moeda).concat(_strVencimento).concat(_strValor).concat(_campoLivre);
		console.log("Minha String:[" + sb + "]");        	

        for (i = sb.length - 1; i > -1; i--) {
			// console.log(sb.substr(i, 1));        	
            num = parseInt(sb.substr(i, 1));
            produto = num * multiplicador;
            soma += produto;
            multiplicador++;
            if (multiplicador == 10)
            {
                multiplicador = 2;
            }
        }

        resto = soma % 11;
        
        dac = 11 - resto;
        if (dac == 0 || dac == 10)
        {
            dac = 1;
        }
        return dac;

	}
}

var boleto = new Boleto();

//23793.39100 20000.024651 18000.067704 1 60690000056462
//boleto.setLinhaDigitavel("23793391002000002465118000067704160690000056462");
//console.log("Calculo do digito do Boleto:[" + boleto.calculaDigito() + "]");

//03399.19284 40600.000026 18359.501022 5 60510000048590
//boleto.setLinhaDigitavel("03399192844060000002618359501022560510000048590");
//console.log("Calculo do digito do Boleto:[" + boleto.calculaDigito() + "]");

//23792.37429 59701.009942 01002.562609 2 61040000006000
boleto.setLinhaDigitavel("23792374295970100994201002562609261040000006000");
console.log("Calculo do digito do Boleto:[" + boleto.calculaDigito() + "]");
console.log("Data do Boleto:[" + boleto.getDataBoleto() + "]");

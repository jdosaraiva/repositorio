using System;
using System.Collections.Generic;
using System.Text;

namespace CodigoDeBarras
{
    public class CodigoDeBarras
    {
        private static readonly DateTime dataBase =  new DateTime(1997, 10, 7);

        public static DateTime DataBase
        {
            get { return dataBase; }
        }

        private String linhaDigitavel;

        public String LinhaDigitavel
        {
            get { return linhaDigitavel; }
            set { linhaDigitavel = value; }
        }

        private String banco;

        public String Banco
        {
            get { return banco; }
            set { banco = value; }
        }

        private String moeda;

        public String Moeda
        {
            get { return moeda; }
            set { moeda = value; }
        }


        private String strVencimento;

        public String StrVencimento
        {
            get { return strVencimento; }
            set 
            { 
                strVencimento = value;
            }
        }

        private int vencimento;

        public int Vencimento
        {
            get { return vencimento; }
            set { vencimento = value; }
        }
        private DateTime dataDeVencimento;

        public DateTime DataDeVencimento
        {
            get { return dataDeVencimento; }
            set 
            { 
                dataDeVencimento = value;
            }
        }

        private String strValor;

        public String StrValor
        {
            get { return strValor; }
            set { strValor = value; }
        }

        private double valor;

        public double Valor
        {
            get { return valor; }
            set 
            { 
                valor = value; 
                // dac = calculateDac(); 
            }
        }

        private String campoLivre;

        public String CampoLivre
        {
            get { return campoLivre; }
            set { campoLivre = value; }
        }

        private int dac;

        public int Dac
        {
            get { return dac; }
        }

        public CodigoDeBarras()
        {

        }

        public CodigoDeBarras(String linhaDigitavel)
        {
            LinhaDigitavel = linhaDigitavel;
            Banco = LinhaDigitavel.Substring(0, 3);
            Moeda = LinhaDigitavel.Substring(3, 1);
            StrVencimento = LinhaDigitavel.Substring(33, 4);
            Vencimento = int.Parse(LinhaDigitavel.Substring(33, 4));
            DataDeVencimento = dataBase.AddDays(Vencimento);
            StrValor = LinhaDigitavel.Substring(37, 10);
            Valor = double.Parse(LinhaDigitavel.Substring(37, 10))/100;
            CampoLivre = LinhaDigitavel.Substring(4, 5) +
                         LinhaDigitavel.Substring(10, 10) +
                         LinhaDigitavel.Substring(21, 10);
            dac = calculateDac();

        }

        public int calculateDac()
        {
            StringBuilder sb = new StringBuilder();
            StringBuilder aux = new StringBuilder();
            int num = 0;
            int produto = 0;
            int soma = 0;
            int multiplicador = 2;
            int resto = 0;

            sb.Append(Banco).Append(Moeda).Append(StrVencimento).Append(StrValor).Append(CampoLivre);

            for (int i = sb.Length - 1; i > -1; i--)
            {
                // Console.Write(sb.ToString().Substring(i, 1));
                aux.Append(sb.ToString().Substring(i, 1));
                num = int.Parse(sb.ToString().Substring(i, 1));
                produto = num * multiplicador;
                soma += produto;
                multiplicador++;
                if (multiplicador == 10)
                {
                    multiplicador = 2;
                }
            }
            // Console.WriteLine();

            resto = soma % 11;
            
            dac = 11 - resto;
            if (dac == 0 || dac == 10)
            {
                dac = 1;
            }
            return dac;
        }

    }

}

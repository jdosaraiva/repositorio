using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace CodigoDeBarras
{
    public partial class FormMain : Form
    {

        private String CAMINHO = Application.ExecutablePath;

        // 23790.00108 54013.266660 76025.369901 1 36340000014495
        private CodigoDeBarras cdb;
        
        public FormMain()
        {
            InitializeComponent();
            TxtCampo1.Focus();
        }

        private void BtnCalcular_Click(object sender, EventArgs e)
        {
            cdb = new CodigoDeBarras(prepareString());
            TxtDAC.Text = cdb.calculateDac().ToString();
            if ("".Equals(TxtVencimento.Text))
            {
                TxtVencimento.Text = cdb.DataDeVencimento.ToShortDateString();
            }
            if ("".Equals(TxtValor.Text))
            {
                TxtValor.Text = cdb.Valor.ToString();
            }
        }

        private void TxtCampo1_KeyUp(object sender, KeyEventArgs e)
        {
            if (TxtCampo1.Text.Length == TxtCampo1.MaxLength)
            {
                TxtCampo2.Focus();
            }
        }

        private void TxtCampo2_KeyUp(object sender, KeyEventArgs e)
        {
            if (TxtCampo2.Text.Length == TxtCampo2.MaxLength)
            {
                TxtCampo3.Focus();
            }
        }

        private void TxtCampo3_KeyUp(object sender, KeyEventArgs e)
        {
            if (TxtCampo3.Text.Length == TxtCampo3.MaxLength)
            {
                TxtCampo4.Focus();
            }
        }

        private void TxtCampo4_KeyUp(object sender, KeyEventArgs e)
        {
            if (TxtCampo4.Text.Length == TxtCampo4.MaxLength)
            {
                TxtCampo5.Focus();
            }

        }

        private void TxtCampo5_KeyUp(object sender, KeyEventArgs e)
        {
            if (TxtCampo5.Text.Length == TxtCampo5.MaxLength)
            {
                TxtCampo6.Focus();
            }
        }

        private void TxtCampo6_KeyUp(object sender, KeyEventArgs e)
        {
            if (TxtCampo6.Text.Length == TxtCampo6.MaxLength)
            {
                TxtDAC.Focus();
            }
        }

        private void TxtDAC_KeyUp(object sender, KeyEventArgs e)
        {
            if (TxtDAC.Text.Length == TxtDAC.MaxLength)
            {
                TxtCampo8.Focus();
            }
        }

        private void TxtCampo8_KeyUp(object sender, KeyEventArgs e)
        {
            // MessageBox.Show(e.KeyCode.ToString());
            if (e.KeyCode == Keys.Left || e.KeyCode == Keys.Right)
            {
                e.Handled = false;
                return;
            }

            if ((e.Control==false) && (TxtCampo8.Text.Length == TxtCampo8.MaxLength))
            {
                BtnCalcular.Focus();
            }
        }

        private void TxtVencimento_Leave(object sender, EventArgs e)
        {
            if ("".Equals(TxtVencimento.Text))
            {
                return;
            }

            int dia = int.Parse(TxtVencimento.Text.Substring(0, 2));
            int mes = int.Parse(TxtVencimento.Text.Substring(3, 2));
            int ano = int.Parse(TxtVencimento.Text.Substring(6, 4));
            // MessageBox.Show("Vencimento=" + dia + "/" + mes + "/" + ano); 

            DateTime d = new DateTime(ano, mes, dia);
            TimeSpan ts = d - CodigoDeBarras.DataBase;
            int venc = ts.Days;

            if (cdb == null)
            {
                cdb = new CodigoDeBarras(prepareString());
            }

            cdb.Vencimento = venc;
            cdb.StrVencimento = venc.ToString();
            TxtCampo8.Text = cdb.StrVencimento + cdb.StrValor;
            TxtDAC.Text = cdb.calculateDac().ToString();
        }

        private void TxtCampo8_Leave(object sender, EventArgs e)
        {
            if ("".Equals(TxtCampo8.Text))
            {
                return;
            }

            int venc = int.Parse(TxtCampo8.Text.Substring(0, 4));
            DateTime d = CodigoDeBarras.DataBase.AddDays(venc);
            TxtVencimento.Text = d.ToShortDateString();

            String v = TxtCampo8.Text.Substring(4, 10);

            double val = double.Parse(v)/100;
            TxtValor.Text = val.ToString();

            BtnCalcular.PerformClick();

        }

        private String prepareString()
        {
            String cmp1 = "".Equals(TxtCampo1.Text) ? "00000" : TxtCampo1.Text;
            String cmp2 = "".Equals(TxtCampo2.Text) ? "00000" : TxtCampo2.Text;
            String cmp3 = "".Equals(TxtCampo3.Text) ? "00000" : TxtCampo3.Text;
            String cmp4 = "".Equals(TxtCampo4.Text) ? "000000" : TxtCampo4.Text;
            String cmp5 = "".Equals(TxtCampo5.Text) ? "00000" : TxtCampo5.Text;
            String cmp6 = "".Equals(TxtCampo6.Text) ? "000000" : TxtCampo6.Text;
            String cmp7 = "".Equals(TxtDAC.Text) ? "1" : TxtDAC.Text;
            String cmp8 = "".Equals(TxtCampo8.Text) ? "00000000000000" : TxtCampo8.Text;

            StringBuilder sb = new StringBuilder();
            sb.Append(cmp1).Append(cmp2)
              .Append(cmp3).Append(cmp4)
              .Append(cmp5).Append(cmp6)
              .Append(cmp7).Append(cmp8);

            return sb.ToString();
        }

        private void FormMain_Load(object sender, EventArgs e)
        {

            //TxtCampo1.Text = "23790";
            //TxtCampo2.Text = "00108";
            //TxtCampo3.Text = "54013";
            //TxtCampo4.Text = "266660";
            //TxtCampo5.Text = "76025";
            //TxtCampo6.Text = "369901";
            //TxtDAC.Text = "1";
            //TxtCampo8.Text = "36340000014495";

            //toolStripStatusLabel1.Text = CAMINHO;
            toolStripStatusLabel1.Text = "Copyright © Saraiva Soluções em Sistemas Ltda - 2007";
        }

        private void TxtValor_KeyDown(object sender, KeyEventArgs e)
        {
            if ("".Equals(TxtValor.Text)) 
            {
                return;
            }

            if (e.KeyCode != Keys.Enter)
            {
                return;
            }

            double val = double.Parse(TxtValor.Text);
            val *= 100;

            String strVal = "0000000000" + val.ToString();
            strVal = strVal.Substring(strVal.Length - 10, 10);

            String venc = TxtCampo8.Text.Substring(0, 4);
            TxtCampo8.Text = venc + strVal;

            if (cdb == null)
            {
                cdb = new CodigoDeBarras(prepareString());
            }

            BtnCalcular.PerformClick();

        }

        private void TxtCampo_KeyPress(object sender, KeyPressEventArgs e)
        {
            TextBox tb = (TextBox)sender;
            // MessageBox.Show(tb.Name);

            if (tb.Equals(TxtValor))
            {
                if ((!Char.IsDigit(e.KeyChar)) && (!Char.IsControl(e.KeyChar)) &&
                     (e.KeyChar != ',') && (e.KeyChar != '.'))
                {
                    e.Handled = true;
                }
            }
            else if (tb.Equals(TxtVencimento))
            {
                if ( (!Char.IsDigit(e.KeyChar)) 
                     && (!Char.IsControl(e.KeyChar)) 
                     && (e.KeyChar != '/'))
                {
                    e.Handled = true;
                }
            }
            else if ((!Char.IsDigit(e.KeyChar)) && (!Char.IsControl(e.KeyChar))) 
            {
                e.Handled = true;
            }

        }

        private void TxtVencimento_KeyDown(object sender, KeyEventArgs e)
        {
            if ("".Equals(TxtValor.Text))
            {
                return;
            }

            if (e.KeyCode != Keys.Enter)
            {
                return;
            }

            BtnCalcular.Focus();

        }

        private void menuItem3_Click(object sender, EventArgs e)
        {

            foreach (Control aControl in this.Controls)
            {
                if (aControl is TextBox ) {
                    aControl.Text = "";
                }

            }
        }

        private void menuItem5_Click(object sender, EventArgs e)
        {
            this.Close();
        }


    }

}
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Aladdin.HASP;

namespace RecHLockNew
{
    public partial class FormMain : Form
    {

        private Logger logger = new Logger(typeof(FormMain));

        private HardLockHelper helper = new HardLockHelper();

        private static readonly string FORM_CAPTION = "Gravador de HardLock";
        
        public FormMain()
        {
            InitializeComponent();
        }

        private void FormMain_Load(object sender, EventArgs e)
        {

        }

        private void btnSair_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnLoginHasp_Click(object sender, EventArgs e)
        {

            HaspStatus status = helper.loginInHasp();

            exibeMensagem(status, "Login no HASP efetuado com sucesso!");

            if (HaspStatus.StatusOk == status)
            {
                helper.logoutInHasp();
            }

        }

        private string exibeMensagem(HaspStatus status, string msgSucesso)
        {
            string alert = "";

            if (HaspStatus.StatusOk != status)
            {
                alert = "ERRO: [" + HardLockHelper.MapaDeStatus.getStatus((int)status) + "]";
                MessageBox.Show(alert, FORM_CAPTION, MessageBoxButtons.OK, MessageBoxIcon.Error);
                logger.logError("#exibeMensagem - " + alert);
            }
            else
            {
                alert = msgSucesso;
                MessageBox.Show(alert, FORM_CAPTION, MessageBoxButtons.OK, MessageBoxIcon.Information);
                logger.logInfo("#exibeMensagem - " + alert);
            }

            return alert;
        }


        private void btnCmdWrite_Click(object sender, EventArgs e)
        {
            HaspStatus status;

            string msgaux = "";

            DateTime? validade = null;
            if (!chkIlimitado.Checked)
            {
                validade = Calendar.SelectionRange.Start;
            }

            if (!validaCampos()) return;

            HardLock hl = new HardLockBuilder()
                    .withVersaHardLock(Convert.ToInt32(txtVersaoHardLock.Text))
                    .withNCanais(Convert.ToInt32(txtNCanais.Text))
                    .withValidade(validade)
                    .withVMajor(Convert.ToInt32(txtVMajor.Text))
                    .withVMinor(Convert.ToInt32(txtVMinor.Text))
                    .withNUsers(Convert.ToInt32(txtNUsers.Text))
                    .withVoiceMail(chkVoiceMail.Checked)
                    .withFaxMail(chkFaxMail.Checked)
                    .withCampanha(chkCampanha.Checked)
                    .withXFace(chkXFace.Checked)
                    .withBroadcast(chkBroadcast.Checked)
                    .withRobot(chkRobot.Checked)
                    .withSpeech(chkSpeech.Checked)
                    .withTextToSpeech(chkTextToSpeech.Checked)
                    .build();

            status = helper.loginInHasp();

            if (HaspStatus.StatusOk != status)
            {
                string msg = "Não foi possível fazer o login no HASP!\n"
                    + "Verifique se a chave está conectada.";
                MessageBox.Show(msg, FORM_CAPTION, MessageBoxButtons.OK, MessageBoxIcon.Error);
                logger.logError("#btnCmdWrite_Click - " + msg.Replace("\n", " "));
                return;
            }

            string aux = "";

            if (helper.writeInHasp(ref msgaux, hl, ref aux))
            {
                helper.logoutInHasp();
            }

            txtWrite.Text = aux;

            txtDTControle.Text = hl.DTControle.ToString("dd/MM/yyyy HH:00:00");

        }

        private bool validaCampos()
        {
            if (string.Empty == txtVersaoHardLock.Text)
            {
                MessageBox.Show("O campo Versão HardLock deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtVersaoHardLock.Focus();
                return false;
            }

            if (string.Empty == txtNCanais.Text)
            {
                MessageBox.Show("O campo Canais deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtNCanais.Focus();
                return false;
            }

            if (string.Empty == txtVMajor.Text)
            {
                MessageBox.Show("O campo Versão Crytal deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtVMajor.Focus();
                return false;
            }

            if (string.Empty == txtVMinor.Text)
            {
                MessageBox.Show("O campo Versão Crytal deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtVMinor.Focus();
                return false;
            }

            if (string.Empty == txtNUsers.Text)
            {
                MessageBox.Show("O campo Máximo de usuários deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtNUsers.Focus();
                return false;
            }

            return true;
        }

        private void btnCmdLer_Click(object sender, EventArgs e)
        {
            HaspStatus status;
            string mensagem = "";

            status = helper.loginInHasp();

            if (HaspStatus.StatusOk != status)
            {
                string msg = "Não foi possível fazer o login no HASP!\n"
                    + "Verifique se a chave está conectada.";
                MessageBox.Show(msg, FORM_CAPTION, MessageBoxButtons.OK, MessageBoxIcon.Error);
                logger.logError("#btnCmdLer_Click - " + msg.Replace("\n", " "));
                return;
            }

            string strlida = helper.readInHasp(ref status, ref mensagem);

            helper.logoutInHasp();

            HardLock hardlock = helper.str2Hardlock(strlida);

            txtRead.Text = strlida;

            toScreen(hardlock);
                        
        }

        private void toScreen(HardLock hardlock)
        {
            txtVersaoHardLock.Text = Convert.ToString(hardlock.VersaHardLock);
            txtDTControle.Text = hardlock.DTControle.ToString("dd/MM/yyyy HH:00:00");
            txtNCanais.Text = Convert.ToString(hardlock.NCanais);
            txtVMajor.Text = Convert.ToString(hardlock.VMajor);
            txtVMinor.Text = Convert.ToString(hardlock.VMinor);
            txtNUsers.Text = Convert.ToString(hardlock.NUsers);
            chkVoiceMail.Checked = hardlock.VoiceMail;
            chkFaxMail.Checked = hardlock.FaxMail;
            chkCampanha.Checked = hardlock.Campanha;
            chkXFace.Checked = hardlock.XFace;
            chkBroadcast.Checked = hardlock.Broadcast;
            chkRobot.Checked = hardlock.Robot;
            chkSpeech.Checked = hardlock.Speech;
            chkTextToSpeech.Checked = hardlock.TextToSpeech;

            if (hardlock.Valido)
            {
                txtHardLockValido.Text = "HARDLOCK VÁLIDO";
                if (hardlock.Validade == null)
                {
                    chkIlimitado.Checked = true;
                }
                else
                {
                    chkIlimitado.Checked = false;
                }
            }
            else
            {
                txtHardLockValido.Text = "HARDLOCK INVÁLIDO";
            }
        }

        private void AceitaApenasNumeros_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (char.IsDigit(e.KeyChar)) return;
            if (char.IsControl(e.KeyChar)) return;
            
            e.Handled = true;
        }

        private void chkIlimitado_CheckedChanged(object sender, EventArgs e)
        {
            if (chkIlimitado.Checked)
            {
                if (Calendar.Enabled) Calendar.Enabled = false;
            }
            else
            {
                if (!Calendar.Enabled) Calendar.Enabled = true;
            }
        }

        private void btnLimpar_Click(object sender, EventArgs e)
        {
            txtVersaoHardLock.Text = "";
            txtDTControle.Text = "";
            txtNCanais.Text = "";
            txtVMajor.Text = "";
            txtVMinor.Text = "";
            txtNUsers.Text = "";
            chkVoiceMail.Checked = false;
            chkFaxMail.Checked = false;
            chkCampanha.Checked = false;
            chkXFace.Checked = false;
            chkBroadcast.Checked = false;
            chkRobot.Checked = false;
            chkSpeech.Checked = false;
            chkTextToSpeech.Checked = false;
            chkIlimitado.Checked = false;
            txtRead.Text = "";
            //txtWrite.Text = "";

        }

    }
 
}
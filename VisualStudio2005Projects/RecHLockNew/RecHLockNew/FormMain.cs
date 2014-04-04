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

        private Logger log = new Logger();
        private MapaStatus mpst = new MapaStatus();
        
        public FormMain()
        {
            InitializeComponent();
        }

        private void FormMain_Load(object sender, EventArgs e)
        {
            txtHardLockValido.Text = "HARDLOCK VÁLIDO";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnLoginHasp_Click(object sender, EventArgs e)
        {

            Hasp hasp;
            HaspStatus status;
            loginInHasp(out hasp, out status);

            if (HaspStatus.StatusOk == status)
            {
                logoutInHasp(hasp, ref status);
            }

        }

        private void logoutInHasp(Hasp hasp, ref HaspStatus status)
        {
            status = hasp.Logout();

            string mensagem = "";

            if (HaspStatus.StatusOk != status)
            {
                mensagem = "ERRO: [" + mpst.getStatus((int)status) + "]";
            }
            else
            {
                mensagem = "Logout no HASP efetuado com sucesso!";
            }

            log.info("#logoutInHasp - " + mensagem);
        }

        private void loginInHasp(out Hasp hasp, out HaspStatus status)
        {
            //HaspFeature feature = HaspFeature.FromFeature(10);
            HaspFeature feature = HaspFeature.FromFeature(50);
            string mensagem = "";

            string scope =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<haspscope>" +
                "    <hasp type=\"HASP-HL\" />" +
                "</haspscope>";

            hasp = new Hasp(feature);
            //HaspStatus status = hasp.Login(VendorCode.Code);
            status = hasp.Login(VendorCode.Code, scope);

            mensagem = exibeMensagem(status, "Login no HASP efetuado com sucesso!");

            log.info("#loginInHasp - " + mensagem);

        }

        private void btnCmdWrite_Click(object sender, EventArgs e)
        {
            Hasp hasp;
            HaspStatus status;

            string msgaux = "";

            loginInHasp(out hasp, out status);

            if (HaspStatus.StatusOk != status)
            {
                return;
            }

            int size = 100;
            byte[] data = new byte[size];

            string strgravar = addLeadingWhiteSpaces(texto.Text, size);

            log.info("#btnCmdWrite_Click - String a gravar:[" + strgravar + "]");

            data = Encoding.ASCII.GetBytes(strgravar);

            //byte[] data = {
            //        0x48, 0xce, 0x04, 0x95, 0x09, 0xac, 0x62, 0x63, 
            //        0x0e, 0x4b, 0x8e, 0xe3, 0x85, 0x6e, 0x7b, 0x59, 
            //        0x5a, 0xa1, 0xde, 0x30, 0xfc, 0xe7, 0x06, 0x1e, 
            //        0x4f, 0xba, 0x35, 0x3f, 0x1b, 0xe5, 0x67, 0xaa, 
            //        0x63, 0xbe, 0x47, 0x35, 0xdc, 0x6a, 0x49, 0xd8, 
            //        0xd2, 0x9c, 0xf4, 0xa1, 0x38, 0xae, 0xa9, 0x77, 
            //        0xf5, 0x4f, 0x15, 0x0e, 0x1d, 0x17, 0x51, 0xba, 
            //        0x03, 0x80, 0xff, 0x11, 0x9d, 0x61, 0x62, 0xc3, 
            //        0xe8, 0xab, 0x26, 0x79, 0x4e, 0x14, 0xbe, 0x0e, 
            //        0x0e, 0x82, 0xa2, 0x82, 0xd0, 0x41, 0x8f, 0x4c, 
            //        0x9d, 0x02, 0x96, 0x31, 0xf2, 0x0d, 0xa7, 0x23, 
            //        0x0c, 0xc2, 0x77, 0xfc, 0xa4, 0xfe, 0x4c, 0x57, 
            //        0x36, 0xe6, 0x33, 0x3e};

            status = hasp.Encrypt(data);

            if (HaspStatus.StatusOk != status)
            {
                msgaux = "ERRO: [" + mpst.getStatus((int)status) + "]";
                MessageBox.Show(msgaux, FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Error);

                log.info("#btnCmdWrite_Click - " + msgaux);

                logoutInHasp(hasp, ref status);

                return;
            }

            HaspFile file = hasp.GetFile(HaspFileId.ReadWrite);

            status = file.Write(data, 0, data.Length);

            msgaux = exibeMensagem(status, "Gravação efetuada com sucesso!");

            log.info("#btnCmdWrite_Click - " + msgaux);

            logoutInHasp(hasp, ref status);
        }

        private string addLeadingWhiteSpaces(string str, int tam)
        {
            StringBuilder sb = new StringBuilder(str);
            while (sb.Length < tam) sb.Append(" ");

            return sb.ToString();
        }

        private string exibeMensagem(HaspStatus status, string msgSucesso)
        {
            MessageBoxIcon mbi  = MessageBoxIcon.Information;

            string alert = "";

            if (HaspStatus.StatusOk != status)
            {
                alert = "ERRO: [" + mpst.getStatus((int)status) + "]";
                mbi = MessageBoxIcon.Error;
            }
            else
            {
                alert = msgSucesso;
            }

            MessageBox.Show(alert, FormMain.ActiveForm.Text, MessageBoxButtons.OK, mbi);
            return alert;
        }

        private void btnCmdLer_Click(object sender, EventArgs e)
        {
            Hasp hasp;
            HaspStatus status;
            string mensagem = "";

            loginInHasp(out hasp, out status);

            if (HaspStatus.StatusOk != status)
            {
                return;
            }

            readInHasp(hasp, ref status, ref mensagem);
            
            logoutInHasp(hasp, ref status);
        }

        private void readInHasp(Hasp hasp, ref HaspStatus status, ref string mensagem)
        {
            HaspFile file = hasp.GetFile(HaspFileId.ReadWrite);
            int size = 100;
            byte[] data = new byte[size];
            status = file.Read(data, 0, data.Length);

            mensagem = exibeMensagem(status, "Leitura efetuada com sucesso!");

            status = hasp.Decrypt(data);

            System.Text.ASCIIEncoding enc = new System.Text.ASCIIEncoding();
            string dadosDecriptados = enc.GetString(data);

            dadosDecriptados = dadosDecriptados.Replace("\0", String.Empty);

            log.info("#readInHasp - Dados decriptados:[" + dadosDecriptados + "]");

            // MessageBox.Show("Lido:[" + dadosDecriptados + "]", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Information);

            txtRead.Text = dadosDecriptados.Trim();

            log.info("#readInHasp - " + mensagem);

        }

        private void texto_TextChanged(object sender, EventArgs e)
        {
            if (String.Empty != texto.Text)
            {
                if (!(btnCmdWrite.Enabled == true)) btnCmdWrite.Enabled = true;
            }
            else {
                if (btnCmdWrite.Enabled == true) btnCmdWrite.Enabled = false;
            }
        }

    }

}
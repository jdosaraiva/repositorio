using System;
using System.Collections.Generic;
using System.Text;
using Aladdin.HASP;
using System.Windows.Forms;

namespace RecHLockNew
{
    class HardLockHelper
    {
        private static Logger logger = new Logger(typeof(HardLockHelper));

        private static MapaStatus mpst = new MapaStatus();

        private static Hasp hasp = new Hasp();

        public HaspStatus loginInHasp()
        {
            //HaspFeature feature = HaspFeature.FromFeature(10);
            HaspFeature feature = HaspFeature.FromFeature(50);
            string mensagem = "";

            string scope =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<haspscope>" +
                "    <hasp type=\"HASP-HL\" />" +
                "</haspscope>";

            // hasp = new Hasp(feature);
            //HaspStatus status = hasp.Login(VendorCode.Code);
            HaspStatus status = hasp.Login(VendorCode.Code, scope);

            mensagem = exibeMensagem(status, "Login no HASP efetuado com sucesso!");

            logger.logInfo("#loginInHasp - " + mensagem);

            return status;

        }

        public HaspStatus logoutInHasp()
        {
            HaspStatus status = hasp.Logout();

            string mensagem = "";

            if (HaspStatus.StatusOk != status)
            {
                mensagem = "ERRO: [" + mpst.getStatus((int)status) + "]";
                logger.logError("#logoutInHasp - " + mensagem);
            }
            else
            {
                mensagem = "Logout no HASP efetuado com sucesso!";
                logger.logInfo("#logoutInHasp - " + mensagem);
            }

            return status;
        }


        public bool writeInHasp(ref string msgaux, HardLock hardlock)
        {
            int size = 30;
            byte[] data = new byte[size];

            string meusDados = preparaDados(hardlock);

            string strgravar = addLeadingWhiteSpaces(meusDados, size);

            logger.logInfo("#btnCmdWrite_Click - String a gravar:[" + strgravar + "]");

            data = Encoding.ASCII.GetBytes(strgravar);

            HaspStatus status = hasp.Encrypt(data);

            if (HaspStatus.StatusOk != status)
            {
                msgaux = "ERRO: [" + mpst.getStatus((int)status) + "]";
                MessageBox.Show(msgaux, FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Error);

                logger.logError("#btnCmdWrite_Click - " + msgaux);

                logoutInHasp();

                return false;
            }

            HaspFile file = hasp.GetFile(HaspFileId.ReadWrite);

            status = file.Write(data, 0, data.Length);

            msgaux = exibeMensagem(status, "Gravação efetuada com sucesso!");

            logger.logInfo("#btnCmdWrite_Click - " + msgaux);

            return true;
        }


        public string readInHasp(ref HaspStatus status, ref string mensagem)
        {
            HaspFile file = hasp.GetFile(HaspFileId.ReadWrite);
            int size = 30;
            byte[] data = new byte[size];
            status = file.Read(data, 0, data.Length);

            mensagem = exibeMensagem(status, "Leitura efetuada com sucesso!");

            status = hasp.Decrypt(data);

            System.Text.ASCIIEncoding enc = new System.Text.ASCIIEncoding();
            string dadosDecriptados = enc.GetString(data);

            dadosDecriptados = dadosDecriptados.Replace("\0", String.Empty);

            logger.logInfo("#readInHasp - Dados decriptados:[" + dadosDecriptados + "]");

            // MessageBox.Show("Lido:[" + dadosDecriptados + "]", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Information);

            logger.logInfo("#readInHasp - " + mensagem);

            return dadosDecriptados.Trim();

        }

        private string exibeMensagem(HaspStatus status, string msgSucesso)
        {
            MessageBoxIcon mbi = MessageBoxIcon.Information;

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

        private string preparaDados(HardLock hardlock)
        {
            StringBuilder sb = new StringBuilder();
            sb.Append(hardlock.VersaHardLock > 0 ? Convert.ToChar(hardlock.VersaHardLock) : '0'); //[01]
            sb.Append(hardlock.NCanais > 0 ? Convert.ToChar(hardlock.NCanais) : '0');             //[02]

            if (hardlock.Validade == null)
            {
                sb.Append('0');                 //[03]
                sb.Append(Convert.ToChar(255)); //[04]
                sb.Append('0');                 //[05]
            }
            else
            {
                sb.Append(Convert.ToChar(hardlock.Validade.Value.Day));         //[03]
                sb.Append(Convert.ToChar(hardlock.Validade.Value.Month));       //[04]
                sb.Append(Convert.ToChar(hardlock.Validade.Value.Year - 2000)); //[05] 
            }

            sb.Append(hardlock.VMajor > 0 ? Convert.ToChar(hardlock.VMajor) : '0'); //[06]
            sb.Append(hardlock.VMinor > 0 ? Convert.ToChar(hardlock.VMinor) : '0'); //[07]

            sb.Append(hardlock.NUsers > 0 ? Convert.ToChar(hardlock.NUsers) : '0'); //[08]
            sb.Append(hardlock.VoiceMail ? '1' : '0');    //[09]
            sb.Append(hardlock.FaxMail ? '1' : '0');      //[10]
            sb.Append(hardlock.Campanha ? '1' : '0');     //[11]
            sb.Append(hardlock.XFace ? '1' : '0');        //[12]
            sb.Append(hardlock.Broadcast ? '1' : '0');    //[13]
            sb.Append(hardlock.Robot ? '1' : '0');        //[14]
            sb.Append(hardlock.Speech ? '1' : '0');       //[15]
            sb.Append(hardlock.TextToSpeech ? '1' : '0'); //[16]

            sb.Append(Convert.ToChar(hardlock.DTControle.Day));          //[17]
            sb.Append(Convert.ToChar(hardlock.DTControle.Month));        //[18]
            sb.Append(Convert.ToChar(hardlock.DTControle.Year - 2000));  //[19]
            sb.Append(Convert.ToChar(hardlock.DTControle.Hour));         //[20]

            sb.Append(Convert.ToChar(hardlock.DTControle.Hour));         //[21]
            sb.Append(Convert.ToChar(hardlock.DTControle.Day));          //[22]
            sb.Append(Convert.ToChar(hardlock.DTControle.Month));        //[23] 
            sb.Append(Convert.ToChar(hardlock.DTControle.Year - 2000));  //[24] 

            logger.logInfo("#preparaDados - String preparada:[" + sb.ToString() + "]");

            return sb.ToString();

        }

        private string addLeadingWhiteSpaces(string str, int tam)
        {
            StringBuilder sb = new StringBuilder(str);
            while (sb.Length < tam) sb.Append(" ");

            return sb.ToString();
        }

    }
}

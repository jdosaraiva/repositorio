using System;
using System.Collections.Generic;
using System.Text;
using Aladdin.HASP;
using System.Windows.Forms;

namespace RecHLockNew
{
    class HardLockHelper
    {
        private static readonly string FORM_CAPTION = "Gravador de HardLock";

        private static readonly int SIZE_MEMORY = 40;

        private static readonly int TAMANHO_NUMERO = 3;

        private static Logger logger = new Logger(typeof(HardLockHelper));

        private static MapaStatus mpst = new MapaStatus();

        public static MapaStatus MapaDeStatus
        {
            get { return HardLockHelper.mpst; }
            set { HardLockHelper.mpst = value; }
        }

        private static Hasp hasp;

        public HaspStatus loginInHasp()
        {
            //HaspFeature feature = HaspFeature.FromFeature(10);
            HaspFeature feature = HaspFeature.FromFeature(50);

            string scope =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<haspscope>" +
                "    <hasp type=\"HASP-HL\" />" +
                "</haspscope>";

            hasp = new Hasp(feature);
            //HaspStatus status = hasp.Login(VendorCode.Code);
            HaspStatus status = hasp.Login(VendorCode.Code, scope);

            // mensagem = exibeMensagem(status, "Login no HASP efetuado com sucesso!");

            logger.logInfo("#loginInHasp - " + MapaDeStatus.getStatus((int) status));

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


        public bool writeInHasp(ref string msgaux, HardLock hardlock, ref string gravada)
        {
            int size = SIZE_MEMORY;
            byte[] data = new byte[size];

            string meusDados = preparaDados(hardlock);

            string strgravar = addWhiteSpaces(meusDados, size);

            gravada = strgravar;

            logger.logInfo("#writeInHasp - String a gravar:[" + strgravar + "]");

            data = Encoding.ASCII.GetBytes(strgravar);

            HaspStatus status = hasp.Encrypt(data);

            if (HaspStatus.StatusOk != status)
            {
                msgaux = "ERRO: [" + mpst.getStatus((int)status) + "]";
                MessageBox.Show(msgaux, FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Error);

                logger.logError("#writeInHasp - " + msgaux);

                logoutInHasp();

                return false;
            }

            HaspFile file = hasp.GetFile(HaspFileId.ReadWrite);

            status = file.Write(data, 0, data.Length);

            msgaux = showMessage(status, "Gravação efetuada com sucesso!");

            logger.logInfo("#writeInHasp - " + msgaux);

            return true;
        }


        public string readInHasp(ref HaspStatus status, ref string mensagem)
        {
            HaspFile file = hasp.GetFile(HaspFileId.ReadWrite);
            int size = SIZE_MEMORY;
            byte[] data = new byte[size];
            status = file.Read(data, 0, data.Length);

            mensagem = showMessage(status, "Leitura efetuada com sucesso!");

            status = hasp.Decrypt(data);

            System.Text.ASCIIEncoding enc = new System.Text.ASCIIEncoding();
            string dadosDecriptados = enc.GetString(data);

            dadosDecriptados = dadosDecriptados.Replace("\0", String.Empty);

            logger.logInfo("#readInHasp - Dados decriptados:[" + dadosDecriptados + "]");

            //MessageBox.Show("Lido:[" + dadosDecriptados + "]", FORM_CAPTION, MessageBoxButtons.OK, MessageBoxIcon.Information);

            logger.logInfo("#readInHasp - " + mensagem);

            //stringToHarklock(dadosDecriptados.Trim());

            return dadosDecriptados;

        }

        private string showMessage(HaspStatus status, string msgSucesso)
        {
            MessageBoxIcon mbi = MessageBoxIcon.Information;

            string alert = "";

            if (HaspStatus.StatusOk != status)
            {
                alert = "ERRO: [" + mpst.getStatus((int)status) + "]";
                mbi = MessageBoxIcon.Error;
                logger.logError(alert);
            }
            else
            {
                alert = msgSucesso;
                logger.logInfo(alert);
            }

            MessageBox.Show(alert, FORM_CAPTION, MessageBoxButtons.OK, mbi);
            return alert;
        }

        public HardLock str2Hardlock(string str)
        {
            int pos = 0;
            int dia, mes, ano, hor;

            HardLockBuilder hlb = new HardLockBuilder()
                .withVersaHardLock(Convert.ToInt32(str.Substring(pos, TAMANHO_NUMERO).Trim())); //[01]

            pos += TAMANHO_NUMERO;

            hlb = hlb.withNCanais(Convert.ToInt32(str.Substring(pos, TAMANHO_NUMERO).Trim()));  //[04]
            
            pos += TAMANHO_NUMERO;

            DateTime? validade = null;
            char ch = str.ToCharArray(pos, 1)[0];
            if (ch != '0')
            {
                dia = Convert.ToInt32(str.ToCharArray(pos++, 1)[0]);        //[07]
                mes = Convert.ToInt32(str.ToCharArray(pos++, 1)[0]);        //[08]
                ano = 2000 + Convert.ToInt32(str.ToCharArray(pos++, 1)[0]); //[09]
                DateTime dt = new DateTime(ano, mes, dia, 23, 59, 59);
                validade = dt;

                if (DateTime.Now.CompareTo(validade.Value) > 0)
                {
                    hlb = hlb.invalido();
                }
            }
            else
            {
                pos += 3; //[07][08][09]
            }

            hlb = hlb.withValidade(validade);

            hlb = hlb.withVMajor(Convert.ToInt32(str.Substring(pos, TAMANHO_NUMERO).Trim()));      //[10]
            pos += TAMANHO_NUMERO;
            hlb = hlb.withVMinor(Convert.ToInt32(str.Substring(pos, TAMANHO_NUMERO).Trim()));      //[13]
            pos += TAMANHO_NUMERO;
            hlb = hlb.withNUsers(Convert.ToInt32(str.Substring(pos, TAMANHO_NUMERO).Trim()));      //[16]
            pos += TAMANHO_NUMERO;

            hlb = hlb.withVoiceMail(str.ToCharArray(pos++, 1)[0] == '1' ? true : false)//[19]
                .withFaxMail(str.ToCharArray(pos++, 1)[0] == '1' ? true : false)       //[20]
                .withCampanha(str.ToCharArray(pos++, 1)[0] == '1' ? true : false)      //[21]
                .withXFace(str.ToCharArray(pos++, 1)[0] == '1' ? true : false)         //[22]
                .withBroadcast(str.ToCharArray(pos++, 1)[0] == '1' ? true : false)     //[23]
                .withRobot(str.ToCharArray(pos++, 1)[0] == '1' ? true : false)         //[24]
                .withSpeech(str.ToCharArray(pos++, 1)[0] == '1' ? true : false)        //[25]
                .withTextToSpeech(str.ToCharArray(pos++, 1)[0] == '1' ? true : false); //[26]

            dia = Convert.ToInt32(str.ToCharArray(pos++, 1)[0]);        //[27]
            mes = Convert.ToInt32(str.ToCharArray(pos++, 1)[0]);        //[28]
            ano = 2000 + Convert.ToInt32(str.ToCharArray(pos++, 1)[0]); //[29]
            hor = Convert.ToInt32(str.ToCharArray(pos++, 1)[0]);        //[30]

            DateTime controle = new DateTime(ano, mes, dia, hor, 0, 0);

            HardLock hl = hlb.withDTControle(controle).build();
            return hl;
        }

        private string preparaDados(HardLock hardlock)
        {
            StringBuilder sb = new StringBuilder();

            sb.Append(addWhiteSpacesLeft(TAMANHO_NUMERO, Convert.ToString(hardlock.VersaHardLock)));  //[01]
            sb.Append(addWhiteSpacesLeft(TAMANHO_NUMERO, Convert.ToString(hardlock.NCanais)));        //[04]

            if (hardlock.Validade == null)
            {
                sb.Append('0');  //[07]
                sb.Append('0');  //[08]
                sb.Append('0');  //[09]
            }
            else
            {
                sb.Append(Convert.ToChar(hardlock.Validade.Value.Day));         //[07]
                sb.Append(Convert.ToChar(hardlock.Validade.Value.Month));       //[08]
                sb.Append(Convert.ToChar(hardlock.Validade.Value.Year - 2000)); //[09] 
            }

            sb.Append(addWhiteSpacesLeft(TAMANHO_NUMERO, Convert.ToString(hardlock.VMajor))); //[10]
            sb.Append(addWhiteSpacesLeft(TAMANHO_NUMERO, Convert.ToString(hardlock.VMinor))); //[13]
            sb.Append(addWhiteSpacesLeft(TAMANHO_NUMERO, Convert.ToString(hardlock.NUsers))); //[16]

            sb.Append(hardlock.VoiceMail ? '1' : '0');    //[19]
            sb.Append(hardlock.FaxMail ? '1' : '0');      //[20]
            sb.Append(hardlock.Campanha ? '1' : '0');     //[21]
            sb.Append(hardlock.XFace ? '1' : '0');        //[22]
            sb.Append(hardlock.Broadcast ? '1' : '0');    //[23]
            sb.Append(hardlock.Robot ? '1' : '0');        //[24]
            sb.Append(hardlock.Speech ? '1' : '0');       //[25]
            sb.Append(hardlock.TextToSpeech ? '1' : '0'); //[26]

            sb.Append(Convert.ToChar(hardlock.DTControle.Day));          //[27]
            sb.Append(Convert.ToChar(hardlock.DTControle.Month));        //[28]
            sb.Append(Convert.ToChar(hardlock.DTControle.Year - 2000));  //[29]
            sb.Append(Convert.ToChar(hardlock.DTControle.Hour));         //[30]

            sb.Append(Convert.ToChar(hardlock.DTControle.Hour));         //[31]
            sb.Append(Convert.ToChar(hardlock.DTControle.Day));          //[32]
            sb.Append(Convert.ToChar(hardlock.DTControle.Month));        //[33] 
            sb.Append(Convert.ToChar(hardlock.DTControle.Year - 2000));  //[34] 

            logger.logInfo("#preparaDados - String preparada:[" + sb.ToString() + "]");

            return sb.ToString();

        }

        private string addWhiteSpaces(string str, int tam)
        {
            StringBuilder sb = new StringBuilder(str);
            while (sb.Length < tam) sb.Append(" ");

            return sb.ToString();
        }

        private static string addWhiteSpacesLeft(int spaces, string value)
        {
            if (spaces <= value.Length)
            {
                return value;
            }

            StringBuilder buffer = new StringBuilder();
            int iChange = spaces - value.Length;
            while (buffer.Length < iChange)
            {
                buffer.Append(" ");
            }
            buffer.Append(value);
            return buffer.ToString();
        }

    }

}

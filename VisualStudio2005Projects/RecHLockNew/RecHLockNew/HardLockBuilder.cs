using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace RecHLockNew
{
    class HardLockBuilder
    {

        private HardLock hl;

        public HardLockBuilder()
        {
            hl = new HardLock();
            hl.Valido = true;
            hl.Bloqueado = false;
            hl.DTControle = DateTime.Now;
        }

        public HardLock build()
        {
            return this.hl;
        }

        public HardLockBuilder withVersaHardLock(int versaoHardLock)
        {
            hl.VersaHardLock = versaoHardLock;
            return this;
        }

        public HardLockBuilder withNCanais(int nCanais)
        {
            hl.NCanais = nCanais;
            return this;
        }

        public HardLockBuilder withValidade(DateTime? validade)
        {
            hl.Validade = validade;
            return this;
        }

        public HardLockBuilder withVMajor(int vMajor)
        {
            hl.VMajor = vMajor;
            return this;
        }

        public HardLockBuilder withVMinor(int vMinor)
        {
            hl.VMinor = vMinor;
            return this;
        }

        public HardLockBuilder withNUsers(int nUsers)
        {
            hl.NUsers = nUsers;
            return this;
        }

        public HardLockBuilder withVoiceMail(bool voiceMail)
        {
            hl.VoiceMail = voiceMail;
            return this;
        }

        public HardLockBuilder withFaxMail(bool faxMail)
        {
            hl.FaxMail = faxMail;
            return this;
        }

        public HardLockBuilder withCampanha(bool campanha)
        {
            hl.Campanha = campanha;
            return this;
        }

        public HardLockBuilder withXFace(bool xFace)
        {
            hl.XFace = xFace;
            return this;
        }

        public HardLockBuilder withBroadcast(bool broadcast)
        {
            hl.Broadcast = broadcast;
            return this;
        }

        public HardLockBuilder withRobot(bool robot)
        {
            hl.Robot = robot;
            return this;
        }

        public HardLockBuilder withSpeech(bool speech)
        {
            hl.Speech = speech;
            return this;
        }

        public HardLockBuilder withTextToSpeech(bool textToSpeech)
        {
            hl.TextToSpeech = textToSpeech;
            return this;
        }

        public HardLockBuilder bloqueado()
        {
            hl.Bloqueado = true;
            return this;
        }

        public HardLockBuilder invalido()
        {
            hl.Valido = false;
            return this;
        }
    }
}

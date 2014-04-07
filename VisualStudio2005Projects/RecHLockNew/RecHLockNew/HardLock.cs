using System;
using System.Collections.Generic;
using System.Text;

namespace RecHLockNew
{
    class HardLock
    {
        private bool valido;

        public bool Valido
        {
            get { return valido; }
            set { valido = value; }
        }
        private int versaHardLock;

        public int VersaHardLock
        {
            get { return versaHardLock; }
            set { versaHardLock = value; }
        }
        private int nCanais;

        public int NCanais
        {
            get { return nCanais; }
            set { nCanais = value; }
        }

        private DateTime? validade;

        public DateTime? Validade
        {
            get { return validade; }
            set { validade = value; }
        }

        private int vMajor;

        public int VMajor
        {
            get { return vMajor; }
            set { vMajor = value; }
        }
        private int vMinor;

        public int VMinor
        {
            get { return vMinor; }
            set { vMinor = value; }
        }
        private int nUsers;

        public int NUsers
        {
            get { return nUsers; }
            set { nUsers = value; }
        }
        private bool voiceMail;

        public bool VoiceMail
        {
            get { return voiceMail; }
            set { voiceMail = value; }
        }
        private bool faxMail;

        public bool FaxMail
        {
            get { return faxMail; }
            set { faxMail = value; }
        }
        private bool campanha;

        public bool Campanha
        {
            get { return campanha; }
            set { campanha = value; }
        }
        private bool xFace;

        public bool XFace
        {
            get { return xFace; }
            set { xFace = value; }
        }
        private bool broadcast;

        public bool Broadcast
        {
            get { return broadcast; }
            set { broadcast = value; }
        }
        private bool robot;

        public bool Robot
        {
            get { return robot; }
            set { robot = value; }
        }
        private bool speech;

        public bool Speech
        {
            get { return speech; }
            set { speech = value; }
        }
        private bool textToSpeech;

        public bool TextToSpeech
        {
            get { return textToSpeech; }
            set { textToSpeech = value; }
        }
        private DateTime dTControle;

        public DateTime DTControle
        {
            get { return dTControle; }
            set { dTControle = value; }
        }
        private bool bloqueado;

        public bool Bloqueado
        {
            get { return bloqueado; }
            set { bloqueado = value; }
        }
    }
}

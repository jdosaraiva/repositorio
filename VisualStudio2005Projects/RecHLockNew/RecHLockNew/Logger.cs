using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace RecHLockNew
{
    class Logger
    {
        private static readonly string INFO = "INFO";

        private static readonly string DEBUG = "DEBUG";

        private static readonly string ERROR = "ERROR";

        private static readonly string FATAL = "FATAL";

        private static readonly string WARN = "WARN";

        private StreamWriter arqLog;

        private static string PATH = "RecHLockNew.log";

        private Type tipo;

        public Logger(Type type)
        {
            tipo = type;
        }

        private void open()
        {
            if (!File.Exists(PATH))
            {
                arqLog = File.CreateText(PATH);
            }
            else
            {
                arqLog = File.AppendText(PATH);
            }

        }

        public void log(string tipoLog, Type type, string message)
        {
            open();

            StringBuilder strToLog = new StringBuilder();

            strToLog.Append(DateTime.Now.ToString("dd/MM/yyyy HH:mm:ss,fff"))
                .Append("\t")
                .Append(tipoLog)
                .Append("\t")
                .Append(type.Name)
                .Append(" - ")
                .Append(message);

            arqLog.WriteLine(strToLog.ToString());
            arqLog.Flush();

            arqLog.Close();
        }

        public void logInfo(string message)
        {
            log(INFO, tipo, message);
        }

        public void logDebug(string message)
        {
            log(DEBUG, tipo, message);
        }

        public void logWarn(string message)
        {
            log(WARN, tipo, message);
        }

        public void logError(string message)
        {
            log(ERROR, tipo, message);
        }

        public void logError(string message, Exception excecao)
        {
            StringBuilder mensagemComposta = new StringBuilder(message);
            mensagemComposta.Append(" ");
            mensagemComposta.Append(excecao.ToString());
            mensagemComposta.Append("\n");
            mensagemComposta.Append(excecao.Message);
            log(ERROR, tipo, mensagemComposta.ToString());
        }

        public void logFatal(string message)
        {
            log(FATAL, tipo, message);
        }

        public void logFatal(string message, Exception excecao)
        {
            StringBuilder mensagemComposta = new StringBuilder(message);
            mensagemComposta.Append(" ");
            mensagemComposta.Append(excecao.ToString());
            mensagemComposta.Append("\n");
            mensagemComposta.Append(excecao.Message);
            log(FATAL, tipo, mensagemComposta.ToString());
        }

    }
}

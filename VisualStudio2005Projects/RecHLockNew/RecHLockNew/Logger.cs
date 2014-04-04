using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace RecHLockNew
{
    class Logger
    {
        private StreamWriter log;

        private static string PATH = "RecHLockNew.log";

        private void open()
        {
            if (!File.Exists(PATH))
            {
                log = File.CreateText(PATH);
            }
            else
            {
                log = File.AppendText(PATH);
            }

        }

        public void info(string mensagem)
        {
            open();

            log.WriteLine(DateTime.Now.ToString("dd/MM/yyyy HH:mm:ss,fff") + "\tINFO\t" + mensagem);
            log.Flush();

            log.Close();
        }
    }
}

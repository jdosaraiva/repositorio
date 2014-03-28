using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace RecHLockNew
{
    public partial class FormMain : Form
    {
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

    }
}
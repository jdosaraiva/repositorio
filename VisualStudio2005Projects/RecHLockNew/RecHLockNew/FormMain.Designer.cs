namespace RecHLockNew
{
    partial class FormMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormMain));
            this.panel1 = new System.Windows.Forms.Panel();
            this.chkIlimitado = new System.Windows.Forms.CheckBox();
            this.txtInvalida = new System.Windows.Forms.TextBox();
            this.Calendar = new System.Windows.Forms.MonthCalendar();
            this.panel2 = new System.Windows.Forms.Panel();
            this.txtDTControle = new System.Windows.Forms.TextBox();
            this.btnSair = new System.Windows.Forms.Button();
            this.btnCmdLer = new System.Windows.Forms.Button();
            this.btnCmdWrite = new System.Windows.Forms.Button();
            this.chkTextToSpeech = new System.Windows.Forms.CheckBox();
            this.chkSpeech = new System.Windows.Forms.CheckBox();
            this.chkRobot = new System.Windows.Forms.CheckBox();
            this.chkBroadcast = new System.Windows.Forms.CheckBox();
            this.chkXFace = new System.Windows.Forms.CheckBox();
            this.chkCampanha = new System.Windows.Forms.CheckBox();
            this.chkFaxMail = new System.Windows.Forms.CheckBox();
            this.chkVoiceMail = new System.Windows.Forms.CheckBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.txtNUsers = new System.Windows.Forms.TextBox();
            this.txtVMinor = new System.Windows.Forms.TextBox();
            this.txtVMajor = new System.Windows.Forms.TextBox();
            this.txtNCanais = new System.Windows.Forms.TextBox();
            this.txtVersaoHardLock = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtHardLockValido = new System.Windows.Forms.TextBox();
            this.txtRead = new System.Windows.Forms.TextBox();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel1.Controls.Add(this.chkIlimitado);
            this.panel1.Controls.Add(this.txtInvalida);
            this.panel1.Controls.Add(this.Calendar);
            this.panel1.Location = new System.Drawing.Point(281, 12);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(260, 283);
            this.panel1.TabIndex = 1;
            // 
            // chkIlimitado
            // 
            this.chkIlimitado.AutoSize = true;
            this.chkIlimitado.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.chkIlimitado.Location = new System.Drawing.Point(9, 248);
            this.chkIlimitado.Name = "chkIlimitado";
            this.chkIlimitado.Size = new System.Drawing.Size(78, 21);
            this.chkIlimitado.TabIndex = 0;
            this.chkIlimitado.Text = "Ilimitado";
            this.chkIlimitado.UseVisualStyleBackColor = true;
            this.chkIlimitado.CheckedChanged += new System.EventHandler(this.chkIlimitado_CheckedChanged);
            // 
            // txtInvalida
            // 
            this.txtInvalida.BackColor = System.Drawing.Color.Red;
            this.txtInvalida.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtInvalida.Enabled = false;
            this.txtInvalida.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtInvalida.Location = new System.Drawing.Point(9, 183);
            this.txtInvalida.Name = "txtInvalida";
            this.txtInvalida.ReadOnly = true;
            this.txtInvalida.Size = new System.Drawing.Size(227, 31);
            this.txtInvalida.TabIndex = 1;
            this.txtInvalida.Text = "DATA INVÁLIDA";
            this.txtInvalida.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.txtInvalida.Visible = false;
            // 
            // Calendar
            // 
            this.Calendar.Location = new System.Drawing.Point(9, 9);
            this.Calendar.Name = "Calendar";
            this.Calendar.TabIndex = 1;
            // 
            // panel2
            // 
            this.panel2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel2.Controls.Add(this.txtDTControle);
            this.panel2.Controls.Add(this.btnSair);
            this.panel2.Controls.Add(this.btnCmdLer);
            this.panel2.Controls.Add(this.btnCmdWrite);
            this.panel2.Controls.Add(this.chkTextToSpeech);
            this.panel2.Controls.Add(this.chkSpeech);
            this.panel2.Controls.Add(this.chkRobot);
            this.panel2.Controls.Add(this.chkBroadcast);
            this.panel2.Controls.Add(this.chkXFace);
            this.panel2.Controls.Add(this.chkCampanha);
            this.panel2.Controls.Add(this.chkFaxMail);
            this.panel2.Controls.Add(this.chkVoiceMail);
            this.panel2.Controls.Add(this.label6);
            this.panel2.Controls.Add(this.label5);
            this.panel2.Controls.Add(this.txtNUsers);
            this.panel2.Controls.Add(this.txtVMinor);
            this.panel2.Controls.Add(this.txtVMajor);
            this.panel2.Controls.Add(this.txtNCanais);
            this.panel2.Controls.Add(this.txtVersaoHardLock);
            this.panel2.Controls.Add(this.label4);
            this.panel2.Controls.Add(this.label3);
            this.panel2.Controls.Add(this.label2);
            this.panel2.Controls.Add(this.label7);
            this.panel2.Controls.Add(this.label1);
            this.panel2.Location = new System.Drawing.Point(12, 12);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(260, 283);
            this.panel2.TabIndex = 0;
            // 
            // txtDTControle
            // 
            this.txtDTControle.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.txtDTControle.Enabled = false;
            this.txtDTControle.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtDTControle.Location = new System.Drawing.Point(103, 40);
            this.txtDTControle.Name = "txtDTControle";
            this.txtDTControle.ReadOnly = true;
            this.txtDTControle.Size = new System.Drawing.Size(136, 13);
            this.txtDTControle.TabIndex = 1;
            // 
            // btnSair
            // 
            this.btnSair.Location = new System.Drawing.Point(168, 247);
            this.btnSair.Name = "btnSair";
            this.btnSair.Size = new System.Drawing.Size(60, 23);
            this.btnSair.TabIndex = 17;
            this.btnSair.Text = "&Sair";
            this.btnSair.UseVisualStyleBackColor = true;
            this.btnSair.Click += new System.EventHandler(this.btnSair_Click);
            // 
            // btnCmdLer
            // 
            this.btnCmdLer.Location = new System.Drawing.Point(92, 247);
            this.btnCmdLer.Name = "btnCmdLer";
            this.btnCmdLer.Size = new System.Drawing.Size(60, 23);
            this.btnCmdLer.TabIndex = 16;
            this.btnCmdLer.Text = "&Ler";
            this.btnCmdLer.UseVisualStyleBackColor = true;
            this.btnCmdLer.Click += new System.EventHandler(this.btnCmdLer_Click);
            // 
            // btnCmdWrite
            // 
            this.btnCmdWrite.Location = new System.Drawing.Point(16, 247);
            this.btnCmdWrite.Name = "btnCmdWrite";
            this.btnCmdWrite.Size = new System.Drawing.Size(60, 23);
            this.btnCmdWrite.TabIndex = 15;
            this.btnCmdWrite.Text = "&Gravar";
            this.btnCmdWrite.UseVisualStyleBackColor = true;
            this.btnCmdWrite.Click += new System.EventHandler(this.btnCmdWrite_Click);
            // 
            // chkTextToSpeech
            // 
            this.chkTextToSpeech.AutoSize = true;
            this.chkTextToSpeech.Location = new System.Drawing.Point(154, 212);
            this.chkTextToSpeech.Name = "chkTextToSpeech";
            this.chkTextToSpeech.Size = new System.Drawing.Size(99, 17);
            this.chkTextToSpeech.TabIndex = 14;
            this.chkTextToSpeech.Text = "Text to Speech";
            this.chkTextToSpeech.UseVisualStyleBackColor = true;
            // 
            // chkSpeech
            // 
            this.chkSpeech.AutoSize = true;
            this.chkSpeech.Location = new System.Drawing.Point(16, 212);
            this.chkSpeech.Name = "chkSpeech";
            this.chkSpeech.Size = new System.Drawing.Size(123, 17);
            this.chkSpeech.TabIndex = 13;
            this.chkSpeech.Text = "Speech Recognition";
            this.chkSpeech.UseVisualStyleBackColor = true;
            // 
            // chkRobot
            // 
            this.chkRobot.AutoSize = true;
            this.chkRobot.Location = new System.Drawing.Point(154, 189);
            this.chkRobot.Name = "chkRobot";
            this.chkRobot.Size = new System.Drawing.Size(55, 17);
            this.chkRobot.TabIndex = 12;
            this.chkRobot.Text = "Robot";
            this.chkRobot.UseVisualStyleBackColor = true;
            // 
            // chkBroadcast
            // 
            this.chkBroadcast.AutoSize = true;
            this.chkBroadcast.Location = new System.Drawing.Point(16, 189);
            this.chkBroadcast.Name = "chkBroadcast";
            this.chkBroadcast.Size = new System.Drawing.Size(74, 17);
            this.chkBroadcast.TabIndex = 11;
            this.chkBroadcast.Text = "Broadcast";
            this.chkBroadcast.UseVisualStyleBackColor = true;
            // 
            // chkXFace
            // 
            this.chkXFace.AutoSize = true;
            this.chkXFace.Location = new System.Drawing.Point(154, 166);
            this.chkXFace.Name = "chkXFace";
            this.chkXFace.Size = new System.Drawing.Size(57, 17);
            this.chkXFace.TabIndex = 10;
            this.chkXFace.Text = "XFace";
            this.chkXFace.UseVisualStyleBackColor = true;
            // 
            // chkCampanha
            // 
            this.chkCampanha.AutoSize = true;
            this.chkCampanha.Location = new System.Drawing.Point(16, 166);
            this.chkCampanha.Name = "chkCampanha";
            this.chkCampanha.Size = new System.Drawing.Size(77, 17);
            this.chkCampanha.TabIndex = 9;
            this.chkCampanha.Text = "Campanha";
            this.chkCampanha.UseVisualStyleBackColor = true;
            // 
            // chkFaxMail
            // 
            this.chkFaxMail.AutoSize = true;
            this.chkFaxMail.Location = new System.Drawing.Point(154, 143);
            this.chkFaxMail.Name = "chkFaxMail";
            this.chkFaxMail.Size = new System.Drawing.Size(65, 17);
            this.chkFaxMail.TabIndex = 8;
            this.chkFaxMail.Text = "Fax Mail";
            this.chkFaxMail.UseVisualStyleBackColor = true;
            // 
            // chkVoiceMail
            // 
            this.chkVoiceMail.AutoSize = true;
            this.chkVoiceMail.Location = new System.Drawing.Point(16, 143);
            this.chkVoiceMail.Name = "chkVoiceMail";
            this.chkVoiceMail.Size = new System.Drawing.Size(75, 17);
            this.chkVoiceMail.TabIndex = 7;
            this.chkVoiceMail.Text = "Voice Mail";
            this.chkVoiceMail.UseVisualStyleBackColor = true;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(144, 92);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(10, 13);
            this.label6.TabIndex = 9;
            this.label6.Text = "-";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(145, 118);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 13);
            this.label5.TabIndex = 6;
            this.label5.Text = "X 5 usuários";
            // 
            // txtNUsers
            // 
            this.txtNUsers.Location = new System.Drawing.Point(103, 114);
            this.txtNUsers.MaxLength = 1;
            this.txtNUsers.Name = "txtNUsers";
            this.txtNUsers.Size = new System.Drawing.Size(35, 20);
            this.txtNUsers.TabIndex = 5;
            this.txtNUsers.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.AceitaApenasNumeros_KeyPress);
            // 
            // txtVMinor
            // 
            this.txtVMinor.Location = new System.Drawing.Point(160, 88);
            this.txtVMinor.MaxLength = 1;
            this.txtVMinor.Name = "txtVMinor";
            this.txtVMinor.Size = new System.Drawing.Size(35, 20);
            this.txtVMinor.TabIndex = 4;
            this.txtVMinor.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.AceitaApenasNumeros_KeyPress);
            // 
            // txtVMajor
            // 
            this.txtVMajor.Location = new System.Drawing.Point(103, 88);
            this.txtVMajor.MaxLength = 1;
            this.txtVMajor.Name = "txtVMajor";
            this.txtVMajor.Size = new System.Drawing.Size(35, 20);
            this.txtVMajor.TabIndex = 3;
            this.txtVMajor.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.AceitaApenasNumeros_KeyPress);
            // 
            // txtNCanais
            // 
            this.txtNCanais.Location = new System.Drawing.Point(103, 62);
            this.txtNCanais.MaxLength = 2;
            this.txtNCanais.Name = "txtNCanais";
            this.txtNCanais.Size = new System.Drawing.Size(35, 20);
            this.txtNCanais.TabIndex = 2;
            this.txtNCanais.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.AceitaApenasNumeros_KeyPress);
            // 
            // txtVersaoHardLock
            // 
            this.txtVersaoHardLock.Location = new System.Drawing.Point(103, 10);
            this.txtVersaoHardLock.MaxLength = 1;
            this.txtVersaoHardLock.Name = "txtVersaoHardLock";
            this.txtVersaoHardLock.Size = new System.Drawing.Size(35, 20);
            this.txtVersaoHardLock.TabIndex = 0;
            this.txtVersaoHardLock.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.AceitaApenasNumeros_KeyPress);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(60, 118);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(46, 13);
            this.label4.TabIndex = 3;
            this.label4.Text = "Máximo:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(29, 92);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(77, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Versão Crystal:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(64, 66);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(42, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Canais:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(13, 40);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(90, 13);
            this.label7.TabIndex = 0;
            this.label7.Text = "Data de Controle:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 14);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(93, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Versão HardLock:";
            // 
            // txtHardLockValido
            // 
            this.txtHardLockValido.BackColor = System.Drawing.SystemColors.Control;
            this.txtHardLockValido.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtHardLockValido.Location = new System.Drawing.Point(12, 301);
            this.txtHardLockValido.MaxLength = 100;
            this.txtHardLockValido.Name = "txtHardLockValido";
            this.txtHardLockValido.ReadOnly = true;
            this.txtHardLockValido.Size = new System.Drawing.Size(529, 31);
            this.txtHardLockValido.TabIndex = 2;
            this.txtHardLockValido.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // txtRead
            // 
            this.txtRead.BackColor = System.Drawing.SystemColors.MenuBar;
            this.txtRead.Enabled = false;
            this.txtRead.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtRead.ForeColor = System.Drawing.SystemColors.MenuHighlight;
            this.txtRead.Location = new System.Drawing.Point(12, 338);
            this.txtRead.Multiline = true;
            this.txtRead.Name = "txtRead";
            this.txtRead.ReadOnly = true;
            this.txtRead.Size = new System.Drawing.Size(529, 58);
            this.txtRead.TabIndex = 4;
            // 
            // FormMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(553, 411);
            this.Controls.Add(this.txtRead);
            this.Controls.Add(this.txtHardLockValido);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FormMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Gravador de HardLock";
            this.Load += new System.EventHandler(this.FormMain_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.TextBox txtInvalida;
        private System.Windows.Forms.MonthCalendar Calendar;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtNUsers;
        private System.Windows.Forms.TextBox txtVMajor;
        private System.Windows.Forms.TextBox txtNCanais;
        private System.Windows.Forms.TextBox txtVersaoHardLock;
        private System.Windows.Forms.TextBox txtHardLockValido;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtVMinor;
        private System.Windows.Forms.CheckBox chkXFace;
        private System.Windows.Forms.CheckBox chkCampanha;
        private System.Windows.Forms.CheckBox chkFaxMail;
        private System.Windows.Forms.CheckBox chkVoiceMail;
        private System.Windows.Forms.CheckBox chkTextToSpeech;
        private System.Windows.Forms.CheckBox chkSpeech;
        private System.Windows.Forms.CheckBox chkRobot;
        private System.Windows.Forms.CheckBox chkBroadcast;
        private System.Windows.Forms.Button btnSair;
        private System.Windows.Forms.Button btnCmdLer;
        private System.Windows.Forms.Button btnCmdWrite;
        private System.Windows.Forms.TextBox txtRead;
        private System.Windows.Forms.CheckBox chkIlimitado;
        private System.Windows.Forms.TextBox txtDTControle;
        private System.Windows.Forms.Label label7;
    }
}
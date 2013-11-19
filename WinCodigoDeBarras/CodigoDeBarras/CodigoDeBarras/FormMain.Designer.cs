namespace CodigoDeBarras
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
            this.components = new System.ComponentModel.Container();
            this.LblLinhaDigitavel = new System.Windows.Forms.Label();
            this.TxtCampo1 = new System.Windows.Forms.TextBox();
            this.TxtCampo2 = new System.Windows.Forms.TextBox();
            this.TxtCampo3 = new System.Windows.Forms.TextBox();
            this.TxtCampo4 = new System.Windows.Forms.TextBox();
            this.TxtCampo6 = new System.Windows.Forms.TextBox();
            this.TxtCampo5 = new System.Windows.Forms.TextBox();
            this.TxtDAC = new System.Windows.Forms.TextBox();
            this.TxtCampo8 = new System.Windows.Forms.TextBox();
            this.LblVencimento = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.TxtValor = new System.Windows.Forms.TextBox();
            this.TxtVencimento = new System.Windows.Forms.TextBox();
            this.BtnCalcular = new System.Windows.Forms.Button();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            this.mainMenu1 = new System.Windows.Forms.MainMenu(this.components);
            this.menuItem1 = new System.Windows.Forms.MenuItem();
            this.menuItem2 = new System.Windows.Forms.MenuItem();
            this.menuItem3 = new System.Windows.Forms.MenuItem();
            this.menuItem4 = new System.Windows.Forms.MenuItem();
            this.menuItem5 = new System.Windows.Forms.MenuItem();
            this.BtnLimpar = new System.Windows.Forms.Button();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // LblLinhaDigitavel
            // 
            this.LblLinhaDigitavel.AutoSize = true;
            this.LblLinhaDigitavel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblLinhaDigitavel.Location = new System.Drawing.Point(23, 13);
            this.LblLinhaDigitavel.Name = "LblLinhaDigitavel";
            this.LblLinhaDigitavel.Size = new System.Drawing.Size(96, 13);
            this.LblLinhaDigitavel.TabIndex = 0;
            this.LblLinhaDigitavel.Text = "Linha Digitável:";
            // 
            // TxtCampo1
            // 
            this.TxtCampo1.Location = new System.Drawing.Point(125, 9);
            this.TxtCampo1.MaxLength = 5;
            this.TxtCampo1.Name = "TxtCampo1";
            this.TxtCampo1.Size = new System.Drawing.Size(50, 20);
            this.TxtCampo1.TabIndex = 1;
            this.TxtCampo1.KeyUp += new System.Windows.Forms.KeyEventHandler(this.TxtCampo1_KeyUp);
            this.TxtCampo1.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            // 
            // TxtCampo2
            // 
            this.TxtCampo2.Location = new System.Drawing.Point(181, 9);
            this.TxtCampo2.MaxLength = 5;
            this.TxtCampo2.Name = "TxtCampo2";
            this.TxtCampo2.Size = new System.Drawing.Size(50, 20);
            this.TxtCampo2.TabIndex = 2;
            this.TxtCampo2.KeyUp += new System.Windows.Forms.KeyEventHandler(this.TxtCampo2_KeyUp);
            this.TxtCampo2.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            // 
            // TxtCampo3
            // 
            this.TxtCampo3.Location = new System.Drawing.Point(242, 9);
            this.TxtCampo3.MaxLength = 5;
            this.TxtCampo3.Name = "TxtCampo3";
            this.TxtCampo3.Size = new System.Drawing.Size(50, 20);
            this.TxtCampo3.TabIndex = 3;
            this.TxtCampo3.KeyUp += new System.Windows.Forms.KeyEventHandler(this.TxtCampo3_KeyUp);
            this.TxtCampo3.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            // 
            // TxtCampo4
            // 
            this.TxtCampo4.Location = new System.Drawing.Point(298, 9);
            this.TxtCampo4.MaxLength = 6;
            this.TxtCampo4.Name = "TxtCampo4";
            this.TxtCampo4.Size = new System.Drawing.Size(50, 20);
            this.TxtCampo4.TabIndex = 4;
            this.TxtCampo4.KeyUp += new System.Windows.Forms.KeyEventHandler(this.TxtCampo4_KeyUp);
            this.TxtCampo4.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            // 
            // TxtCampo6
            // 
            this.TxtCampo6.Location = new System.Drawing.Point(415, 9);
            this.TxtCampo6.MaxLength = 6;
            this.TxtCampo6.Name = "TxtCampo6";
            this.TxtCampo6.Size = new System.Drawing.Size(50, 20);
            this.TxtCampo6.TabIndex = 6;
            this.TxtCampo6.KeyUp += new System.Windows.Forms.KeyEventHandler(this.TxtCampo6_KeyUp);
            this.TxtCampo6.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            // 
            // TxtCampo5
            // 
            this.TxtCampo5.Location = new System.Drawing.Point(359, 9);
            this.TxtCampo5.MaxLength = 5;
            this.TxtCampo5.Name = "TxtCampo5";
            this.TxtCampo5.Size = new System.Drawing.Size(50, 20);
            this.TxtCampo5.TabIndex = 5;
            this.TxtCampo5.KeyUp += new System.Windows.Forms.KeyEventHandler(this.TxtCampo5_KeyUp);
            this.TxtCampo5.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            // 
            // TxtDAC
            // 
            this.TxtDAC.Location = new System.Drawing.Point(476, 9);
            this.TxtDAC.MaxLength = 1;
            this.TxtDAC.Name = "TxtDAC";
            this.TxtDAC.Size = new System.Drawing.Size(16, 20);
            this.TxtDAC.TabIndex = 7;
            this.TxtDAC.KeyUp += new System.Windows.Forms.KeyEventHandler(this.TxtDAC_KeyUp);
            this.TxtDAC.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            // 
            // TxtCampo8
            // 
            this.TxtCampo8.Location = new System.Drawing.Point(503, 9);
            this.TxtCampo8.MaxLength = 14;
            this.TxtCampo8.Name = "TxtCampo8";
            this.TxtCampo8.Size = new System.Drawing.Size(96, 20);
            this.TxtCampo8.TabIndex = 8;
            this.TxtCampo8.Leave += new System.EventHandler(this.TxtCampo8_Leave);
            this.TxtCampo8.KeyUp += new System.Windows.Forms.KeyEventHandler(this.TxtCampo8_KeyUp);
            this.TxtCampo8.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            // 
            // LblVencimento
            // 
            this.LblVencimento.AutoSize = true;
            this.LblVencimento.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblVencimento.Location = new System.Drawing.Point(42, 41);
            this.LblVencimento.Name = "LblVencimento";
            this.LblVencimento.Size = new System.Drawing.Size(77, 13);
            this.LblVencimento.TabIndex = 9;
            this.LblVencimento.Text = "Vencimento:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(239, 41);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(87, 13);
            this.label1.TabIndex = 10;
            this.label1.Text = "(dd/mm/aaaa)";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(79, 69);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(40, 13);
            this.label2.TabIndex = 11;
            this.label2.Text = "Valor:";
            // 
            // TxtValor
            // 
            this.TxtValor.Location = new System.Drawing.Point(125, 65);
            this.TxtValor.MaxLength = 13;
            this.TxtValor.Name = "TxtValor";
            this.TxtValor.Size = new System.Drawing.Size(106, 20);
            this.TxtValor.TabIndex = 10;
            this.TxtValor.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            this.TxtValor.KeyDown += new System.Windows.Forms.KeyEventHandler(this.TxtValor_KeyDown);
            // 
            // TxtVencimento
            // 
            this.TxtVencimento.Location = new System.Drawing.Point(125, 37);
            this.TxtVencimento.MaxLength = 10;
            this.TxtVencimento.Name = "TxtVencimento";
            this.TxtVencimento.Size = new System.Drawing.Size(106, 20);
            this.TxtVencimento.TabIndex = 9;
            this.TxtVencimento.Leave += new System.EventHandler(this.TxtVencimento_Leave);
            this.TxtVencimento.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtCampo_KeyPress);
            this.TxtVencimento.KeyDown += new System.Windows.Forms.KeyEventHandler(this.TxtVencimento_KeyDown);
            // 
            // BtnCalcular
            // 
            this.BtnCalcular.Location = new System.Drawing.Point(443, 64);
            this.BtnCalcular.Name = "BtnCalcular";
            this.BtnCalcular.Size = new System.Drawing.Size(75, 23);
            this.BtnCalcular.TabIndex = 11;
            this.BtnCalcular.Text = "&Calcular";
            this.BtnCalcular.UseVisualStyleBackColor = true;
            this.BtnCalcular.Click += new System.EventHandler(this.BtnCalcular_Click);
            // 
            // statusStrip1
            // 
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel1});
            this.statusStrip1.Location = new System.Drawing.Point(0, 105);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(622, 22);
            this.statusStrip1.TabIndex = 12;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(109, 17);
            this.toolStripStatusLabel1.Text = "toolStripStatusLabel1";
            // 
            // mainMenu1
            // 
            this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
            this.menuItem1});
            // 
            // menuItem1
            // 
            this.menuItem1.Index = 0;
            this.menuItem1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
            this.menuItem2,
            this.menuItem3,
            this.menuItem4,
            this.menuItem5});
            this.menuItem1.Text = "&Arquivo";
            // 
            // menuItem2
            // 
            this.menuItem2.Index = 0;
            this.menuItem2.Shortcut = System.Windows.Forms.Shortcut.F2;
            this.menuItem2.Text = "&Calcular";
            this.menuItem2.Click += new System.EventHandler(this.BtnCalcular_Click);
            // 
            // menuItem3
            // 
            this.menuItem3.Index = 1;
            this.menuItem3.Shortcut = System.Windows.Forms.Shortcut.F3;
            this.menuItem3.Text = "&Limpar";
            this.menuItem3.Click += new System.EventHandler(this.menuItem3_Click);
            // 
            // menuItem4
            // 
            this.menuItem4.Index = 2;
            this.menuItem4.Text = "-";
            // 
            // menuItem5
            // 
            this.menuItem5.Index = 3;
            this.menuItem5.Shortcut = System.Windows.Forms.Shortcut.AltF4;
            this.menuItem5.Text = "Sai&r";
            this.menuItem5.Click += new System.EventHandler(this.menuItem5_Click);
            // 
            // BtnLimpar
            // 
            this.BtnLimpar.Location = new System.Drawing.Point(524, 64);
            this.BtnLimpar.Name = "BtnLimpar";
            this.BtnLimpar.Size = new System.Drawing.Size(75, 23);
            this.BtnLimpar.TabIndex = 13;
            this.BtnLimpar.Text = "&Limpar";
            this.BtnLimpar.UseVisualStyleBackColor = true;
            this.BtnLimpar.Click += new System.EventHandler(this.menuItem3_Click);
            // 
            // FormMain
            // 
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None;
            this.ClientSize = new System.Drawing.Size(622, 127);
            this.Controls.Add(this.BtnLimpar);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.BtnCalcular);
            this.Controls.Add(this.TxtValor);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.LblVencimento);
            this.Controls.Add(this.TxtCampo8);
            this.Controls.Add(this.TxtDAC);
            this.Controls.Add(this.TxtCampo6);
            this.Controls.Add(this.TxtCampo5);
            this.Controls.Add(this.TxtCampo4);
            this.Controls.Add(this.TxtCampo3);
            this.Controls.Add(this.TxtCampo2);
            this.Controls.Add(this.TxtVencimento);
            this.Controls.Add(this.TxtCampo1);
            this.Controls.Add(this.LblLinhaDigitavel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Menu = this.mainMenu1;
            this.Name = "FormMain";
            this.Text = "Linha Digitável 0.2";
            this.Load += new System.EventHandler(this.FormMain_Load);
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label LblLinhaDigitavel;
        private System.Windows.Forms.TextBox TxtCampo1;
        private System.Windows.Forms.TextBox TxtCampo2;
        private System.Windows.Forms.TextBox TxtCampo3;
        private System.Windows.Forms.TextBox TxtCampo4;
        private System.Windows.Forms.TextBox TxtCampo6;
        private System.Windows.Forms.TextBox TxtCampo5;
        private System.Windows.Forms.TextBox TxtDAC;
        private System.Windows.Forms.TextBox TxtCampo8;
        private System.Windows.Forms.Label LblVencimento;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox TxtValor;
        private System.Windows.Forms.TextBox TxtVencimento;
        private System.Windows.Forms.Button BtnCalcular;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
        private System.Windows.Forms.MainMenu mainMenu1;
        private System.Windows.Forms.MenuItem menuItem1;
        private System.Windows.Forms.MenuItem menuItem2;
        private System.Windows.Forms.MenuItem menuItem3;
        private System.Windows.Forms.MenuItem menuItem4;
        private System.Windows.Forms.MenuItem menuItem5;
        private System.Windows.Forms.Button BtnLimpar;
    }
}


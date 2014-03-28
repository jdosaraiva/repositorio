namespace RecHLockNew
{
    partial class Form1
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
            this.rdOption1 = new System.Windows.Forms.RadioButton();
            this.rdOption2 = new System.Windows.Forms.RadioButton();
            this.rdOption3 = new System.Windows.Forms.RadioButton();
            this.btnEntrar = new System.Windows.Forms.Button();
            this.grbOptions = new System.Windows.Forms.GroupBox();
            this.grbOptions.SuspendLayout();
            this.SuspendLayout();
            // 
            // rdOption1
            // 
            this.rdOption1.AutoSize = true;
            this.rdOption1.Location = new System.Drawing.Point(5, 17);
            this.rdOption1.Name = "rdOption1";
            this.rdOption1.Size = new System.Drawing.Size(72, 17);
            this.rdOption1.TabIndex = 0;
            this.rdOption1.TabStop = true;
            this.rdOption1.Text = "HardLock";
            this.rdOption1.UseVisualStyleBackColor = true;
            // 
            // rdOption2
            // 
            this.rdOption2.AutoSize = true;
            this.rdOption2.Location = new System.Drawing.Point(6, 41);
            this.rdOption2.Name = "rdOption2";
            this.rdOption2.Size = new System.Drawing.Size(66, 17);
            this.rdOption2.TabIndex = 1;
            this.rdOption2.TabStop = true;
            this.rdOption2.Text = "CP - 500";
            this.rdOption2.UseVisualStyleBackColor = true;
            // 
            // rdOption3
            // 
            this.rdOption3.AutoSize = true;
            this.rdOption3.Location = new System.Drawing.Point(6, 65);
            this.rdOption3.Name = "rdOption3";
            this.rdOption3.Size = new System.Drawing.Size(84, 17);
            this.rdOption3.TabIndex = 2;
            this.rdOption3.TabStop = true;
            this.rdOption3.Text = "FT - Rockey";
            this.rdOption3.UseVisualStyleBackColor = true;
            // 
            // btnEntrar
            // 
            this.btnEntrar.Location = new System.Drawing.Point(80, 119);
            this.btnEntrar.Name = "btnEntrar";
            this.btnEntrar.Size = new System.Drawing.Size(75, 33);
            this.btnEntrar.TabIndex = 1;
            this.btnEntrar.Text = "Entrar";
            this.btnEntrar.UseVisualStyleBackColor = true;
            this.btnEntrar.Click += new System.EventHandler(this.btnEntrar_Click);
            // 
            // grbOptions
            // 
            this.grbOptions.Controls.Add(this.rdOption3);
            this.grbOptions.Controls.Add(this.rdOption2);
            this.grbOptions.Controls.Add(this.rdOption1);
            this.grbOptions.Location = new System.Drawing.Point(12, 12);
            this.grbOptions.Name = "grbOptions";
            this.grbOptions.Size = new System.Drawing.Size(228, 93);
            this.grbOptions.TabIndex = 2;
            this.grbOptions.TabStop = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(253, 164);
            this.Controls.Add(this.grbOptions);
            this.Controls.Add(this.btnEntrar);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "HardLock - CP 500";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.grbOptions.ResumeLayout(false);
            this.grbOptions.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.RadioButton rdOption3;
        private System.Windows.Forms.RadioButton rdOption2;
        private System.Windows.Forms.RadioButton rdOption1;
        private System.Windows.Forms.Button btnEntrar;
        private System.Windows.Forms.GroupBox grbOptions;
    }
}


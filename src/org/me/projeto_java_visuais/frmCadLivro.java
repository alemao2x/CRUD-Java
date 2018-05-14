/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.projeto_java_visuais;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.me.projeto_java.classes.BDConexao;

/**
 *
 * @author JOHNKELVINDOSSANTOSG
 */
public class frmCadLivro extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String caminho = null;
    
    public frmCadLivro() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = BDConexao.bdconexao();
    }
    public void Limpar(){
        txtNomeLivro.setText("Nome do livro");
        txtNomeAutor.setText("Nome do autor");
        txtPreco.setText("Preço");
        txtAdicionais.setText("Sinopse, informações adicionais, etc");
        jLabel1.setIcon(null);
    }

    public void CadastroLivro() throws SQLException{
        String sql = "INSERT INTO livros (nome_livro,nome_autor,preco,informacoes,caminho) VALUES (?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, txtNomeLivro.getText());
            pst.setString(2, txtNomeAutor.getText());
            pst.setDouble(3, Double.parseDouble(txtPreco.getText()));
            pst.setString(4, txtAdicionais.getText());
            pst.setString(5, caminho);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro cadastrado.");
            Limpar();
            
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNomeLivro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAdicionais = new javax.swing.JTextArea();
        btnCadLivro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeAutor = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        btnHome = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("CADASTRO LIVRO"));

        txtNomeLivro.setForeground(new java.awt.Color(153, 153, 153));
        txtNomeLivro.setText("Nome do livro");
        txtNomeLivro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeLivroFocusGained(evt);
            }
        });
        txtNomeLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNomeLivroMousePressed(evt);
            }
        });

        txtAdicionais.setColumns(20);
        txtAdicionais.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtAdicionais.setForeground(new java.awt.Color(153, 153, 153));
        txtAdicionais.setRows(5);
        txtAdicionais.setText("Sinopse, informaçoes adicionais, etc.");
        txtAdicionais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAdicionaisFocusGained(evt);
            }
        });
        txtAdicionais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtAdicionaisMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtAdicionais);

        btnCadLivro.setText("Cadastrar");
        btnCadLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadLivroActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtNomeAutor.setForeground(new java.awt.Color(153, 153, 153));
        txtNomeAutor.setText("Nome do autor");
        txtNomeAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeAutorFocusGained(evt);
            }
        });
        txtNomeAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNomeAutorMousePressed(evt);
            }
        });

        txtPreco.setForeground(new java.awt.Color(153, 153, 153));
        txtPreco.setText("Preço");
        txtPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecoFocusGained(evt);
            }
        });
        txtPreco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPrecoMousePressed(evt);
            }
        });

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/me/image/image/if_home_126572.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel2.setText("Capa 185x272");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                .addComponent(btnCadLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomeAutor)
                            .addComponent(txtNomeLivro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnHome)
                .addGap(11, 11, 11)
                .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCadLivro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeLivroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeLivroMousePressed
        txtNomeLivro.setText("");
        txtNomeLivro.setForeground(Color.BLACK);
        txtNomeLivro.setFont(new Font("Arial", Font.PLAIN, 12));
    }//GEN-LAST:event_txtNomeLivroMousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        
        ImageIcon conteudo = null;
        
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "jpeg", "gif"));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.showDialog(jfc, "Selecione");
        if(JFileChooser.APPROVE_OPTION==0) {
            caminho = jfc.getSelectedFile().toString();
            ImageIcon imagem = new ImageIcon(caminho);
            Image img = null;
            img = imagem.getImage().getScaledInstance(185, 272,img.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(img);
            jLabel1.setIcon(icon);
            
    }
            //JOptionPane.showMessageDialog(null, jfc.getSelectedFile());
         
    }//GEN-LAST:event_jPanel2MousePressed

    private void txtNomeAutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeAutorMousePressed
        txtNomeAutor.setText("");
        txtNomeAutor.setForeground(Color.BLACK);
        txtNomeAutor.setFont(new Font("Arial", Font.PLAIN, 12));
    }//GEN-LAST:event_txtNomeAutorMousePressed

    private void txtPrecoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecoMousePressed
        txtPreco.setText("");
        txtPreco.setForeground(Color.BLACK);
        txtPreco.setFont(new Font("Arial", Font.PLAIN, 12));
    }//GEN-LAST:event_txtPrecoMousePressed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        frmHome proj = null;
        try {
            proj = new frmHome();
        } catch (SQLException ex) {
            Logger.getLogger(frmCadLivro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmCadLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        proj.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCadLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadLivroActionPerformed
        try {
            CadastroLivro();
        } catch (SQLException ex) {
            Logger.getLogger(frmCadLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadLivroActionPerformed

    private void txtAdicionaisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAdicionaisMousePressed
        txtAdicionais.setText("");
        txtAdicionais.setForeground(Color.BLACK);
        txtAdicionais.setFont(new Font("Arial", Font.PLAIN, 12));
    }//GEN-LAST:event_txtAdicionaisMousePressed

    private void txtNomeLivroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeLivroFocusGained
        txtNomeLivro.setText("");
        txtNomeLivro.setForeground(Color.BLACK);
        txtNomeLivro.setFont(new Font("Arial", Font.PLAIN, 12));
    }//GEN-LAST:event_txtNomeLivroFocusGained

    private void txtNomeAutorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeAutorFocusGained
        txtNomeAutor.setText("");
        txtNomeAutor.setForeground(Color.BLACK);
        txtNomeAutor.setFont(new Font("Arial", Font.PLAIN, 12));
    }//GEN-LAST:event_txtNomeAutorFocusGained

    private void txtPrecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoFocusGained
        txtPreco.setText("");
        txtPreco.setForeground(Color.BLACK);
        txtPreco.setFont(new Font("Arial", Font.PLAIN, 12));
    }//GEN-LAST:event_txtPrecoFocusGained

    private void txtAdicionaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAdicionaisFocusGained
        txtAdicionais.setText("");
        txtAdicionais.setForeground(Color.BLACK);
        txtAdicionais.setFont(new Font("Arial", Font.PLAIN, 12));
    }//GEN-LAST:event_txtAdicionaisFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmCadLivro().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmCadLivro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadLivro;
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAdicionais;
    private javax.swing.JTextField txtNomeAutor;
    private javax.swing.JTextField txtNomeLivro;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}

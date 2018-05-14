/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.projeto_java_visuais;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.me.projeto_java.classes.BDConexao;

/**
 *
 * @author JOHNKELVINDOSSANTOSG
 */
public class frmEditarLivro extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    String caminho = null;
    int id;

    public frmEditarLivro() throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        txtID.setText(System.getProperty("livro"));
        id = Integer.parseInt(txtID.getText());
        con = BDConexao.bdconexao();
        preencher();
        txtID.setEditable(false);
    }

    public void preencher() throws SQLException {
        int id = Integer.parseInt(System.getProperty("livro"));
        String titulo = null, autor = null, desc = null;
        Double preco = null;
        Image img = null;
        stm = con.prepareStatement("SELECT * FROM livros WHERE id_livro = ? limit 1");
        stm.setInt(1, id);
        rs = stm.executeQuery();
        while (rs.next()) {
            titulo = rs.getString("nome_livro");
            autor = rs.getString("nome_autor");
            preco = rs.getDouble("preco");
            desc = rs.getString("informacoes");
            caminho = rs.getString("caminho");
        }
        txtAltNome.setText(titulo);
        txtAltAutor.setText(autor);
        txtAltPreco.setText(preco.toString());
        txtAltAdcionais.setText(desc);
        ImageIcon imagem = new ImageIcon(caminho);
        img = imagem.getImage().getScaledInstance(185, 272, img.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(img);
        lblImagem.setIcon(icon);

    }

    public void editarLivro() throws SQLException {
        String sql = "UPDATE livros SET nome_livro = ?,nome_autor = ?,preco = ?,informacoes = ?,caminho = ? WHERE id_livro = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, txtAltNome.getText());
            stm.setString(2, txtAltAutor.getText());
            stm.setDouble(3, Double.parseDouble(txtAltPreco.getText()));
            stm.setString(4, txtAltAdcionais.getText());
            stm.setString(5, caminho);
            stm.setInt(6, id);

            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro editado.");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        txtAltNome = new javax.swing.JTextField();
        txtAltAutor = new javax.swing.JTextField();
        txtAltPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAltAdcionais = new javax.swing.JTextArea();
        btnAlterar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImagem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ALTERAR LIVRO"));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/me/image/image/if_home_126572.png"))); // NOI18N
        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        txtAltNome.setText("Nome do livro");

        txtAltAutor.setText("Nome do autor");

        txtAltPreco.setText("Preço");

        txtAltAdcionais.setColumns(20);
        txtAltAdcionais.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtAltAdcionais.setRows(5);
        txtAltAdcionais.setText("Sinopse, informaçoes adicionais, etc.");
        jScrollPane1.setViewportView(txtAltAdcionais);

        btnAlterar.setText("Alterar");
        btnAlterar.setMaximumSize(new java.awt.Dimension(81, 23));
        btnAlterar.setMinimumSize(new java.awt.Dimension(81, 23));
        btnAlterar.setPreferredSize(new java.awt.Dimension(81, 23));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(93, 2));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel2.setText("Capa 185x272");

        lblID.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnHome)
                        .addComponent(txtAltNome)
                        .addComponent(txtAltAutor)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtAltPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblID)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnHome)
                .addGap(11, 11, 11)
                .addComponent(txtAltNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAltAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAltPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 107, Short.MAX_VALUE))
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

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        ImageIcon conteudo = null;

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "jpeg", "gif"));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.showDialog(jfc, "Selecione");
        if (JFileChooser.APPROVE_OPTION == 0) {
            caminho = jfc.getSelectedFile().toString();
            ImageIcon imagem = new ImageIcon(caminho);
            Image img = null;
            img = imagem.getImage().getScaledInstance(185, 272, img.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(img);
            lblImagem.setIcon(icon);
        }
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            editarLivro();
        } catch (SQLException ex) {
            Logger.getLogger(frmEditarLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        try {
            frmHome home = new frmHome();
            home.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(frmEditarLivro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmEditarLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(frmEditarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEditarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEditarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEditarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmEditarLivro().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmEditarLivro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(frmEditarLivro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTextArea txtAltAdcionais;
    private javax.swing.JTextField txtAltAutor;
    private javax.swing.JTextField txtAltNome;
    private javax.swing.JTextField txtAltPreco;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
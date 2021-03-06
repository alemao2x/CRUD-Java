/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.projeto_java_visuais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Image;
import javax.swing.ImageIcon;
import org.me.projeto_java.classes.BDConexao;

/**
 *
 * @author JOHNKELVINDOSSANTOSG
 */
public class frmLivro extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public frmLivro() throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        preencher();
    }

    public void preencher() throws SQLException {
        int id = Integer.parseInt(System.getProperty("livro"));
        String titulo = null, autor = null, desc = null, caminho = null;
        Double preco = null;
        Image img = null;
        try {
            con = BDConexao.bdconexao();
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
            lblTitulo1.setText(titulo);
            lblAutor1.setText(autor);
            lblPreco1.setText(preco.toString());
            lblDesc1.setText(desc);
            ImageIcon imagem = new ImageIcon(caminho);
            img = imagem.getImage().getScaledInstance(185, 272,img.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(img);
            lblImage.setIcon(icon);
        } catch (ClassNotFoundException ex) {
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
        slblNomeLivro = new javax.swing.JLabel();
        slblAutor = new javax.swing.JLabel();
        slblPreco = new javax.swing.JLabel();
        slbldescricao = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        lblAutor1 = new javax.swing.JLabel();
        lblPreco1 = new javax.swing.JLabel();
        lblDesc1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        slblNomeLivro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        slblNomeLivro.setText("Título do livro");

        slblAutor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        slblAutor.setText("Autor do livro");

        slblPreco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        slblPreco.setText("Preço");

        slbldescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        slbldescricao.setText("Descrição");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );

        lblTitulo1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTitulo1.setText("jLabel2");

        lblAutor1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAutor1.setText("jLabel3");

        lblPreco1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPreco1.setText("jLabel4");

        lblDesc1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDesc1.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slblNomeLivro)
                    .addComponent(slblPreco)
                    .addComponent(slbldescricao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc1)
                    .addComponent(lblPreco1)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slblNomeLivro)
                            .addComponent(lblTitulo1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slblAutor)
                            .addComponent(lblAutor1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slblPreco)
                            .addComponent(lblPreco1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slbldescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDesc1))))
                .addContainerGap(155, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(frmLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmLivro().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmLivro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(frmLivro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAutor1;
    private javax.swing.JLabel lblDesc1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPreco1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel slblAutor;
    private javax.swing.JLabel slblNomeLivro;
    private javax.swing.JLabel slblPreco;
    private javax.swing.JLabel slbldescricao;
    // End of variables declaration//GEN-END:variables
}

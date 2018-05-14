/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.projeto_java.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian
 */
public class Livro {
    int id;
    String nome_livro, nome_autor, informacoes;
    double preco;
    private Connection con = null;

    public Livro() throws ClassNotFoundException {
        con = new BDConexao().bdconexao();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public List<Livro> read() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement stm = null;
            stm = con.prepareStatement("select * from livros");
            
            rs = stm.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id_livro"));
                livro.setNome_livro(rs.getString("nome_livro"));
                livro.setNome_autor(rs.getString("nome_autor"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setInformacoes(rs.getString("informacoes"));
                livros.add(livro);
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fodeu");
        }
        return livros;
    }
    public List<Livro> readForDesc(String desc) throws SQLException {
        List<Livro> livros = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement stm = null;
            stm = con.prepareStatement("select * from livros where nome_livro like ?");
            stm.setString(1, "%"+desc+"%");
            rs = stm.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id_livro"));
                livro.setNome_livro(rs.getString("nome_livro"));
                livro.setNome_autor(rs.getString("nome_autor"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setInformacoes(rs.getString("informacoes"));
                livros.add(livro);
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fodeu");
        }
        return livros;
    }
}

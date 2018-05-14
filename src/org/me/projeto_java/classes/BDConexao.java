package org.me.projeto_java.classes;
import java.sql.*;
import javax.swing.JOptionPane;
public class BDConexao {
    
   public static Connection bdconexao() throws ClassNotFoundException{
       try{
           Class.forName("org.postgresql.Driver");
           Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto","postgres","postgres");
           return con;
       }
       catch(SQLException error){
           JOptionPane.showMessageDialog(null, error);
           
           
           return null;
       }
   }
}

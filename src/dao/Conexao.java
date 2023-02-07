//Conexão da tela de login
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexao {
    private Connection con = null;
    
    public Connection ConexaoDAO(){
        try{
            String url = "jdbc:sqlite:C://Pi/dados/db_usuario.db";
            con = DriverManager.getConnection(url);
                       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + erro.getMessage());
        }
        return con;    
    
    }
    
}
        
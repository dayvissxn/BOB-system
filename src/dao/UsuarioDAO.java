
package dao;

import dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
        

public class UsuarioDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
        
    public ResultSet usuarioAutenticacao(UsuarioDTO usuarioDTO)
    {
        con = new Conexao().ConexaoDAO();
        String sql = "SELECT usuarioLogin, usuarioSenha FROM usuario WHERE usuarioLogin = ? AND usuarioSenha = ?";
        try {
             ps = con.prepareStatement(sql);
             ps.setString(1, usuarioDTO.getUsuarioLogin());
             ps.setString(2, usuarioDTO.getUsuarioSenha());
             rs = ps.executeQuery();
             return rs;
             
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro na classe UsuarioDAO: " + erro.getMessage());
            return null;           
        }
    }

    
}

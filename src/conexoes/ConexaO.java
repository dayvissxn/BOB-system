//Conexão da tela de perfil
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaO {
    
    private static Connection conexao;
    public ConexaO()
    { try
        {
            
Class.forName("org.sqlite.JDBC");
String url = "jdbc:sqlite:C://Pi/dados/db_usuario.db";
            
            conexao = DriverManager.getConnection(url);
            System.out.println("conexao ok");
            //JOptionPane.showMessageDialog(null,"conexao ok");
            
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null, 
           "Ocorreu um erro de conexão. Verifique a Base de Dados indicada !"+"\n" +  erro.getMessage(),"Conexão",3);
            erro.printStackTrace();
        }
        
    
}
// Metodos publicos:
    public Connection getConexao()
    {
        return conexao;
    }
    

}

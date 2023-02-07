
package dao;

import conexoes.ConexaO;
import dto.ModelPerfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PesquisarDAO {
    public ModelPerfil Pesquisar(int cod) throws SQLException
    {
     ModelPerfil objpes = new ModelPerfil();
     
        ConexaO conexao = new ConexaO();
        PreparedStatement pstmt =
        conexao.getConexao().prepareStatement(
        "SELECT * FROM perfil where codigo = ?");
        pstmt.setInt(1,cod);
        
        ResultSet rs = pstmt.executeQuery();
        objpes = null;
        if (rs.next()){
            objpes = new ModelPerfil();
            
             objpes.setCodigo(rs.getInt("codigo"));
             objpes.setNome(rs.getString("nome").trim());
             objpes.setProficao(rs.getString("proficao").trim());
             objpes.setEmail(rs.getString("email").trim());
             objpes.setCurso1(rs.getString("curso1").trim());
             objpes.setCurso2(rs.getString("curso2").trim());
             objpes.setCurso3(rs.getString("curso3").trim());
             objpes.setCurso4(rs.getString("curso4").trim());
             objpes.setIdade(rs.getString("idade").trim());
             objpes.setEstadocivil(rs.getString("estadocivil").trim());
             objpes.setEndereco(rs.getString("endereco").trim());
             objpes.setCidade(rs.getString("cidade").trim());
             objpes.setEstado(rs.getString("estado").trim());
             objpes.setTelefone(rs.getString("telefone").trim());
                          
         }
          pstmt.close();
        return objpes;
    }
    
}

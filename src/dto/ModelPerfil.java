
package dto;

public class ModelPerfil {
    private int codigo;
    private String nome;
    private String proficao;
    private String email;
    private String curso1;
    private String curso2;
    private String curso3;
    private String curso4;
    private String idade;
    private String estadocivil;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;
    
    public ModelPerfil() {
    }
    
    
    public ModelPerfil(int codigo, String nome, String proficao, String email, String curso1, String curso2, String curso3,
            String curso4, String idade, String estadocivil, String endereco, String cidade, String estado, String telefone) 
    {
        this.codigo = codigo;
        this.nome = nome;
        this.proficao = proficao;
        this.email = email;
        this.curso1 = curso1;
        this.curso2 = curso2;
        this.curso3 = curso3;
        this.curso4 = curso4;
        this.idade = idade;
        this.estadocivil = estadocivil;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
    }
 
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProficao() {
        return proficao;
    }

    public void setProficao(String proficao) {
        this.proficao = proficao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso1() {
        return curso1;
    }

    public void setCurso1(String curso1) {
        this.curso1 = curso1;
    }

    public String getCurso2() {
        return curso2;
    }

    public void setCurso2(String curso2) {
        this.curso2 = curso2;
    }

    public String getCurso3() {
        return curso3;
    }

    public void setCurso3(String curso3) {
        this.curso3 = curso3;
    }

    public String getCurso4() {
        return curso4;
    }

    public void setCurso4(String curso4) {
        this.curso4 = curso4;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
       
}

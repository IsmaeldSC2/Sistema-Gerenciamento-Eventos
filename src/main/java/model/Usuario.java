package model;

public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private String tipoUsuario;
    private String dataCadastro;

    public Usuario() {}

    public Usuario(String nome, String email, String telefone,
                   String tipoUsuario, String dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
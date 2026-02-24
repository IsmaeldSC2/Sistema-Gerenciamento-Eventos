package model;

public class Avaliacao {

    private String emailUsuario;
    private String nomeEvento;
    private int nota;
    private String comentario;
    private String dataAvaliacao;

    public Avaliacao() {
    }

    public Avaliacao(String emailUsuario, String nomeEvento,
                     int nota, String comentario, String dataAvaliacao) {
        this.emailUsuario = emailUsuario;
        this.nomeEvento = nomeEvento;
        this.nota = nota;
        this.comentario = comentario;
        this.dataAvaliacao = dataAvaliacao;
    }

    // Getters
    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    // Setters
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
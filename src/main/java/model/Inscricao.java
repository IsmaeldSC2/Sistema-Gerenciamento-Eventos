package model;

public class Inscricao {

    private String emailUsuario;
    private String nomeEvento;
    private String dataInscricao;
    private String status;
    private boolean checkIn;

    // Construtor vazio
    public Inscricao() {
    }

    // Construtor principal
    public Inscricao(String emailUsuario, String nomeEvento, String dataInscricao) {
        this.emailUsuario = emailUsuario;
        this.nomeEvento = nomeEvento;
        this.dataInscricao = dataInscricao;
        this.status = "PENDENTE";
        this.checkIn = false;
    }

    // Getters
    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public String getDataInscricao() {
        return dataInscricao;
    }

    public String getStatus() {
        return status;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    // Setters
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }
}
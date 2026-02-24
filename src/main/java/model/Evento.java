package model;

public class Evento {

    private String nome;
    private String tipo;
    private String descricao;
    private String data;
    private String local;
    private int capacidade;
    private String organizador;

    // Construtor completo
    public Evento(String nome, String tipo, String descricao,
                  String data, String local, int capacidade,
                  String organizador) {

        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.organizador = organizador;
    }

    // Construtor vazio (importante para DAO)
    public Evento() {}

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public String getDescricao() { return descricao; }
    public String getData() { return data; }
    public String getLocal() { return local; }
    public int getCapacidade() { return capacidade; }
    public String getOrganizador() { return organizador; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setData(String data) { this.data = data; }
    public void setLocal(String local) { this.local = local; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }
    public void setOrganizador(String organizador) { this.organizador = organizador; }
}
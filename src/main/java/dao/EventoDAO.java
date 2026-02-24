package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Evento;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    private final MongoCollection<Document> collection;

    public EventoDAO() {

        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("gerenciamento_eventos");
        this.collection = database.getCollection("eventos");
    }

    // ================= INSERIR =================
    public void inserir(Evento evento) {

        Document doc = new Document("nome", evento.getNome())
                .append("tipo", evento.getTipo())
                .append("descricao", evento.getDescricao())
                .append("data", evento.getData())
                .append("local", evento.getLocal())
                .append("capacidade", evento.getCapacidade())
                .append("organizador", evento.getOrganizador());

        collection.insertOne(doc);
    }

    // ================= LISTAR TODOS =================
    public List<Evento> listarEventos() {

        List<Evento> lista = new ArrayList<>();

        for (Document doc : collection.find()) {

            Evento evento = new Evento(
                    doc.getString("nome"),
                    doc.getString("tipo"),
                    doc.getString("descricao"),
                    doc.getString("data"),
                    doc.getString("local"),
                    doc.getInteger("capacidade"),
                    doc.getString("organizador")
            );

            lista.add(evento);
        }

        return lista;
    }

    // ================= BUSCAR POR NOME =================
    public Evento buscarPorNome(String nome) {

        Document doc = collection.find(new Document("nome", nome)).first();

        if (doc == null) return null;

        return new Evento(
                doc.getString("nome"),
                doc.getString("tipo"),
                doc.getString("descricao"),
                doc.getString("data"),
                doc.getString("local"),
                doc.getInteger("capacidade"),
                doc.getString("organizador")
        );
    }

    // ================= REMOVER =================
    public void remover(String nome) {
        collection.deleteOne(new Document("nome", nome));
    }

    // ================= ATUALIZAR =================
    public void atualizar(String nome, String novoLocal, int novaCapacidade) {

        Document filtro = new Document("nome", nome);

        Document atualizacao = new Document("$set",
                new Document("local", novoLocal)
                        .append("capacidade", novaCapacidade)
        );

        collection.updateOne(filtro, atualizacao);
    }
}
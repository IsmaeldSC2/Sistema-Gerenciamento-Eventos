package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import conexao.MongoConnection;
import model.Inscricao;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class InscricaoDAO {

    private final MongoCollection<Document> collection;

    public InscricaoDAO() {
        MongoDatabase database = MongoConnection.getDatabase();
        this.collection = database.getCollection("inscricoes");
    }

    // ================= CREATE =================
    public void inserir(Inscricao inscricao) {

        Document doc = new Document()
                .append("emailUsuario", inscricao.getEmailUsuario())
                .append("nomeEvento", inscricao.getNomeEvento())
                .append("dataInscricao", inscricao.getDataInscricao())
                .append("status", inscricao.getStatus());

        collection.insertOne(doc);
    }

    // ================= READ =================
    public List<Inscricao> listarPorEvento(String nomeEvento) {

        List<Inscricao> inscricoes = new ArrayList<>();

        for (Document doc : collection.find(Filters.eq("nomeEvento", nomeEvento))) {

            Inscricao i = new Inscricao();
            i.setEmailUsuario(doc.getString("emailUsuario"));
            i.setNomeEvento(doc.getString("nomeEvento"));
            i.setDataInscricao(doc.getString("dataInscricao"));
            i.setStatus(doc.getString("status"));

            inscricoes.add(i);
        }

        return inscricoes;
    }

    public List<Inscricao> listarPorUsuario(String emailUsuario) {

        List<Inscricao> inscricoes = new ArrayList<>();

        for (Document doc : collection.find(Filters.eq("emailUsuario", emailUsuario))) {

            Inscricao i = new Inscricao();
            i.setEmailUsuario(doc.getString("emailUsuario"));
            i.setNomeEvento(doc.getString("nomeEvento"));
            i.setDataInscricao(doc.getString("dataInscricao"));
            i.setStatus(doc.getString("status"));

            inscricoes.add(i);
        }

        return inscricoes;
    }

    public List<Inscricao> listarPorStatus(String status) {

        List<Inscricao> inscricoes = new ArrayList<>();

        for (Document doc : collection.find(Filters.eq("status", status))) {

            Inscricao i = new Inscricao();
            i.setEmailUsuario(doc.getString("emailUsuario"));
            i.setNomeEvento(doc.getString("nomeEvento"));
            i.setDataInscricao(doc.getString("dataInscricao"));
            i.setStatus(doc.getString("status"));

            inscricoes.add(i);
        }

        return inscricoes;
    }

    // ================= UPDATE =================
    public void atualizarStatus(String emailUsuario, String nomeEvento, String novoStatus) {

        collection.updateOne(
                Filters.and(
                        Filters.eq("emailUsuario", emailUsuario),
                        Filters.eq("nomeEvento", nomeEvento)
                ),
                Updates.set("status", novoStatus)
        );
    }

    // ================= DELETE =================
    public void remover(String emailUsuario, String nomeEvento) {

        collection.deleteOne(
                Filters.and(
                        Filters.eq("emailUsuario", emailUsuario),
                        Filters.eq("nomeEvento", nomeEvento)
                )
        );
    }

    // ================= CONSULTAS AUXILIARES =================

    public List<String> listarParticipantesPorEvento(String nomeEvento) {

        List<String> participantes = new ArrayList<>();

        for (Document doc : collection.find(Filters.eq("nomeEvento", nomeEvento))) {
            participantes.add(doc.getString("emailUsuario"));
        }

        return participantes;
    }

    public List<String> listarEventosPorUsuario(String emailUsuario) {

        List<String> eventos = new ArrayList<>();

        for (Document doc : collection.find(Filters.eq("emailUsuario", emailUsuario))) {
            eventos.add(doc.getString("nomeEvento"));
        }

        return eventos;
    }

    public long contarInscritosPorEvento(String nomeEvento) {

        return collection.countDocuments(
                Filters.eq("nomeEvento", nomeEvento)
        );
    }

    public List<Document> listarInscricoesPendentes() {

        List<Document> pendentes = new ArrayList<>();

        for (Document doc : collection.find(Filters.eq("status", "PENDENTE"))) {
            pendentes.add(doc);
        }

        return pendentes;
    }

    // ================= MÉDIA DE AVALIAÇÕES =================
    public double calcularMediaPorEvento(String nomeEvento) {

        MongoCollection<Document> avaliacoes =
                MongoConnection.getDatabase().getCollection("avaliacoes");

        int soma = 0;
        int total = 0;

        for (Document doc : avaliacoes.find(Filters.eq("nomeEvento", nomeEvento))) {
            soma += doc.getInteger("nota");
            total++;
        }

        return total == 0 ? 0 : (double) soma / total;
    }
}
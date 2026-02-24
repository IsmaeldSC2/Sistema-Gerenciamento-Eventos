package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexao.MongoConnection;
import model.Avaliacao;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {

    private MongoCollection<Document> collection;

    public AvaliacaoDAO() {
        this.collection = MongoConnection
                .getDatabase()
                .getCollection("avaliacoes");
    }

    // CREATE
    public void inserir(Avaliacao avaliacao) {
        Document doc = new Document("emailUsuario", avaliacao.getEmailUsuario())
                .append("nomeEvento", avaliacao.getNomeEvento())
                .append("nota", avaliacao.getNota())
                .append("comentario", avaliacao.getComentario())
                .append("dataAvaliacao", avaliacao.getDataAvaliacao());

        collection.insertOne(doc);
    }

    // READ - listar todas
    public List<Avaliacao> listarTodas() {
        List<Avaliacao> avaliacoes = new ArrayList<>();

        for (Document doc : collection.find()) {
            Avaliacao a = new Avaliacao(
                    doc.getString("emailUsuario"),
                    doc.getString("nomeEvento"),
                    doc.getInteger("nota"),
                    doc.getString("comentario"),
                    doc.getString("dataAvaliacao")
            );
            avaliacoes.add(a);
        }

        return avaliacoes;
    }

    // READ - buscar por evento
    public List<Avaliacao> buscarPorEvento(String nomeEvento) {
        List<Avaliacao> avaliacoes = new ArrayList<>();

        for (Document doc : collection.find(Filters.eq("nomeEvento", nomeEvento))) {
            Avaliacao a = new Avaliacao(
                    doc.getString("emailUsuario"),
                    doc.getString("nomeEvento"),
                    doc.getInteger("nota"),
                    doc.getString("comentario"),
                    doc.getString("dataAvaliacao")
            );
            avaliacoes.add(a);
        }

        return avaliacoes;
    }

    // DELETE
    public void remover(String emailUsuario, String nomeEvento) {
        collection.deleteOne(
                Filters.and(
                        Filters.eq("emailUsuario", emailUsuario),
                        Filters.eq("nomeEvento", nomeEvento)
                )
        );
    }
}

package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import conexao.MongoConnection;
import model.Usuario;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private final MongoCollection<Document> collection;

    public UsuarioDAO() {
        MongoDatabase database = MongoConnection.getDatabase();
        this.collection = database.getCollection("usuarios");
    }

    // ================= CREATE =================
    public void inserir(Usuario usuario) {

        Document doc = new Document("nome", usuario.getNome())
                .append("email", usuario.getEmail())
                .append("telefone", usuario.getTelefone())
                .append("tipoUsuario", usuario.getTipoUsuario())
                .append("dataCadastro", usuario.getDataCadastro());

        collection.insertOne(doc);
    }

    // ================= READ - LISTAR TODOS =================
    public List<Usuario> listarTodos() {

        List<Usuario> usuarios = new ArrayList<>();

        for (Document doc : collection.find()) {

            Usuario usuario = new Usuario();
            usuario.setNome(doc.getString("nome"));
            usuario.setEmail(doc.getString("email"));
            usuario.setTelefone(doc.getString("telefone"));
            usuario.setTipoUsuario(doc.getString("tipoUsuario"));
            usuario.setDataCadastro(doc.getString("dataCadastro"));

            usuarios.add(usuario);
        }

        return usuarios;
    }

    // ================= READ - BUSCAR POR EMAIL =================
    public Usuario buscarPorEmail(String email) {

        Document doc = collection.find(Filters.eq("email", email)).first();

        if (doc == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setNome(doc.getString("nome"));
        usuario.setEmail(doc.getString("email"));
        usuario.setTelefone(doc.getString("telefone"));
        usuario.setTipoUsuario(doc.getString("tipoUsuario"));
        usuario.setDataCadastro(doc.getString("dataCadastro"));

        return usuario;
    }

    // ================= UPDATE =================
    public void atualizar(String email, String novoNome,
                          String novoTelefone, String novoTipoUsuario) {

        collection.updateOne(
                Filters.eq("email", email),
                Updates.combine(
                        Updates.set("nome", novoNome),
                        Updates.set("telefone", novoTelefone),
                        Updates.set("tipoUsuario", novoTipoUsuario)
                )
        );
    }

    // ================= DELETE =================
    public void remover(String email) {
        collection.deleteOne(Filters.eq("email", email));
    }
}
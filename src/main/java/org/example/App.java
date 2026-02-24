package org.example;

import static spark.Spark.*;

import dao.UsuarioDAO;
import dao.EventoDAO;
import dao.InscricaoDAO;

import model.Usuario;
import model.Evento;
import model.Inscricao;

import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) {

        port(4567);

        // ================= HOME =================
        get("/", (req, res) -> """
            <h1>Sistema de Gerenciamento de Eventos</h1>
            <ul>
                <li><a href="/usuarios/cadastrar">Cadastrar Usuário</a></li>
                <li><a href="/evento">Cadastrar Evento</a></li>
                <li><a href="/inscricao">Realizar Inscrição</a></li>
                <li><a href="/usuarios">Listar Usuários</a></li>
                <li><a href="/usuarios/atualizar">Atualizar Usuário</a></li>
                <li><a href="/usuarios/remover">Remover Usuário</a></li>
                <li><a href="/inscricoes/atualizar-status">Atualizar Status</a></li>
                <li><a href="/consultas">Consultas</a></li>
            </ul>
        """);

        // ================= USUARIO - CADASTRO =================
        get("/usuarios/cadastrar", (req, res) -> """
            <h1>Cadastrar Usuário</h1>
            <form method='post' action='/usuarios/cadastrar'>
                Nome: <input name='nome'/><br>
                Email: <input name='email'/><br>
                Telefone: <input name='telefone'/><br>
                Tipo: <input name='tipoUsuario'/><br>
                Data Cadastro: <input name='dataCadastro'/><br>
                <button type='submit'>Cadastrar</button>
            </form>
            <br><a href='/'>Voltar</a>
        """);

        post("/usuarios/cadastrar", (req, res) -> {

            Usuario usuario = new Usuario(
                    req.queryParams("nome"),
                    req.queryParams("email"),
                    req.queryParams("telefone"),
                    req.queryParams("tipoUsuario"),
                    req.queryParams("dataCadastro")
            );

            new UsuarioDAO().inserir(usuario);

            return "<h2>Usuário cadastrado com sucesso!</h2><a href='/'>Voltar</a>";
        });

        // ================= LISTAR USUARIOS =================
        get("/usuarios", (req, res) -> {

            List<Usuario> usuarios = new UsuarioDAO().listarTodos();

            StringBuilder html = new StringBuilder("<h1>Lista de Usuários</h1>");

            for (Usuario u : usuarios) {
                html.append("<p>")
                        .append("Nome: ").append(u.getNome()).append("<br>")
                        .append("Email: ").append(u.getEmail()).append("<br>")
                        .append("Telefone: ").append(u.getTelefone()).append("<br>")
                        .append("Tipo: ").append(u.getTipoUsuario()).append("<br>")
                        .append("Data Cadastro: ").append(u.getDataCadastro())
                        .append("</p><hr>");
            }

            html.append("<br><a href='/'>Voltar</a>");
            return html.toString();
        });

        // ================= ATUALIZAR USUARIO =================
        get("/usuarios/atualizar", (req, res) -> """
            <h1>Atualizar Usuário</h1>
            <form method='post' action='/usuarios/atualizar'>
                Email: <input name='email'/><br>
                Novo Nome: <input name='nome'/><br>
                Novo Telefone: <input name='telefone'/><br>
                Novo Tipo: <input name='tipoUsuario'/><br>
                <button type='submit'>Atualizar</button>
            </form>
            <br><a href='/'>Voltar</a>
        """);

        post("/usuarios/atualizar", (req, res) -> {

            new UsuarioDAO().atualizar(
                    req.queryParams("email"),
                    req.queryParams("nome"),
                    req.queryParams("telefone"),
                    req.queryParams("tipoUsuario")
            );

            return "<h2>Usuário atualizado com sucesso!</h2><a href='/'>Voltar</a>";
        });

        // ================= REMOVER USUARIO =================
        get("/usuarios/remover", (req, res) -> """
            <h1>Remover Usuário</h1>
            <form method='post' action='/usuarios/remover'>
                Email: <input name='email'/><br>
                <button type='submit'>Remover</button>
            </form>
            <br><a href='/'>Voltar</a>
        """);

        post("/usuarios/remover", (req, res) -> {
            new UsuarioDAO().remover(req.queryParams("email"));
            return "<h2>Usuário removido com sucesso!</h2><a href='/'>Voltar</a>";
        });

        // ================= EVENTO =================
        get("/evento", (req, res) -> """
            <h2>Cadastrar Evento</h2>
            <form method="post" action="/evento">
                Nome: <input name="nome"><br><br>
                Tipo: <input name="tipo"><br><br>
                Descrição: <input name="descricao"><br><br>
                Data: <input type="date" name="data"><br><br>
                Local: <input name="local"><br><br>
                Capacidade: <input type="number" name="capacidade"><br><br>
                Organizador: <input name="organizador"><br><br>
                <button type="submit">Cadastrar</button>
            </form>
            <br><a href="/">Voltar</a>
        """);

        post("/evento", (req, res) -> {

            Evento evento = new Evento(
                    req.queryParams("nome"),
                    req.queryParams("tipo"),
                    req.queryParams("descricao"),
                    req.queryParams("data"),
                    req.queryParams("local"),
                    Integer.parseInt(req.queryParams("capacidade")),
                    req.queryParams("organizador")
            );

            new EventoDAO().inserir(evento);

            return "<h3>Evento cadastrado com sucesso!</h3><a href='/'>Voltar</a>";
        });

        // ================= INSCRICAO =================
        get("/inscricao", (req, res) -> """
            <h2>Realizar Inscrição</h2>
            <form method="post" action="/inscricao">
                Email do Usuário: <input name="emailUsuario"><br><br>
                Nome do Evento: <input name="nomeEvento"><br><br>
                <button type="submit">Inscrever</button>
            </form>
            <br><a href="/">Voltar</a>
        """);

        post("/inscricao", (req, res) -> {

            Inscricao inscricao = new Inscricao(
                    req.queryParams("emailUsuario"),
                    req.queryParams("nomeEvento"),
                    LocalDate.now().toString()
            );

            new InscricaoDAO().inserir(inscricao);

            return "<h3>Inscrição realizada com sucesso!</h3><a href='/'>Voltar</a>";
        });

        // ================= ATUALIZAR STATUS INSCRIÇÃO =================
        get("/inscricoes/atualizar-status", (req, res) -> """
    <h1>Atualizar Status da Inscrição</h1>
    <form method='post' action='/inscricoes/atualizar-status'>
        Email do Usuário: <input name='email'/><br><br>
        Nome do Evento: <input name='evento'/><br><br>
        Novo Status:
        <select name='status'>
            <option value='PENDENTE'>PENDENTE</option>
            <option value='CONFIRMADA'>CONFIRMADA</option>
            <option value='CANCELADA'>CANCELADA</option>
        </select><br><br>
        <button type='submit'>Atualizar</button>
    </form>
    <br><a href='/'>Voltar</a>
""");

        post("/inscricoes/atualizar-status", (req, res) -> {

            new InscricaoDAO().atualizarStatus(
                    req.queryParams("email"),
                    req.queryParams("evento"),
                    req.queryParams("status")
            );

            return "<h2>Status atualizado com sucesso!</h2><a href='/'>Voltar</a>";
        });

        // ================= CONSULTAS =================
        get("/consultas", (req, res) -> """
            <h2>Consultas</h2>
            <ul>
                <li><a href="/consultas/eventos">Listar Eventos</a></li>
                <li><a href="/consultas/inscricoes-pendentes">Inscrições Pendentes</a></li>
                <li><a href="/consultas/participantes-form">Participantes por Evento</a></li>
                <li><a href="/consultas/contar-inscritos">Contar Inscritos</a></li>
            </ul>
            <br><a href="/">Voltar</a>
        """);

        get("/consultas/eventos", (req, res) -> {

            StringBuilder html = new StringBuilder("<h2>Eventos</h2><ul>");

            new EventoDAO().listarEventos().forEach(evento ->
                    html.append("<li>").append(evento.getNome()).append("</li>")
            );

            html.append("</ul><br><a href='/consultas'>Voltar</a>");
            return html.toString();
        });

        get("/consultas/inscricoes-pendentes", (req, res) -> {

            StringBuilder html = new StringBuilder("<h2>Inscrições Pendentes</h2><ul>");

            new InscricaoDAO().listarInscricoesPendentes().forEach(doc ->
                    html.append("<li>")
                            .append("Usuário: ").append(doc.getString("emailUsuario"))
                            .append(" | Evento: ").append(doc.getString("nomeEvento"))
                            .append("</li>")
            );

            html.append("</ul><br><a href='/consultas'>Voltar</a>");
            return html.toString();
        });

        get("/consultas/participantes-form", (req, res) -> """
            <h2>Buscar Participantes</h2>
            <form method="get" action="/consultas/participantes">
                Nome do Evento: <input name="evento">
                <button type="submit">Buscar</button>
            </form>
            <br><a href="/consultas">Voltar</a>
        """);

        get("/consultas/participantes", (req, res) -> {

            String nomeEvento = req.queryParams("evento");
            List<String> participantes =
                    new InscricaoDAO().listarParticipantesPorEvento(nomeEvento);

            StringBuilder html = new StringBuilder(
                    "<h2>Participantes do evento: " + nomeEvento + "</h2><ul>");

            if (participantes.isEmpty()) {
                html.append("<li>Nenhum participante encontrado</li>");
            } else {
                participantes.forEach(p -> html.append("<li>").append(p).append("</li>"));
            }

            html.append("</ul><br><a href='/consultas'>Voltar</a>");
            return html.toString();
        });

        get("/consultas/contar-inscritos", (req, res) -> """
            <h2>Contar Inscritos</h2>
            <form method="post" action="/consultas/contar-inscritos">
                Nome do Evento: <input name="evento">
                <button type="submit">Contar</button>
            </form>
            <br><a href="/consultas">Voltar</a>
        """);

        post("/consultas/contar-inscritos", (req, res) -> {

            long total = new InscricaoDAO()
                    .contarInscritosPorEvento(req.queryParams("evento"));

            return "<h2>Total de inscritos: " + total + "</h2><a href='/consultas'>Voltar</a>";
        });

    }
}
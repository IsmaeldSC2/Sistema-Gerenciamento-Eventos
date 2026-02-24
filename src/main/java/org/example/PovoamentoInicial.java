package org.example;

import dao.UsuarioDAO;
import dao.EventoDAO;
import dao.InscricaoDAO;

import model.Usuario;
import model.Evento;
import model.Inscricao;

import java.time.LocalDate;

public class PovoamentoInicial {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        EventoDAO eventoDAO = new EventoDAO();
        InscricaoDAO inscricaoDAO = new InscricaoDAO();

        // ================= USUÁRIOS =================
        usuarioDAO.inserir(new Usuario(
                "Carlos",
                "carlos@email.com",
                "31999999999",
                "ADMIN",
                LocalDate.now().toString()
        ));

        usuarioDAO.inserir(new Usuario(
                "Maria",
                "maria@email.com",
                "31988888888",
                "PARTICIPANTE",
                LocalDate.now().toString()
        ));

        usuarioDAO.inserir(new Usuario(
                "Carolina",
                "carolina@email.com",
                "31977777777",
                "PALESTRANTE",
                LocalDate.now().toString()
        ));

        // ================= EVENTOS =================
        eventoDAO.inserir(new Evento(
                "Java Conference",
                "Tecnologia",
                "Evento sobre Java e boas práticas",
                "2026-03-10",
                "Auditório Central",
                100,
                "Carlos"
        ));

        eventoDAO.inserir(new Evento(
                "Workshop MongoDB",
                "Banco de Dados",
                "Workshop prático de MongoDB",
                "2026-04-05",
                "Sala 101",
                50,
                "Carolina"
        ));

        // ================= INSCRIÇÕES =================
        inscricaoDAO.inserir(new Inscricao(
                "maria@email.com",
                "Java Conference",
                LocalDate.now().toString()
        ));

        inscricaoDAO.inserir(new Inscricao(
                "maria@email.com",
                "Workshop MongoDB",
                LocalDate.now().toString()
        ));

        inscricaoDAO.inserir(new Inscricao(
                "carolina@email.com",
                "Java Conference",
                LocalDate.now().toString()
        ));

        System.out.println("Povoamento realizado com sucesso!");
    }
}
import dao.AvaliacaoDAO;
import dao.EventoDAO;
import dao.InscricaoDAO;
import dao.UsuarioDAO;
import model.Avaliacao;
import model.Evento;
import model.Inscricao;
import model.Usuario;

public class Main {

    public static void main(String[] args) {

        AvaliacaoDAO dao = new AvaliacaoDAO();

        Avaliacao a = new Avaliacao(
                "ismael@email.com",
                "Semana de Tecnologia",
                5,
                "Evento excelente, bem organizado!",
                "2026-01-27"
        );

        dao.inserir(a);

            System.out.println("Inscrição realizada com sucesso!");
        }


}

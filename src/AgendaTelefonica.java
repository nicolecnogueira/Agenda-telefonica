import java.util.HashMap;
import java.util.Map;

public class AgendaTelefonica implements Agenda {
    private Map<String, Contato> contatosPorEmail;
    private Map<String, Contato> contatosPorNome;

    public AgendaTelefonica() {
        contatosPorEmail = new HashMap<>();
        contatosPorNome = new HashMap<>();
    }

    @Override
    public void salvar(Contato contato) {
        // Remover o contato anterior se o e-mail ou o nome já existir
        if (contatosPorEmail.containsKey(contato.getEmail())) {
            Contato contatoAntigo = contatosPorEmail.get(contato.getEmail());
            contatosPorNome.remove(contatoAntigo.getNome());
        }
        if (contatosPorNome.containsKey(contato.getNome())) {
            Contato contatoAntigo = contatosPorNome.get(contato.getNome());
            contatosPorEmail.remove(contatoAntigo.getEmail());
        }

        // Adicionar o novo contato
        contatosPorEmail.put(contato.getEmail(), contato);
        contatosPorNome.put(contato.getNome(), contato);
    }

    @Override
    public Contato buscarPorEmail(String email) {
        return contatosPorEmail.get(email);
    }

    @Override
    public Contato buscarPorNome(String nome) {
        return contatosPorNome.get(nome);
    }
}

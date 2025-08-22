
import br.com.minhaestante.dao.LivroDAO;
import br.com.minhaestante.model.Livro;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instanciamos o DAO, que é nosso acesso ao "banco de dados"
        LivroDAO livroDAO = new LivroDAO();

        System.out.println("--- 1. INSERINDO LIVROS ---");
        Livro livro1 = new Livro("Duna", "Aleph", 1965, "Disponível");
        Livro livro2 = new Livro("O Senhor dos Anéis", "HarperCollins", 1954, "Disponível");
        livroDAO.salvar(livro1);
        livroDAO.salvar(livro2);

        System.out.println("\n--- 2. LISTANDO TODOS OS LIVROS ---");
        List<Livro> livros = livroDAO.listarTodos();
        for (Livro livro : livros) {
            System.out.println(livro);
        }

        System.out.println("\n--- 3. BUSCANDO UM LIVRO ESPECÍFICO ---");
        Livro livroEncontrado = livroDAO.buscarPorId(1); // Busca "Duna"
        System.out.println("Livro encontrado: " + livroEncontrado);

        System.out.println("\n--- 4. ATUALIZANDO UM LIVRO ---");
        if (livroEncontrado != null) {
            livroEncontrado.setStatus("Emprestado");
            livroDAO.salvar(livroEncontrado); // O método salvar também serve para atualizar
        }
        System.out.println("Livro após atualização: " + livroDAO.buscarPorId(1));
        
        System.out.println("\n--- 5. DELETANDO UM LIVRO ---");
        livroDAO.deletar(2); // Deleta "O Senhor dos Anéis"
        
        System.out.println("\n--- 6. LISTANDO NOVAMENTE PARA VER O RESULTADO ---");
        livros = livroDAO.listarTodos();
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}

package br.com.minhaestante.dao; 

import br.com.minhaestante.model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LivroDAO {
    private static final List<Livro> bancoDeDados = new ArrayList<>();
    private static final AtomicInteger sequence = new AtomicInteger(1);

    public void salvar(Livro livro) {
        if (livro.getId() == 0) {
            livro.setId(sequence.getAndIncrement());
            bancoDeDados.add(livro);
            System.out.println("DAO: Livro '" + livro.getTitulo() + "' salvo com o ID " + livro.getId());
        } else {
            for (int i = 0; i < bancoDeDados.size(); i++) {
                if (bancoDeDados.get(i).getId() == livro.getId()) {
                    bancoDeDados.set(i, livro);
                    System.out.println("DAO: Livro '" + livro.getTitulo() + "' atualizado.");
                    break;
                }
            }
        }
    }

    public Livro buscarPorId(int id) {
        for (Livro livro : bancoDeDados) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> listarTodos() {
        return new ArrayList<>(bancoDeDados);
    }

    public void deletar(int id) {
        bancoDeDados.removeIf(livro -> livro.getId() == id);
        System.out.println("DAO: Livro com ID " + id + " deletado.");
    }
}
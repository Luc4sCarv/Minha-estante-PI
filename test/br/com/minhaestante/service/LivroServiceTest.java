package br.com.minhaestante.service;

import br.com.minhaestante.model.Livro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LivroServiceTest {

    private LivroService livroService;

    @Before
    public void setUp() {
        // Roda antes de cada teste, garantindo uma instância limpa
        livroService = new LivroService();
    }

    @Test
    public void testIsVintage_LivroAntigo_DeveRetornarTrue() {
        // Arrange (Organizar): Crie um livro com mais de 50 anos
        Livro livroAntigo = new Livro("O Senhor dos Anéis", "HarperCollins", 1954, "Disponível");

        // Act (Agir): Chame o método que queremos testar
        boolean resultado = livroService.isVintage(livroAntigo);

        // Assert (Verificar): Verifique se o resultado é o esperado
        Assert.assertTrue("Um livro de 1954 deveria ser considerado vintage.", resultado);
    }

    @Test
    public void testIsVintage_LivroRecente_DeveRetornarFalse() {
        // Arrange: Crie um livro recente
        Livro livroRecente = new Livro("Projeto Hail Mary", "Rocco", 2021, "Disponível");

        // Act: Chame o método
        boolean resultado = livroService.isVintage(livroRecente);

        // Assert: Verifique se o resultado é falso
        Assert.assertFalse("Um livro de 2021 não deveria ser considerado vintage.", resultado);
    }
}
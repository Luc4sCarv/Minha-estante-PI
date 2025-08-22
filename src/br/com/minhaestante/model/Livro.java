
package br.com.minhaestante.model;

public class Livro {
    private int id;
    private String titulo;
    private String editora;
    private int anoPublicacao;
    private String status;

    
    public Livro() {}


    public Livro(String titulo, String editora, int anoPublicacao, String status) {
        this.titulo = titulo;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.status = status;
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo='" + titulo + '\'' + ", status='" + status + '\'' + '}';
    }
}
package br.edu.ulbra.biblioteca;

/**
 * Representa um Livro, estendendo as funcionalidades básicas de MediaItem.
 */
public class Book extends MediaItem {
    private String author; // Corrigi o nome da variável para 'author'
    private String isbn;

    // CONSTRUTOR
    // Deve chamar o construtor da superclasse (MediaItem) usando 'super()'
    public Book(int id, String title, int year, int totalCopies, String author, String isbn) {
        super(id, title, year, totalCopies); // Chama o construtor de MediaItem
        this.author = author;
        this.isbn = isbn;
    }

    // Getters para atributos específicos de Book
    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
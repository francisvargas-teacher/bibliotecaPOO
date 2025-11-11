package br.edu.ulbra.biblioteca;

/**
 * Classe base abstrata para todos os itens de mídia da biblioteca.
 * Contém a lógica de controle de cópias.
 */
public abstract class MediaItem {
    // Usando 'protected' para permitir acesso direto pelas classes filhas (como Book)
    protected int id;
    protected String title;
    protected int year;
    protected int totalCopies;
    protected int availableCopies;

    // CONSTRUTOR: Essencial para inicializar todos os atributos
    public MediaItem(int id, String title, int year, int totalCopies) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies; // Inicialmente, todas as cópias estão disponíveis
    }

    /**
     * Tenta emprestar uma cópia do item.
     * @return true se o empréstimo for bem-sucedido, false caso contrário.
     */
    public boolean borrow() {
        if (availableCopies > 0) {
            availableCopies--;
            System.out.println("SUCESSO: Uma cópia de '" + title + "' foi emprestada.");
            System.out.println("Disponíveis restantes: " + availableCopies);
            return true;
        } else {
            System.out.println("ERRO: Todas as " + totalCopies + " cópias de '" + title + "' estão emprestadas.");
            return false;
        }
    }

    /**
     * Recebe uma cópia do item de volta.
     * @return true se a devolução for bem-sucedida, false caso contrário.
     */
    public boolean returnItem() {
        if (availableCopies < totalCopies) {
            availableCopies++;
            System.out.println("SUCESSO: Uma cópia de '" + title + "' foi devolvida.");
            System.out.println("Disponíveis agora: " + availableCopies);
            return true;
        } else {
            // Isso só deve acontecer se houver um erro de lógica na aplicação
            System.out.println("AVISO: A devolução não foi registrada. O total de cópias (" + totalCopies + ") já está no máximo.");
            return false;
        }
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
}
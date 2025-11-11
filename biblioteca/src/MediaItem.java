import java.util.Date;

public abstract class MediaItem {
    public String id;
    public String title;
    public int year;
    public int totalCopies;
    public int availableCopies;

    public void borrow() {
        System.out.println("Seu aluguél começou no dia " + Date);
    }
    public void returnItem () {
        System.out.println("Você dever devolve-lo no dia " + Date);

    }

}
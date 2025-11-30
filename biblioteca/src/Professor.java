import java.util.Random;
import br.edu.ulbra.biblioteca.MediaItem; 

// Representa um Professor da faculdade.Estende a classe abstrata Member, implementando os métodos
public class Professor extends Member {
    private String departamento; 

    // Construtor: Chama o construtor da superclasse Member
    // O construtor da superclasse Member não foi fornecido, mas assumimos que é o padrão ou que os setters serão usados para simplificar, focaremos apenas nos métodos
    public Professor(int id, String name, String email, String departamento) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = true;
        this.penalty = 0;
        this.departamento = departamento;
        this.random = new Random();
    }

    // Getters e Setters específicos do Professor
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Professores têm maior tolerância. @return true se não houver multa ou multa for menor que 30 dias.
    @Override
    public boolean canBorrow() {
        if (this.penalty > 30) {
            System.out.println("Membro com Penalidade Alta (" + this.penalty + " dias). Empréstimo Negado.");
            return false;
        }
        System.out.println("Professor pode emprestar (Penalidade atual: " + this.penalty + " dias).");
        return true;
    }

    // Multa menor do que a aplicada ao Student (ex: 1-5 dias).
    @Override
    protected void addPenalty() {
        int randomPenalty = random.nextInt(1, 5);
        penalty += randomPenalty;
        System.out.println("Penalidade adicionada ao Professor " + name + ": " + randomPenalty + " dias. Total: " + penalty + " dias.");
    }

    // Limpa Penalidade
    @Override
    protected void clearPenalty() {
        penalty = 0;
        System.out.println("Penalidade do Professor " + name + " foi zerada.");
    }

    // Assumimos que o Professor tem 30 dias de prazo padrão, independentemente do item.
    @Override
    public void loadDaysFor(MediaItem item) {
        System.out.println("Professor tem prazo fixo de 30 dias para " + item.getTitle() + ".");
    }
}
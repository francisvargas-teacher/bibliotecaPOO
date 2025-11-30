// Classe de teste unitário manual para a entidade Professor. Verifica a Herança (Member) e o Polimorfismo (regras diferentes de Student).
public class TestProfessor {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Testes da Classe Professor ---");

        // 1. Teste de Instanciação e Herança (id, name, email são de Member)
        Professor prof = new Professor(200, "Dr. Almeida", "almeida@ulbra.edu.br", "Ciências da Computação");
        
        System.out.println("\n[1] Verificação Básica:");
        if (prof.getDepartamento().equals("Ciências da Computação") && prof.penalty == 0) {
             System.out.println("Sucesso: Professor instanciado e atributos OK.");
        } else {
             System.err.println("Falha: Instanciação ou Herança falhou.");
        }

        // 2. Teste de Polimorfismo: canBorrow() e addPenalty()
        System.out.println("\n[2] Teste de Empréstimo e Penalidade:");
        
        // Deve ser true inicialmente
        if (prof.canBorrow()) {
            System.out.println("Sucesso: Professor pode emprestar sem multa.");
        } else {
            System.err.println("Falha: Professor não deveria ter empréstimo negado.");
        }

        // Aplicar penalidade e verificar
        prof.addPenalty(); 
        System.out.println("Penalidade após primeira infração: " + prof.penalty);
        
        // Aplicar penalidade várias vezes para testar o limite
        for(int i = 0; i < 7; i++) {
            prof.addPenalty(); 
        }

        System.out.println("Penalidade Acumulada (deve ser <= 30): " + prof.penalty);
        
        // 3. Teste de Limite (canBorrow() falha se multa > 30)
        // Tentamos forçar a falha
        if (prof.penalty > 30) {
            System.out.println("Tentativa de empréstimo com penalidade acima do limite (30 dias)...");
            if (!prof.canBorrow()) {
                 System.out.println("Sucesso: Empréstimo negado corretamente para penalidade alta.");
            } else {
                 System.err.println("Falha: Empréstimo deveria ter sido negado com penalidade alta.");
            }
        }
        
        // 4. Teste clearPenalty()
        System.out.println("\n[4] Teste de Limpeza de Penalidade:");
        prof.clearPenalty();
        if (prof.penalty == 0) {
             System.out.println("Sucesso: Penalidade zerada.");
        } else {
             System.err.println("Falha: Penalidade não foi zerada.");
        }

        System.out.println("\n--- Testes Concluídos ---");
    }
}
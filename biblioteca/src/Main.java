import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int randomInt = random.nextInt(1,10);
        System.out.println(randomInt);
    }
}
import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        Random rand = new Random();

        
        int numero = rand.nextInt(10) + 1;

        System.out.println("Número aleatorio generado: " + numero);
    }
}

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void mostrarBienvenida() {
        System.out.println("---------------------------------------------------");
        System.out.println("Bienvenido al juego de adivinar el número!");
        System.out.println("Debes adivinar un numero aleatorio entre 1 y 100");
    }

    public static void mostrarMenuDificultad() {
        System.out.println("-----------------------------------");
        System.out.println("Introduce el nivel de dificultad");
        System.out.println("1. Facil");
        System.out.println("2. Medio");
        System.out.println("3. Dificil");
        System.out.println("-----------------------------------");

    }
    public static void jugar(){
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();
        boolean salir = false;
        mostrarBienvenida();
        while (!salir) {

            boolean acertado = false;
            int contador = 0, numJugador, intentosJugador = 0;


            int numAdivinar = aleatorio.nextInt(0, 100);
            mostrarMenuDificultad();

            int dificultad = teclado.nextInt();

            while (dificultad < 0 || dificultad >= 4) {
                System.out.println("Opcion no valida!");
                mostrarMenuDificultad();
                dificultad = teclado.nextInt();
            }
            switch (dificultad) {
                case 1:
                    System.out.println("Perfecto! Has elegido la dificultad: Facil");
                    contador = 10;
                    break;
                case 2:
                    System.out.println("Perfecto! Has elegido la dificultad: Medio");
                    contador = 5;
                    break;
                case 3:
                    System.out.println("Perfecto! Has elegido la dificultad: Dificil");
                    contador = 3;
                    break;
            }

            while (!acertado && contador > 0) {
                System.out.println("Elige un numero (Entre 1 - 100):");
                numJugador = teclado.nextInt();
                if (numJugador == numAdivinar) {
                    System.out.println("FELICIDADES!! Has acertado el número oculto");
                    System.out.println("Necesitaste " + (intentosJugador + 1) + " intentos");
                    acertado = true;

                } else if (numJugador > numAdivinar) {
                    System.out.println("Incorrecto! El numero a adivinar es menor que " + numJugador);
                    contador -= 1;
                    System.out.println("Te quedan " + contador + " intentos");
                    intentosJugador += 1;
                } else if (numJugador < numAdivinar) {
                    System.out.println("Incorrecto! El numero a adivinar es mayor que " + numJugador);
                    contador -= 1;
                    System.out.println("Te quedan " + contador + " intentos");
                    intentosJugador += 1;
                }


            }
            if(!acertado || contador == 0){
                System.out.println("El número oculto era: " + numAdivinar);

            }
            System.out.println("------------------------");
            System.out.println("Quieres seguir jugando?");
            System.out.println("(JUGAR DE NUEVO - 1)");
            System.out.println("(SALIR  - 0)");

            int respuesta = teclado.nextInt();
            if (respuesta == 0) {
                System.out.println("Saliendo del programa...");
                salir = true;

            }
        }
    }

    public static void main(String[] args) {

        jugar();

    }
}
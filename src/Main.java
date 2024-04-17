import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al increíble y turbo dinámico 'Tres en Raya Hipersport 2024'");

            while(true) {
            System.out.println("Por favor seleccione que desea hacer:");
            System.out.println(" 1.Nueva Partida \n 2.Cargar Partida \n 3.Configuración\n 4.Salir\n");


                String input = sc.nextLine();
                switch (input) {
                    case "1":
                        //Nueva partida
                        System.out.println("Su selección ha sido: Nueva partida");
                        break;
                    case "2":
                        //Cargar partida
                        System.out.println("Su selección ha sido: Cargar partida");
                        break;
                    case "3":
                        //Configuración
                        System.out.println("Su selección ha sido: Configuración");
                        break;
                    case "4":
                        //Finalizar
                        System.out.println("¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Ha habido un error con el input. Prueba de nuevo");
                        break;
                }
            }
    }
}

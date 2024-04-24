import java.util.Scanner;

public class TUI {
    public static short seleccion() {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch (input) {
            case "1":
                //Nueva partida
                return 1;
            case "2":
                //Cargar partida
                return 2;
            case "3":
                //Configuración
                return 3;
            case "4":
                //Finalizar
                return 4;
            default:
                return 5;
        }
    }

    public static void menu() {
        bucle:
        while (true) {
            System.out.println("Por favor seleccione que desea hacer:");
            System.out.println(" 1.Nueva Partida \n 2.Cargar Partida \n 3.Configuración\n 4.Salir\n");
            switch (seleccion()) {
                case 1:
                    //Nueva partida
                    System.out.println("Su selección ha sido: Nueva partida");
                    Main.nueva_partida();
                    break;
                case 2:
                    //Cargar partida
                    System.out.println("Su selección ha sido: Cargar partida");
                    Main.cargar_partida();
                    break;
                case 3:
                    //Configuración
                    System.out.println("Su selección ha sido: Configuración");
                    Main.congiguracion();
                    break;
                case 4:
                    //Finalizar
                    System.out.println("¡Hasta pronto!\n");
                    break bucle;
                default:
                    System.out.println("Ha habido un error con el input. Prueba de nuevo\n");
            }
        }
    }
}

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
    public static void menu(){
        switch (seleccion()){
            case 1:
                //Nueva partida
                System.out.println("Su selección ha sido: Nueva partida");
                break;
            case 2:
                //Cargar partida
                System.out.println("Su selección ha sido: Cargar partida");
                break;
            case 3:
                //Configuración
                System.out.println("Su selección ha sido: Configuración");
                break;
            case 4:
                //Finalizar
                System.out.println("¡Hasta pronto!");
                break;
            default:
                System.out.println("Ha habido un error con el input. Prueba de nuevo");
        }
    }
}

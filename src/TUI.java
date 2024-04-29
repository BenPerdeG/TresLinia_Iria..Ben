import java.util.Scanner;

public class TUI {
    public static short seleccion() {
    //Selección de menú
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

    public void menu() {
        System.out.println("Bienvenido al increíble y turbo dinámico 'Tres en Raya Hipersport 2024'");
        System.out.println("-----------------------------------------------------------------------");
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

    public static boolean jugada_inicial(int fila, int columna) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Comience la partida, juega con: 'o'. \n Ingrese su jugada en formato coordenada (fila columna)");
        try {
            while(true){
            return jugar_partida(sc);}

        } catch (Exception e) {
            System.out.println("Error de coordenadas. El formato es Fila 'espacio' Columna");
            return false;
        }
    }

    private static boolean jugar_partida(Scanner sc) {
        int fila;
        int columna;
        fila = sc.nextInt();
        columna = sc.nextInt();

        boolean fila_correcta = (0 < fila) && (fila < 4);
        boolean col_correcta = (0 < columna) && (columna < 4);

        if (!fila_correcta) {
            System.out.println("La coordenada de la fila es incorrecta, inténtelo de nuevo");
            return false;
        } else if (!col_correcta) {
            System.out.println("La coordenada de la columna es incorrecta, inténtelo de nuevo");
            return false;
        } else System.out.println("La posición de su ficha es: " + fila + " " + columna);

        if (Joc.turno_jugador1){
            Joc.jugarO(fila,columna);
            Joc.alternar_turno();
        }
        else {
            Joc.jugarX(fila,columna);
            Joc.alternar_turno();
        }

        return true;
    }
}

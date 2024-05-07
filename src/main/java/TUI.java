import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//TODAS LAS ENTRADAS Y SALIDAS DE INFORMACIÓN

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
                    Main.configuracion();
                    break;
                case 4:
                    //Finalizar
                    System.out.println("¡Hasta pronto!\n");
                    break bucle;
                default:
                    System.out.println("Ha habido un error con el input. Prueba de nuevo: \n");
            }
        }
    }

    //INICIAR JUEGO
    public static boolean jugada_inicial() {
        System.out.println("Comienza la partida, jugador 1 con: 'o'. \n Ingrese su jugada en formato coordenada (fila columna)");
        try {
            Joc.tablero_nuevo();
            while (!Joc.tablero_completo()) {
                //jugar_partida();

                if (Joc.jugada_ganadora() == 'X') {
                    System.out.println("El ganador es el jugador 1");
                } else if (Joc.jugada_ganadora() == 'O') {
                    System.out.println("El ganador es el jugador 1");
                }
            }

        } catch (Exception e) {
            System.out.println("Error de coordenadas. El formato es Fila 'espacio' Columna");
            return false;
        }


        //DESARROLLO DEL JUEGO
        static void jugar_partida() {
            Scanner sc = new Scanner(System.in);
            int fila = sc.nextInt();
            int columna = sc.nextInt();

            boolean fila_correcta = (0 < fila) && (fila < 4);
            boolean col_correcta = (0 < columna) && (columna < 4);

            try {
                if (!fila_correcta) {
                    System.out.println("La coordenada de la fila es incorrecta, inténtelo de nuevo: ");

                } else if (!col_correcta) {
                    System.out.println("La coordenada de la columna es incorrecta, inténtelo de nuevo: ");
                } else System.out.println("La posición de su ficha es: " + fila + " " + columna);

                if (Joc.turno_jugador1) {
                    Joc.jugarO(fila, columna);
                } else {
                    Joc.jugarX(fila, columna);
                }
            } catch (Exception f) {
                System.out.println("Error");
                Joc.tablero_actual = Joc.tablero_nuevo();
                Joc.turno_jugador1 = true;
            }
        }
    }

    public static void createConfig(){
        File config = new File("config.txt");
        try {
            FileWriter esc = new FileWriter("config.txt");
            Scanner sc = new Scanner(System.in);
            int _1 = sc.nextInt();
            int _2 = sc.nextInt();
            esc.write(_1);
            esc.write(_2);
            esc.close();
        } catch (IOException e) {
            throw new RuntimeException("Error de Configuración");
        }
    }
    public static void readConfig(){
        Scanner leer = new Scanner("config.txt");

        Joc.filas=leer.nextInt();
        Joc.columnas=leer.nextInt();
        leer.close();
    }
}
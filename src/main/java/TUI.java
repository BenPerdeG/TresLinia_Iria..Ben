
import java.util.Scanner;

//TODAS LAS ENTRADAS Y SALIDAS DE INFORMACIÓN

public class TUI {
    public void mostraMisstage(String missatge) {
        System.out.println(missatge);
    }

    public short seleccion() {
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

    public short mostrarMenu() {
        System.out.println("Bienvenido al increíble y turbo dinámico 'Tres en Raya Hipersport 2024'");
        System.out.println("-----------------------------------------------------------------------");

        while (true) {
            System.out.println("Por favor seleccione que desea hacer:");
            System.out.println(" 1.Nueva Partida \n 2.Cargar Partida \n 3.Configuración\n 4.Salir\n");
            return seleccion();
        }
    }

    char [][] tablero;
    int filas;
    int columnas;



    public  void mostrarTablero(char [][] tablero_actual){
        for (int i =0;i<filas;i++){
            for (int j =0;j<columnas;j++){
                System.out.print("|"+ tablero_actual[i][j]+"|");
            }
            System.out.println();
        }
    }



    public boolean jugada_inicial(int fila, int columna) {
        System.out.println("Comienza la partida, jugador 1 con: 'x'. \n Ingrese su jugada en formato coordenada (fila columna)");
        try {
            while (true) {
                jugar_partida();
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error de coordenadas. El formato es Fila 'espacio' Columna");
            return false;
        }
    }


    //DESARROLLO DEL JUEGO
    void jugar_partida() {
        Scanner sc = new Scanner(System.in);
        Joc joc = new Joc();
        int fila = sc.nextInt();
        int columna = sc.nextInt();

        boolean fila_correcta = (0 < fila) && (fila < 4);
        boolean col_correcta = (0 < columna) && (columna < 4);

        try {
            if (!fila_correcta || !col_correcta) {
                System.out.println("La coordenada de la fila o columna, es incorrecta, inténtelo de nuevo: ");
            } else {
                System.out.println("La posición de su ficha es: " + fila + " " + columna);
            }
            boolean jugada_valida;

            if (joc.turnoJugador1) {
                //turno del jugador 1, usa JugarX
                jugada_valida = joc.jugarX(fila, columna);
            } else {
                //turno del jugador 2, usa JugarO
                jugada_valida = joc.jugarO(fila, columna);
            }

            if (jugada_valida) {
                char ganador = joc.jugada_ganadora();
                if (ganador != ' ') {
                } else if (joc.tablero_completo()) {

                }
            }
            joc.final_partida();

        } catch (Exception f) {
            System.out.println("Error");
            joc.tablero_actual = joc.tablero_nuevo();
            joc.turnoJugador1 = true;
        }
    }


    /* public void createConfig() {
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

    public static void readConfig() {
        Scanner leer = new Scanner("config.txt");


        joc.filas = leer.nextInt();
        joc.columnas = leer.nextInt();
        leer.close();
    }*/


}
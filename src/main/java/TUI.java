
import java.util.Scanner;

//TODAS LAS ENTRADAS Y SALIDAS DE INFORMACIÓN

public class TUI {
    Scanner sc = new Scanner(System.in);
int filaJugador;
int columnaJugador;
    public void mostrarMensaje(String missatge) {

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

   public void coordenadas(Scanner sc) {
        filaJugador= sc.nextInt();
        columnaJugador = sc.nextInt();
   }

    public  void mostrarTablero(char [][] tablero_actual, int filas, int columnas){
        for (int i =0;i<filas;i++){
            for (int j =0;j<columnas;j++){
                System.out.print("|"+ tablero_actual[i][j]+"|");
            }
            System.out.println();
        }
    }



    public void jugada_inicial(int fila, int columna) {
        System.out.println("Comienza la partida, jugador 1 con: 'x'. \n Ingrese su jugada en formato coordenada (fila columna)");
    }


    //DESARROLLO DEL JUEGO
    void recorrerPartida() {

        coordenadas(sc);
        boolean fila_correcta = (0 < filaJugador) && (filaJugador < 4);
        boolean col_correcta = (0 < columnaJugador) && (columnaJugador < 4);


            if (!fila_correcta || !col_correcta) {
                System.out.println("La coordenada de la fila o columna, es incorrecta, inténtelo de nuevo: ");
            } else {
                System.out.println("La posición de su ficha es: " + filaJugador + " " + columnaJugador);
            }

    }
    //FINALIZAR JUEGO
    public void finalPartida(char ganador, boolean tablero_completo) {

        if (ganador != ' ') {  // Verifica si hay un ganador primero
            System.out.println("La partida ha sido finalizada.\n");
        } else if (tablero_completo) {  // verifica si el tablero está completo, si no hay ganador
            System.out.println("EMPATE, no hay más casillas libres. \nLa partida ha sido finalizada.\n");
        }
    }

    public boolean Victoria(char ganador){


        if (ganador != ' ') {
            System.out.println("¡¡¡FELICIDADES!!!. ¡El Jugador 1 ('x') ha ganado!");
            return true;
        } else {
        System.out.println("Posición ocupada, inténtelo de nuevo: ");
        return false;
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
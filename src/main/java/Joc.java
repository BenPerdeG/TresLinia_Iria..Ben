import java.util.Scanner;

public class Joc {
    static int filas;
    static int columnas;

    static boolean turno_jugador1 = true; // Inicia con el jugador 1
    static char [][] tablero_actual = tablero_nuevo();

    //INICIALIZAR EL TABLERO EN BLANCO
    public static char[][]tablero_nuevo(){
        TUI.readConfig();
        char tab [][] = new char[filas][columnas];
        for (int i = 0; i<tab.length; i++){
            for (int j = 0; j<tab.length; j++){
                tab[i][j] = ' ';
            }
        }
        return tab;
    }

    //MOSTRAR TABLERO ACTUALIZADO
    public static void mostrar_tablero(char [][] tablero_actual){
        for (int i =0;i<filas;i++){
            for (int j =0;j<columnas;j++){
                System.out.print("|"+ tablero_actual[i][j]+"|");
            }
            System.out.println();
        }
    }

    //TURNO DE JUGADORES Y FICHAS
    public static boolean alternar_turno(){
        if(!turno_jugador1){
            System.out.println("Turno Jugador 1, ingrese su jugada: ");
            turno_jugador1=true;
        }else{
            System.out.println("Turno Jugador 2, ingrese su partida: ");
            turno_jugador1 = false;
        }
        return turno_jugador1;
    }

    public static boolean jugarX(int coord1, int coord2) {
        if (tablero_actual[coord1 - 1][coord2 - 1] == ' ') {
            tablero_actual[coord1 - 1][coord2 - 1] = 'x';
            Joc.mostrar_tablero(tablero_actual);
            //comprobar final
            Joc.alternar_turno();
            return true;
        } else {
            System.out.println("Posición ocupada, inténtelo de nuevo: ");
            return false;
        }
    }

    public static boolean jugarO(int coord1, int coord2) {
        Scanner sc = new Scanner(System.in);
        if (tablero_actual[coord1 - 1][coord2 - 1] == ' ') {
            tablero_actual[coord1 - 1][coord2 - 1] = 'o';
            Joc.mostrar_tablero(tablero_actual);
            //comprobar final
            Joc.alternar_turno();
            return true;
        } else {
            System.out.println("Posición ocupada, inténtelo de nuevo: ");
            return false;
        }
    }

    //FINALIZAR JUEGO
    public static void final_partida() {
        if (tablero_completo()) {
            System.out.println("EMPATE. La partida ha sido finalizada.");
        } else if (!tablero_completo()) {
            System.out.println("No hay más casillas libres.");
        }
    }

    //perfecto funciona
    public static boolean tablero_completo(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero_actual[i][j] == ' ') {
                    return false; // Retorna false si encuentra alguna casilla vacía
                }
            }
        }
        return true;
    }

    /* jugada_ganadora comprueba cuál es la ficha que se colocó en tres en línea. Modifico todos los
    métodos de comprobar para que se pueda detectar el carácter x ó o */

    public static char jugada_ganadora() {
        char ficha;

        ficha = comprobar_horizontales();

        if (ficha != ' ') {
            return ficha;
        }
        ficha = comprobar_verticales();
        if (ficha != ' ') {
            return ficha;
        }
        ficha = comprobar_diagonales();
        return ficha;
    }

    public static char comprobar_horizontales() {
        for (int i = 0; i < 3; i++) {
            if (tablero_actual[i][0] != ' ' && tablero_actual[i][0] == tablero_actual[i][1] && tablero_actual[i][1] == tablero_actual[i][2]) {
                System.out.println("Existe una horizontal ganadora");
                return tablero_actual[i][0]; // Devuelve el carácter ganador.Existe linea ganadora
            }
        }
        char resultado = comprobar_horizontales();
        if (resultado != ' ') {
            System.out.println("Existe una horizontal ganadora");
        }
        return ' '; //no hay jugada ganadora en ninguna horizontal
    }

    public static char comprobar_verticales() {
        for (int j = 0; j < 3; j++) {
            if (tablero_actual[0][j] != ' ' && tablero_actual[0][j] == tablero_actual[1][j] && tablero_actual[1][j] == tablero_actual[2][j]) {
                return tablero_actual[0][j]; //Devuelve el carácter ganador. Existe una vertical ganadora
            }
        }
        char resultado = comprobar_verticales();
        if (resultado != ' ') {
            System.out.println("Existe una vertical ganadora");
        }
        return ' '; //no hay jugada ganadora en ninguna horizontal
    }

    public static char comprobar_diagonales() {
        //Diagonal principal
        if (tablero_actual[0][0] != ' ' && tablero_actual[0][0] == tablero_actual[1][1] && tablero_actual[1][1] == tablero_actual[2][2]) {
            return tablero_actual[0][0]; // Devuelve el carácter ganador en diagonal ganadora 1
        }
        //diagonal secundaria
        if (tablero_actual[0][2] != ' ' && tablero_actual[0][2] == tablero_actual[1][1] && tablero_actual[1][1] == tablero_actual[2][0]) {
            return tablero_actual[0][2]; //diagonal ganadora 2
        }
        char resultado = comprobar_diagonales();
        if (resultado != ' ') {
            System.out.println("Existe una diagonal ganadora");
        }
        return ' '; //no hay jugada ganadora en ninguna diagonal
    }
}
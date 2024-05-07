import java.util.Scanner;

public class Joc {
    static boolean turno_jugador1 = true; // Inicia con el jugador 1
    static char [][] tablero_actual = tablero_nuevo();

    //INICIALIZAR EL TABLERO EN BLANCO
    public static char[][]tablero_nuevo(){
        char tab [][] = new char[3][3];
        for (int i = 0; i<tab.length; i++){
            for (int j = 0; j<tab.length; j++){
                tab[i][j] = ' ';
            }
        }
        return tab;
    }

    //MOSTRAR TABLERO ACTUALIZADO
    public static void mostrar_tablero(){
        System.out.println(tablero_actual[0][0]+"|"+tablero_actual[0][1]+"|"+tablero_actual[0][2]+"\n"
                +tablero_actual[1][0]+"|"+tablero_actual[1][1]+"|"+tablero_actual[1][2]+"\n"
                +tablero_actual[2][0]+"|"+tablero_actual[2][1]+"|"+tablero_actual[2][2]);
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
            Joc.mostrar_tablero();
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
            Joc.mostrar_tablero();

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
        } else {
            System.out.println("Ganador!!!!");

        }
    }

    //perfecto funciona
    public static boolean tablero_completo(){
        for (int i = 0; i < tablero_actual.length; i++) {
            for (int j = 0; j < tablero_actual[i].length; j++) {
                if (tablero_actual[i][j] == ' ') {
                    return false; // Retorna false si encuentra alguna casilla vacía
                }
            }
        }
        return false;
    }

    public static boolean jugada_ganadora() {
        return comprobar_horizontales() || comprobar_verticales() || comprobar_diagonales();
    }

    private static boolean comprobar_horizontales() {
        for (int i = 0; i < 3; i++) {
            if (tablero_actual[i][0] != ' ' && tablero_actual[i][0] == tablero_actual[i][1] && tablero_actual[i][1] == tablero_actual[i][2]) {
                return true;
            }
        }
        return false;
    }

    private static boolean comprobar_verticales() {
        for (int i = 0; i < 3; i++) {
            if (tablero_actual[0][i] != ' ' && tablero_actual[0][i] == tablero_actual[1][i] && tablero_actual[1][i] == tablero_actual[2][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean comprobar_diagonales() {
        //Diagonal principal
        if (tablero_actual[0][0] != ' ' && tablero_actual[0][0] == tablero_actual[1][1] && tablero_actual[1][1] == tablero_actual[2][2]) {
            return true;
        }
        //diagonal secundaria
        if (tablero_actual[0][2] != ' ' && tablero_actual[0][2] == tablero_actual[1][1] && tablero_actual[1][1] == tablero_actual[2][0]) {
            return true;
        }
        return false;
    }
}
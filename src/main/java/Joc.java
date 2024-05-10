import java.util.Scanner;

public class Joc {

    int torn;

    boolean turnoJugador1; // Inicia con el jugador 1

    public char[][] getTablero() {
        return tablero;
    }

    private char[][] tablero;

    public void novaPartida(int filas, int columnas) {
        //  TUI.readConfig();
        tablero = new char[filas][columnas];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = ' ';
            }
        }
        turnoJugador1 = true;
    }

    //TURNO DE JUGADORES Y FICHAS
    public boolean alternar_turno() {
        if (!turnoJugador1) {
            System.out.println("Turno Jugador 1, ingrese su jugada: ");
            turnoJugador1 = true;
        } else {
            System.out.println("Turno Jugador 2, ingrese su partida: ");
            turnoJugador1 = false;
        }
        return turnoJugador1;
    }

    public boolean jugarX(int coord1, int coord2) {
        if (tablero_actual[coord1 - 1][coord2 - 1] == ' ') {
            tablero_actual[coord1 - 1][coord2 - 1] = 'x';
            //Joc.mostrar_tablero();

            char ganador = jugada_ganadora();

            if (ganador != ' ') {
                System.out.println("¡¡¡FELICIDADES!!!. ¡El Jugador 1 ('x') ha ganado!");
                final_partida();
                return true;
            }
            alternar_turno();
            return false;
        } else {
            System.out.println("Posición ocupada, inténtelo de nuevo: ");
            return false;
        }
    }

    public boolean jugarO(int coord1, int coord2) {
        Scanner sc = new Scanner(System.in);
        if (tablero_actual[coord1 - 1][coord2 - 1] == ' ') {
            tablero_actual[coord1 - 1][coord2 - 1] = 'o';
            //Joc.mostrar_tablero();

            char ganador = jugada_ganadora();

            if (ganador != ' ') {
                System.out.println("¡¡¡FELICIDADES!!!. ¡El Jugador 2 ('o') ha ganado!");
                final_partida();
                return true;
            }
            alternar_turno();
            return false;
        } else {
            System.out.println("Posición ocupada, inténtelo de nuevo: ");
            return false;
        }
    }

    //FINALIZAR JUEGO
    public void final_partida() {

        char ganador = jugada_ganadora();

        if (ganador != ' ') {  // Verifica si hay un ganador primero
            System.out.println("La partida ha sido finalizada.\n");
        } else if (tablero_completo()) {  // verifica si el tablero está completo, si no hay ganador
            System.out.println("EMPATE, no hay más casillas libres. \nLa partida ha sido finalizada.\n");
        }
    }

    public boolean tablero_completo() {
        for (int i = 0; i < tablero_actual.length; i++) {
            for (int j = 0; j < tablero_actual[i].length; j++) {
                if (tablero_actual[i][j] == ' ') {
                    return false; // Retorna false si encuentra alguna casilla vacía
                }
            }
        }
        return true;
    }

    /* jugada_ganadora comprueba cuál es la ficha que se colocó en tres en línea. Modifico todos los
    métodos de comprobar para que se pueda detectar el carácter x ó o */

    public char jugada_ganadora() {
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

    public char comprobar_horizontales() {
        for (int i = 0; i < 3; i++) {
            if (tablero_actual[i][0] != ' ' &&
                    tablero_actual[i][0] == tablero_actual[i][1] &&
                    tablero_actual[i][1] == tablero_actual[i][2]) {
                return tablero_actual[i][0]; // Devuelve el carácter ganador.Existe linea ganadora
            }
        }
        return ' '; //no hay jugada ganadora en ninguna horizontal
    }

    public char comprobar_verticales() {
        for (int j = 0; j < 3; j++) {
            if (tablero_actual[0][j] != ' ' &&
                    tablero_actual[0][j] == tablero_actual[1][j] &&
                    tablero_actual[1][j] == tablero_actual[2][j]) {
                return tablero_actual[0][j]; //Devuelve el carácter ganador. Existe una vertical ganadora
            }
        }
        return ' '; //no hay jugada ganadora en ninguna horizontal
    }

    public char comprobar_diagonales() {
        //Diagonal principal
        if (tablero_actual[0][0] != ' ' &&
                tablero_actual[0][0] == tablero_actual[1][1] &&
                tablero_actual[1][1] == tablero_actual[2][2]) {
            return tablero_actual[0][0]; // Devuelve el carácter ganador en diagonal ganadora 1
        }
        //diagonal secundaria
        if (tablero_actual[0][2] != ' ' &&
                tablero_actual[0][2] == tablero_actual[1][1] &&
                tablero_actual[1][1] == tablero_actual[2][0]) {
            return tablero_actual[0][2]; //diagonal ganadora 2
        }
        return ' '; //no hay jugada ganadora en ninguna diagonal
    }
}

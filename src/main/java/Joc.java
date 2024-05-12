import java.util.Scanner;

public class Joc {
    TUI tui = new TUI();

    int turno;
    boolean turnoJugador1; // Inicia con el jugador 1

    public char[][] getTablero() {
        return tablero;
    }

    private char[][] tablero;
//Muestar tablero nuevo
    public void nuevaPartida(int filas, int columnas) {
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
    public boolean alternarTurno() {
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
        if (getTablero()[coord1 - 1][coord2 - 1] == ' ') {
            getTablero()[coord1 - 1][coord2 - 1] = 'x';
          //  nuevaPartida(getTablero());

            char ganador = jugadaGanadora();

            if (ganador != ' ') {
                System.out.println("¡¡¡FELICIDADES!!!. ¡El Jugador 1 ('x') ha ganado!");
                finalPartida();
                return true;
            }
            alternarTurno();
            return false;
        } else {
            System.out.println("Posición ocupada, inténtelo de nuevo: ");
            return false;
        }
    }

    public boolean jugarO(int coord1, int coord2) {
        Scanner sc = new Scanner(System.in);
        if (getTablero()[coord1 - 1][coord2 - 1] == ' ') {
            getTablero()[coord1 - 1][coord2 - 1] = 'o';
            //Joc.mostrar_tablero();

            char ganador = jugadaGanadora();

            if (ganador != ' ') {
                System.out.println("¡¡¡FELICIDADES!!!. ¡El Jugador 2 ('o') ha ganado!");
                finalPartida();
                return true;
            }
            alternarTurno();
            return false;
        } else {
            System.out.println("Posición ocupada, inténtelo de nuevo: ");
            return false;
        }
    }

    //FINALIZAR JUEGO
    public void finalPartida() {

        char ganador = jugadaGanadora();

        if (ganador != ' ') {  // Verifica si hay un ganador primero
            System.out.println("La partida ha sido finalizada.\n");
        } else if (tablero_completo()) {  // verifica si el tablero está completo, si no hay ganador
            System.out.println("EMPATE, no hay más casillas libres. \nLa partida ha sido finalizada.\n");
        }
    }

    public boolean tablero_completo() {
        for (int i = 0; i < getTablero().length; i++) {
            for (int j = 0; j < getTablero()[i].length; j++) {
                if (getTablero()[i][j] == ' ') {
                    return false; // Retorna false si encuentra alguna casilla vacía
                }
            }
        }
        return true;
    }

    /* jugada_ganadora comprueba cuál es la ficha que se colocó en tres en línea. Modifico todos los
    métodos de comprobar para que se pueda detectar el carácter x ó o */

    public char jugadaGanadora() {
        char ficha;

        ficha = comprobarHorizontales();
        if (ficha != ' ') {
            return ficha;
        }
        ficha = comprobarVerticales();
        if (ficha != ' ') {
            return ficha;
        }
        ficha = comprobarDiagonales();
        return ficha;
    }

    public char comprobarHorizontales() {
        for (int i = 0; i < 3; i++) {
            if (getTablero()[i][0] != ' ' &&
                    getTablero()[i][0] == getTablero()[i][1] &&
                    getTablero()[i][1] == getTablero()[i][2]) {
                return getTablero()[i][0]; // Devuelve el carácter ganador.Existe linea ganadora
            }
        }
        return ' '; //no hay jugada ganadora en ninguna horizontal
    }

    public char comprobarVerticales() {
        for (int j = 0; j < 3; j++) {
            if (getTablero()[0][j] != ' ' &&
                    getTablero()[0][j] == getTablero()[1][j] &&
                    getTablero()[1][j] == getTablero()[2][j]) {
                return getTablero()[0][j]; //Devuelve el carácter ganador. Existe una vertical ganadora
            }
        }
        return ' '; //no hay jugada ganadora en ninguna horizontal
    }

    public char comprobarDiagonales() {
        //Diagonal principal
        if (getTablero()[0][0] != ' ' &&
                getTablero()[0][0] == getTablero()[1][1] &&
                getTablero()[1][1] == getTablero()[2][2]) {
            return getTablero()[0][0]; // Devuelve el carácter ganador en diagonal ganadora 1
        }
        //diagonal secundaria
        if (getTablero()[0][2] != ' ' &&
                getTablero()[0][2] == getTablero()[1][1] &&
                getTablero()[1][1] == getTablero()[2][0]) {
            return getTablero()[0][2]; //diagonal ganadora 2
        }
        return ' '; //no hay jugada ganadora en ninguna diagonal
    }
}

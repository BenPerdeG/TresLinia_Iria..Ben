public class Joc {
    private char[][] tablero;
    int turnoJugador1 = 1; // Inicia con el jugador 1

    public char[][] getTablero() {
        return tablero;
    }

    public int getTurnoJugador1() {
        return turnoJugador1;
    }

    public void crearTablero(int filas, int columnas){
        tablero = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            tablero[i][j] = ' ';
        }
    }
}

//Muestar tablero nuevo
    public void nuevaPartida(int filas, int columnas) {
        //  TUI.readConfig();
        crearTablero(filas,columnas);
        turnoJugador1 = 0;
    }


    //TURNO DE JUGADORES Y FICHAS
    public int alternarTurno() {
           turnoJugador1++;
           return turnoJugador1;
            }

    public void jugar(int coord1, int coord2, char[][] tablero) {

        if (tablero[coord1 - 1][coord2 - 1] == ' ') {  // Asegúrate que la casilla está vacía
            if (turnoJugador1 % 2 != 1) {
                tablero[coord1 - 1][coord2 - 1] = 'x';
            } else {
                tablero[coord1 - 1][coord2 - 1] = 'o';
            }
            alternarTurno();  // Alternar el turno solo después de hacer una jugada válida
        }
    }


    public boolean tableroCompleto() {
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

    public char jugadaGanadora(int config) {
        char ficha = 'º';

        ficha = comprobarHorizontales(config);
        if (ficha != ' ') {
            return ficha;
        }
        ficha = comprobarVerticales(config);
        if (ficha != ' ') {
            return ficha;
        }
        ficha = comprobarDiagonales(config);
        if (ficha != ' ') {
            return ficha;
        }
        return ficha;
    }

    public char comprobarHorizontales(int config) {

        for (int i = 0; i < config-2; i++) {
            if (getTablero()[i][i] != ' ' &&
                    getTablero()[i][i] == getTablero()[i][i+1] &&
                    getTablero()[i][i+1] == getTablero()[i][i+2]) {
                return getTablero()[i][i]; // Devuelve el carácter ganador.Existe linea ganadora
            }
        }
        return ' '; //no hay jugada ganadora en ninguna horizontal
    }

    public char comprobarVerticales(int config) {
        for (int j = 0; j < config-2; j++) {
            if (getTablero()[j][j] != ' ' &&
                    getTablero()[j][j] == getTablero()[j+1][j] &&
                    getTablero()[j+1][j] == getTablero()[j+2][j]) {
                return getTablero()[j][j]; //Devuelve el carácter ganador. Existe una vertical ganadora
            }
        }
        return ' '; //no hay jugada ganadora en ninguna horizontal
    }

    public char comprobarDiagonales(int config) {
        //Diagonal principal

        for (int j = 0; j < config-2; j++) {
        if (getTablero()[j][j] != ' ' &&
                getTablero()[j][j] == getTablero()[j+1][j+1] &&
                getTablero()[j+1][j+1] == getTablero()[j+2][j+2]) {
            return getTablero()[j][j]; // Devuelve el carácter ganador en diagonal ganadora 1
        }
        //diagonal secundaria
        if (getTablero()[j][config-2] != ' ' &&
                getTablero()[j][config-1] == getTablero()[j][config-2] &&
                getTablero()[j+1][config-2] == getTablero()[j+2][config-3]) {
            return getTablero()[j][config]; //diagonal ganadora 2
        }
        }
        return ' '; //no hay jugada ganadora en ninguna diagonal
    }
}

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

    public char jugadaGanadora() {
        char ficha = 'º';

        ficha = comprobarHorizontales();
        if (ficha != ' ') {
            return ficha;
        }
        ficha = comprobarVerticales();
        if (ficha != ' ') {
            return ficha;
        }
        ficha = comprobarDiagonales();
        if (ficha != ' ') {
            return ficha;
        }
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

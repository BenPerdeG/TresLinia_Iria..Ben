import org.junit.jupiter.api.Assertions;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Test {
    // Comprobar tablero en blanco
    @org.junit.jupiter.api.Test
    void tablero_blanco() { //Joc
        char tab[][] = new char[3][3];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = ' ';
            }
        }
        Assertions.assertArrayEquals(tab, Joc.tablero_nuevo());
    }

    @org.junit.jupiter.api.Test
    void turno_jugador() { //Joc
        //Comienza el tuRno del jugado1 ('x')
        boolean turno = Joc.alternar_turno();
        Assertions.assertFalse(turno);
        //Continua jugador2 ('o')
        turno = Joc.alternar_turno();
        Assertions.assertTrue(turno);
    }

    @org.junit.jupiter.api.Test
//REESTRUCTURAR
    void primera_jugada_() { //Joc
        Joc.jugarX(1, 1);
        coord_simulador();
        Assertions.assertEquals('x', Joc.tablero_actual[0][0]);
        Joc.jugarO(2, 2);
        coord_simulador();
        Assertions.assertEquals('o', Joc.tablero_actual[0][0]);
    }

    @org.junit.jupiter.api.Test
    public void coord_simulador() {
        String data = "2\n2\n"; // Coordenada simulada (2 2), como si fuera el jugador 1.
        InputStream input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);
    }

    @org.junit.jupiter.api.Test
//REESTRUCTURAR
    void jugada_correcta() { //TUI
        coord_simulador();
        //comprobar fila
        Assertions.assertFalse(TUI.jugada_inicial(0, 2));
        //comprobar columna
        Assertions.assertFalse(TUI.jugada_inicial(2, 0));
        //Coordenada completa valida
        Assertions.assertFalse(TUI.jugada_inicial(2, 2));
    }

    @org.junit.jupiter.api.Test
    void posicion_vacia_jugarX() {
        char[][] tablero = Joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;

        Joc.tablero_actual = tablero;
        // Coloca primera ficha 'x'
        boolean primeraColocacion = Joc.jugarX(fila, columna);
        Assertions.assertTrue(primeraColocacion, "La primera ficha debería colocarse correctamente.");

        // 'x' en la misma posición?
        boolean segundaColocacion = Joc.jugarX(fila, columna);
        Assertions.assertFalse(segundaColocacion, "No debería ser posible colocar otra ficha en la misma posición.");

        // Comprueba si esta ocupada la coordenada solicitada
        Assertions.assertEquals('x', Joc.tablero_actual[fila - 1][columna - 1], "La posición debe seguir con la primera ficha 'x'.");
    }

    @org.junit.jupiter.api.Test
    void posicion_vacia_jugarO() {
        char[][] tablero = Joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;
        Joc.tablero_actual = tablero;

        // Prueba colocar 'o' en una posición vacía
        Joc.jugarO(fila, columna);
        Assertions.assertEquals('o', Joc.tablero_actual[fila - 1][columna - 1]);
        // Intentar colocar ficha en la misma posición
        Joc.jugarO(fila, columna);
        Assertions.assertEquals('o', Joc.tablero_actual[fila - 1][columna - 1], "No debería permitirse colocar otra 'o' en la misma posición.");
    }

    @org.junit.jupiter.api.Test
    void posicion_ocupada() {
        char[][] tablero = Joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;
        Joc.tablero_actual = tablero;
        // Colocar 'x' en una posición
        boolean jugada1 = Joc.jugarX(fila, columna);
        Assertions.assertTrue(jugada1);
        // jugar 'o' en la misma posición
        boolean jugada2 = Joc.jugarO(fila, columna);
        Assertions.assertFalse(jugada2);
        // Comprobar que la ficha no se ha cambiado a 'o'
        Assertions.assertEquals('x', Joc.tablero_actual[fila - 1][columna - 1]);
        // Jugar 'x' en la misma posición, de nuevo.
        boolean jugada3 = Joc.jugarX(fila, columna);
        Assertions.assertFalse(jugada3);
    }

      /*  @org.junit.jupiter.api.Test
        public void final_partida() {
            //horizontal
            Joc.tablero_actual[0][0] = 'x';
            Joc.tablero_actual[0][1] = 'x';
            Joc.tablero_actual[0][2] = 'x';

            Assertions.assertTrue(Joc.final_partida());

            //Diagonal
            Joc.tablero_actual = Joc.tablero_nuevo();
            Joc.tablero_actual[0][0] = 'x';
            Joc.tablero_actual[1][1] = 'x';
            Joc.tablero_actual[2][2] = 'x';

            Assertions.assertTrue(Joc.final_partida());

            //Vertical
            Joc.tablero_actual = Joc.tablero_nuevo();
            Joc.tablero_actual[0][0] = 'x';
            Joc.tablero_actual[1][0] = 'x';
            Joc.tablero_actual[2][0] = 'x';

            Assertions.assertTrue(Joc.final_partida());
        }*/
}
import org.junit.jupiter.api.Assertions;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Test {
    Joc joc = new Joc();
    TUI tui = new TUI();
    // Comprobar tablero en blanco
    @org.junit.jupiter.api.Test
    void tablero_blanco() { //Joc
        char tab[][] = new char[3][3];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = ' ';
            }
        }
        Assertions.assertArrayEquals(tab, joc.tablero_nuevo());
    }

    @org.junit.jupiter.api.Test
    void turno_jugador() { //Joc
        //Comienza el tuRno del jugado1 ('x')
        boolean turno = joc.alternar_turno();
        Assertions.assertFalse(turno);
        //Continua jugador2 ('o')
        turno = joc.alternar_turno();
        Assertions.assertTrue(turno);
    }

    @org.junit.jupiter.api.Test
//REESTRUCTURAR
    void primera_jugada_() { //Joc
        joc.jugarX(1, 1);
        coord_simulador();
        Assertions.assertEquals('x', joc.tablero_actual[0][0]);
        joc.jugarO(2, 2);
        coord_simulador();
        Assertions.assertEquals('o', joc.tablero_actual[0][0]);
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
        Assertions.assertFalse(tui.jugada_inicial(1,1));
        //comprobar columna
        Assertions.assertFalse(tui.jugada_inicial(1, 1));
        //Coordenada completa valida
        Assertions.assertFalse(tui.jugada_inicial(1,1));
    }

    @org.junit.jupiter.api.Test
    void posicion_vacia_jugarX() {
        char[][] tablero = joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;

        joc.tablero_actual = tablero;
        // Coloca primera ficha 'x'
        boolean primeraColocacion = joc.jugarX(fila, columna);
        Assertions.assertTrue(primeraColocacion, "La primera ficha debería colocarse correctamente.");

        // 'x' en la misma posición?
        boolean segundaColocacion = joc.jugarX(fila, columna);
        Assertions.assertFalse(segundaColocacion, "No debería ser posible colocar otra ficha en la misma posición.");

        // Comprueba si esta ocupada la coordenada solicitada
        Assertions.assertEquals('x', joc.tablero_actual[fila - 1][columna - 1], "La posición debe seguir con la primera ficha 'x'.");
    }

    @org.junit.jupiter.api.Test
    void posicion_vacia_jugarO() {
        char[][] tablero = joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;
        joc.tablero_actual = tablero;

        // Prueba colocar 'o' en una posición vacía
        joc.jugarO(fila, columna);
        Assertions.assertEquals('o', joc.tablero_actual[fila - 1][columna - 1]);
        // Intentar colocar ficha en la misma posición
        joc.jugarO(fila, columna);
        Assertions.assertEquals('o', joc.tablero_actual[fila - 1][columna - 1], "No debería permitirse colocar otra 'o' en la misma posición.");
    }

    @org.junit.jupiter.api.Test
    void posicion_ocupada() {
        char[][] tablero = joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;
        joc.tablero_actual = tablero;
        // Colocar 'x' en una posición
        boolean jugada1 = joc.jugarX(fila, columna);
        Assertions.assertTrue(jugada1);
        // jugar 'o' en la misma posición
        boolean jugada2 = joc.jugarO(fila, columna);
        Assertions.assertFalse(jugada2);
        // Comprobar que la ficha no se ha cambiado a 'o'
        Assertions.assertEquals('x', joc.tablero_actual[fila - 1][columna - 1]);
        // Jugar 'x' en la misma posición, de nuevo.
        boolean jugada3 = joc.jugarX(fila, columna);
        Assertions.assertFalse(jugada3);
    }

    @org.junit.jupiter.api.Test
    public void final_partida_horizontal() {

        char[][] tablero = joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;

        joc.tablero_actual[0][0] = 'x';
        joc.tablero_actual[0][1] = 'x';
        joc.tablero_actual[0][2] = 'x';

        Assertions.assertEquals(joc.tablero_actual[fila - 1][columna - 1], 'x');
    }

    @org.junit.jupiter.api.Test
    public void final_partida_diagonal() {

        char[][] tablero = joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;

        joc.tablero_actual[0][0] = 'x';
        joc.tablero_actual[1][1] = 'x';
        joc.tablero_actual[2][2] = 'x';

        Assertions.assertEquals(joc.tablero_actual[fila - 1][columna - 1], 'x');
    }

    @org.junit.jupiter.api.Test
    public void final_partida_vertical() {

        char[][] tablero = joc.tablero_nuevo();
        int fila = 1;
        int columna = 1;

            joc.tablero_actual[0][0] = 'x';
            joc.tablero_actual[1][0] = 'x';
            joc.tablero_actual[2][0] = 'x';

        Assertions.assertEquals(joc.tablero_actual[fila - 1][columna - 1], 'x');
        }
}
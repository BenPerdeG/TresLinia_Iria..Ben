import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Test {
    Joc joc = new Joc();
    TUI tui = new TUI();

    @org.junit.jupiter.api.Test
    void archivoConfigCreado(){
        File config = new File("config.txt");
        Assertions.assertTrue(config.exists());
    }

  /*  @org.junit.jupiter.api.Test
    void tablero_blanco() { //Joc
        char tab[][] = new char[tui.readConfig()][tui.readConfig()];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = ' ';
            }
        }
        Assertions.assertArrayEquals(tab, joc.getTablero());
    }*/


  @org.junit.jupiter.api.Test
    void turnoJugador() { //Joc

      //Comienza turno del jugador1 ('x')
      int turno = joc.alternarTurno();
        Assertions.assertEquals(0,joc.getTurnoJugador1() % 2 );

        //Continua jugador2 ('o')
        turno = joc.alternarTurno();
        Assertions.assertNotEquals(0,joc.getTurnoJugador1() % 2 );
    }

/*
   @org.junit.jupiter.api.Test
    void primera_jugada_() { //Joc
        joc.jugar(1, 1);

        Assertions.assertEquals('x', joc.tablero_actual[0][0]);
        joc.jugarO(2, 2);
        coord_simulador();
        Assertions.assertEquals('o', joc.tablero_actual[0][0]);
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

        joc.novaPartida();[0][0] = 'x';
        joc.novaPartida();[1][1] = 'x';
        joc.novaPartida();[2][2] = 'x';

        Assertions.assertEquals(joc.novaPartida();[fila - 1][columna - 1], 'x');
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
        }*/
}
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;


public class Test {
    Joc joc = new Joc();
    TUI tui = new TUI();

    @org.junit.jupiter.api.Test
    void archivoConfigCreado(){
        File config = new File("config.txt");
        Assertions.assertTrue(config.exists());
    }

  @org.junit.jupiter.api.Test
    void tablero_blanco() throws FileNotFoundException { //Joc
        joc.nuevaPartida(3,3);
        for (int i =0; i< joc.getTablero().length;i++) {
            for (int j = 0; j < joc.getTablero().length; j++) {
                Assertions.assertEquals(' ', joc.getTablero()[i][j]);
            }
        }
    }


  @org.junit.jupiter.api.Test
    void turnoJugador() { //Joc

      //Comienza turno del jugador1 ('x')
      int turno = joc.alternarTurno();
        Assertions.assertEquals(0,joc.getTurnoJugador1() % 2 );

        //Continua jugador2 ('o')
        turno = joc.alternarTurno();
        Assertions.assertNotEquals(0,joc.getTurnoJugador1() % 2 );
    }


   @org.junit.jupiter.api.Test
    void primera_jugada_() { //Joc
        joc.nuevaPartida(3,3);
        joc.jugar(1,1,joc.getTablero());
        Assertions.assertEquals('x', joc.getTablero()[0][0]);
        joc.jugar(2, 2, joc.getTablero());
        Assertions.assertEquals('o', joc.getTablero()[1][1]);
    }


    /*@org.junit.jupiter.api.Test
//REESTRUCTURAR
    void jugada_correcta() { //TUI
     //Benja:no se que se refiere este test

    }*/




    @org.junit.jupiter.api.Test
    void posicion_ocupada() {
        joc.nuevaPartida(3,3);
        // Colocar 'x' en una posición

        joc.jugar(1,1, joc.getTablero());
        Assertions.assertEquals('x',joc.getTablero()[0][0]);

        Assertions.assertFalse(joc.jugar(1,1, joc.getTablero()));
    }

    @org.junit.jupiter.api.Test
    public void final_partida_horizontal() {
        joc.nuevaPartida(3,3);
        joc.jugar(1,1, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(1,2, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(1,3, joc.getTablero());
        Assertions.assertEquals('x',joc.comprobarHorizontales(3));
    }

    @org.junit.jupiter.api.Test
    public void final_partida_diagonal() {
        joc.nuevaPartida(3,3);
        joc.jugar(1,1, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(2,2, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(3,3, joc.getTablero());
        Assertions.assertEquals('x',joc.comprobarDiagonales(3));
    }

    @org.junit.jupiter.api.Test
    public void final_partida_vertical() {
        joc.nuevaPartida(3,3);
        joc.jugar(1,1, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(2,1, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(3,1, joc.getTablero());
        Assertions.assertEquals('x',joc.comprobarVerticales(3));
        }
}
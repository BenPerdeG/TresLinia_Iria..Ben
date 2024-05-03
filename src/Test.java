import org.junit.jupiter.api.Assertions;
import java.io.InputStream;
import java.io.ByteArrayInputStream;


public class Test {
    // Comprobar tablero en blanco
    @org.junit.jupiter.api.Test
    void Tablero_Blanco() { //Joc
        char tab [][] = new char[3][3];
        for (int i = 0; i<tab.length; i++){
            for (int j = 0; j<tab.length; j++){
                tab[i][j] = ' ';
            }
        }
        Assertions.assertArrayEquals(tab,Joc.tablero());
    }
    @org.junit.jupiter.api.Test
    void TurnoJugador() { //Joc
        Joc j = new Joc();
        Assertions.assertTrue(j.alternar_turno());
    }

    @org.junit.jupiter.api.Test
    void una_jugada() { //Joc
        Joc j = new Joc();
        j.jugarX(1,1);
        Assertions.assertEquals('x',j.tablero_actual[0][0]);
        j.jugarO(2,2);
        Assertions.assertEquals('o',j.tablero_actual[0][0]);
    }


    @org.junit.jupiter.api.Test
    public void Coord_simulador() {
        String data = "2\n2\n"; // Coordenada simulada (2 2), como si fuera el jugador 1.
        InputStream input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);
    }

    @org.junit.jupiter.api.Test
    void jugada_correcta() { //TUI
        Coord_simulador();
        //comprobar fila
        Assertions.assertFalse(TUI.jugada_inicial(0, 2));
        //comprobar columna
        Assertions.assertFalse(TUI.jugada_inicial(2, 0));
        //Coordenada completa valida
        Assertions.assertTrue(TUI.jugada_inicial(2, 2));
    }
}

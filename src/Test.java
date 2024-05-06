import org.junit.jupiter.api.Assertions;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Test {
    // Comprobar tablero en blanco
    @org.junit.jupiter.api.Test
    void tablero_blanco() { //Joc
        char tab [][] = new char[3][3];
        for (int i = 0; i<tab.length; i++){
            for (int j = 0; j<tab.length; j++){
                tab[i][j] = ' ';
            }
        }
        Assertions.assertArrayEquals(tab,Joc.tablero_nuevo());
    }
    @org.junit.jupiter.api.Test
    void turno_jugador() { //Joc
        Joc j = new Joc();
        Assertions.assertTrue(j.alternar_turno());
    }

    @org.junit.jupiter.api.Test
    void una_jugada() { //Joc
        Joc j = new Joc();
        j.jugarX(1,1);
        coord_simulador();
        Assertions.assertEquals('x',j.tablero_actual[0][0]);
        j.jugarO(2,2);
        coord_simulador();
        Assertions.assertEquals('o',j.tablero_actual[0][0]);
    }

    @org.junit.jupiter.api.Test
    public void coord_simulador() {
        String data = "2\n2\n"; // Coordenada simulada (2 2), como si fuera el jugador 1.
        InputStream input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);
    }

    @org.junit.jupiter.api.Test
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
    public void final_partida() {
        //horizontal
        Joc.tablero_actual[0][0]='x';
        Joc.tablero_actual[0][1]='x';
        Joc.tablero_actual[0][2]='x';

        Assertions.assertTrue(Joc.final_partida());

        //Diagonal
        Joc.tablero_actual=Joc.tablero_nuevo();
        Joc.tablero_actual[0][0]='x';
        Joc.tablero_actual[1][1]='x';
        Joc.tablero_actual[2][2]='x';

        Assertions.assertTrue(Joc.final_partida());

        //Vertical
        Joc.tablero_actual=Joc.tablero_nuevo();
        Joc.tablero_actual[0][0]='x';
        Joc.tablero_actual[1][0]='x';
        Joc.tablero_actual[2][0]='x';

        Assertions.assertTrue(Joc.final_partida());
    }
}

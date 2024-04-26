import org.junit.jupiter.api.Assertions;
public class Test {

    // Comprobar tablero en blanco
    @org.junit.jupiter.api.Test
    void Tablero_Blanco() {
        char tab [][] = new char[3][3];

        for (int i = 0; i<tab.length; i++){
            for (int j = 0; j<tab.length; j++){
                tab[i][j] = ' ';
            }
        }
            Assertions.assertArrayEquals(tab,Joc.tablero());
    }

    @org.junit.jupiter.api.Test
    void TurnoJugador() {
        Joc j = new Joc();
        Assertions.assertTrue(j.get_jugador1());
    }

    @org.junit.jupiter.api.Test
    void una_jugada() {
        Joc j = new Joc();
        j.jugar(1,1);
        Assertions.assertEquals('x',j.tablero_actual[0][0]);
    }



}

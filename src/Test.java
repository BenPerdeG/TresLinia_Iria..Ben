import org.junit.jupiter.api.Assertions;
public class Test {

    // Comprobar tablero en blanco
    @org.junit.jupiter.api.Test
    void Tablero_Blanco() {
            Joc j = new Joc();
            String linea1 = " | | ";
            String linea2 = " | | ";
            String linea3 = " | | ";


            char tablero[][] = new char[3][5];

            tablero[0] = linea1.toCharArray();
            tablero[1] = linea2.toCharArray();
            tablero[2] = linea3.toCharArray();
            Assertions.assertArrayEquals(tablero,j.tablero());
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
        Assertions.assertEquals('x',j.tablero()[1][1]);
    }



}

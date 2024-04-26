import org.junit.jupiter.api.Assertions;
public class Test {

    // Comprobar tablero en blanco
    @org.junit.jupiter.api.Test
    void Tablero_Blanco() {
        Joc j = new Joc();
        String linea1 = " | | ";
        String linea2 = " | | ";
        String linea3 = " | | ";
        String lineamid = "_____";


        char tablero[][] = new char[5][5];

        tablero[0] = linea1.toCharArray();
        tablero[1] = lineamid.toCharArray();
        tablero[2] = linea2.toCharArray();
        tablero[3] = lineamid.toCharArray();
        tablero[4] = linea3.toCharArray();
        Assertions.assertArrayEquals(tablero, j.tablero());

    }

    @org.junit.jupiter.api.Test
    void TurnoJugador() {
        Joc j = new Joc();
        Assertions.assertTrue(j.get_jugador1());
    }
}

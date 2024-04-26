import org.junit.jupiter.api.Assertions;
public class Test {
    @org.junit.jupiter.api.Test
    void NuevaPartida() {
        Joc j = new Joc();
        String linea1 = " | | ";
        String linea2 = " | | ";
        String linea3 = " | | ";


        char tablero[][] = new char[5][3];

        tablero[0] = linea1.toCharArray();
        tablero[2] = linea2.toCharArray();
        tablero[4] = linea3.toCharArray();
        Assertions.assertArrayEquals(tablero,j.tablero());
    }

}

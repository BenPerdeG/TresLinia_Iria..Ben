import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.File;



public class Test {
    Joc joc = new Joc();
    TUI tui = new TUI();

    @org.junit.jupiter.api.Test
    void archivoConfigCreado(){
        File config = new File("config.txt");
        Assertions.assertTrue(config.exists());
    }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    void tablero_Blanco(int config){ //Joc
        joc.nuevaPartida(config,config);
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

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    void primeraJugada_(int config) { //Joc
        joc.nuevaPartida(config,config);
        joc.jugar(1,1,joc.getTablero());
        Assertions.assertEquals('x', joc.getTablero()[0][0]);
        joc.jugar(2, 2, joc.getTablero());
        Assertions.assertEquals('o', joc.getTablero()[1][1]);
    }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    void posicionOcupada(int config) {
        joc.nuevaPartida(config,config);
        // Colocar 'x' en una posición

        joc.jugar(1,1, joc.getTablero());
        Assertions.assertEquals('x',joc.getTablero()[0][0]);

        Assertions.assertFalse(joc.jugar(1,1, joc.getTablero()));
    }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    public void finalPartidaHorizontal(int config) {
        joc.nuevaPartida(config,config);
        joc.jugar(1,config-2, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(1,config-1, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(1,config, joc.getTablero());
        Assertions.assertEquals('x',joc.comprobarHorizontales(config));

    }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    public void finalPartidaDiagonal(int config) {
        joc.nuevaPartida(config,config);
        joc.jugar(config-2,config-2, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(config-1,config-1, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(config,config, joc.getTablero());
        Assertions.assertEquals('x',joc.comprobarDiagonales(config));
    }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    public void finalPartidaVertical(int config) {
        joc.nuevaPartida(config,config);
        joc.jugar(config-2,1, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(config-1,1, joc.getTablero());
        joc.alternarTurno();
        joc.jugar(config,1, joc.getTablero());
        Assertions.assertEquals('x',joc.comprobarVerticales(config));
        }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    public void borrarFichero (int config) {
    }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    public void comprobarExisteFichero (int config) {
    }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    public void borrarDirectorio (int config) {
    }

    @ParameterizedTest
    @CsvSource({"3", "10", "9384"})
    public void comprobarExistedirectorio (int config) {
    }

}
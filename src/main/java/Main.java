

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        Joc joc = new Joc();

        while (true) {
            switch (tui.mostrarMenu()) {
                case 1:
                    //Nueva partida
                    tui.mostrarMensaje("Su selección ha sido: Nueva partida");
                    partidaNueva(tui, joc, 3, 3);
                    break;
                case 2:
                    //Cargar partida
                    tui.mostrarMensaje("Su selección ha sido: Cargar partida");
                    cargar_partida();
                    break;
                case 3:
                    //Configuración
                    tui.mostrarMensaje("Su selección ha sido: Configuración");
                    configuracion();
                    break;
                case 4:
                    //Finalizar
                    tui.mostrarMensaje("Su selección ha sido: Marcharse :C \n ¡¡Hasta luego!!");
                    return;
                default:
                    System.out.println("Ha habido un error con el input. Prueba de nuevo: \n");
            }
        }
    }

        private static void partidaNueva (TUI tui, Joc joc, int filas, int columnas) {

            joc.nuevaPartida(filas, columnas);
            tui.mostrarTablero(joc.getTablero(), filas, columnas);
            tui.jugada_inicial(filas, columnas);

            while (!joc.tablero_completo()) {
                try{
                    tui.recorrerPartida();
                    joc.jugar(tui.filaJugador, tui.columnaJugador, joc.getTablero());
                    tui.mostrarTablero(joc.getTablero(),joc.getTablero().length,joc.getTablero().length);
                    joc.finalPartida();

                } catch (Exception f) {
                    joc.turnoJugador1 = true;
                    System.out.println("Error");
                }
            }
            joc.finalPartida();
        }

        public static void cargar_partida () {

            not_implemented();
        }

        public static void configuracion () {
            not_implemented();
        }

        public static void not_implemented () {

            System.out.println("Método no implementado\n");
        }
    }

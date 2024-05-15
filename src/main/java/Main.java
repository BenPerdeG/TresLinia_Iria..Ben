import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TUI tui = new TUI();
        Joc joc = new Joc();

        while (true) {
            switch (tui.mostrarMenu()) {
                case 1:
                    //Nueva partida
                    tui.mostrarMensaje("Su selección ha sido: Nueva partida");
                    partidaNueva(tui, joc, tui.readConfig());
                    break;
                case 2:
                    //Cargar partida
                    tui.mostrarMensaje("Su selección ha sido: Cargar partida");
                    cargar_partida();
                    break;
                case 3:
                    //Configuración
                    tui.mostrarMensaje("Su selección ha sido: Configuración");
                    configuracion(tui,joc);
                    break;
                case 4:
                    //Finalizar
                    tui.mostrarMensaje("Su selección ha sido: Marcharse :C \n ¡¡Hasta luego!!");
                    return;
                default:
                    tui.mostrarMensaje("Ha habido un error con el input. Prueba de nuevo: \n");
            }
        }
    }

        private static void partidaNueva (TUI tui, Joc joc, int config) {

            joc.nuevaPartida(config,config);
            tui.mostrarTablero(joc.getTablero(), config, config);
            tui.jugada_inicial();

            while (!joc.tableroCompleto()) {
                try{
                    tui.recorrerPartida(config);

                    joc.jugar(tui.filaJugador, tui.columnaJugador, joc.getTablero());

                    if(joc.getTurnoJugador1()%2 == 0){
                        tui.mostrarMensaje("Turno del jugador 1, ingrese su jugada: ");
                    }else {
                        tui.mostrarMensaje("Turno del jugador 2, ingrese su jugada: ");
                    }

                    tui.mostrarTablero(joc.getTablero(),joc.getTablero().length,joc.getTablero().length);

                    if(tui.victoria(joc.jugadaGanadora(config))){
                        return;
                    }

                } catch (Exception f) {
                    joc.turnoJugador1 = 0;
                    System.out.println("Error");
                    return;
                }
            }
            tui.finalPartida(joc.jugadaGanadora(config), joc.tableroCompleto());


        }

        public static void cargar_partida () {

            not_implemented();
        }

        public static void configuracion (TUI tui, Joc joc) {
        tui.mostrarMensaje("Escriba cual desea sea el tamaño del tablero:");
        tui.createConfig();
        }
        public static void  ocupado(){
            TUI tui = new TUI();
            tui.mostrarMensaje("Esa casilla esta ocupada, pruebe de nuevo");
        }

        public static void not_implemented () {

            System.out.println("Método no implementado\n");
        }
    }

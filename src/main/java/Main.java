

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

        private void partidaNueva (TUI tui, Joc joc, int filas, int columnas) {
            int fila = 0;
            int columna = 0;

            joc.nuevaPartida(fila, columna);
            tui.mostrarTablero(joc.getTablero(), filas, columnas);
            tui.jugada_inicial(fila, columna);

            while (!joc.tablero_completo()) {
                tui.recorrerPartida();
            }
            joc.finalPartida();
        }

        public void cargar_partida () {

            not_implemented();
        }

        public void configuracion () {
            not_implemented();
        }

        public void not_implemented () {

            System.out.println("Método no implementado\n");
        }
    }

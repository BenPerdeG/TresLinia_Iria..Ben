

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();


        while (true) {
            switch (tui.menu()) {
                case 1:
                    //Nueva partida
                    tui.mostraMisstage("Su selección ha sido: Nueva partida");
                    nueva_partida();
                    break;
                case 2:
                    //Cargar partida
                    tui.mostraMisstage("Su selección ha sido: Cargar partida");
                    cargar_partida();
                    break;
                case 3:
                    //Configuración
                    tui.mostraMisstage("Su selección ha sido: Configuración");
                    configuracion();
                    break;
                case 4:
                    //Finalizar
                    tui.mostraMisstage("Su selección ha sido: Marcharse :C \n ¡¡Hasta luego!!");
                    return;
                default:
                    System.out.println("Ha habido un error con el input. Prueba de nuevo: \n");
            }
        }
    }


        public static void nueva_partida (TUI tui, Joc joc) {
            int fila = 0;
            int columna = 0;
            tui.jugada_inicial(fila, columna);

            while (!joc.tablero_completo()) {
                tui.jugar_partida();
            }
            joc.final_partida();
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

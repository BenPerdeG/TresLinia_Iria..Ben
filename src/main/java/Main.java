

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        Joc joc = new Joc();

        while (true) {
            switch (tui.menu()) {
                case 1:
                    //Nueva partida
                    tui.mostraMisstage("Su selección ha sido: Nueva partida");
                    nueva_partida();
                    break;
                case 2:
                    //Cargar partida
                    System.out.println("Su selección ha sido: Cargar partida");
                    cargar_partida();
                    break;
                case 3:
                    //Configuración
                    System.out.println("Su selección ha sido: Configuración");
                    configuracion();
                    break;
                case 4:
                    //Finalizar
                    System.out.println("¡Hasta pronto!\n");
                    return;
                default:
                    System.out.println("Ha habido un error con el input. Prueba de nuevo: \n");
            }
        }
    }


        public static void nueva_partida () {
            int fila = 0;
            int columna = 0;

            TUI.jugada_inicial(fila, columna);

            while (!joc.tablero_completo()) {
                TUI.jugar_partida();
            }
            Joc.final_partida();
        }

        public static void cargar_partida () {

            not_implemented();
        }

        public static void configuracion () {
      /*  System.out.println("Aqui en configuración puede cambiar el tamaño del tablero.(Formato 'fila' espacio 'columna').");
        TUI.createConfig(); */
        }

        public static void not_implemented () {

            System.out.println("Método no implementado\n");
        }
    }

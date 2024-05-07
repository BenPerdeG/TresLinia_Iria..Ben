import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        tui.menu();
    }

    public static void nueva_partida() {
        int fila = 0;
        int columna = 0;

        TUI.jugada_inicial();

        while (!Joc.tablero_completo()) {
            TUI.jugar_partida();
        }
        Joc.final_partida();
    }

    public static void cargar_partida (){

        not_implemented();
    }

    public static void configuracion(){
        System.out.println("Aqui en configuración puede cambiar el tamaño del tablero.(Formato 'fila' espacio 'columna').");
        TUI.createConfig();
    }
    public static void not_implemented (){

        System.out.println("Método no implementado\n");
    }
}
public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        tui.menu();
    }

    public static void nueva_partida(){
        int fila = 0;
        int columna = 0;
        TUI.jugada_inicial(fila, columna); //Entrada la nueva partida
         // Muestra el tablero
    }

    public static void cargar_partida (){

        not_implemented();
    }

    public static void congiguracion (){

        not_implemented();
    }
    public static void not_implemented (){
        System.out.println("Metódo no implementado\n");
    }
}


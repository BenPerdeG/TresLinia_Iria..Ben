public class Main {
    public static void main(String[] args) {
        TUI p = new TUI();
        p.menu();
    }

    //Metodos
    public static void nueva_partida(){

        // Comenzar con el tablero vacio
        int i;
        int j;

        for ( i =0 ; i<5; i++){
            for (j= 0; j<5; j++){
                Joc.tablero();
            }
        }
        Joc.mostrar_tablero();

        //Definir con que carácter juega cada uno de los jugadores y quien comienza.

        System.out.println("La máquina juega con: 'x'");
        System.out.println("Usted juega con; 'o'");


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


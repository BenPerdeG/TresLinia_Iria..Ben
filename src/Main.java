public class Main {
    public static void main(String[] args) {
        TUI p = new TUI();
        System.out.println("Bienvenido al increíble y turbo dinámico 'Tres en Raya Hipersport 2024'");
        System.out.println("-----------------------------------------------------------------------");
        p.menu();

    }

    //Metodos
    public static void nueva_partida (){
        Joc.mostrar_tablero();
        // Comenzar con el tablero vacio
        int i;
        int j;

        for ( i =0 ; i<5; i++){
            for (j= 0; j<5; j++){
                //tablero[i][j]= ' ';
            }
        }
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


public class Joc {
    boolean turno_jugador1 = true; // Inicia con el jugador 1
    static char [][] tablero_actual = tablero_nuevo();

//INICIALIZAR EL TABLERO EN BLANCO
    public static char[][]tablero_nuevo(){
        char tab [][] = new char[3][3];
        for (int i = 0; i<tab.length; i++){
            for (int j = 0; j<tab.length; j++){
                tab[i][j] = ' ';
            }
        }
        return tab;
    }

//MOSTRAR TABLERO ACTUALIZADO
    public static void mostrar_tablero(){
        System.out.println(tablero_actual[0][0]+"|"+tablero_actual[0][1]+"|"+tablero_actual[0][2]+"\n"
                +tablero_actual[1][0]+"|"+tablero_actual[1][1]+"|"+tablero_actual[1][2]+"\n"
                +tablero_actual[2][0]+"|"+tablero_actual[2][1]+"|"+tablero_actual[2][2]);
    }

    public boolean alternar_turno (){

        if(turno_jugador1){
            turno_jugador1=true;
        }else{
            turno_jugador1 = false;
        }
        return turno_jugador1;
    }

    public static void jugarX(int coord1, int coord2){

        tablero_actual[coord1-1][coord2-1]='x';
    }

    public void jugarO(int coord1, int coord2){

        tablero_actual[coord1-1][coord2-1]='o';
    }

}

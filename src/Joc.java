public class Joc {

boolean turno_jugador1 = false;
char [][] tablero_actual = tablero();


    public static char[][]tablero(){

        char tab [][] = new char[3][3];

        for (int i = 0; i<tab.length; i++){
            for (int j = 0; j<tab.length; j++){
                tab[i][j] = ' ';
            }
        }
        return tab;
    }

    public static void mostrar_tablero(){
        for (int i =0; i< tablero().length;i++) {

                System.out.println(tablero()[i]);
        }
    }

    public boolean get_jugador1 (){
        if(turno_jugador1){
            turno_jugador1=false;
        }else{
            turno_jugador1 = true;
        }
        return turno_jugador1;
    }
    public void jugar(int coord1, int coord2){
        tablero_actual[coord1-1][coord2-1]='x';

    }
}

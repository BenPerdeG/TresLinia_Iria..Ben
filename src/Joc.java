public class Joc {

boolean turno_jugador1 = false;

    public static char[][]tablero(){

        String linea1 = " | | ";
        String linea2 = " | | ";
        String linea3 = " | | ";



        char tablero[][] = new char[3][5];

        tablero[0] = linea1.toCharArray();

        tablero[1] = linea2.toCharArray();

        tablero[2] = linea3.toCharArray();

        return tablero;
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
    public  static void jugar(int coor1, int coord2){
        tablero()[coor1][coord2]='x';
    }

}

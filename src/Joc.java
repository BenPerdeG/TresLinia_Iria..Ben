public class Joc {


    public static char[][]tablero(){

        String linea1 = " | | ";
        String linea2 = " | | ";
        String linea3 = " | | ";
        String lineamid = "_____";


        char tablero[][] = new char[5][5];

        tablero[0] = linea1.toCharArray();
        tablero[1] = lineamid.toCharArray();
        tablero[2] = linea2.toCharArray();
        tablero[3] = lineamid.toCharArray();
        tablero[4] = linea3.toCharArray();

        return tablero;
    }

    public static void mostrar_tablero(){
        for (int i =0; i< tablero().length;i++) {

                System.out.println(tablero()[i]);
        }
    }
}

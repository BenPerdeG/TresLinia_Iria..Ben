
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.util.Scanner;

//TODAS LAS ENTRADAS Y SALIDAS DE INFORMACIÓN

public class TUI {
    Scanner sc = new Scanner(System.in);
int filaJugador;
int columnaJugador;
    public void mostrarMensaje(String missatge) {

        System.out.println(missatge);
    }

    public short seleccion() {
        //Selección de menú
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch (input) {
            case "1":
                //Nueva partida
                return 1;
            case "2":
                //Cargar partida
                return 2;
            case "3":
                //Configuración
                return 3;
            case "4":
                //Finalizar
                return 4;
            default:
                return 5;
        }
    }

    public short mostrarMenu() {
        System.out.println("Bienvenido al increíble y turbo dinámico 'Tres en Raya Hipersport 2024'");
        System.out.println("-----------------------------------------------------------------------");

        while (true) {
            System.out.println("Por favor seleccione que desea hacer:");
            System.out.println(" 1.Nueva Partida \n 2.Cargar Partida \n 3.Configuración\n 4.Salir\n");
            return seleccion();
        }
    }

    char [][] tablero;

   public void coordenadas(Scanner sc, char[][]tablero) {
        filaJugador= sc.nextInt();
        if(filaJugador==-1){
            crearGuardado(tablero);
            return;
        }
        columnaJugador = sc.nextInt();
   }

    public  void mostrarTablero(char [][] tablero_actual, int filas, int columnas){
        for (int i =0;i<filas;i++){
            for (int j =0;j<columnas;j++){
                System.out.print("|"+ tablero_actual[i][j]+"|");
            }
            System.out.println();
        }
    }



    public void jugada_inicial() {
        System.out.println("Comienza la partida, jugador 1 con: 'x'. \n Ingrese su jugada en formato coordenada (fila columna)");
    }


    //DESARROLLO DEL JUEGO
    void recorrerPartida( int config, char[][] tablero) {

        coordenadas(sc,tablero);
        boolean fila_correcta = (0 < filaJugador) && (filaJugador < config);
        boolean col_correcta = (0 < columnaJugador) && (columnaJugador < config);


            if (!fila_correcta || !col_correcta) {
                System.out.println("Error. La coordenada de la fila o columna, es incorrecta, inténtelo de nuevo: ");
            } else {
                System.out.println("La posición de su ficha es: " + filaJugador + " " + columnaJugador);
            }

    }
    //FINALIZAR JUEGO
    public void finalPartida(char ganador, boolean tablero_completo) {

        if (ganador != ' ') {  // Verifica si hay un ganador primero
            System.out.println("La partida ha sido finalizada.\n");
        } else if (tablero_completo) {  // verifica si el tablero está completo, si no hay ganador
            System.out.println("EMPATE, no hay más casillas libres. \nLa partida ha sido finalizada.\n");
        }
    }

    public boolean victoria(char ganador){

        if (ganador != ' ') {  // Hay un ganador
            System.out.println("El juego ha terminado. \n");
            if (ganador == 'x') {
                System.out.println("¡¡¡FELICIDADES!!! ¡El Jugador 1 ('x') ha ganado! \n");
            } else if (ganador == 'o') {
                System.out.println("¡¡¡FELICIDADES!!! ¡El Jugador 2 ('o') ha ganado! \n");
            }
            return true;  // Devuelve true porque hay un ganador
        }
        return false;  // No hay ganador
    }


    public void createConfig() {
        File config = new File("config.txt");
        try {
            FileWriter esc = new FileWriter("config.txt");
            Scanner sc = new Scanner(System.in);
            String _1 = sc.nextLine();
            if (Integer.parseInt(_1)>10){
                System.out.println("El tablero es muy grande, el limite es 10.\n Tablero por defecto establecido");
                esc.write("3");
                esc.close();
            }
            else if (Integer.parseInt(_1)<3){
                System.out.println("El tablero es muy pequeño, el limite es 3.\n Tablero por defecto establecido");
                esc.write("3");
                esc.close();
            }
            else{
            esc.write(_1);
            esc.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error de Configuración");
        }
    }

    public int readConfig() throws FileNotFoundException {
        Scanner leer = new Scanner(new File("config.txt"));
        try{
            int config = leer.nextInt();


                leer.close();
                return config;
        }
        catch (Exception a){
            return -1;
        }
    }

public void crearGuardado(char[][]tablero){
    File config = new File("guardado.txt");
    try {
        FileWriter esc = new FileWriter("guardado.txt");
        for (int i=0; i<tablero.length;i++){
            for (int j=0; j<tablero.length;j++){
                esc.write(tablero[i][j]);
            }
        }
        esc.close();
    }
    catch(Exception a){
        System.out.println("Error de Guardado");
    }
}
public char[][] leerGuardado(int config) throws FileNotFoundException {
    Scanner leer = new Scanner(new File("guardado.txt"));
    char[][] tablero = new char[config][config];
   for(int i =0; i<config;i++){
    ;
   }
       return tablero;

}

public void crearDirectorio(){
    File directorio = new File("directorio/");

       try{
           if (directorio.exists()) {
                System.out.println("El directorio ya existe.");
            }else {
                if (directorio.mkdir()) {
                    System.out.println("Directorio creado con éxito");
                }
            }
       }catch (Exception e){
           System.out.println("Error en la creación del fichero");
       }
    }
}

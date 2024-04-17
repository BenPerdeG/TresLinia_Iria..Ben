import java.util.Scanner;

public class Tresenraya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        bienvenida();
        menu();

        try{
            int input= sc.nextInt();
            if (input>=5){
                System.out.println("Ha habido un error con el input. Prueba de nuevo");
                menu();
            }
        }catch (Exception e){
            System.out.println("Ha habido un error con el input. Prueba de nuevo");
                menu();
        }
    }


//Métodos

    public static void bienvenida (){
        System.out.println("Bienvenido al increíble y turbo dinámico 'Tres en Raya Hipersport 2024'");

    }

    public static void menu(){
        System.out.println("Por favor seleccione que desea hacer:");
        System.out.println(" 1.Nueva Partida \n 2.Cargar Partida \n 3.Configuración\n 4.Salir");
    }
}

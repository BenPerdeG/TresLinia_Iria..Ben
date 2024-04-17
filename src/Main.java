import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al increíble y turbo dinámico 'Tres en Raya Hipersport 2024'");

        System.out.println("Por favor seleccione que desea hacer:");
        System.out.println(" 1.Nueva Partida \n 2.Cargar Partida \n 3.Configuración\n 4.Salir");

        try{
            int input= sc.nextInt();
            if (input>=5){
                System.out.println("Ha habido un error con el input. Prueba de nuevo");
            }
        }catch (Exception e){
            System.out.println("Ha habido un error con el input. Prueba de nuevo");
        }
    }
}

import java.util.Scanner;
import java.util.Random;

    public class Controlador {




        public static void controlador(){


            Contenedor robot = new Contenedor(1);
            boolean estado;


            Controlador.iniciarPista();



            robot.getEstado();
            robot.setCambiar(1);

            do {
               estado= robot.movimientosAire();

            }while (estado=true);


        }


        private static int iniciarPista() {

            Scanner scanner= new Scanner(System.in);
            int eleccion;


            do {
            System.out.println("MENU DE OPCIONES: \n");
            System.out.println("\t (1)Iniciar pista ");
            eleccion = scanner.nextInt();
            if(eleccion!=1) System.out.println("|||||No es posible iniciar  sin pista||||\n");
            }while (eleccion !=1);

            return 1;
        }


    }













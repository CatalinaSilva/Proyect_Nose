import java.util.Scanner;
import java.util.Random;

    public class Controlador {

        public static void controlador(){

            boolean jugar=true;
            Contenedor robot = new Contenedor(1);

            while (jugar == true){


                boolean estado;


                robot.iniciarPista();
                robot.dejar_de_jugar();

                robot.getEstado();
                robot.setCambiar(1);

                do {
                    estado = robot.movimientosAire();

                } while (estado = true);

            }
            System.out.println("GAME OVER");
        }






    }













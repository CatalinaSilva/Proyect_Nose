import java.util.Scanner;
import java.util.Random;

    public class Controlador {




        public static void controlador(){


            Contenedor robot = new Contenedor(1);
            boolean estado;


            robot.iniciarPista();

            int m=1;

            while(m==1) {

                robot.getEstado();
                m = robot.setDespegarModoAvion(robot.panel.getVelocidad(), robot.panel.getAltura(), robot.panel.getL_pista());
                robot.condiciones_Despegar();
            }
            robot.getEstado();
            robot.Despegar();


            robot.setCambiar(1);
            int cont = 0;
            do {
               estado= robot.movimientosAire();

            }while (estado=true);


        }





    }













import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Contenedor {
    int cambiare;
    private int cambiar;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    String boton;


    public Contenedor(int cambiar) {

        this.cambiar = cambiar;
    }

    public int getCambiar() {

        return cambiar;
    }


    Panel_de_Control panel = new Panel_de_Control("Fighter", 0);
    Cabeza c = new Cabeza(false);
    Brazos b_der = new Brazos(0, 0, false);
    Brazos b_izq = new Brazos(0, 0, false);
    Alas a_der = new Alas(true);
    Alas a_izq = new Alas(true);
    Piernas p_der = new Piernas(false, false, false);
    Piernas p_izq = new Piernas(false, false, false);
    Armas laser = new Armas(10, "laser");
    Piernas anterior = new Piernas(true, false, false); //Va a tomar el mismo valor que boton al caminar

    public Panel_de_Control getPanel() {

        return panel;
    }

    public void setPanel(Panel_de_Control panel) {

        this.panel = panel;
    }

    public int iniciarPista() {

        Scanner scanner= new Scanner(System.in);
        int eleccion;
        do {
            System.out.println("MENU DE OPCIONES: \n");
            System.out.println("\t (1)Iniciar pista ");
            eleccion = scanner.nextInt();
            System.out.println("---------------------------------------------------------------------------------------");
            if(eleccion!=1) System.out.println("|||||No es posible iniciar  sin pista||||");
        }while (eleccion !=1);
        return 1;
    }

    public int setCambiar(int cambiar) {

        switch (cambiar) {

            //Fighter: Avion
            case 1: {
                c.setMostrar_Cabeza(false);
                b_der.setMostrar_brazo(false);
                b_izq.setMostrar_brazo(false);
                a_der.setMostrar_alas(true);
                a_izq.setMostrar_alas(true);
                p_der.setMostrar_piernas(false);
                p_izq.setMostrar_piernas(false);
                panel.setEstado("Fighter");
                break;
            }
            //Battloid: Humanoide
            case 2: {
                c.setMostrar_Cabeza(true);
                b_der.setMostrar_brazo(true);
                b_izq.setMostrar_brazo(true);
                a_der.setMostrar_alas(false);
                a_izq.setMostrar_alas(false);
                p_der.setMostrar_piernas(true);
                p_izq.setMostrar_piernas(true);
                panel.setEstado("Battloid");
                break;
            }
            //Gerwalk: Pajaro
            case 3: {
                c.setMostrar_Cabeza(false);
                b_der.setMostrar_brazo(true);
                b_izq.setMostrar_brazo(true);
                a_der.setMostrar_alas(true);
                a_izq.setMostrar_alas(true);
                p_der.setMostrar_piernas(true);
                p_izq.setMostrar_piernas(true);
                panel.setEstado("Gerwalk");
                break;
            }

        }
        return cambiar;
    }

    public void getEstado() {
        System.out.println("ESTADO DEL ROBOT" +
                "\n \t Modo: " + panel.getEstado() +
                "\n \t Altura: " + panel.getAltura() +
                " metros\n \t Largo pista: " + panel.getL_pista() +
                " metros \n \t Velocidad: " + panel.getVelocidad() +
                " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                "-----------------------------------------------------------------------------------------");
    }

    public int setDespegarModoAvion(int velocidad, int altura, int l_pista) {


        if ((panel.getVelocidad() > 350) && (altura == 0) && ((getCambiar() == 1) || (getCambiar() == 3)))
        {
            System.out.println(" |Esta en condiciones de volar|\n");
            return 0;
        }
        else {
            System.out.println("No cumple condiciones para iniciar vuelo en modo Fighter, presione nuevamente 1.");
            Scanner scanner = new Scanner(System.in);
            int eleccion;
            eleccion = scanner.nextInt();
            return 1;
        }

    }


    public void condiciones_Despegar() {
        panel.setVelocidad(random.nextInt(450)+300);
        panel.setPos_robot(random.nextInt(panel.getL_pista()));


    }



    public int Despegar() {

        int p=0;
        while (p==0) {



             System.out.println("¿Desea despegar? s/n");
             boton = scanner.nextLine();


             if (boton.equals("s")) {
                 panel.setAltura(random.nextInt(950) + 50);
                 cambiare=1;
                 p++;

             }

             if (boton.equals("n")){
                 System.out.println("¿Desea pasar a modo Battloid o Gerwalk o desea despegar? b/g/d");
                 Scanner scanner= new Scanner(System.in);
                 String boton2;
                 boton2=scanner.nextLine();
                 if (boton2.equals("b")){
                     setCambiar(2);
                     cambiare = 2;
                     p++;

                 }

                 if (boton2.equals("g")){
                     setCambiar(3);
                     cambiare = 3;
                     p++;

                 }

                 if (boton2.equals("d")) {
                     panel.setAltura(random.nextInt(950) + 50);
                     cambiare = 1;
                     p++;

                 }

                 if (!boton2.equals("b") && !boton2.equals("g") && !boton2.equals("d")){
                     System.out.println("La tecla presionada no es valida.");
                     p=0;
                 }

             }

             if (!boton.equals("n") && !boton.equals("s")) {
                 System.out.println("La tecla presionada no es valida.");
                 p=0;
             }
        }return cambiare;
    }



    public int movimientosAire() {

        System.out.println("(a) Giro derecha. \t (d) Giro izquerda. \t (w) Aumentar altura. \t (s) Disminuye altura. \n" +
                "(i) Acelerar. \t (k) Desacelerar. \t (j) Disparar. \t (h) Cambiar a modo Battloid. \t(p) Cambiar a modo Gerwalk.\n" );

        boton = scanner.nextLine();

        switch (boton) {


            case "a":
                System.out.println("ESTADO DEL ROBOT" +
                        "\n \t Modo: " + panel.getEstado() +
                        "\n \t Altura: " + panel.getAltura() +
                        " metros\n \t Largo pista: " + panel.getL_pista() +
                        " metros \n \t Velocidad: " + panel.getVelocidad() +
                        " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" + "el robot ha avanzado hacia la izquierda"+
                        "-----------------------------------------------------------------------------------------");
                break;

            case "d":
                System.out.println("ESTADO DEL ROBOT" +
                        "\n \t Modo: " + panel.getEstado() +
                        "\n \t Altura: " + panel.getAltura() +
                        " metros\n \t Largo pista: " + panel.getL_pista() +
                        " metros \n \t Velocidad: " + panel.getVelocidad() +
                        " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" + "el robot ha avanzado hacia la derecha"+
                        "-----------------------------------------------------------------------------------------");
                break;

            case "w": {
                if (panel.getAltura() < 10000) {
                    panel.setAltura(panel.getAltura() + 100);
                    System.out.println("ESTADO DEL ROBOT" +
                            "\n \t Modo: " + panel.getEstado() +
                            "\n \t Altura: " + panel.getAltura() +
                            " metros\n \t Largo pista: " + panel.getL_pista() +
                            " metros \n \t Velocidad: " + panel.getVelocidad() +
                            " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                            "-----------------------------------------------------------------------------------------");
                    break;
                } else System.out.println("El avion ya esta en su altura maxima de vuelo");
                break;
            }

            case "s": {
                if (panel.getAltura() >= 21) {
                    panel.setAltura(panel.getAltura() - 100);
                    System.out.println("ESTADO DEL ROBOT" +
                            "\n \t Modo: " + panel.getEstado() +
                            "\n \t Altura: " + panel.getAltura() +
                            " metros\n \t Largo pista: " + panel.getL_pista() +
                            " metros \n \t Velocidad: " + panel.getVelocidad() +
                            " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                            "-----------------------------------------------------------------------------------------");
                    break;
                } else System.out.println("El avion ya esta en su altura minima de vuelo");
                break;

            }

            case "i":
                if (panel.getVelocidad() <= 750) {
                    panel.setVelocidad(panel.getVelocidad()+100);
                    System.out.println("ESTADO DEL ROBOT" +
                            "\n \t Modo: " + panel.getEstado() +
                            "\n \t Altura: " + panel.getAltura() +
                            " metros\n \t Largo pista: " + panel.getL_pista() +
                            " metros \n \t Velocidad: " + panel.getVelocidad() +
                            " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                            "-----------------------------------------------------------------------------------------");
                    break;
                } else System.out.println("Imposible  acelerar, ya ha alcanzado el maximo");
                break;

            case "k":
                if (panel.getVelocidad() >= 100) {
                    panel.setVelocidad(panel.getVelocidad() - 100);
                    System.out.println("ESTADO DEL ROBOT" +
                            "\n \t Modo: " + panel.getEstado() +
                            "\n \t Altura: " + panel.getAltura() +
                            " metros\n \t Largo pista: " + panel.getL_pista() +
                            " metros \n \t Velocidad: " + panel.getVelocidad() +
                            " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                            "-----------------------------------------------------------------------------------------");
                    break;
                } else {
                    System.out.println("Imposible  desacelerar, ya ha alcanzado el minimo");
                    break;
                }

            case "j": {
                laser.setLaser(panel.getEstado());
                break;
            }

            case "h":{
                if (((panel.getAltura() < 200) && (panel.getEstado().equals("Gerwalk"))) || ((panel.getAltura() < 200) && (panel.getEstado().equals("Fighter")))){
                   setCambiar(2);
                    System.out.println("ESTADO DEL ROBOT" +
                            "\n \t Modo: " + panel.getEstado() +
                            "\n \t Altura: " + panel.getAltura() +
                            " metros\n \t Largo pista: " + panel.getL_pista() +
                            " metros \n \t Velocidad: " + panel.getVelocidad() +
                            " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                            "-----------------------------------------------------------------------------------------");
                    return 2;
                }
                else{
                    System.out.println("No cumple con los requerimientos basicos para cambiar de forma");break;
                }
            }

            case "p":{
                if ((panel.getEstado().equals("Fighter")) || ((panel.getAltura() == 0) && (panel.getEstado().equals("Battloid")))) {
                    setCambiar(3);
                    System.out.println("ESTADO DEL ROBOT" +
                            "\n \t Modo: " + panel.getEstado() +
                            "\n \t Altura: " + panel.getAltura() +
                            " metros\n \t Largo pista: " + panel.getL_pista() +
                            " metros \n \t Velocidad: " + panel.getVelocidad() +
                            " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                            "-----------------------------------------------------------------------------------------");
                    return 3;

                }
                else {
                    System.out.println("No cumple con los requerimientos basicos para cambiar de forma");break;
                }
            }

            //para pasar de gerwalk a battloid, me pase po, ****para el gerwalk******
            /*case "f":{
                if (panel.getEstado().equals("Gerwalk") && panel.getAltura()>0){
                   setCambiar(1);
                    System.out.println("ESTADO DEL ROBOT" +
                            "\n \t Modo: " + panel.getEstado() +
                            "\n \t Altura: " + panel.getAltura() +
                            " metros\n \t Largo pista: " + panel.getL_pista() +
                            " metros \n \t Velocidad: " + panel.getVelocidad() +
                            " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                            "-----------------------------------------------------------------------------------------");break;
                }
                else {
                    System.out.println("No cumple con los requerimientos basicos para cambiar de forma");break;
                }
            }*/

        }

        return 1;
    }

    public int movimientosSuelo() {
        //SOLO SE MUEVE HACIA ADELANTE
        System.out.println("MENU DE OPCIONES CAMINAR EN MODO BATTLOID: Para avanzar presione cualquiera de las siguientes letras" +
                    "\n\t(A): Avanzar con pierna izquierda \n\t(D): Avanzar con pierna derecha " +
                    "\nADVERTENCIA: recuerda que no puedes avanzar dos veces con la misma pierna\n\t" +
                    "Para cambiar a modo Gerwalk presione (P)"+
                    "\n---------------------------------------------------------------------------------------------------------------------");
        
        boton = scanner.nextLine();
        switch (boton) {
            //Avanzar
            case "a": { //PIERNA DERECHA
                p_der.setAvanzar(true);
                p_izq.setAvanzar(false);
                if (anterior == p_der) {
                    System.out.println("No puede avanzar y/o retroceder dos veces con la misma pierna");
                }
                if (p_der.isAvanzar() == true && anterior != p_der) {
                    System.out.println("Ha movido la pierna derecha\n --------------------------------------------------------------------------------------");
                    panel.setPos_robot(panel.getPos_robot() + 10);
                }
                getEstado();
                anterior = p_der;
                break;
            }
            case "d": { //PIERNA IZQUIERDA
                p_izq.setAvanzar(true);
                p_der.setAvanzar(false);
                if (anterior == p_izq) {
                    System.out.println("No puede avanzar y/o retroceder dos veces con la misma pierna");
                }
                if (p_izq.isAvanzar() == true && anterior != p_izq) {
                    System.out.println("Ha movido la pierna izquierda\n ----------------------------------------------------------------------------------------");
                    panel.setPos_robot(panel.getPos_robot() + 10);
                }
                getEstado();
                anterior = p_izq;
                break;
            }
            case "p": {
                if ((panel.getEstado().equals("Fighter")) || ((panel.getAltura() == 0) && (panel.getEstado().equals("Battloid")))) {
                    setCambiar(3);
                    System.out.println("ESTADO DEL ROBOT" +
                            "\n \t Modo: " + panel.getEstado() +
                            "\n \t Altura: " + panel.getAltura() +
                            " metros\n \t Largo pista: " + panel.getL_pista() +
                            " metros \n \t Velocidad: " + panel.getVelocidad() +
                            " km/h \n \t Posicion: " + panel.getPos_robot() + " metros\n" +
                            "-----------------------------------------------------------------------------------------");
                    return 3;

                } else {
                    System.out.println("No cumple con los requerimientos basicos para cambiar de forma");
                    break;
                }
            }

            default: {
                System.out.println("ERROR al leer tecla ingresada, vuelva a presionar");
                System.out.println("-----------------------------------------------------------------------");
                break;
            }
        }
        return 2;
    }
}







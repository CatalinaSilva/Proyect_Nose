public class Brazos {


    private int SubirBajar_Brazo;
    private int DerIzq_Brazo;
    boolean Mostrar_brazo;


    public Brazos( int subirBajar_Brazo, int derIzq_Brazo, boolean mostrar_brazo) {

        SubirBajar_Brazo = subirBajar_Brazo;
        DerIzq_Brazo = derIzq_Brazo;
        Mostrar_brazo = mostrar_brazo;
        Armas armas;
    }





    public int getSubirBajar_Brazo() {
        return SubirBajar_Brazo;
    }

    public void setSubirBajar_Brazo(int subirBajar_Brazo) {
        SubirBajar_Brazo = subirBajar_Brazo;
    }

    public int getDerIzq_Brazo() {
        return DerIzq_Brazo;
    }

    public void setDerIzq_Brazo(int derIzq_Brazo) {
        DerIzq_Brazo = derIzq_Brazo;
    }

    public boolean isMostrar_brazo() {
        return Mostrar_brazo;
    }

    public void setMostrar_brazo(boolean mostrar_brazo) {
        Mostrar_brazo = mostrar_brazo;
    }
}

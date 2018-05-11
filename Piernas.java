public class Piernas {

    boolean Mostrar_piernas;
    boolean Avanzar;
    boolean Retroceder;

    public Piernas(boolean mostrar_piernas, boolean avanzar, boolean retroceder) {
        Mostrar_piernas = mostrar_piernas;
        Avanzar = avanzar;
        Retroceder = retroceder;
    }

    public boolean isMostrar_piernas() {
        return Mostrar_piernas;
    }

    public void setMostrar_piernas(boolean mostrar_piernas) {
        Mostrar_piernas = mostrar_piernas;
    }

    public boolean isAvanzar() {
        return Avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        Avanzar = avanzar;
    }

    public boolean isRetroceder() {
        return Retroceder;
    }

    public void setRetroceder(boolean retroceder) {
        Retroceder = retroceder;
    }
}

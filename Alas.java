public class Alas {


    private String Armas;
    boolean Mostrar_alas;


    public Alas(String armas, boolean mostrar_alas) {
        Armas = armas;
        Mostrar_alas = mostrar_alas;
    }

    public String getArmas() {
        return this.Armas;
    }

    public void setArmas(String armas) {
        this.Armas = armas;
    }

    public boolean isMostrar_alas() {
        return Mostrar_alas;
    }

    public void setMostrar_alas(boolean mostrar_alas) {
        Mostrar_alas = mostrar_alas;
    }
}

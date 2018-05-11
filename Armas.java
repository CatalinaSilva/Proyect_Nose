public class Armas {

    private int  Laser;
    private int Canion;
    boolean Preparar;
    boolean Apuntar;
    boolean Disparar;

    //constructor de armas; laser u otro tipo de armas que pudiera tener


    public Armas(int laser, int canion) {
        Laser = laser;
        Canion = canion;
    }

    //getter
    public int getLaser() {
        return Laser;
    }

    public int getCanion() {
        return Canion;
    }

    public boolean isPreparar() {
        return Preparar;
    }

    public boolean isApuntar() {
        return Apuntar;
    }

    public boolean isDisparar() {
        return Disparar;
    }

    //setter


    public void setLaser(int laser) {
        Laser = laser;
    }

    public void setCanion(int canion) {
        Canion = canion;
    }

    public void setPreparar(boolean preparar) {
        Preparar = preparar;
    }

    public void setApuntar(boolean apuntar) {
        Apuntar = apuntar;
    }

    public void setDisparar(boolean disparar) {
        Disparar = disparar;
    }
}

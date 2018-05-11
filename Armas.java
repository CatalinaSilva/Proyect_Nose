public class Armas {
    private int balas;
    private String tipo;

    public Armas( int balas, String tipo) {
        this.balas = balas;
        this.tipo = tipo;

    }


    public int getBalas() {
        return balas;
    }

    public String getTipo() {
        return tipo;
    }

    public void   setLaser(String estado) {

        switch (estado){
            case "Batlloid":
                System.out.println("El modo Battloid no dispone de armas laser"); break;

            case "Fighter":
                if (this.balas >0 )this.balas= this.balas -1;
                System.out.println("Carga del laser "+ this.balas +"0%");
            break;

        }


    }
}


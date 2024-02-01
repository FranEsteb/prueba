public class Arbitro {
    String nombre;
    String colegio;
    int velocidad;
    int acierto;
    boolean activo;
    public Arbitro(String nombre, String colegio, int velocidad, int acierto, boolean activo) {
        this.nombre = nombre;
        this.colegio = colegio;
        this.velocidad = velocidad;
        this.acierto = acierto;
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String toString() {
        return "Arbitro\n-------\n" +
                "nombre:'" + nombre + '\'' +
                ", colegio:'" + colegio + '\'' +
                ", velocidad:" + velocidad +
                ", acierto:" + acierto +
                ", activo:" + activo
                ;
    }
}


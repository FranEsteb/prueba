public class Jugador {
    String nombre;
    String posicion;
    int velocidad;
    int regate;
    boolean lesionado;
    //constructor
    public Jugador(String nombre, String posicion, int velocidad, int regate, boolean lesionado) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.velocidad = velocidad;
        this.regate = regate;
        this.lesionado = lesionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getRegate() {
        return regate;
    }

    public void setRegate(int regate) {
        this.regate = regate;
    }

    public boolean isLesionado() {
        return lesionado;
    }

    public void setLesionado(boolean lesionado) {
        this.lesionado = lesionado;
    }

    public String toString() {
        return "Jugador\n-------\n" +
                "nombre:'" + nombre + '\'' +
                ", posicion:'" + posicion + '\'' +
                ", velocidad:" + velocidad +
                ", regate:" + regate +
                ", lesionado:" + lesionado;
    }
}

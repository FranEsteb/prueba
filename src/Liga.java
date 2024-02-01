import java.util.ArrayList;
import java.util.Scanner;

public class Liga {
    public static Scanner teclado = new Scanner(System.in);
    public static ArrayList listaPer = new ArrayList();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            menu();
            System.out.println("elige opcion");
            opcion = tcInt();

            switch (opcion) {
                case 1:
                    System.out.println("Insertando Jugador...");
                    insertaJugador();
                    break;
                case 2:
                    System.out.println("Insertando Árbitro...");
                    insertaArbitro();
                    break;
                case 3:
                    System.out.println("Mostrando Lista de Personas...");
                    mostrarTodo(listaPer);
                    break;
                case 4: 
                    /*System.out.println("Ordenando Personas por Velocidad (Iterativo)..."); 
                    ordenaPerVelo();*/
                    System.out.println("Ordenando Personas por Velocidad (Recursivo)...");
                    ordenaPerVeloRecursivo(listaPer.size() - 1);
                    break;
                case 5:
                    System.out.println("Mostrando Solo Jugadores...");
                    mostrarSoloJugadores();
                    break;
                case 7:
                    System.out.println("Buscando Persona por Nombre...");
                    teclado.nextLine(); // Consumir el salto de línea pendiente 
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscado = teclado.nextLine();
                    buscarPersonaRecursivo(0, nombreBuscado);
                    break;
                case 8:
                    System.out.println("Buscando Jugador con Más Regate (Recursivo)...");
                    jugadorMasRegateRecursivo(0, null, -1);
                    break;
                case 9:
                    System.out.println("Calculando Suma de Todas las Velocidades...");
                    System.out.println("Suma total de velocidades: " + sumaVelocidades());
                    break;
                case 10:
                    System.out.println("Programa Finalizado");
                    break;
                default:
                    System.out.println("Introduce un número del 1 al 10");
                    break;
            }
        }while (opcion!=10);
    }

    private static int tcInt() {
        int valorIngresado = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print("Ingrese un número entero: ");
                valorIngresado = teclado.nextInt();
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                teclado.nextLine(); // Limpiar el búfer de entrada
            }
        } while (!entradaValida);

        return valorIngresado;
    }
    private static void jugadorMasRegateRecursivo(int i, Jugador maxRegateJugador, int maxRegate) {
        if (i >= listaPer.size()) {
            if (maxRegateJugador != null) {
                System.out.println("Jugador con más regate:\n" + maxRegateJugador);
            } else {
                System.out.println("No hay jugadores en la lista.");
            }
            return;
        }

        Object persona = listaPer.get(i);

        if (persona instanceof Jugador) {
            Jugador jugador = (Jugador) persona;
            if (jugador.getRegate() > maxRegate) {
                maxRegate = jugador.getRegate();
                maxRegateJugador = jugador;
            }
        }

        jugadorMasRegateRecursivo(i + 1, maxRegateJugador, maxRegate);
    }
    private static boolean leerBool() {
        boolean entradaValida = false;
        boolean valorIngresado = false;

        do {
            System.out.print("Ingrese 's' para true o 'n' para false: ");
            String entrada = teclado.nextLine();

            if (entrada.equalsIgnoreCase("s")) {
                valorIngresado = true;
                entradaValida = true;
            } else if (entrada.equalsIgnoreCase("n")) {
                valorIngresado = false;
                entradaValida = true;
            } else {
                System.out.println("Error: Debe ingresar 's' o 'n'.");
            }
        } while (!entradaValida);

        return valorIngresado;
    }
    private static void ordenaPerVeloRecursivo(int j) {
        if (j > 0) {
            for (int i = 0; i < j; i++) {
                Object persona1 = listaPer.get(i);
                Object persona2 = listaPer.get(i + 1);

                int velocidad1 = getVelocidad(persona1);
                int velocidad2 = getVelocidad(persona2);

                if (velocidad1 < velocidad2) {
                    // Intercambia las posiciones si es necesario 
                    listaPer.set(i, persona2);
                    listaPer.set(i + 1, persona1);
                }
            }

            // Llamada recursiva para la siguiente pasada 
            ordenaPerVeloRecursivo(j - 1);
        }
    }

    private static void mostrarTodo(ArrayList lista) {
        for (int i = 0; i < lista.size(); i++) {
            Object persona = lista.get(i);
            System.out.println(persona);
        }
    }


    private static void ordenaPerVelo() {
        for (int i = 0; i < listaPer.size(); i++) {
            for (int j = 0; j < listaPer.size() - 1 - i; j++) {
                Object persona1 = listaPer.get(j);
                Object persona2 = listaPer.get(j + 1);

                int velocidad1 = getVelocidad(persona1);
                int velocidad2 = getVelocidad(persona2);

                if (velocidad1 < velocidad2) {
                    // Swap 
                    listaPer.set(j, persona2);
                    listaPer.set(j + 1, persona1);
                }
            }
        }
    }

    private static int getVelocidad(Object persona) {
        if (persona instanceof Jugador) {
            return ((Jugador) persona).getVelocidad();
        } else if (persona instanceof Arbitro) {
            return ((Arbitro) persona).getVelocidad();
        }
        return 0;
    }

    private static void mostrarSoloJugadores() {
        for (int i = 0; i < listaPer.size(); i++) {
            Object persona = listaPer.get(i);
            if (persona instanceof Jugador) {
                System.out.println(persona);
            }
        }
    }

    private static void buscarPersonaRecursivo(int index, String nombreBuscado) {
        if (index >= listaPer.size()) {
            System.out.println("Persona no encontrada.");
            return;
        }

        Object persona = listaPer.get(index);
        String nombre;

        if (persona instanceof Jugador) {
            nombre = ((Jugador) persona).getNombre();
        } else if (persona instanceof Arbitro) {
            nombre = ((Arbitro) persona).getNombre();
        } else {
            buscarPersonaRecursivo(index + 1, nombreBuscado);
            return;
        }

        if (nombre.equalsIgnoreCase(nombreBuscado)) {
            System.out.println(persona);
        } else {
            buscarPersonaRecursivo(index + 1, nombreBuscado);
        }
    }
 
    /*private static void buscarPersona() { 
        teclado.nextLine(); // Consumir el salto de línea pendiente 
        System.out.print("Ingrese el nombre a buscar: "); 
        String nombreBuscado = teclado.nextLine(); 
 
        boolean encontrado = false; 
 
        for (int i = 0; i < listaPer.size(); i++) { 
            Object persona = listaPer.get(i); 
            String nombre; 
 
            if (persona instanceof Jugador) { 
                nombre = ((Jugador) persona).getNombre(); 
            } else if (persona instanceof Arbitro) { 
                nombre = ((Arbitro) persona).getNombre(); 
            } else { 
                continue; 
            } 
 
            if (nombre.equalsIgnoreCase(nombreBuscado)) { 
                System.out.println(persona); 
                encontrado = true; 
                break; 
            } 
        } 
 
        if (!encontrado) { 
            System.out.println("Persona no encontrada."); 
        } 
    }*/

    private static void jugadorMasRegate() {
        Jugador maxRegateJugador = null;
        int maxRegate = -1;

        for (int i = 0; i < listaPer.size(); i++) {
            Object persona = listaPer.get(i);
            if (persona instanceof Jugador) {
                Jugador jugador = (Jugador) persona;
                if (jugador.getRegate() > maxRegate) {
                    maxRegate = jugador.getRegate();
                    maxRegateJugador = jugador;
                }
            }
        }

        if (maxRegateJugador != null) {
            System.out.println("Jugador con más regate:\n" + maxRegateJugador);
        } else {
            System.out.println("No hay jugadores en la lista.");
        }
    }

    private static int sumaVelocidades() {
        int suma = 0;

        for (int i = 0; i < listaPer.size(); i++) {
            Object persona = listaPer.get(i);
            if (persona instanceof Jugador) {
                suma += ((Jugador) persona).getVelocidad();
            } else if (persona instanceof Arbitro) {
                suma += ((Arbitro) persona).getVelocidad();
            }
        }

        return suma;
    }

    private static void insertaArbitro() {
        System.out.print("Ingrese el nombre del arbitro: ");
        // Consumir el salto de línea pendiente, si no lo hago nombre y colegio se aplican a la vez 
        teclado.nextLine();
        String nombre = teclado.nextLine();

        System.out.print("Ingrese el colegio del arbitro: ");
        String colegio = teclado.nextLine();

        int velocidad = (int) (Math.random() * 100 + 0);
        int acierto = (int) (Math.random() * 100 + 0);

        System.out.print("¿El arbitro está activo? (true/false): ");
        boolean activo = teclado.nextBoolean();

        Arbitro arbitro = new Arbitro(nombre, colegio, velocidad, acierto, activo);
        listaPer.add(arbitro);
    }

    private static void insertaJugador() {
        System.out.print("Ingrese el nombre del jugador: ");
        // Consumir el salto de línea pendiente 
        teclado.nextLine();
        String nombre = teclado.nextLine();

        System.out.print("Ingrese la posición del jugador: ");
        String posicion = teclado.nextLine();

        int velocidad = (int) (Math.random() * 100 + 0);
        int regate = (int) (Math.random() * 100 + 0);

        System.out.print("¿El jugador está lesionado? (true/false): ");
        boolean lesionado = leerBool();

        Jugador jugador = new Jugador(nombre, posicion, velocidad, regate, lesionado);
        listaPer.add(jugador);
    }

    public static void menu() {
        System.out.println(
                "1) inserta jugador\n" +
                        "2) inserta arbitro\n" +
                        "3) mostrar todo el vector\n" +
                        "4) Ordenar personas por velocidad (recursivo)\n" +
                        "5) Mostrar solo jugadores\n" +
                        "7) Buscar jugador o arbitro por nombre (iterativo y recursivo)\n" +
                        "8) Jugador con más regate (recursivo)\n" +
                        "9) Suma todas las velocidades (recursivo)\n" +
                        "10) Salir del programa"
        );
    }
} 
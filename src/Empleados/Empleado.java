package Empleados;

/**
 * Esta clase es una clase abstracta que representa un empleado en una empresa.
 * Tiene los siguientes campos:
 * - nombre: el nombre del empleado.
 * - apellido: el apellido del empleado.
 * - cedula: la cédula del empleado.
 * - cantidad_Hijos: el número de hijos del empleado.
 * Tiene un constructor que inicializa estos campos.
 * Además, tiene dos métodos abstractos:
 * - sueldoGeneral(): devuelve el sueldo neto del empleado.
 * - valuesList(): devuelve un arreglo de cadenas que contiene los valores de los campos del empleado.
 *
 * @author (Francisco Rojas)
 */
abstract class Empleado {
    public String nombre;
    public String apellido;
    public String cedula;
    public int cantidad_Hijos;

    public Empleado(String nombre, String apellido, String cedula, int cantidad_Hijos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.cantidad_Hijos = cantidad_Hijos;
    }
    /**
     * Este método devuelve el sueldo neto del empleado.
     * @return el sueldo neto del empleado.
     */
    abstract double sueldoGeneral();

    /**
     * Este método devuelve un arreglo de cadenas que contiene los valores de los campos del empleado.
     * @return un arreglo de cadenas que contiene los valores de los campos del empleado.
     */
    abstract String[] valuesList();
}



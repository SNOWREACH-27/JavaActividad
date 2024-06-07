package Empleados;

/**
 * Esta clase representa un empleado temporal en una empresa.
 * Tiene los siguientes campos:
 * - nombre: el nombre del empleado.
 * - apellido: el apellido del empleado.
 * - cedula: la cédula del empleado.
 * - cantidad_Hijos: el número de hijos del empleado.
 * - fechaAlta: la fecha de alta del empleado.
 * - fechaBaja: la fecha de baja del empleado.
 * Tiene un constructor que inicializa estos campos.
 * Además, tiene dos métodos:
 * - sueldoGeneral(): devuelve el sueldo neto del empleado.
 * - valuesList(): devuelve un arreglo de cadenas que contiene los valores de los campos del empleado.
 * @author (Francisco Rojas)
 */
public class EmpleadoTemporal extends Empleado{
    double SUELDO_BASE  = 18000;
    double ADICIONAL_POR_HIJO  = 1000;
    String fechaAlta;
    String fechaBaja;

    public EmpleadoTemporal(String nombre, String apellido, String cedula, int cantidad_Hijos,String fechaAlta, String fechaBaja) {
        super(nombre, apellido, cedula, cantidad_Hijos);
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }
    
    /**
     * Este método devuelve el sueldo neto del empleado.
     * @return el sueldo neto del empleado.
     */
    double sueldoGeneral() {
        return SUELDO_BASE + (ADICIONAL_POR_HIJO  * cantidad_Hijos);
    }
    
    /**
     * Este método devuelve un arreglo de cadenas que contiene los valores de los campos del empleado.
     * @return un arreglo de cadenas que contiene los valores de los campos del empleado.
     */
    public String[] valuesList(){
        return new String[] {nombre,apellido,cedula,Integer.toString(cantidad_Hijos),"Temporal","****","****",fechaAlta,fechaBaja,Double.toString(sueldoGeneral()) + "bsS"};
    }
}

package Empleados;

/**
 * Esta clase representa un empleado por hora en una empresa.
 *
 * Tiene los siguientes campos:
 * - nombre: el nombre del empleado.
 * - apellido: el apellido del empleado.
 * - cedula: la cédula del empleado.
 * - cantidad_Hijos: el número de hijos del empleado.
 * - horasTrabajadas: el número de horas trabajadas por el empleado.
 *
 * Tiene un constructor que inicializa estos campos.
 *
 * Además, tiene dos métodos:
 * - sueldoGeneral(): devuelve el sueldo neto del empleado.
 * - valuesList(): devuelve un arreglo de cadenas que contiene los valores de los campos del empleado.
 *
 * @author (Francisco Rojas)
 */
public class EmpleadoPorHora extends Empleado{
    double SUELDO_POR_HORA  = 100;
    int horasTrabajadas; 
    
    /**
     * Crea un nuevo objeto de tipo EmpleadoPorHora.
     * @param nombre el nombre del empleado.
     * @param apellido el apellido del empleado.
     * @param cedula la cédula del empleado.
     * @param cantidad_Hijos el número de hijos del empleado.
     * @param horasTrabajadas el número de horas trabajadas por el empleado.
     */
    public EmpleadoPorHora(String nombre, String apellido, String cedula, int cantidad_Hijos, int horasTrabajadas) {
        super(nombre, apellido, cedula, cantidad_Hijos);
        this.horasTrabajadas = horasTrabajadas;
    }
    
    /**
     * Este método devuelve el sueldo neto del empleado.
     * @return el sueldo neto del empleado.
     */
    double sueldoGeneral() {
        return SUELDO_POR_HORA * horasTrabajadas;
    }
    
    /**
     * Este método devuelve un arreglo de cadenas que contiene los valores de los campos del empleado.
     * @return un arreglo de cadenas que contiene los valores de los campos del empleado.
     */
    public String[] valuesList(){
        return new String[] {nombre,apellido,cedula,Integer.toString(cantidad_Hijos),"Por Hora",Integer.toString(horasTrabajadas),"****","****","****",Double.toString(sueldoGeneral()) + "bsS"};
    }
}


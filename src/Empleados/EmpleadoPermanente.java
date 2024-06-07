package Empleados;

/**
 * Esta clase representa un empleado de planta permanente en una empresa.
 * Tiene los siguientes campos:
 * - nombre: el nombre del empleado.
 * - apellido: el apellido del empleado.
 * - cedula: la cédula del empleado.
 * - cantidad_Hijos: el número de hijos del empleado.
 * - AñosServicios: el número de años que el empleado ha trabajado en la empresa.
 * Tiene un constructor que inicializa estos campos.
 * Además, tiene dos métodos:
 * - sueldoGeneral(): devuelve el sueldo neto del empleado.
 * - valuesList(): devuelve un arreglo de cadenas que contiene los valores de los campos del empleado.
 * @author (Francisco Rojas)
 */
public class EmpleadoPermanente extends Empleado{
    double SUELDO_BASE  = 20000;
    double ADICIONAL_POR_HIJO  = 1000;
    double ADICIONAL_POR_ANTIGUEDAD  = 1000; 
    int AñosServicios;

    public EmpleadoPermanente(String nombre, String apellido, String cedula, int cantidad_Hijos, int AñosServicios) {
        super(nombre, apellido, cedula, cantidad_Hijos);
        this.AñosServicios = AñosServicios ;
    }
    /**
     * Este método devuelve el sueldo neto del empleado.
     * @return el sueldo neto del empleado.
     */
    public double sueldoGeneral() {
        return SUELDO_BASE + (ADICIONAL_POR_HIJO * cantidad_Hijos) + (ADICIONAL_POR_ANTIGUEDAD * AñosServicios);
    }
    
    /**
     * Este método devuelve un arreglo de cadenas que contiene los valores de los campos del empleado.
     * @return un arreglo de cadenas que contiene los valores de los campos del empleado.
     */
    public String[] valuesList(){
        return new String[] { nombre, apellido, cedula, Integer.toString(cantidad_Hijos),"Permanente","****", Integer.toString(AñosServicios),"****","****",Double.toString(sueldoGeneral())+ "bsS"};
    }
}

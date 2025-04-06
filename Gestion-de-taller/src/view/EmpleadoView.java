package view;

import dao.EmpleadoDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Empleado;

public class EmpleadoView {
    Scanner scanner = new Scanner(System.in);
private List<Empleado> empleados = new ArrayList<>();
private EmpleadoDao empleadoDao = new EmpleadoDao();

    public Empleado crearEmpleado(){
        String nombreEmpleado;
        String apellidoEmpleado;
        String dniEmpleado;
        String puestoEmpleado;
        double salarioEmpleado;

        System.out.println("                          ");
        System.out.println("==========================");
        System.out.println("                          ");
        System.out.println("Ingresa un nombre: ");
        nombreEmpleado = scanner.nextLine();
        System.out.println("Ingresa un apellido: ");
        apellidoEmpleado = scanner.nextLine();
        System.out.println("Ingrese el DNI: ");
        dniEmpleado = scanner.nextLine();
        System.out.println("Ingrese el puesto: ");
        puestoEmpleado = scanner.nextLine();
        System.out.println("Ingrese el salario: ");
        salarioEmpleado = scanner.nextDouble();

        Empleado empleado = new Empleado(nombreEmpleado, apellidoEmpleado, dniEmpleado, puestoEmpleado, salarioEmpleado);
        empleadoDao.insertar(empleado);
        return empleado;
    }

    public void gestionarEmpleado(){
        String dni = "";
        int opcion;
        do { 
            System.out.println("                          ");
            System.out.println("==========================");
            System.out.println("                          ");
            System.out.println("1. Eliminar empleado");
            System.out.println("2. Actualizar datos empleado");
            System.out.println("3. Mostrar todos los empleados");
            System.out.println("4. Mostrar datos de un empleado");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch(opcion) {
                case 1 -> {
                    System.out.println("Ingrese el DNI del empleado a eliminar: ");
                    dni = scanner.nextLine();
                    empleadoDao.eliminar(dni);
                }
                case 2 -> {
                    System.out.println("Ingrese el DNI del empleado a actualizar: ");
                    dni = scanner.nextLine();
                    if (empleadoDao.obtenerPorDni(dni) == null) {
                        System.out.println("Empleado no encontrado.");
                        break;
                    }
                    int respuesta;
                    do { 
                        System.out.println("                          ");
                        System.out.println("==========================");
                        System.out.println("                          ");
                        System.out.println("1. Actualizar nombre");
                        System.out.println("2. Actualizar apellido");
                        System.out.println("3. Actualizar DNI");
                        System.out.println("4. Actualizar puesto");
                        System.out.println("5. Actualizar salario");
                        System.out.println("6. Salir");
                        respuesta = scanner.nextInt();
                        scanner.nextLine(); 

                        switch(respuesta) {
                            case 1 -> {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevoNombre = scanner.nextLine();
                                empleadoDao.actualizarNombre(dni, nuevoNombre);
                            }
                            case 2 -> {
                                System.out.println("Ingrese el nuevo apellido: ");
                                String nuevoApellido = scanner.nextLine();
                                empleadoDao.actualizarApellido(dni, nuevoApellido);
                            }
                            case 3 -> {
                                System.out.println("Ingrese el nuevo DNI: ");
                                String nuevoDni = scanner.nextLine();
                                empleadoDao.actualizarDni(dni, nuevoDni);
                            }
                            case 4 -> {
                                System.out.println("Ingrese el nuevo puesto: ");
                                String nuevoPuesto = scanner.nextLine();
                                empleadoDao.actualizarPuesto(dni, nuevoPuesto);
                            }
                            case 5 -> {
                                System.out.println("Ingrese el nuevo salario: ");
                                double nuevoSalario = scanner.nextDouble();
                                empleadoDao.actualizarSalario(dni, nuevoSalario);
                            }
                            case 6 -> {
                                System.out.println("Saliendo...");
                            }
                            default -> {
                                System.out.println("Opción no válida, intenta de nuevo.");
                            }
                        }
                    } while (respuesta != 6);
                }
                case 3 -> {
                    System.out.println("Mostrando todos los empleados...");
                    List<Empleado> listaEmpleados = empleadoDao.obtenerTodos();
                    for (Empleado e : listaEmpleados) {
                        System.out.println(e.toString());
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el DNI del empleado: ");
                    dni = scanner.nextLine();
                    Empleado empleado = empleadoDao.obtenerPorDni(dni);
                    if (empleado != null) {
                        System.out.println(empleado.toString());
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                }
                case 5 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opción no válida, intenta de nuevo.");
                }
            }
        } while (opcion != 5);
    }
    
}

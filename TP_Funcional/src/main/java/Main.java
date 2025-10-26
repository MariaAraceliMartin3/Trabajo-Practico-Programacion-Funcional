import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        //Csso Práctico 1
        System.out.println("CASO PRÁCTICO 1");

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Juan", 8, "3K9"));
        alumnos.add(new Alumno("Carolina", 5, "3K9"));
        alumnos.add(new Alumno("Sofia", 9, "3K10"));
        alumnos.add(new Alumno("Luis", 6, "3K10"));

        System.out.println("Aprobados con nota mayor a 7: " +
                alumnos.stream()
                        .filter(a -> a.getNota() >= 7)
                        .map(a -> a.getNombre().toUpperCase())
                        .sorted()
                        .toList()
        );

        System.out.println("Promedio general de notas: " +
                alumnos.stream()
                        .mapToDouble(Alumno::getNota)
                        .average()
                        .orElse(0)
        );

        System.out.println("Alumnos por curso: " +
                alumnos.stream()
                        .collect(Collectors.groupingBy(Alumno::getCurso))
        );

        System.out.println("Mejores 3 promedios: " +
                alumnos.stream()
                        .sorted(Comparator.comparing(Alumno::getNota).reversed())
                        .limit(3)
                        .toList()
        );

        System.out.println("____________________");

        //Caso Práctico 2
        System.out.println("CASO PRÁCTICO 2");

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Coca Cola 500ml", "Gaseosas", 180, 10));
        productos.add(new Producto("Pepsi 500ml", "Gaseosas", 160, 13));
        productos.add(new Producto("Cepita Durazno 345ml", "Jugos Preparados", 130, 7));
        productos.add(new Producto("Baggio Manzana 345ml", "Jugos Preparados", 60, 3));

        System.out.println("Productos con precio mayor a 100: " +
                productos.stream()
                        .filter(p -> p.getPrecio() > 100)
                        .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                        .toList()
        );

        System.out.println("Stock por categoría: " +
                productos.stream()
                        .collect(Collectors.groupingBy(Producto::getCategoria,
                                Collectors.summingInt(Producto::getStock)))
        );

        System.out.println("Lista de productos: " +
                productos.stream()
                        .map(p -> p.getNombre() + " - $" + p.getPrecio())
                        .collect(Collectors.joining("; "))
        );

        System.out.println("Promedio de precios: " +
                productos.stream()
                        .mapToDouble(Producto::getPrecio)
                        .average()
                        .orElse(0)
        );

        System.out.println("Promedio por categoría: " +
                productos.stream()
                        .collect(Collectors.groupingBy(Producto::getCategoria,
                                Collectors.averagingDouble(Producto::getPrecio)))
        );

        System.out.println("____________________");

        //Caso Práctico 3
        System.out.println("CASO PRÁCTICO 3");

        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("Harry Potter y el prisionero de Azkabán", "JK Rowling", 700, 55000));
        libros.add(new Libro("El juego de Ender", "Orson Scott Card", 400, 32000));
        libros.add(new Libro("Harry Potter y la piedra filosofal", "JK Rowling", 200, 20000));
        libros.add(new Libro("Mendoza Tiembla", "Martín Rumbo", 100, 9000));

        System.out.println("Libros con más de 300 páginas: " +
                libros.stream()
                        .filter(l -> l.getPaginas() > 300)
                        .map(Libro::getTitulo)
                        .sorted()
                        .toList()
        );

        System.out.println("Promedio de páginas: " +
                libros.stream()
                        .mapToInt(Libro::getPaginas)
                        .average()
                        .orElse(0)
        );

        System.out.println("Cantidad de libros por autor: " +
                libros.stream()
                        .collect(Collectors.groupingBy(Libro::getAutor, Collectors.counting()))
        );

        System.out.println("Libro más caro: " +
                libros.stream()
                        .max(Comparator.comparing(Libro::getPrecio))
                        .map(Libro::getTitulo)
                        .orElse("Lista vacía")
        );

        System.out.println("____________________");

        //Caso Práctico 4
        System.out.println("CASO PRÁCTICO 4");

        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Carlos", "Reposición", 1000, 21));
        empleados.add(new Empleado("Laura", "Caja", 2600, 45));
        empleados.add(new Empleado("Mario", "Caja", 2100, 37));
        empleados.add(new Empleado("Cecilia", "Reposición", 1500, 25));

        System.out.println("Empleados cuyo salario es mayor a 2000: " +
                empleados.stream()
                        .filter(e -> e.getSalario() > 2000)
                        .sorted(Comparator.comparing(Empleado::getSalario).reversed())
                        .toList()
        );

        System.out.println("Promedio de salario: " +
                empleados.stream()
                        .mapToDouble(Empleado::getSalario)
                        .average()
                        .orElse(0)
        );

        System.out.println("Suma de salarios por departamento: " +
                empleados.stream()
                        .collect(Collectors.groupingBy(Empleado::getDepartamento,
                                Collectors.summingDouble(Empleado::getSalario)))
        );

        System.out.println("2 empleados más jóvenes: " +
                empleados.stream()
                        .sorted(Comparator.comparing(Empleado::getEdad))
                        .limit(2)
                        .map(Empleado::getNombre)
                        .toList()
        );
    }
}
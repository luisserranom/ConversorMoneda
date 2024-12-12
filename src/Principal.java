import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*******************************");
            System.out.println("Sea Bienvenido/a al conversor de Moneda =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("**********************************");

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el valor que deseas convertir: ");
                    double cantidad = scanner.nextDouble();
                    try {
                        double resultado = ConsultaMoneda.convertirMoneda(cantidad, "USD", "ARS");
                        System.out.println("El resultado de la conversión es: " + resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese el valor que deseas convertir: ");
                    double cantidad = scanner.nextDouble();
                    try {
                        double resultado = ConsultaMoneda.convertirMoneda(cantidad, "ARS", "USD");
                        System.out.println("El resultado de la conversión es: " + resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el valor que deseas convertir: ");
                    double cantidad = scanner.nextDouble();
                    try {
                        double resultado = ConsultaMoneda.convertirMoneda(cantidad, "USD", "BRL");
                        System.out.println("El resultado de la conversión es: " + resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el valor que deseas convertir: ");
                    double cantidad = scanner.nextDouble();
                    try {
                        double resultado = ConsultaMoneda.convertirMoneda(cantidad, "BRL", "USD");
                        System.out.println("El resultado de la conversión es: " + resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese el valor que deseas convertir: ");
                    double cantidad = scanner.nextDouble();
                    try {
                        double resultado = ConsultaMoneda.convertirMoneda(cantidad, "USD", "COP");
                        System.out.println("El resultado de la conversión es: " + resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.print("Ingrese el valor que deseas convertir: ");
                    double cantidad = scanner.nextDouble();
                    try {
                        double resultado = ConsultaMoneda.convertirMoneda(cantidad, "COP", "USD");
                        System.out.println("El resultado de la conversión es: " + resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
                    }
                }
                case 7 -> System.out.println("Hasta luego!");
                default -> System.out.println("Elija una opción válida:");
            }
        } while (opcion != 7);
    }
}

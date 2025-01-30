package pizza;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.print("Elige una opción: ");
            System.out.println("1. Nueva pizza");
            System.out.println("2. Nuevo cliente");
            System.out.println("3. Realizar un pedido");
            System.out.println("4. Ver pizzas");
            System.out.println("5. Ver pedidos");
            System.out.println("6. Ver clientes");
            System.out.println("7. Consultar cliente mediante su teléfono");
            System.out.println("8. Buscar pizzas con ingrediente");
            System.out.println("9. Buscar pizzas sin ingrediente");
            System.out.println("10. Pedidos de hoy");
            System.out.println("11. Pedidos consumidos en el local");
            System.out.println("12. Pedidos para recoger");
            System.out.println("13. Pedidos a domicilio");
            System.out.println("14. Pizza más cara");
            System.out.println("15. Pizza más barata");
            System.out.println("16. Último pedido realizado");
            System.out.println("17. Salir");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Opción 1: Nueva pizza");
                    break;
                case 2:
                    System.out.println("Opción 2: Nuevo cliente");
                    break;
                case 3:
                    System.out.println("Opción 3: Realizar un pedido");
                    break;
                case 4:
                    System.out.println("Opción 4: Ver pizzas");
                    break;
                case 5:
                    System.out.println("Opción 5: Ver pedidos");
                    break;
                case 6:
                    System.out.println("Opción 6: Ver clientes");
                    break;
                case 7:
                    System.out.println("Opción 7: Consultar cliente mediante su teléfono");
                    break;
                case 8:
                    System.out.println("Opción 8: Buscar pizzas con ingrediente");
                    break;
                case 9:
                    System.out.println("Opción 9: Buscar pizzas sin ingrediente");
                    break;
                case 10:
                    System.out.println("Opción 10: Pedidos de hoy");
                    break;
                case 11:
                    System.out.println("Opción 11: Pedidos consumidos en el local");
                    break;
                case 12:
                    System.out.println("Opción 12: Pedidos para recoger");
                    break;
                case 13:
                    System.out.println("Opción 13: Pedidos a domicilio");
                    break;
                case 14:
                    System.out.println("Opción 14: Pizza más cara");
                    break;
                case 15:
                    System.out.println("Opción 15: Pizza más barata");
                    break;
                case 16:
                    System.out.println("Opción 16: Último pedido realizado");
                    break;
                case 17:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 17.");
            }
            //esto es para separar las iteracciones
            System.out.println(); 
        } while (option != 17);

    }
}
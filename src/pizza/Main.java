package pizza;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static final Pizzeria Pizzeria = null;

	public static void main(String[] args) {

		menu();
	}

	// Atributos
	private TipoPedido tipo;

	public static void cargarDatos(Pizzeria p) {
		// Agregar clientes de prueba
		p.addCliente(new Cliente("Juan", "Calle 123", "juan@example.com", "123456789", 50.0));
		p.addCliente(new Cliente("Maria", "Avenida 456", "maria@example.com", "987654321", 75.5));
		p.addCliente(new Cliente("Carlos", "Plaza 789", "carlos@example.com", "456123789", 100.0));
		p.addCliente(new Cliente("Ana", "Paseo 321", "ana@example.com", "321654987", 30.0));
		p.addCliente(new Cliente("Luis", "Bulevar 654", "luis@example.com", "789321456", 120.0));

		// Agregar pizzas de prueba
		p.addPizza(new Pizza("Margarita", "Tomate, Queso Mozzarella, Albahaca", 8.5));
		p.addPizza(new Pizza("Pepperoni", "Tomate, Queso Mozzarella, Pepperoni", 9.5));
		p.addPizza(new Pizza("Cuatro Quesos", "Mozzarella, Gorgonzola, Parmesano, Cheddar", 10.0));
		p.addPizza(new Pizza("Hawaiana", "Tomate, Queso Mozzarella, Jamón, Piña", 9.0));
		p.addPizza(new Pizza("BBQ Pollo", "Salsa BBQ, Queso, Pollo, Cebolla", 11.0));
	}

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		Pizzeria PizasLosGayos = new Pizzeria();
		Cliente Clientes = new Cliente();

		cargarDatos(PizasLosGayos);

		int option;
		do {
			System.out.println("Elige una opción: ");
			System.out.println("1. Nueva pizza");
			System.out.println("2. Nuevo cliente");
			System.out.println("3. Realizar un pedido");
			System.out.println("4. Ver pizzas ");
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
				Pizza p1 = nuevaPizza(scanner);
				PizasLosGayos.addPizza(p1);

				System.out.println("Opción 1: Nueva pizza");

				break;
			case 2:
				Cliente c1 = nuevoCliente(scanner);
				PizasLosGayos.addCliente(c1);
				break;
			case 3:
				nuevoPedido(scanner, PizasLosGayos);
				break;
			case 4:
				verPizzas(PizasLosGayos.getPizza());

				break;
			case 5:
				verPedidos(PizasLosGayos.getPedido());
				break;
			case 6:
				verCliente(PizasLosGayos.getCliente());
				break;
			case 7:
				PizasLosGayos.consultarTelefono(scanner);

				break;
			case 8:
				PizasLosGayos.consultarPizzaIngrediente(scanner);

				break;
			case 9:
				String ingr = scanner.nextLine();
				PizasLosGayos.consultarPizzaNOIngrediente(scanner);
				break;

			case 10:
			    verPedidosDeHoy(PizasLosGayos.getPedido());
				break;
			case 11:
				PizasLosGayos.verPedidosConsumidosLocal();
				break;
			case 12:
				PizasLosGayos.verPedidosConsumidosRecoger();
				break;
			case 13:
				PizasLosGayos.verPedidosConsumidosDomicilio();
				break;
			case 14:
				System.out.println(Pizza.getPizzaMasCara());
				break;
			case 15:
				System.out.println(Pizza.getPizzaMasBarata());
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
			// esto es para separar las iteracciones
			System.out.println();
		} while (option != 17);

	}

	public static Pizza nuevaPizza(Scanner scanner) {
		System.out.println("Nombre");
		String nombre = scanner.next();
		System.out.println("Ingredientes");
		String ingredientes = scanner.next();
		System.out.println("Precio");
		double precio = scanner.nextDouble();

		return new Pizza(nombre, ingredientes, precio);
	}

	public static Cliente nuevoCliente(Scanner scanner) {
		System.out.println("Nombre: ");
		String nombre = scanner.next();
		System.out.println("Dirección: ");
		String direccion = scanner.next();
		System.out.println("Email: ");
		String email = scanner.next();
		System.out.println("Telefono: ");
		String telefono = scanner.next();
		System.out.println("Saldo disponible: ");
		double dineroDisponible = scanner.nextDouble();

		return new Cliente(nombre, direccion, email, telefono, dineroDisponible);
	}

	public static void nuevoPedido(Scanner scanner, Pizzeria pizzeria) {
		

		System.out.println("Lista de clientes:");
		for (Cliente cliente : pizzeria.getCliente()) {
			System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre());
		}

		System.out.print("Introduce el ID del cliente: ");
		int idCliente = scanner.nextInt();
		scanner.nextLine();

		Cliente clienteSeleccionado = null;
		for (Cliente cliente : pizzeria.getCliente()) {
			if (cliente.getId() == idCliente) {
				clienteSeleccionado = cliente;
				break;
			}
		}

		if (clienteSeleccionado == null) {
			System.out.println("Cliente no encontrado.");
			return;
		}

		System.out.println("Lista de pizzas:");
		for (Pizza pizza : pizzeria.getPizza()) {
			System.out.println(
					"ID: " + pizza.getId() + ", Nombre: " + pizza.getNombre() + ", Precio: " + pizza.getPrecio() + "€");
		}

		System.out.print("Introduce el ID de la pizza: ");
		int idPizza = scanner.nextInt();
		scanner.nextLine();

		Pizza pizzaSeleccionada = null;
		for (Pizza pizza : pizzeria.getPizza()) {
			if (pizza.getId() == idPizza) {
				pizzaSeleccionada = pizza;
				break;
			}
		}

		if (pizzaSeleccionada == null) {
			System.out.println("Pizza no encontrada.");
			return;
		}

		System.out.print("Introduce el tipo de pedido (LOCAL, DOMICILIO, RECOGER): ");
		String tipo = scanner.nextLine().toUpperCase();

		Pedido pedido = new Pedido(clienteSeleccionado, tipo, pizzaSeleccionada);
		pizzeria.addPedido(pedido);
		if (tipo.equals(TipoPedido.LOCAL)) {

		}
		System.out.println("Pedido añadido con éxito.");
	}

	public static void verCliente(List<Cliente> clientes) {
		for (Cliente c : clientes) {
			System.out.println(c);
		}
	}

	public static void verPizzas(List<Pizza> pizzas) {
		for (Pizza p : pizzas) {
			System.out.println(p);
		}
	}

	public static void verPedidos(List<Pedido> pedidos) {
		for (Pedido pedi : pedidos) {
			System.out.println(pedi);
		}
	}
	
	public static void verPedidosDeHoy(List<Pedido> pedidos) {
	    LocalDate hoy = LocalDate.now(); 
	    boolean hayPedidosHoy = false;

	    System.out.println("Pedidos realizados hoy:");
	    for (Pedido pedido : pedidos) {
	        if (pedido.getFecha().equals(hoy)) { 
	            System.out.println(pedido); 
	            hayPedidosHoy = true;
	        }
	    }

	    if (!hayPedidosHoy) {
	        System.out.println("No se han realizado pedidos hoy.");
	    }
	}

}
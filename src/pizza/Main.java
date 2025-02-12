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
			System.out.println("17. Agregar pizza a pedido");
			System.out.println("18. Eliminar pizza a pedido");

			System.out.println("19. Salir");

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
				PizasLosGayos.verPizzas();

				break;
			case 5:
				PizasLosGayos.verPedidos();
				;
				break;
			case 6:
				PizasLosGayos.verCliente();
				;
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
				PizasLosGayos.verPedidosDeHoy();
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
				PizasLosGayos.ultimoPedido();
				break;
			case 17:
				agregarPizzaAPedido(scanner, PizasLosGayos);
				break;
			case 18:
				eliminarPizzaDePedido(scanner, PizasLosGayos);
				break;
			case 19:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 17.");
			}
			// esto es para separar las iteracciones
			System.out.println();
		} while (option != 19);

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

		Cliente clienteSeleccionado = null;
		for (Cliente cliente : pizzeria.getCliente()) {
			if (cliente.getId() == idCliente) {
				clienteSeleccionado = cliente;
			}
		}

		if (clienteSeleccionado == null) {
			System.out.println("Cliente no encontrado.");
		}

		System.out.print("Introduce el tipo de pedido (LOCAL, DOMICILIO, RECOGER): ");
		scanner.nextLine();
		String tipo = scanner.nextLine().toUpperCase();

		Pedido pedido = new Pedido(clienteSeleccionado, tipo);
		pizzeria.addPedido(pedido);
		if (tipo.equals(TipoPedido.LOCAL)) {

		}

		System.out.println("Lista de pizzas:");
		for (Pizza pizza : pizzeria.getPizza()) {
			System.out.println(
					"ID: " + pizza.getId() + ", Nombre: " + pizza.getNombre() + ", Precio: " + pizza.getPrecio() + "€");
		}

		int idPizza;

		do {
			System.out.print("Introduce el ID de la pizza: (0 para salir) ");
			idPizza = scanner.nextInt();

			for (Pizza pizza : pizzeria.getPizza()) {
				if (pizza.getId() == idPizza) {
					pedido.addPizzaPedido(pizza);

				}
			}

			if (idPizza == 0) {
				System.out.println("Pizza no encontrada.");
			}

		} while (idPizza != 0);

		System.out.println("Pedido añadido con éxito.");
	}

	public static void agregarPizzaAPedido(Scanner scanner, Pizzeria pizzeria) {
		System.out.println("Lista de pedidos:");
		for (Pedido pedido : pizzeria.getPedido()) {
			System.out.println("ID: " + pedido.getId() + ", Cliente: " + pedido.getCliente().getNombre());
		}

		System.out.print("Introduce el ID del pedido: ");
		int idPedido = scanner.nextInt();

		Pedido pedidoSeleccionado = null;
		for (Pedido pedido : pizzeria.getPedido()) {
			if (pedido.getId() == idPedido) {
				pedidoSeleccionado = pedido;
				break;
			}
		}

		if (pedidoSeleccionado == null) {
			System.out.println("Pedido no encontrado.");
			return;
		}

		System.out.println("Lista de pizzas disponibles:");
		for (Pizza pizza : pizzeria.getPizza()) {
			System.out.println(
					"ID: " + pizza.getId() + ", Nombre: " + pizza.getNombre() + ", Precio: " + pizza.getPrecio() + "€");
		}

		System.out.print("Introduce el ID de la pizza a añadir: ");
		int idPizza = scanner.nextInt();

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

		pedidoSeleccionado.agregarPizza(pizzaSeleccionada);
		System.out.println("Pizza añadida al pedido con éxito.");
	}

	public static void eliminarPizzaDePedido(Scanner scanner, Pizzeria pizzeria) {
		System.out.println("Lista de pedidos:");
		for (Pedido pedido : pizzeria.getPedido()) {
			System.out.println("ID: " + pedido.getId() + ", Cliente: " + pedido.getCliente().getNombre());
		}

		System.out.print("Introduce el ID del pedido: ");
		int idPedido = scanner.nextInt();

		Pedido pedidoSeleccionado = null;
		for (Pedido pedido : pizzeria.getPedido()) {
			if (pedido.getId() == idPedido) {
				pedidoSeleccionado = pedido;
				break;
			}
		}

		if (pedidoSeleccionado == null) {
			System.out.println("Pedido no encontrado.");
			return;
		}

		if (pedidoSeleccionado.getPizzas().isEmpty()) {
			System.out.println("El pedido no tiene pizzas para eliminar.");
			return;
		}

		System.out.println("Pizzas en el pedido:");
		for (int i = 0; i < pedidoSeleccionado.getPizzas().size(); i++) {
			System.out.println("ID: " + i + ", " + pedidoSeleccionado.getPizzas().get(i));
		}

		System.out.print("Introduce el número de la pizza a eliminar: ");
		int indexPizza = scanner.nextInt();

		if (indexPizza < 0 || indexPizza >= pedidoSeleccionado.getPizzas().size()) {
			System.out.println("Pizza no encontrada en el pedido.");
			return;
		}

		pedidoSeleccionado.eliminarPizza(indexPizza);
		System.out.println("Pizza eliminada del pedido con éxito.");
	}

}